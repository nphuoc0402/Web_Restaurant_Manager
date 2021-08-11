package utils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils {

    public  static Connection getConnection(){
        Connection connection = null;
        String jdbcURL = "jdbc:mysql://localhost:3306/restaurant_system?useSSL=false";
        String jdbcUser = "root";
        String jdbcPassword = "NguyenVanPhuoc123";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL,jdbcUser,jdbcPassword);
        }catch (SQLException e){
            e.printStackTrace();
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return  connection;

    }
}
