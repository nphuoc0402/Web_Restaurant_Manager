package control;

import model.Category;
import model.Product;
import service.CatalogDAO;
import service.ProductDAO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/home")
public class ProductServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;
    private CatalogDAO catalogDAO;
    public void init(){
        productDAO = new ProductDAO();
        catalogDAO = new CatalogDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null ){
            action = "";
        }
        switch (action){
            case "about":
                showAbout(request,response);
                break;
            case "contact":
                showContact(request,response);
                break;
            case "login":
                showLogin(request,response);
                break;
            default:
                showHome(request,response);
                break;
        }


    }

    public void showHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        List<Product> productList = productDAO.SelectAllProduct();
        List<Category> catalogList = catalogDAO.SelectAllCatalog();
        request.setAttribute("cataloglist",catalogList);
        request.setAttribute("products",productList);
        System.out.println(productList);
        RequestDispatcher dis = request.getRequestDispatcher("/home/home.jsp");
        dis.forward(request,response);
    }

    public void showAbout(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        RequestDispatcher dis = request.getRequestDispatcher("/home/about.jsp");
        dis.forward(request,response);
    }

    public void showContact(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
        RequestDispatcher dis = request.getRequestDispatcher("/home/contact.jsp");
        dis.forward(request,response);
    }

    public void showLogin(HttpServletRequest request, HttpServletResponse response)throws ServletException , IOException {
        RequestDispatcher dis = request.getRequestDispatcher("/login/login.jsp");
        dis.forward(request,response);
    }

}
