<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Login form</title>
    <meta charset="utf-8">
    <style>
        <%@include file='../static/css/login.css' %>
    </style>
</head>
<body>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<div id="wrapper">
    <h1>Sign In Form</h1>
    <form method="post" action='/signin' id="signin" autocomplete="on">
        <input type="text" class="violet" id="user" name="username" placeholder="username" required/>
        <input type="password" id="pass" name="password" placeholder="password" required/>
        <button type="submit">&#xf0da;</button>
        <p>Нет аккаунта? <a href='${pageContext.request.contextPath}/signup'>Зарегистрироваться</a></p>
    </form>
</div>

</body>
</html>