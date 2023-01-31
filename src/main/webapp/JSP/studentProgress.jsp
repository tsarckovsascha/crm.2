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
    <h1>Отображена успеваемость для следующего студента</h1>

    <table class="students-table">
        <tr>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Группа</th>
            <th>Дата поступления</th>
        </tr>
        <tr>
            <td>${student.surname}</td>
            <td>${student.name}</td>
            <td>${student.group}</td>
            <td>${student.group}</td>
            <td>${student.datr_enter}</td>
        </tr>
    </table>
    <c:if test="${termNull != '1' }"></c:if>
    <form action="/studentProgress" method="get" id="studentProgressForm">
        <input type="hidden" name="idStudent" value="${student.id}">
        <div class="grade-box">
            <div display="inline">
                <b>Выбрать семестр:</b>
                <select name="selectId" onchange="document.getElementById('studentProgressForm').submit()">
                    <c:forEach items="${allTerms}" var="t">
                        <option
                                <c:if test="${t eq term}">selected</c:if>
                                value="${t.id}">${t.name}</option>
                    </c:forEach>
                </select>
            </div>
            <b>Длительность семестра: ${term.duration}</b>
            <b>Среднея оценка : ${avaradeaMark}</b>
        </div>
        <table class="students-table">

            <tr>
                <th>Дисциплина</th>
                <th>Оценка</th>
            </tr>
            <c:forEach items="${DisciplinMark}" var="dm">
                <tr>
                    <th>${dm.name}</th>
                    <th>${dm.mark}</th>
                </tr>
            </c:forEach>
        </table>
    </form>
    <c:if test="${teremNull == '1' }">
<h2>у данного студента отсутвуют семестры</h2>
    </c:if>
</div>
<footer>
    Created by Tsarckov Alexandr &copy 2022
</footer>
</body>
</html>