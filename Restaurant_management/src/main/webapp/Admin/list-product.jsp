<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <%@include file="/layoutAdmin/head.jsp" %>
    <title>JSP Page</title>
    <style>
        .tm-gallery-page {
            float: left;
        }
    </style>
</head>
<body>

<div id="wrapper">
    <!-- Topbar Start -->
    <%@include file="/layoutAdmin/header.jsp" %>
    <!-- end Topbar -->

    <!-- ========== Left Sidebar Start ========== -->
    <%@include file="/layoutAdmin/left-side-menu.jsp" %>
    <!-- Left Sidebar End -->


    <div class="content-page">
        <div class="container-fluid">
            <!-- /.row -->
            <h2>
                <a href="admin">Home</a>
            </h2>
            <div class="row mt-3">
<%--                <div class="col-lg-3 col-md-6">--%>
                    <c:forEach items="${products}" var="products">
                        <article class="col-lg-3 col-md-4 col-sm-6 col-12 tm-gallery-item">
                            <figure>
                                <img src="${products.getP_image()}" alt="Image" style="width: 200px; height: 140px" class="img-fluid tm-gallery-img"/>
                                <figcaption>
                                    <h4 class="tm-gallery-title">${products.getP_name()}</h4>
                                    <p class="tm-gallery-description">${products.getP_description()}</p>
                                    <p class="tm-gallery-price">
                                        <fmt:formatNumber value="${products.getP_price()}"
                                                          type="currency"
                                                          currencySymbol="$">
                                        </fmt:formatNumber>
                                    </p>
                                </figcaption>
                            </figure>
                        </article>
                    </c:forEach>
<%--                </div>--%>
            </div>
            <!-- /.row -->
            <div class="row"></div>
            <!-- /.row -->
        </div>
        <!-- /.container-fluid -->
    </div>
</div>
</body>
</html>
