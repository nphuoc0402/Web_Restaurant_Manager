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
            <h1>Form Edit Product</h1>
            <h2>
                <a href="admin?action=list">List All Product</a>
            </h2>
            <form class="needs-validation row" novalidate method="post">
                <c:if test="${product != null}">
                    <input class="form-control" type="hidden" name="id" value="<c:out value='${product.getP_id()}'/>" required>
                </c:if>
                <div class="col-4">
                    <label for="validationCustom01">Product Name: </label>
                    <input type="text" name="p_name" size="45" value="<c:out value='${product.getP_name()}' />" class="form-control" id="validationCustom01" required>
                    <div class="invalid-feedback">
                        Product Name is required
                    </div>
                </div>
                <div class="col-4">
                    <label>Price</label>
                    <input type="text" name="p_price" id="email" value="<c:out value='${product.getP_price()}' />" size="45" class="form-control" required>
                    <div class="invalid-feedback">
                        Price is required
                    </div>
                </div>
                <div class="col-4">
                    <label>Description</label>
                    <input type="text" name="p_description" value="<c:out value='${product.getP_description()}' />" class="form-control" required>
                    <div class="invalid-feedback">
                        Description is required
                    </div>
                </div>
                <div class="col-6">
                    <label>Image</label>
                    <input type="text" name="p_image" value="<c:out value='${product.getP_image()}' />" class="form-control" required>
                    <div class="invalid-feedback">
                        Description is required
                    </div>
                </div>
                <div class="col-6">
                    <label>Catalog Id</label>
                    <input type="text" name="cal_id" value="<c:out value='${product.getCal_id()}' />" class="form-control" required>
                    <div class="invalid-feedback">
                        Description is required
                    </div>
                    <br>
                </div >
                <button style="position: relative; left: 500px" class="btn btn-primary" type="submit">Upgrade</button>
            </form>


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

