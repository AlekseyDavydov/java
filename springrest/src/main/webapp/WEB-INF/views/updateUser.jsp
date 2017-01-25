<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Редактирование данных пользователя</title>
</head>
<body>

<form:form action="${user.getId()}" method="put">
    <table>
        <tr>
            <td> Редактирование пользователя</td>
        </tr>
        <tr>
            <td> Введите имя</td>
            <td><input required type="text" name="name" placeholder="${user.name}"></td>
        </tr>
        <tr>
            <td> Введите возраст</td>
            <td><input required type="text" name="age" placeholder="${user.age}"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Сохранить"></td>
        </tr>
    </table>


</form:form>


</body>
</html>
