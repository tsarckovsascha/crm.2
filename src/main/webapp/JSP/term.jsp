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
<div class="action-box">
    <div class="action-item">
        <h1>СИСТЕМА УПРАВЛЕНИЯ СТУДЕНТАМИ И ИХ УСПЕВАЕМОСТЬЮ</h1>
        <a href="/logout" class="gradient-button" >Logout</a>
    </div>
    <c:if test="${isLogin!=1}">
        <div class="action-login">
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
        <div class="content-box">
            <h3>Cеместры:</h3>
            <form action="/term" method="get" id="termForm">
                <table class="students-table">
                    <tr>
                        <td>
                            <input type="hidden" name="idTerm" value="${termId.id}">
                            <div class="grade-box">
                                <div display="inline">
                                    <b>Выбрать семестр:</b>
                                    <select name="selectedId"
                                            onchange="document.getElementById('termForm').submit();">
                                        <c:forEach items="${allTerm}" var="t">
                                            <option
                                                    <c:if test="${t eq term}">selected</c:if>
                                                    value="${t.id}">
                                                    ${t.name}</option>

                                        </c:forEach>
                                    </select>
                                </div>
                                <b>Длительность семестра: ${term.duration}</b>
                            </div>
                        </td>
                    </tr>
                </table>
                <table class="students-table">
                    <tr>
                        <th>Дисциплины:</th>
                    </tr>
                    <c:forEach items="${termDisciplin}" var="t">
                        <tr>
                            <td>${t.disciplineName}</td>
                        </tr>

                    </c:forEach>
                </table>
            </form>


        </div>
        <footer>
            Created by Tsarckov Alexandr &copy 2022
        </footer>
</body>
</html>