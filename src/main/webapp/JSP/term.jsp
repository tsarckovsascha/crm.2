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
  <div class="terms-filter-box">
    <br>
    <div display="inline">
      <b>Выбрать семестр:</b>
      <select size="1" name="hero[]">
        <option value="1">Первый</option>
        <option selected value="2">Второй</option>
      </select>
    </div>
    <b>Длительность семестра: 24 недели</b>
  </div>
  <a href="termCreating.html" class="action-button"><img class="prefix-button" src="../resources/img/add.png"  width="18px" alt="">Создать семестр</a>
  <a href="termModifying.html" class="action-button">Изменить текущий семестр</a>
  <a href="" class="action-button"><img class="prefix-button" src="../resources/img/trash.png"  width="18px" alt="">Удалить текущий семестр</a>
  <h3>Список дисциплин семестра</h3>
  <table>
    <tr>
      <td display="inline">
      <th>Наименование</th>
      <th></th>
      </td>
    </tr>
    <c:forEach items="${allDisciplins}" var="d">
      <tr>
        <td>${d.name}</td>
        <td display="inline">
          <a class="editing-box-button" href=""><img src="../resources/img/pencil.png" width="18px" alt=""></a>
          <a class="trashing-box-button" href=""><img src="../resources/img/trash.png" width="18px" alt=""></a>
        </td>
      </tr>
    </c:forEach>

  </table>
</div>
<footer>
  Created by Rushan Mukharlyamov &copy 2022
</footer>
</body>
</html>