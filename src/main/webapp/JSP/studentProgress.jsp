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
  <h1>Отображена успеваемость для следующего студента</h1>
  <table class="students-table">
    <tr>
      <th>Фамилия</th>
      <th>Имя</th>
      <th>Отчество</th>
      <th>Группа</th>
      <th>Номер</th>
      <th>E-mail</th>
      <th>Дата поступления</th>
    </tr>
    <tr>
      <td>Мухарлямов</td>
      <td>Рушан</td>
      <td>Ринатович</td>
      <td>502-1</td>
      <td>+7 (906) 325 74 39</td>
      <td>muhr@1ccl.ru</td>
      <td>23.11.2022</td>
    </tr>
  </table>
  <div class="grade-box">
    <div display="inline">
      <b>Выбрать семестр:</b>
      <select size="1" name="hero[]">
        <option value="1">Первый</option>
        <option selected value="2">Второй</option>
      </select>
    </div>
    <b>Длительность семестра: 24 недели</b>
  </div>
  <table class="students-table">
    <tr>
      <th>Дисциплина</th>
      <th>Оценка</th>
    </tr>
    <tr>
      <td>Информатика</td>
      <td>4</td>
    </tr>
    <tr>
      <td>Системный анализ</td>
      <td>5</td>
    </tr>
    <tr>
      <td>Математический анализ</td>
      <td>3</td>
    </tr>
    <tr>
      <td>Приближенное исчисление</td>
      <td>4</td>
    </tr>
    <tr>
      <td>Дифференциальные уравнения</td>
      <td>4</td>
    </tr>
  </table>





</div>
<footer>
  Created by Rushan Mukharlyamov &copy 2022
</footer>
</body>
</html>