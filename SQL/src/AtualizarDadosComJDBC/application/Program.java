package AtualizarDadosComJDBC.application;

import AtualizarDadosComJDBC.db.DB;

import java.sql.*;

public class Program {
    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection();
            String query = "UPDATE seller SET base_salary = base_salary + ? where department_id = ?";
            st = conn.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
           st.setDouble(1,200.00);
           st.setInt(2,2);
           Integer linha =  st.executeUpdate();

           if (linha >= 1){
               rs = st.getGeneratedKeys();
               while (rs.next()){
                   System.out.println("Valores Alterado no ID: " + rs.getInt(1));
               }

           }else {
               System.out.println("Nenhum registro foi Alterado");

           }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }finally {
            DB.closeConnection();
            DB.statementClose(st);
            DB.resultSettClose(rs);
        }


    }
}
