//package control;
//
//import service.ProductDAO;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//
//@WebServlet(name = "LoginServlet",urlPatterns = "/login")
//public class LoginServlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String submit = request.getParameter("submit");
//        switch (submit){
//            case "submit":
//            {
//                login(request,response);
//                break;
//            }
//            case "register":
//            {
//                register(request,response);
//                break;
//            }
//            default:
//            {
//                response.sendRedirect("/home");
//                break;
//            }
//        }
//
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//
//    }
//
//    protected void login(HttpServletRequest request, HttpServletResponse response) throws IOException {
//        String username = request.getParameter("username");
//        String password = request.getParameter("password");
//        ProductDAO dao = new ProductDAO();
//        Customer user = dao.login(username,password);
//        if (user == null){
////            đăng nhập thất bại
//            response.sendRedirect("/home");
//        }else{
//            response.sendRedirect("/home");
//        }
//    }
//
//    protected void register(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//        String email = request.getParameter("email");
//        String pass = requestgetParameter("password");
//        String retype = request.getParameter("repassword");
//        if (!(pass.equals(re type))){
//            request.setAttribute("mess","Something is wrong !");
//            request.getRequestDispatcher("login/includes/login.jsp").forward(request,response);
//        }else{
//            ProductDAO dao = new ProductDAO();
//            Customer user = dao.login(email,pass);
//            if (user == null){
//                boolean check = dao.addUser(email,pass);
//                if (check){
//                    request.setAttribute("mess","Successful ! !");
//                    request.getRequestDispatcher("login/includes/login.jsp").forward(request,response);
//                }{
//                    request.setAttribute("mess","Something is wrong !");
//                    request.getRequestDispatcher("login/includes/login.jsp").forward(request,response);
//                }
//            }else{
//                request.setAttribute("mess","Something is wrong !");
//                request.getRequestDispatcher("login/includes/login.jsp").forward(request,response);
//            }
//        }
//    }
//}
