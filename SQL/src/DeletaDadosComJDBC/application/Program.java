package DeletaDadosComJDBC.application;

import DeletaDadosComJDBC.db.DB;
import DeletaDadosComJDBC.db.DbIntegrityException;

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
            String query = "DELETE FROM department WHERE Id = ?";
            rs = stmt.executeQuery(query);

            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("name"));
            }

        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        }

    }
}
