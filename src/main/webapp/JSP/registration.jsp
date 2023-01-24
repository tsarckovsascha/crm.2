<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="../resources/styeles/style.css">
</head>
<body>
<div class="title-box">
    <div class="title-item">
        <h1>СИСТЕМА УПРАВЛЕНИЯ СТУДЕНТАМИ И ИХ УСПЕВАЕМОСТЬЮ</h1>
    </div>
</div>
<hr>
<div class="content-box">
    <h1>Регистрация</h1>
    <form action="/registration" method="post" >
        <table>
            <tr>
                <td>Фамилия</td>
                <td><input width = "200px" type="text" name="firstName" > </td>
            </tr>
            <tr>
                <td>Имя</td>
                <td><input type="text" name="lastName"   ></td>
            </tr>
            <tr>
                <td>Логин</td>
                <td><input type="text" name="login" ></td>
            </tr>
            <tr>
                <td>Пароль</td>
                <td><input type="text" name="password" ></td>
            </tr>
        </table>

        <input type="submit" value="Зарегистрироваться" class="gradient-button-registration" >
    </form>
    <c:if test="${error==1}">
        <h3>
            Поля не должны быть пустыми
        </h3>
    </c:if>
</div>
<footer>
    Created by Tsarckov Alexandr &copy 2022
</footer>
</body>
</html>