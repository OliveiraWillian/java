package model.impl;

import db.DB;
import db.DbException;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SellerDaoJDBC implements SellerDao {
    private Connection conn = null;

    public SellerDaoJDBC(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void insert(Seller obj) {
        PreparedStatement st = null;
        try {

            String query = "INSERT INTO seller (Name, Email, Birth_Date, Base_Salary, Department_Id) VALUES  (?, ?, ?, ?, ?)";
            st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setString(1,obj.getName());
            st.setString(2,obj.getEmail());
            st.setDate(3,new Date(obj.getBirthDate().getTime()));
            st.setDouble(4,obj.getBaseSalary());
            st.setInt(5,obj.getDepartment().getId());

            int row = st.executeUpdate();
            if (row > 0){
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()){
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            }else {
                throw new DbException("Erro ao inserir seller");
            }

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void update(Seller obj) {
        PreparedStatement st = null;
        try {
            String query = "UPDATE seller SET Name = ?, Email = ?, Birth_Date = ?, Base_Salary = ?, Department_Id = ? WHERE Id = ?";
            st = conn.prepareStatement(query);
            st.setString(1, obj.getName());
            st.setString(2, obj.getEmail());
            st.setDate(3,new Date(obj.getBirthDate().getTime()));
            st.setDouble(4,obj.getBaseSalary());
            st.setInt(5,obj.getDepartment().getId());
            st.setInt(6,obj.getId());
            st.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void deleteById(Integer argumento) {
        PreparedStatement st = null;
        try{
            String query = "DELETE FROM seller WHERE Id = ?";
            st = conn.prepareStatement(query);
            st.setInt(1, argumento);
            int row =  st.executeUpdate();
            if (row == 0){
                throw new DbException("Erro ao deletar seller");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public Seller findById(Integer argumento) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String query = "SELECT seller.*,department.Name as DepName FROM seller INNER JOIN department ON seller.department_id = department.Id WHERE seller.Id = ?";
            st = conn.prepareStatement(query);
            st.setInt(1, argumento);
            rs = st.executeQuery();

            if (rs.next()) {
                Department dep = instantiateDepartment(rs);
                Seller seller =  instantiateSeller(rs,dep);
                return seller;


            }
            return null;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }

    }

    private Seller instantiateSeller(ResultSet rs, Department dep) throws SQLException {
        new Seller();
        Seller seller = new Seller();
        seller.setId(rs.getInt("id"));
        seller.setName(rs.getString("name"));
        seller.setEmail(rs.getString("email"));
        seller.setBirthDate(rs.getDate("birth_date"));
        seller.setBaseSalary(rs.getDouble("base_salary"));
        seller.setDepartment(dep);
        return seller;
    }

    private Department instantiateDepartment(ResultSet rs) throws SQLException {
        Department dep = new Department();
        new Department();
        dep.setId(rs.getInt("department_id"));
        dep.setName(rs.getString("DepName"));
        return dep;
    }

    @Override
    public List<Seller> findAll() {
        return List.of();
    }

    @Override
    public List<Seller> findByDepartment(Department department) {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String query = "SELECT seller.*, department.Name AS DepName FROM seller INNER JOIN department ON seller.department_id = department.id WHERE department_id = ? ORDER BY Name";
            st = conn.prepareStatement(query);
            st.setInt(1, department.getId());
            rs = st.executeQuery();

            List<Seller> listSellers = new ArrayList<>();
            Map<Integer,Department> map = new HashMap<>();

            while (rs.next()) {
                Department dep = map.get(rs.getInt("department_id"));
                if(dep == null){
                    dep = instantiateDepartment(rs);
                    map.put(rs.getInt("department_id"), dep);
                }

                Seller seller =  instantiateSeller(rs,dep);

                listSellers.add(seller);



            }
            return listSellers;

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DB.closeStatement(st);
            DB.closeResultSet(rs);
        }
    }
}
