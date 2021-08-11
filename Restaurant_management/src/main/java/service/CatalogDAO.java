package service;

import utils.MySQLConnUtils;
import model.Category;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CatalogDAO implements ICatalogDAO {
    public CatalogDAO(){

    }

    Connection connection = MySQLConnUtils.getConnection();

    @Override
    public List<Category> SelectAllCatalog() {
        List<Category> categoryList = new ArrayList<>();
        String SQL_SELECT_CATEGORY = "SELECT cal_id,cal_name FROM catalog;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_CATEGORY);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                String cal_name = rs.getString("cal_name");
                categoryList.add(new Category(cal_name));
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return categoryList;
    }

    @Override
    public Category SelectCatalogById(int id) {
        Category catalog = null;
        String SQL_SELECT_CATEGORY = "SELECT cal_id,cal_name FROM catalog WHERE cal_id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SELECT_CATEGORY);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                String name = rs.getString("cal_name");
                catalog = new Category(name);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return catalog;
    }

    @Override
    public int findId(String name) {
        int id = 0;
        String SQL_FINDID = "SELECT cal_name FROM catalog WHERE cal_name = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_FINDID);
            preparedStatement.setString(1,name);
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                id = rs.getInt("cal_id");
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return id;
    }

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
