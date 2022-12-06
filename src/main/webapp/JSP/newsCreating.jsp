<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href= "../resources/styeles/style.css">
</head>
<body>
<div class="title-box">
    <div class="title-item">
        <h1>СИСТЕМА УПРАВЛЕНИЯ СТУДЕНТАМИ И ИХ УСПЕВАЕМОСТЬЮ</h1>
    </div>
    <div class="title-login">
        <a href="" class="gradient-button-leftside">Войти</a>
        <a href="" class="gradient-button-rightside">Регистрация</a>
    </div>
</div>
<hr>

<div class="navigation-box">
    <a href="home.jsp" class="gradient-button">Главная</a>
    <a href="student.jsp" class="gradient-button">Студенты</a>
    <a href="disciplins.jsp" class="gradient-button">Дисциплины</a>
    <a href="term.jsp" class="gradient-button">Семестры</a>
    <a href="" class="gradient-button">Контакты</a>
</div>
<div class="content-box">
    <h3>Новое объявление</h3>
    <div display="inline">
        <b>Заголовок:</b>
        <br>
        <input type="text" name="name" id="0" size="34">
    </div>
    <p>
        <b>Содержание</b>
        <br>
        <textarea name="comment" cols="40" rows="3"></textarea>
    </p>
    <a href="index.html" class="gradient-button">Сохранить</a>
</div>
<footer>
    Created by Rushan Mukharlyamov &copy 2022
</footer>
</body>
</html>