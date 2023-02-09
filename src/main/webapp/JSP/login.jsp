<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <%--    <link rel="stylesheet" href="../resources/styeles/style.css">--%>
    <style>
        <%@include file="../resources/styeles/style.css"%>
    </style>
</head>
<body>
<div class="action-box">
    <div class="action-item">
        <h1>СИСТЕМА УПРАВЛЕНИЯ СТУДЕНТАМИ И ИХ УСПЕВАЕМОСТЬЮ</h1>
    </div>
    <div class="title-login">
        <a href="/registration" class="gradient-button-rightside">Регистрация</a>
    </div>
</div>
<hr>
<div class="content-box">
    <h1>Вход в систему</h1>
    <form action="/login" method="post">
        <table style="margin: 0 auto">
            <tr>
                <td>Логин</td>
                <td><input type="text" name="login"></td>
            </tr>
            <br>
            <tr>
                <td>Пароль</td>
                <td><input type="password" name="password"></td>
            </tr>
            <br>
            <tr>
                <td>Роль</td>
                <td>
                    <select name="RoleId">

                        <c:forEach items="${allRole}" var="t">
                            <option value="${t.id}">${t.name}</option>
                        </c:forEach>

                    </select>
                </td>
            </tr>
        </table>
            <tr>
                <input type="submit" value="Войти" class="gradient-button">
            </tr>

    </form>
</div>
<c:if test="${errorEmpty==1}">
    <h3>Поля не должны быть пустыми</h3>
</c:if>
<c:if test="${errorLogin==1}">
    <h3>Пользователь с таким Логином и паролем, и ролью не найдены</h3>
</c:if>


</div>
<footer>
    Created by Tsarckov Alexandr &copy 2022
</footer>
</body>
</html>