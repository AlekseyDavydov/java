<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Обновление данных по автомобилю</title>
</head>
<body>

<form:form action="${auto.getId()}" method="put">
    <table>
        <tr>
            <td>Обновление автомобиля</td>
        </tr>
        <tr>
            <td>Введите модель</td>
            <td><input required type="text" name="model" placeholder="${auto.model}"></td>
        </tr>
        <tr>
            <td>Введите цвет</td>
            <td><input required type="text" name="color" placeholder="${auto.color}"></td>
        </tr>
        <tr>
            <td></td>
            <td>  <input type="submit" value="Сохранить"></td>
          </tr>
    </table>
</form:form>
</body>
</html>
