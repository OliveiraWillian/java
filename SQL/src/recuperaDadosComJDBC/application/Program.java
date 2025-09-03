package recuperaDadosComJDBC.application;

import recuperaDadosComJDBC.db.DB;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program {
    public static void main(String[] args) {
        Connection conexao = null;
        Statement stmt = null;
        ResultSet rs = null;

        try {
            conexao = DB.getConnection();
            stmt = conexao.createStatement();
            String query = "SELECT * FROM department";
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
