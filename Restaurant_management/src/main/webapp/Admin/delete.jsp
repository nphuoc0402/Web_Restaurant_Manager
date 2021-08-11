<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/layoutAdmin/head.jsp" %>
    <title>JSP Page</title>
</head>
<body>

<div id="wrapper" style="margin-top: 20px">
    <!-- Topbar Start -->
    <%@include file="/layoutAdmin/header.jsp" %>
    <!-- end Topbar -->

    <!-- ========== Left Sidebar Start ========== -->
    <%@include file="/layoutAdmin/left-side-menu.jsp" %>
    <!-- Left Sidebar End -->
    <!-- ============================================================== -->
    <!-- Start Page Content here -->
    <!-- ============================================================== -->
    <div class="content-page">
        <div align="center" style="border: 1px solid black; padding: 30px">
            <h1>Form Delete Product</h1>
            <form method="post" >
                <h3>Are you sure?</h3>
                <fieldset>
                    <legend>Product information</legend>
                    <table>
                        <tr style="padding: 10px">
                            <td>Id </td>
                            <td>${requestScope["product"].getP_id()}</td>
                        </tr>
                        <tr style="padding: 10px">
                            <td>Name </td>
                            <td>${requestScope["product"].getP_name()}</td>
                        </tr>
                        <tr style="padding: 10px">
                            <td>Price </td>
                            <td>${requestScope["product"].getP_price()}</td>
                        </tr>
                        <tr style="padding: 10px">
                            <td>Description </td>
                            <td>${requestScope["product"].getP_description()}</td>
                        </tr>
                        <tr style="padding: 10px">
                            <td>Image </td>
                            <td>${requestScope["product"].getP_image()}</td>
                        </tr>
                        <tr style="padding: 10px">
                            <td>Catalog Id </td>
                            <td>${requestScope["product"].getCal_id()}</td>
                        </tr>
                        <tr style="padding: 10px">
                            <td ><input type="submit" value="Delete Product"></td>
                            <td ><a href="/admin?action=list">Back to Product List list</a></td>
                        </tr>
                    </table>
                </fieldset>
            </form>
            <!-- Footer Start -->
            <%@include file="/layoutStartmin-master/script.jsp"%>
            <!-- end Footer -->
        </div>
        <!-- ============================================================== -->
        <!-- End Page content -->
        <!-- ============================================================== -->
    </div>
    <%@include file="/layoutAdmin/script.jsp" %>
    <!-- App JS -->
</body>
</html>

