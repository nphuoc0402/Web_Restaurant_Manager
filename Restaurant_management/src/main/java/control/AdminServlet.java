package control;

import model.Product;
import service.ProductDAO;
import utils.CheckTools;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet(name = "AdminServlet", urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        try {
            switch (action) {
                case "create":
                    InsertProduct(request, response);
                    break;
                case "edit":
                    UpdateProduct(request, response);
                    break;
                case "search":
//                    listSearchCustomer(request, response);
                    break;
                case "delete":
                    DeleteProduct(request,response);
                    break;
                case "list":
                    showList(request,response);
                    break;
                case "showlist":
                    show(request,response);
                    break;
                default:
                    showHome(request, response);
                    break;

            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action == null) {
            action = "";
        }
        switch (action) {
            case "create":
                showFormCreate(request, response);
                break;
            case "edit":
                showFromEdit(request, response);
                break;
            case "delete":
                showFormDelete(request,response);
                break;
            case "list":
                showList(request, response);
                break;
            case "showlist":
                show(request,response);
                break;
            default:
                showHome(request, response);
                break;
        }
    }

    public void showHome(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productDAO.SelectAllProduct();
        request.setAttribute("products", productList);
        System.out.println(productList);
        RequestDispatcher dis = request.getRequestDispatcher("/Admin/Home.jsp");
        dis.forward(request, response);
    }

    public void showList(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productDAO.SelectAllProduct();
        request.setAttribute("products", productList);
        System.out.println(productList);
        RequestDispatcher dis = request.getRequestDispatcher("/Admin/Admin.jsp");
        dis.forward(request, response);
    }

    public void show(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> productList = productDAO.SelectAllProduct();
        request.setAttribute("products", productList);
        System.out.println(productList);
        RequestDispatcher dis = request.getRequestDispatcher("/Admin/list-product.jsp");
        dis.forward(request, response);
    }

    public void showFormCreate(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dis = request.getRequestDispatcher("/Admin/create.jsp");
        dis.forward(request, response);
    }

    public void showFromEdit(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.SelectProductById(id);
        RequestDispatcher dis = request.getRequestDispatcher("/Admin/edit.jsp");
        request.setAttribute("product", product);
        dis.forward(request, response);
    }

    public void showFormDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.SelectProductById(id);
        RequestDispatcher dis = request.getRequestDispatcher("/Admin/delete.jsp");
        request.setAttribute("product", product);
        dis.forward(request, response);
    }

        public void InsertProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        String name = request.getParameter("p_name");
        String str_price = request.getParameter("p_price");
        String description = request.getParameter("p_description");
        String image = request.getParameter("p_image");
        String str_cal_id = request.getParameter("cal_id");
        if (!CheckTools.isNumeric(str_price) || !CheckTools.isNumeric(str_cal_id)) {
            request.setAttribute("success", null);
            request.setAttribute("error", "Invalid Value");
            showFormCreate(request, response);
        } else {
            int price = Integer.parseInt(str_price);
            int cal_id = Integer.parseInt(str_cal_id);
            if (price <= 0) {
                request.setAttribute("success", null);
                request.setAttribute("error", "Price require greater than 0");
                showFormCreate(request, response);
            } else {
                productDAO.InsertProduct(new Product(name, price, description, image, cal_id));
                request.setAttribute("success", "Product was created");
                request.setAttribute("error", null);
                showFormCreate(request, response);
            }
        }

    }

    public void UpdateProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.SelectProductById(id);
        String name = request.getParameter("p_name");
        String str_price = request.getParameter("p_price");
        String description = request.getParameter("p_description");
        String image = request.getParameter("p_image");
        String str_cal_id = request.getParameter("cal_id");
        RequestDispatcher dis;
        if (name == "" || str_price == "" || description == "" || image == "" || str_cal_id == "") {
            request.setAttribute("success", null);
            request.setAttribute("error", "Invalid Value");
            showFromEdit(request, response);
        } else {
            if (!CheckTools.isNumeric(str_price) || !CheckTools.isNumeric(str_cal_id)) {
                request.setAttribute("success", null);
                request.setAttribute("error", "Invalid Value");
                showFromEdit(request, response);
            } else {
                int price = Integer.parseInt(str_price);
                int cal_id = Integer.parseInt(str_cal_id);
                if (price <= 0) {
                    request.setAttribute("success", null);
                    request.setAttribute("error", "Price require greater than 0");
                    showFromEdit(request, response);
                } else {
                    if (product == null) {
                        dis = request.getRequestDispatcher("Admin/error-404.jsp");
                    } else {
                        product.setP_id(id);
                        product.setP_name(name);
                        product.setP_price(price);
                        product.setP_description(description);
                        product.setP_image(image);
                        product.setCal_id(cal_id);
                        productDAO.isUpdate(product);
                        request.setAttribute("error", null);
                        request.setAttribute("success", "Product was edit success");
                        showFromEdit(request, response);
                    }
                }

            }
        }
    }

    public void DeleteProduct(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.SelectProductById(id);
        if(product == null){
            request.setAttribute("error", "Product isn't exist");
            request.setAttribute("success", null);
            showHome(request,response);
        }else {
            productDAO.isDelete(id);
            request.setAttribute("error", null);
            request.setAttribute("success", "Product was delete success");
            showHome(request, response);
        }
    }
}
