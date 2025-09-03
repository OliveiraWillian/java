package InserirDadosComJDBC.application;

import InserirDadosComJDBC.db.DB;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class Program {
    public static void main(String[] args) {
        Connection conexao = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        Integer linhas = null;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        try {
            conexao = DB.getConnection();
            String query = "INSERT INTO seller (name, email, birth_date, base_salary, department_id) Values (?,?,?,?,?)";
            st = conexao.prepareStatement(query,Statement.RETURN_GENERATED_KEYS);
            st.setString(1, "Willian");
            st.setString(2,"Willian@gmail.com");
            st.setDate(3, new java.sql.Date(sdf.parse("04/02/1997").getTime()));
            st.setDouble(4,3000.00);
            st.setInt(5,4);
            linhas = st.executeUpdate();
            if (linhas > 0) {
                rs = st.getGeneratedKeys();
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt(1));

                }
            }else {
                System.out.println("Falha ao Salvar");
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        finally {
            DB.closeConnection();
            DB.statementClose(st);
            DB.resultSettClose(rs);

        }
    }
}
