package service;

import model.Customer;
import model.Product;

import java.sql.SQLException;
import java.util.List;

public interface IProductDAO {
    public void InsertProduct(Product product) throws SQLException;
    public Product SelectProductById(int id);
    public List<Product> SelectAllProduct();
    public boolean isDelete(int id) throws  SQLException;
    public boolean isUpdate(Product product) throws  SQLException;
    public Customer login(String username, String password);
    public boolean addUser(String email, String pass);
}
