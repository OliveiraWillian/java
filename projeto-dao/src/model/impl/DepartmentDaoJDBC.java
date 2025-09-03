package model.impl;

import db.DB;
import db.DbException;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DepartmentDaoJDBC implements DepartmentDao {
    Connection conn = null;

    public DepartmentDaoJDBC(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void insert(Department obj) {
        PreparedStatement st = null;
        try {
            String query = "INSERT INTO Department (Name) VALUES  (?)";
            st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getName());
            int row = st.executeUpdate();
            if (row > 0) {
                ResultSet rs = st.getGeneratedKeys();
                if (rs.next()) {
                    int id = rs.getInt(1);
                    obj.setId(id);
                }
                DB.closeResultSet(rs);
            } else {
                throw new DbException("Erro ao inserir departamento");
            }


        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);

        }
    }

    @Override
    public void update(Department obj) {
        PreparedStatement st = null;
        try {
            String query = "UPDATE Department SET Name=? WHERE Id=?";
            st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            st.setString(1, obj.getName());
            st.setInt(2, obj.getId());
            int row = st.executeUpdate();
            if (row == 0) {
                throw new DbException("Erro ao atualizar departamento");
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public void deleteById(Integer argumento) {
        PreparedStatement st = null;
        try {
            String query = "DELETE FROM Department WHERE Id=?";
            st = conn.prepareStatement(query);
            st.setInt(1, argumento);
            int row = st.executeUpdate();
            if (row == 0) {
                throw new DbException("Erro ao deletar departamento");
            }

        } catch (
                SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);
        }

    }

    @Override
    public Department selectById(Integer argumento) {
        PreparedStatement st = null;
        try {
            String query = "SELECT * FROM Department WHERE id = ?";
            st = conn.prepareStatement(query);
            st.setInt(1, argumento);
            ResultSet rs = st.executeQuery();
            Department obj = new Department();
            if (rs.next()) {
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
            } else {
                throw new DbException("Erro ao buscar departamento");
            }
            DB.closeResultSet(rs);
            return obj;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        } finally {
            DB.closeStatement(st);

        }

    }

    @Override
    public List<Department> findAll() {
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            String query = "SELECT * FROM Department";
            st = conn.prepareStatement(query);
            rs = st.executeQuery();
            List<Department> list = new ArrayList<>();
            if (rs == null) {
                throw new DbException("Erro ao buscar departamentos");
            }
            while (rs.next()) {
                Department obj = new Department();
                obj.setId(rs.getInt("id"));
                obj.setName(rs.getString("name"));
                list.add(obj);
            }
            return List.copyOf(list);


        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
        }

    }
}
