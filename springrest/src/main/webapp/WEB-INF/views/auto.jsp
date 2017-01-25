<%@ page import="java.util.List" %>
<%@ page import="ru.itis.models.Auto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Список автомобилей у пользователя</title>
</head>

<body>

<table>
    <tr>
        <td>ID</td>
        <td>Модель</td>
        <td>Цвет</td>
    </tr>
    <c:forEach var="autos" items="${requestScope.autos}">
        <tr>
            <td>${autos.getId()}</td>
            <td>${autos.getModel()}</td>
            <td>${autos.getColor()}</td>
            <td>
                <form:form action="auto/${autos.id}" method="post">
                    <input type="submit" value="Изменить"">
                </form:form>
            </td>
            <td>
                <form:form action="auto/${autos.id}" method="delete">
                    <input type="submit" value="Удалить">
                </form:form></td>
            </td>
        </tr>
    </c:forEach>
</table>
<form:form modelAttribute="auto" action="auto/${autoid}" method="post">
    <table>
        <tr>
            <td>Добавить автомобиль</td>
        </tr>
        <tr>
            <td> id:</td>
            <td><form:input path="id"/></td>
        </tr>

        <tr>
            <td> Модель:</td>
            <td><form:input path="model"/></td>
        </tr>
        <tr>
            <td> Цвет:</td>
            <td><form:input path="color"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Добавить"/></td>
        </tr>
    </table>
</form:form>

<a href="/users">Назад</a>
<a href="/index">На главную</a>
</body>
</html>

