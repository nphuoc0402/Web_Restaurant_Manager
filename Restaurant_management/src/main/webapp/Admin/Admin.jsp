<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/layoutAdmin/head.jsp"%>
    <title>JSP Page</title>
</head>
<body>
<div id="wrapper">
    <!-- Topbar Start -->
    <%@include file="/layoutAdmin/header.jsp"%>
    <!-- end Topbar -->

    <!-- ========== Left Sidebar Start ========== -->
    <%@include file="/layoutAdmin/left-side-menu.jsp"%>
    <!-- Left Sidebar End -->

    <!-- ============================================================== -->
    <!-- Start Page Content here -->
    <!-- ============================================================== -->
    <div class="content-page">
        <div class="message">
            <c:if test='${requestScope["success"] != null}'>
                <div id="div1" class="alert alert-success" role="alert">
                        ${requestScope["success"]}
                </div>
            </c:if>
            <c:if test='${requestScope["error"] != null}'>
                <div id="div1" class="alert alert-danger" role="alert">
                        ${requestScope["error"]}
                </div>
            </c:if>
        </div>
        <div align="center">
            <h2>
                <a href="admin">Home</a>
            </h2>
            <h2>
                <a href="/admin?action=create">Add New Product</a>
            </h2>
            <table border="1" cellpadding="5" class="table">
                <h2>List of Product</h2>

                <thead class="thead-dark">
                <th scope="col">ID</th>
                <th scope="col">Name Product</th>
                <th scope="col">Price</th>
                <th scope="col">Description</th>
                <th scope="col">Image</th>
                <th scope="col">Catalog Id</th>
                <th scope="col">Action</th>
                </thead>

                <c:forEach var="products" items="${products}">
                    <tr>
                        <td><c:out value="${products.getP_id()}"/></td>
                        <td><c:out value="${products.getP_name()}"/></td>
                        <td style="text-align: right"><fmt:formatNumber value="${products.getP_price()}" type="currency" currencySymbol="$" ></fmt:formatNumber></td>
                        <td><c:out value="${products.getP_description()}"/></td>
                        <td style="text-align: center"><img width="50" height="50" src="<c:out value="${products.getP_image()}"/>" alt="Image Food"></td>
                        <td width="70" style="text-align: center"><c:out value="${products.getCal_id()}"/></td>

                        <td>
                            <a class="btn btn-warning" href="/admin?action=edit&id=${products.getP_id()}" title="Edit">Edit</a>
                            <a class="btn btn-danger" href="/admin?action=delete&id=${products.getP_id()}" title="Delete">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>

    <!-- Footer Start -->
    <%@include file="/layoutAdmin/footer.jsp"%>
    <!-- end Footer -->
</div>
<!-- ============================================================== -->
<!-- End Page content -->
<!-- ============================================================== -->
</div>
<!-- App JS -->
<%@include file="/layoutAdmin/script.jsp"%>
<script>
    // Example starter JavaScript for disabling form submissions if there are invalid fields
    (function() {
        'use strict';
        window.addEventListener('load', function() {
            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.getElementsByClassName('needs-validation');
            // Loop over them and prevent submission
            var validation = Array.prototype.filter.call(forms, function(form) {
                form.addEventListener('submit', function(event) {
                    if (form.checkValidity() === false) {
                        event.preventDefault();
                        event.stopPropagation();
                    }
                    form.classList.add('was-validated');
                }, false);
            });
        }, false);
    })();
</script>
</body>
</html>