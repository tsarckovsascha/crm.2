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
    <div class="title-login">
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
  <a href="/contacts" class="gradient-button">Контакты</a>
</div>
<div class="content-box">
  <h1>Редактирование семестра</h1>
  <div class="grade-box">
    <div display="inline">
      <b>Длительность (недели):</b>
      <input type="number" name="range" id="1" size="3">
    </div>
  </div>
  <h3>Список дисциплин семестра</h3>
  <table>
    <tr>
      <td><input type="checkbox" name="selectStudent" id="2"></td>
      <td>Информатика</td>
    </tr>
    <tr>
      <td><input type="checkbox" name="selectStudent" id="3"></td>
      <td>Системный анализ</td>
    </tr>
    <tr>
      <td><input type="checkbox" name="selectStudent" id="4"></td>
      <td>Математический анализ</td>
    </tr>
    <tr>
      <td><input type="checkbox" name="selectStudent" id="5"></td>
      <td>Приближенное исчисление</td>
    </tr>
    <tr>
      <td><input type="checkbox" name="selectStudent" id="6"></td>
      <td>Дифференциальные уравнения</td>
    </tr>
  </table>
  <a href="" class="gradient-button">Сохранить</a>
</div>
<footer>
  Created by Tsarckov Alexandr &copy 2022
</footer>
</body>
</html>