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
  <a href="index.html" class="gradient-button">Главная</a>
  <a href="students.html" class="gradient-button">Студенты</a>
  <a href="disciplines.html" class="gradient-button">Дисциплины</a>
  <a href="terms.html" class="gradient-button">Семестры</a>
  <a href="" class="gradient-button">Контакты</a>
</div>
<div class="content-box">
  <h3>Редактирование дисциплины</h3>
  <div display="inline">
    <b>Наименование:</b>
    <input type="text" name="range" id="1" size="34">
  </div>
  <div display="inline">
    <b>Длительность (семестров):</b>
    <input type="number" name="range" id="2" size="2">
  </div>
  <a href="" class="gradient-button">Сохранить</a>
</div>
<footer>
  Created by Rushan Mukharlyamov &copy 2022
</footer>
</body>
</html>