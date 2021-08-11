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
    <%@include file="head.jsp"%>
    <title>JSP Page</title>
</head>
<body>
    <div id="wrapper">
        <!-- Topbar Start -->
        <%@include file="header.jsp"%>
        <!-- end Topbar -->

        <!-- ========== Left Sidebar Start ========== -->
        <%@include file="left-side-menu.jsp"%>
        <!-- Left Sidebar End -->

        <!-- ============================================================== -->
        <!-- Start Page Content here -->
        <!-- ============================================================== -->
        <div class="content-page">

            <h1><a href="/customersManage" style="text-decoration: none; color: black; margin-left:200px ">Customer Management</a></h1>
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
            <form class="needs-validation row" novalidate method="post">
            <div class="col-4">
                    <label for="validationCustom01">User Name: </label>
                    <input type="text" name="name" size="45" class="form-control"  id="validationCustom01" required >
                    <div class="invalid-feedback">
                        Id Customer is required
                    </div>
            </div>
            <div class="col-4">
                    <label >Email:</label>
                    <input  type="text" name="email" id="email" size="45" class="form-control" required>
                    <div class="invalid-feedback">
                    Id Customer is required
                    </div>
            </div>
            <div class="col-4">
                    <label >Salary:</label>
                    <input type="text" name="salary" class="form-control" required>
                    <div class="invalid-feedback" >
                    Id Customer is required
                    </div>
            </div>
            <button class="btn btn-primary" type="submit">Create</button>

            </form>
                    <form action="/customersManage?action=search" method="post">
                    <input type="text" name="search" class="form-control">
                    <button type="submit">Search</button>
            </form>


            <table border="1" cellpadding="5" class="table">
            <h2>List of Users</h2>

            <thead class="thead-dark">
                    <th scope="col">ID</th>
                    <th scope="col">Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Salary</th>
                    <th scope="col">Actions</th>
            </thead>

            <c:forEach var="user" items="${customers}">
                <tr>
                        <td><c:out value="${user.getId()}"/></td>
                        <td><c:out value="${user.getName()}"/></td>
                        <td><c:out value="${user.getEmail()}"/></td>
                        <td><fmt:formatNumber value="${user.getSalary()}" type="currency" currencySymbol="$" ></fmt:formatNumber></td>
                        <td>
                                <a class="btn btn-warning" href="/customersManage?action=edit&id=${user.id}" title="Edit"><i class="fa fa-pencil-square-o" aria-hidden="true"></i></a>
                                <a class="btn btn-success" href="/customersManage?action=transfer&id=${user.id}" title="Transfer"><i class="fa fa-exchange" aria-hidden="true"></i></a>
                        <%--                    <a class="btn btn-success" href="/customersManage?action=sent&id=${user.id}"><i class="fa fa-exchange" aria-hidden="true"></i></a>--%>
                                <a class="btn btn-danger" href="/customersManage?action=delete&id=${user.id}" title="Delete"><i class="fa fa-trash-o" aria-hidden="true"></i></a>
                        </td>
                </tr>
            </c:forEach>
            </table>
        </div>

            <!-- Footer Start -->
            <%@include file="footer.jsp"%>
            <!-- end Footer -->
        </div>
        <!-- ============================================================== -->
        <!-- End Page content -->
        <!-- ============================================================== -->
    </div>

    <!-- App JS -->
    <%@include file="script.jsp"%>
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