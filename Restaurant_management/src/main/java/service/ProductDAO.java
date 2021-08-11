package service;

import model.Customer;
import model.Product;
import utils.MySQLConnUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO implements IProductDAO {
    public ProductDAO(){

    }

    Connection connection = MySQLConnUtils.getConnection();
    PreparedStatement ps = null;
    @Override
    public void InsertProduct(Product product) throws SQLException {
        String SQL_INSERT_PRODUCT = "INSERT INTO product (p_name,p_price,p_description,p_image,cal_id) VALUES " + "(?,?,?,?,?);";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_INSERT_PRODUCT);
            preparedStatement.setString(1,product.getP_name());
            preparedStatement.setInt(2,product.getP_price());
            preparedStatement.setString(3,product.getP_description());
            preparedStatement.setString(4,product.getP_image());
            preparedStatement.setInt(5,product.getCal_id());
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            printSQLException(e);
        }
    }

    @Override
    public Product SelectProductById(int id) {
        Product product = null;
        String SQL_SelectProduct_By_Id = "SELECT p_id,p_name,p_price,p_description,p_image,cal_id FROM product WHERE p_id = ?;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SelectProduct_By_Id);
            preparedStatement.setInt(1,id);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int p_id = rs.getInt(1);
                String p_name = rs.getString(2);
                int p_price = rs.getInt(3);
                String p_description = rs.getString(4);
                String p_image = rs.getString(5);
                int cal_id = rs.getInt(6);
                product = new Product(p_id,p_name,p_price,p_description,p_image,cal_id);
            }
        }catch (SQLException e){
            printSQLException(e);
        }
        return product;
    }

    @Override
    public List<Product> SelectAllProduct() {
        List<Product> productList = new ArrayList<>();
        String SQL_SelectAll_Product = "SELECT p_id,p_name,p_price,p_description,p_image,cal_id FROM product;";
        try{
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_SelectAll_Product);
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()){
                int id = rs.getInt("p_id");
                String name = rs.getString("p_name");
                int price = rs.getInt("p_price");
                String description = rs.getString("p_description");
                String image = rs.getString("p_image");
                int cal_id = rs.getInt("cal_id");
                productList.add(new Product(id,name,price,description,image,cal_id));
            }

        }catch (SQLException e){
            printSQLException(e);
        }
        return productList;
    }

    @Override
    public boolean isDelete(int id) throws SQLException {
        boolean delete = false;
        String SQL_Delete_Product = "DELETE FROM product WHERE p_id = ?;";
        try {
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_Delete_Product);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
            delete = true;
        }catch (SQLException e){
            connection.rollback();
            printSQLException(e);
        }
        return delete;
    }

    @Override
    public boolean addUser(String email, String pass) {
        boolean check=false;
        try{
            String query="INSERT INTO `r_user` (`email`, `password`) VALUES (?, ?);";
            ps= connection.prepareStatement(query);
            ps.setString(1,email);
            ps.setString(2,pass);
            check = ps.executeUpdate()>0;
        }catch(Exception e){

        }
        return check;
    }

    @Override
    public Customer login(String username, String password) {
        Customer customer = null;
//        try{
//            String query = "select * from  r_user where email=? and password=?";
//            ps = connection.prepareStatement(query);
//            ps.setString(1,username);
//            ps.setString(2,password);
//            ResultSet rs = ps.executeQuery();
//            while(rs.next()){
//                customer = new Customer(rs.getInt(1),
//                        rs.getString(2),
//                        rs.getString(3));
//            }
//        }catch(Exception e){
//
//        }
        return customer;
//    }
    }

    @Override
    public boolean isUpdate(Product product) throws SQLException {
        boolean update = false;
        String SQL_Update_Product = "UPDATE product SET p_name = ?,p_price = ?,p_description = ?,p_image = ?,cal_id = ? WHERE p_id = ?;";
        try{
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement(SQL_Update_Product);
            preparedStatement.setString(1,product.getP_name());
            preparedStatement.setInt(2,product.getP_price());
            preparedStatement.setString(3,product.getP_description());
            preparedStatement.setString(4,product.getP_image());
            preparedStatement.setInt(5,product.getCal_id());
            preparedStatement.setInt(6,product.getP_id());
            preparedStatement.executeUpdate();
            connection.commit();
            connection.setAutoCommit(true);
            update = true;
        }catch (SQLException e){
            connection.rollback();
            printSQLException(e);
        }
        return update;
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
