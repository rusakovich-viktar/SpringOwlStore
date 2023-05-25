<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>My profile</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <%--    <link rel="stylesheet" href="resources/style.css" type="text/css">--%>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    <style>
        <%@include file='../static/css/style.css' %>
    </style>
</head>
<body>
<ul>
    <jsp:include page="header.jsp"/>
</ul>
<br>
<h3 class="text-center">Личный кабинет пользователя <b class="font-italic">${userDto.getUsername()}</b></h3>
<div>
    <p class="text-left">имя : <b class="font-italic">${userDto.getName()}</b>
    <p class="text-left">фамилия: <b class="font-italic">${userDto.getSurname()}</b>
    <p class="text-left">гендер: <b class="font-italic">${userDto.getGender()}</b>
    <p class="text-left">дата рождения: <b class="font-italic">${userDto.getBirthday()}</b>
    <p class="text-left">электронная почта: <b class="font-italic">${userDto.getEmail()}</b>
    <p class="text-left">дата регистрации: <b class="font-italic">${userDto.getRegistrationDate()}</b>
        <br>
        <button>
            <a class="fa fa-sign-out fa-lg "
               href="/user/edit" style="padding: 10px 20px;"><i>Edit</i></a>
        </button>

</div>


<button onclick="window.location.href = '<c:url value="/logout"/>';" class="buttonQuit">
    <i class="fa fa-sign-out fa-lg" aria-hidden="true"></i> Завершить сеанс и выйти
</button>

</body>
</html>
