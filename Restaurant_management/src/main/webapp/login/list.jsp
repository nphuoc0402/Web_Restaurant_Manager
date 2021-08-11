<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<html>
<head>
    <title>Customer</title>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/css/bootstrap.min.css" integrity="sha384-B0vP5xmATw1+K9KRQjQERJvTumQW0nPEzvF6L/Z6nronJ3oUOFUFpCjEUQouq2+l" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-Piv4xVNRyMGpqkS2by6br4gNJ7DXjqk09RmUpJ8jgGtD7zP9yug3goQfGII0yAns" crossorigin="anonymous"></script>

    <style>
        .message{
            color:white;
        }
        .error{
            color: red;
            font-family: Arial;
            font-weight: bold;
        }
        .success{
            color: lightgreen;
            font-weight: bold;
            font-family: Arial;
        }
        form{
            display: flex; !important;

        }
        .message{
            float: right;
            position: relative;
            top: 0px;
            right: 0px;
        }

        a{
            padding: 20px;
            width: 40px;
        }

    </style>
</head>
<body>
<div class="container">
    <h1><a href="/Home" style="text-decoration: none; color: black; margin-left:200px ">Product Management</a></h1>
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
            <label for="validationCustom01">Product Name: </label>
            <input type="text" name="name" size="45" class="form-control"  id="validationCustom01" required >
            <div class="invalid-feedback">
                Product is required
            </div>
        </div>
        <div class="col-4">
            <label >Price:</label>
            <input  type="text" name="email" id="email" size="45" class="form-control" required>
            <div class="invalid-feedback">
                Price is required
            </div>
        </div>
        <div class="col-4">
            <label >Image:</label>
            <input type="text" name="salary" class="form-control" required>
            <div class="invalid-feedback" >
                Image is required
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
        <th scope="col">Name Product</th>
        <th scope="col">Price</th>
        <th scope="col">Image</th>
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

</div>
</body>
</html>