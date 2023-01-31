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
<%--    <link rel="stylesheet" href="../resources/styeles/style.css">--%>
<style>
    <%@include file="../resources/styeles/style.css"%>
    </style>
    <script src="../resources/js/functions.js"></script>
</head>
<body>
<div class="title-box">
    <div class="title-item">
        <h1>СИСТЕМА УПРАВЛЕНИЯ СТУДЕНТАМИ И ИХ УСПЕВАЕМОСТЬЮ</h1>
        <a href="/logout" class="gradient-button" style="margin-left: 1050px;margin-top: 10px">Logout</a>
        <p name="user" style="margin-left: 800px; margin-top: -45px;"> ${RoleName} ${FirstName} ${LastName} </p>
    </div>
</div>
<hr>
<div class="navigation-box">
    <a href="/home" class="gradient-button">Главная</a>
    <a href="/student" class="gradient-button">Студенты</a>
    <a href="/disciplins" class="gradient-button">Дисциплины</a>
    <a href="/term" class="gradient-button">Семестры</a>
    <a href="/contacts" class="gradient-button">Контакты</a>
</div>
<c:if test="${RoleId==1}">
<div>
    <a href="/newsCreating" class="action-button"><img class="prefix-button" src="../resources/img/pencil.png"
                                                       width="18px" alt="">Добавить объявление</a>

    <a href="#" class="action-button" onclick="deletNews()"><img class="prefix-button"
                                                                 src="../resources/img/trash.png"
                                                                 width="18px">Удалить объявление</a>
    </c:if>
</div>
<div class="content-box">
    <c:forEach items="${AllNews}" var="n">
        <h1 display="inline">
            <th>
                <input type="checkbox" value="${n.id}" name="idNews">
            </th>
                ${n.header}
        </h1>
        <th> ${n.text} </th>
    </c:forEach>
</div>
<form action="/deletNews" method="post" id="deletNewsForm">
    <input type="hidden" id="deletNewsHidden" name="idnNews">
</form>
<footer>
    Created by Tsarckov Alexandr &copy 2022
</footer>
</body>
</html>