<%--
  Created by IntelliJ IDEA.
  User: sergeykin
  Date: 04.07.2021
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<c:set var="post" value="${post}"/>
<body>
<div class="container mt-3">
    <div class="row">
        <h4>Пост</h4>
    </div>
    <form action="<c:url value='/save'/>" method='POST'>
        <table>
            <tr>
                <td hidden><input type='id' name='id' value="${post.id}" readonly></td>
            </tr>
            <tr>
                <td>Название:</td>
                <td><input type='text' name='name' value="${post.name}" readonly></td>
            </tr>
            <tr>
                <td>Описание:</td>
                <td><input type='text' name='desc' value="${post.desc}" readonly></td>
            </tr>
        </table>

        <table>
            <tr>
                <td>Комментарий:</td>
                <td><input type='text' name='comment' value="" ></td>
            </tr>
        </table>

        <div>
            <input name="submit" type="submit" value="Сохранить"/>
        </div>

    </form>
</div>
</body>
</html>
