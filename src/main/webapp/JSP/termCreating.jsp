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
    <a href="/home" class="gradient-button">Главная</a>
    <a href="/student" class="gradient-button">Студенты</a>
    <a href="/disciplins" class="gradient-button">Дисциплины</a>
    <a href="/term" class="gradient-button">Семестры</a>
    <a href="" class="gradient-button">Контакты</a>
</div>
<div class="content-box">
    <h1>Создание семестра</h1>
    <div class="grade-box">
        <div display="inline">
            <b>Длительность (недели):</b>
            <input type="number" name="range" id="0" size="3">
        </div>
    </div>
    <h3>Список дисциплин семестра</h3>
    <table>
        <tr>
            <td><input type="checkbox" name="selectStudent" id="1"></td>
            <td>Информатика</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="selectStudent" id="2"></td>
            <td>Системный анализ</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="selectStudent" id="3"></td>
            <td>Математический анализ</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="selectStudent" id="4"></td>
            <td>Приближенное исчисление</td>
        </tr>
        <tr>
            <td><input type="checkbox" name="selectStudent" id="5"></td>
            <td>Дифференциальные уравнения</td>
        </tr>
    </table>
    <a href="" class="gradient-button">Сохранить</a>
</div>
<footer>
    Created by Rushan Mukharlyamov &copy 2022
</footer>
</body>
</html>