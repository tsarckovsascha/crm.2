<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

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
<c:if test="${RoleId==1}">
<div class="grade-box">
    <a href="/newsCreating" class="action-button" ><img class="prefix-button" src="../resources/img/pencil.png"  width="18px" alt="">Добавить объявление</a>
</div>
</c:if>

<c:forEach items="${AllNews}" var="n">
<div class="content-box">
    <div class="inline-box">
            <h1 display="inline">
                ${n.header}
            <a class="editing-box-button" href=""><img src="../resources/img/pencil.png"  width="18px" alt=""></a>
            <a class="trashing-box-button" href=""><img src="../resources/img/trash.png" width="18px" alt=""></a>
            </h1>
        <td></td>
    </div>
    <td>   ${n.text}    </td>
</div>
</c:forEach>
<footer>
    Created by Tsarckov Alexandr &copy 2022
</footer>
</body>
</html>