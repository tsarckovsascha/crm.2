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
    <script src="../resources/js/functions.js"></script>

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
    <a href="#" class="action-button" onclick="studentProgress()"><img class="prefix-button"
                                                                       width="18px" alt="">Посмотреть успеваемость
        студента</a>
    <c:if test="${RoleId==1}">

        <a href="/studentCreating" class="action-button"><img class="prefix-button" src="../resources/img/pencil.png"
                                                              width="18px" alt="">Добавить нового студента</a>

        <a href="#" class="action-button" onclick="daletStudent()"><img class="prefix-button"
                                                                        src="../resources/img/trash.png"
                                                                        width="18px" alt="">Удалить студента</a>
    </c:if>
    <div class="action-box">
    <table class="students-table">
        <tr>
            <th></th>
            <th>Фамилия</th>
            <th>Имя</th>
            <th>Группа</th>
            <th>Дата поступления</th>
            <th></th>
        </tr>
        <c:forEach items="${allStudent}" var="s">
            <tr>
                <th>
                    <input type="checkbox" value="${s.id}" name="idStudent">
                </th>
                <td>${s.surname}</td>
                <td>${s.name}</td>
                <td>${s.group}</td>
                <td><fmt:formatDate pattern="dd/MM/yyyy" value="${s.datr_enter}"/>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<form action="/daletStudent" method="post" id="deleteStudentForm">
    <input type="hidden" id="deleteStudentHidden" name="idsStudent">
</form>
<form action="/studentProgress" method="get" id="studentProgressForm">
    <input type="hidden" id="studentProgressHidden" name="idStudent">
</form>
<footer>
    Created by Tsarckov Alexandr &copy 2022
</footer>
</body>
</html>
