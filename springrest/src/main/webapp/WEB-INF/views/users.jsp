<%@ page import="java.util.List" %>
<%@ page import="ru.itis.models.Auto" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Пользователи</title>
</head>
<body>
<table>
    <td>ID</td>
    <td>Имя</td>
    <td>Возраст</td>
    <td>Количество автомобилей</td>
    <c:forEach items="${requestScope.users}" var="user">
        <tr>
            <td>${user.getId()}</td>
            <td>${user.getName()}</td>
            <td>${user.getAge()}</td>
            <td>${user.getAuto().size()}</td>
            <td>
                <form action="/users/${user.getId()}/auto">
                    <input type="submit" value="Показать автомобили">
                </form>
            </td>
            <td>
                <form action="/users/${user.getId()}" method="post">
                    <input type="submit" value="Изменить данные пользователя">
                </form>
            </td>
            <td><form:form action="/users/${user.getId()}" method="delete">
                <input type="submit" value="Удалить пользователя">
            </form:form>
            </td>
        </tr>
    </c:forEach>
</table>
<form:form modelAttribute="user" action="users" method="post">
    <table>
        <tr>
            <td> Добавить пользователя</td>
        </tr>
        <tr>
            <td> id</td>
            <td><form:input path="id" size="5" maxlength="5"/></td>
        </tr>

        <tr>
            <td>Имя пользователя</td>
            <td><form:input path="name"/></td>
        </tr>
        <tr>
            <td>Возраст</td>
            <td><form:input path="age"/></td>
        </tr>
        <tr>
            <td><input type="submit" value="Сохранить"/></td>
        </tr>
    </table>
</form:form>
</body>
</html>

