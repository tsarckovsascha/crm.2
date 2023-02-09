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
<div class="action-box">
    <div class="action-item">
        <h1>СИСТЕМА УПРАВЛЕНИЯ СТУДЕНТАМИ И ИХ УСПЕВАЕМОСТЬЮ</h1>
        <a href="/logout" class="gradient-button" >Logout</a>
    </div>
    <c:if test="${isLogin!=1}">
        <div class="action-login">
            <a href="" class="gradient-button-leftside">Войти</a>
            <a href="" class="gradient-button-rightside">Регистрация</a>
        </div>
    </c:if>
</div>
<hr>
<div class="action-box">
    <a href="/home" class="gradient-button">Главная</a>
    <a href="/student" class="gradient-button">Студенты</a>
    <a href="/disciplins" class="gradient-button">Дисциплины</a>
    <a href="/term" class="gradient-button">Семестры</a>
    <a href="" class="gradient-button">Контакты</a>
</div>
<div class="content-box">
    <h3>Создание новой дисциплины</h3>
    <form action="/disciplineCreating" method="post" >
    <div display="inline">
        <b>Наименование:</b>
        <input type="text" name="name"  size="34">
    </div>
    <input type="submit" value="Сохранить" class="gradient-button" >
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