<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="<c:url value="/static/css/registration.css"/>">
    <script type="text/javascript" src="<c:url value="/static/css/script.js"/>"></script>
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
                    <input id="name" type="text" placeholder="Имя" name="name" oninput="validateName()"
                           required><br/>
                    <span id="nameError" style="display: none;">*Поле 'Имя' не заполнено!</span>
                </div>
                <div class="form-item box-item">
                    <input id="surname" type="text" placeholder="Фамилия" name="surname"
                           oninput="validateSurname()" required><br/>
                    <span id="surnameError" style="display: none;">*Поле 'Фамилия' не заполнено!</span>
                </div>
                <div id="brthDateLbl">
                    <label>Дата рождения</label>
                </div>
                <div class="form-group">
                    <input type="date" id="birthdate" name="date" class="form-control" required>
                </div>

                <div class="form-item box-item">
                    <input id="email" type="email" placeholder="Email" name="email" oninput="validateEmail()"
                           required><br/>
                    <span id="emailError" style="display: none;">*Поле 'Email' не заполнено!</span>
                    <span id="validationErr" style="display: none;">*Неверный формат email адреса!</span>
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
                    <small class="errorOnce"><i class="fa fa-asterisk" aria-hidden="true"></i> choose at least
                        one</small>
                </div>
                <div class="form-item box-item">
                    <label>Username</label>
                    <input id="username" type="text" placeholder="enter username" autocomplete="off" name="username"
                           oninput="validatePass()" required><br/>
                </div>
                <div class="form-item box-item">
                    <span>..Введите пароль  </span>
                    <input id="password" type="password" name="password" autocomplete="off" oninput="validatePass()"
                           required><br/>
                    <span id="passwordError"
                          style="display: none;">*Поле 'Пароль' должно содержать не менее 8 символов</span>
                </div>
                <div class="form-item box-item">
                    <span>Повторите пароль</span>
                    <input id="repeatPswd" type="password" required name="repeatPass" autocomplete="off"
                           oninput="validateRepeatPass()"><br/>
                    <span id="repeatPassError" style="display: none;">*Поле 'Повторите пароль' не заполнено!</span>
                    <span id="matchingError" style="display: none;">*Пароли не совпадают!</span>
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