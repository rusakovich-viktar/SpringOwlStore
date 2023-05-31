<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/registration.css"/>">
    <title>Страница авторизации</title>
</head>
<body>
<div class="row">
    <section class="section">
        <header>
            <h3>Register</h3>
            <h4>Please fill your information bellow</h4>
        </header>
        <main>
            <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
            <form id="registrationForm" method="post" action="${contextPath}/signup" onsubmit="return validateForm()">
                <div class="form-item box-item">
                    <input id="name" type="text" placeholder="Имя" name="name" required><br/>
                </div>
                <div class="form-item box-item">
                    <input id="surname" type="text" placeholder="Фамилия" name="surname" required><br/>
                </div>
                <div id="brthDateLbl">
                    <label>Дата рождения</label>
                </div>
                <div class="form-group">
                    <input type="date" id="birthdate" name="date" class="form-control" required>
                </div>

                <div class="form-item box-item">
                    <input id="email" type="email" placeholder="Email" name="email" required><br/>
                </div>
                <div class="form-item box-item">
                    <div class="form-item-triple">
                        <div class="radio-label">
                            <label class="label">Gender</label>
                        </div>
                        <div class="form-item">
                            <input id="Male" type="radio" name="gender" value="Male" data-once required>
                            <label for="Male">male</label>
                        </div>
                        <div class="form-item">
                            <input id="Female" type="radio" name="gender" value="Female" data-once required>
                            <label for="Female">female</label>
                        </div>
                        <div class="form-item">
                            <input id="Non-binary" type="radio" name="gender" value="Non-binary" data-once required>
                            <label for="Non-binary">non-binary</label>
                        </div>
                    </div>
                </div>
                <div class="form-item box-item">
                    <label>Username</label>
                    <input id="username" type="text" placeholder="enter username" autocomplete="off" name="username"
                            required><br/>
                </div>
                <div class="form-item box-item">
                    <span>..Введите пароль  </span>
                    <input id="password" type="password" name="password" autocomplete="off" required><br/>
                </div>
                <div class="form-item box-item">
                    <span>Повторите пароль</span>
                    <input id="repeatPswd" type="password" required name="repeatPass" autocomplete="off"><br/>
                </div>
                <input type="hidden" name="registrationDate" value="<%= java.time.LocalDate.now() %>">
                <div id="lower">
                    <button id="regFormSignUpBtn" type="submit">Зарегистрироваться</button>
                    <br/>
                </div>
            </form>
        </main>
        <footer>
            <p>Already have an account? <a href='${contextPath}/home'>Login here</a></p>
        </footer>
        <i class="wave"></i>
    </section>
</div>
</body>
</html>