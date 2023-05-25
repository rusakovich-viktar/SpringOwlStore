<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Product</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <%--    <link rel="stylesheet" href="resources/style.css" type="text/css">--%>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<style>
    <%@include file='../static/css/style.css' %>
</style>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<ul>
    <jsp:include page="header.jsp"/>
</ul>
<br>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<c:if test="${not empty oneProduct}">
    <div class="container-fluid">
        <h2 class="text-center">${oneProduct.getName()}</h2><br>

        <img class="mx-auto d-block" style="height:auto; max-width: 400px;"
             src="${contextPath}/images/${oneProduct.getImageName()}"
             alt="${oneProduct.getImageName()}">

        <br>
        <div class="container">
            <h2>Product description:</h2>
            <table class="table table-bordered">
                <thead>
                <tr>
                    <th class="text-center" style="vertical-align: middle">Description</th>
                    <th class="text-center" style="vertical-align: middle">Price руб</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${oneProduct.getDescription()}</td>
                    <td class="text-center" style="vertical-align: middle">${oneProduct.getPrice()}</td>
                </tr>
                </tbody>
            </table>
        </div>
        <br>
        <form method="post" action="/cart/add">
            <input type="hidden" value="${oneProduct.getId()}" name="id"/>
            <input type="hidden" value="${oneProduct.getImageName()}" name="imageName"/>
            <input type="hidden" value="${oneProduct.getName()}" name="name"/>
            <input type="hidden" value="${oneProduct.getDescription()}" name="description"/>
            <input type="hidden" value="${oneProduct.getPrice()}" name="price"/>
            <input type="hidden" value="${oneProduct.getCategoryId()}" name="categoryId"/>
            <button type="submit" value="Buy" name="action" class="buttonAddProduct"><i
                    class="fa fa-lg fa-fw fa-cart-plus"></i> Buy
            </button>
            <br>
        </form>
    </div>
</c:if>
</body>
</html>
