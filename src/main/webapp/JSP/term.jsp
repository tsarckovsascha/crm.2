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
    <link rel="stylesheet" href="../resources/styeles/style.css">
</head>
<body>
<div class="title-box">
    <div class="title-item">
        <h1>СИСТЕМА УПРАВЛЕНИЯ СТУДЕНТАМИ И ИХ УСПЕВАЕМОСТЬЮ</h1>
        <a href="/logout" class="gradient-button" style="margin-left: 1050px;margin-top: 10px">Logout</a>
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
    <a href="/contacts" class="gradient-button">Контакты</a>
</div>
<div class="content-box">
    <div class="terms-filter-box">
        <br>
        <c:if test="${RoleId==1}">
        <a href="/termCreating" class="action-button"><img class="prefix-button" src="../resources/img/add.png"
                                                           width="18px" alt="">Создать семестр</a>
        <a href="/termModifying" class="action-button">Изменить текущий семестр</a>
        <a href="" class="action-button"><img class="prefix-button" src="../resources/img/trash.png" width="18px"
                                              alt="">Удалить текущий семестр</a>
        </c:if>
        <h3>Список дисциплин семестра</h3>
        <div display="inline">
            <div class="grade-box">
                <div display="inline">
                    <b>Выбрать семестр:</b>
                    <select name="selectId" onchange="document.getElementById('term_disciplinForm').submit()">
                        <c:forEach items="${allTerms}" var="t">
                            <option
                                    <c:if test="${t eq term}">selected</c:if>
                                    value="${t.id}">${t.name}</option>
                        </c:forEach>
                    </select>
                </div>
                <b>Длительность семестра: ${term.duration}</b>
            </div>
            <table class="disciplins-table">
                <tr>
                    <td display="inline">
                    <th>Наименование</th>
                    <th></th>
                    </td>
                </tr>
                <c:forEach items="${allDisciplins}" var="d">
                    <tr>
                        <th>
                            <input type="checkbox" value="${d.id}" name="idDiscipline">
                        </th>
                        <td>${d.name}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <footer>
            Created by Tsarckov Alexandr &copy 2022
        </footer>
</body>
</html>