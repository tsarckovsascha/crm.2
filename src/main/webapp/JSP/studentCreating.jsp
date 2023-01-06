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
    <c:if test="${isLogin!=1}">
        <div class="title-login">
            <a href="" class="gradient-button-leftside">Войти</a>
            <a href="" class="gradient-button-rightside">Регистрация</a>
        </div>
    </c:if>
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
    <h1>Добавление нового студента</h1>
    <form action="/studentCreating" method="post" >
        <table>
            <tr>
                <td>Имя</td>
                <td><input width = "200px" type="text" name="firstName" id="0"> </td>
            </tr>
            <tr>
                <td>Фамилия</td>
                <td><input type="text" name="lastName" id="1"  ></td>
            </tr>
            <tr>
                <td>Группа</td>
                <td><input type="text" name="groupName" id="2"></td>
            </tr>
            <tr>
                <td>Дата поступления</td>
                <td><input type="date" name="registrationDate" id="3"></td>
            </tr>
        </table>

        <input type="submit" value="Применить" class="gradient-button" >
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