package InserirDadosComJDBC.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class DB {
    public static Connection conn = null;

    public static Connection getConnection() {
        try {
          if(conn == null) {
              Properties props = propertiesLoad();
              String url = props.getProperty("dburl");
              conn = DriverManager.getConnection(url,props);

          }
            return conn;

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public static void closeConnection() {
        try {
            if (conn != null) {
                conn.close();
            }
        }catch (SQLException e){
            throw new DbException(e.getMessage());
        }
    }

    public static Properties propertiesLoad()  {
       try (FileInputStream fs = new FileInputStream("db.properties")) {
           Properties prop = new Properties();
           prop.load(fs);
           return prop;

       } catch (IOException e) {
           throw new DbException(e.getMessage());
       }

    }
    public static void statementClose(Statement st){
        try {
            if(st != null) {
                st.close();
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }
    public static void resultSettClose(ResultSet rs){
        try {
            if(rs != null) {
                rs.close();
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

}
