package service;

import model.Category;

import java.util.List;

public interface ICatalogDAO {
    public Category SelectCatalogById(int id);
    public List<Category> SelectAllCatalog();
    public int findId(String name);
}
