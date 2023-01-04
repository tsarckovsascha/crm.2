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
  <h1>Вход в систему</h1>
  <form action="/login" method="post" >
    <table>
      <tr>
        <td>Логин</td>
        <td><input width = "200px" type="text" name="login"> </td>
      </tr>
      <tr>
        <td>Пароль</td>
        <td><input type="text" name="password"  ></td>
      </tr>
    </table>
    <tr>
      <td>Роль</td>
      <select name="rolId" >">
        <c:forEach items="${allRole}" var="t">
          <option value="${t.id}">${t.name}</option>
        </c:forEach>
      </select>
    </tr>

    <input type="submit" value="Войти" class="gradient-button" >
  </form>
  <c:if test="${errorEmpty==1}">
    <h3>Поля не должны быть пустыми</h3>
  </c:if>
  <c:if test="${errorLogin==1}">
    <h3>Пользователь с таким Логином и паролем, и ролью не найдены</h3>
  </c:if>

</div>
<footer>
  Created by Tsarckov Alexandr &copy 2022
</footer>
</body>
</html>