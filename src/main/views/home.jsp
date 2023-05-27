<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <%--    <link rel="stylesheet" type="text/css" href="resources/style.css">--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        <%@include file='../static/css/style.css' %>
    </style>

</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<jsp:include page="header.jsp"/>
<br>
<h2>All categories</h2>
<div class="container-fluid">
    <c:if test="${categories!=null}">
        <div class="row">
            <c:forEach items="${categories}" var="category">
                <div class="card w-25 m-1" type="category">
                    <div class="card-body">
                            ${category.getName()}
                            <%--                                /eshop?command=category&categoryId=${category.getId()}&nameCategory=${category.getName()}">--%>
                        <a href="/category?categoryId=${category.getId()}&nameCategory=${category.getName()}">
                            <img class="card-img"
                                 style="width:150px;height:120px"
                                 src="${contextPath}/images/${category.getImagePath()}"
                                 alt="Card image">
                        </a>
                    </div>
                </div>
            </c:forEach>
        </div>
    </c:if>
</div>
</body>
</html>