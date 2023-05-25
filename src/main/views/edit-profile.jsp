<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Edit user</title>
</head>
<body>

<form:form action="profile" modelAttribute="userDto" method="post">
    Username <form:input path="username" title="Неизменяемое поле" readonly="true"/>
    <br>
    <br>
    name <form:input path="name" title="Введите ваше имя"/>
    <br>
    <br>
    Surname <form:input path="surname" title="Введите вашу фамилию"/>
    <br>
    <br>
    birthday <form:input path="birthday" title="Введите год рождения"/>
    <br>
    <br>
    gender:
    <form:radiobutton path="gender" value="male"/> Male
    <form:radiobutton path="gender" value="female"/> Female
    <form:radiobutton path="gender" value="non-binary"/> Non-binary
    <br>
    <br>
    email <form:input path="email"/>
    <br>
    <br>
    <input type="hidden" name="id" value="${userDto.id}"/>
    <input type="submit" value="Изменить">

</form:form>

</body>
</html>
