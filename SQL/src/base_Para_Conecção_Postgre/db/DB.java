package base_Para_Conecção_Postgre.db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
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

}
