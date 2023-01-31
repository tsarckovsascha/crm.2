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
        <a href="/logout" class="gradient-button" style="margin-left: 1050px;margin-top: 10px">Logout</a>
    </div>
    <c:if test="${isLogin!=1}">
        <div class="title-login">
            <a href="" class="gradient-button-leftside">Войти</a>
            <a href="" class="gradient-button-rightside">Регистрация</a>
        </div>
    </c:if>
</div>
<hr>
<hr>
<div class="navigation-box">
    <a href="/home" class="gradient-button">Главная</a>
    <a href="/student" class="gradient-button">Студенты</a>
    <a href="/disciplins" class="gradient-button">Дисциплины</a>
    <a href="/term" class="gradient-button">Семестры</a>
    <a href="/contacts" class="gradient-button">Контакты</a>
</div>
<div class="content-box">
    <h1 style="position: center"
    >Информация и контакты</h1>
    <p style="
    font-style: oblique;
    font-family: Georgia, Serif;
    position: center;
    background-position: right center;
">Проект называется "СИСТЕМА УПРАВЛЕНИЯ СТУДЕНТАМИ И ИХ УСПЕВАЕМОСТЬЮ"<br>
        Он представляет из себя сайт связанный с базой данных, где вы можете зарегестрироваться.<br>
        Удаляя и создавая записи на стене новостей, моежете немного почуствовать себя администратором.<br>
        (Для этого нужно ввести логин: sasha ; пароль: qwe )<br>
        Так же можно создать свою учетную запись пользователя.<br>
    </p>
</div>
<div class="flex-row-box">
    <p>Проект разработал Царьков Александр.</p>
</div>
<footer>
    Created by Tsarckov Alexandr &copy 2022
</footer>
</body>
</html>