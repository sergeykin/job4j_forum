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
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-+0n0xVW2eSR5OomGNYDnhzAbDsOXxcvSN1TPprVMTNDbiYZCxYbOOl7+AMvyTG2x" crossorigin="anonymous">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!--<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js"
            integrity="sha384-Atwg2Pkwv9vp0ygtn1JAojH0nYbwNJLPhwyoVbhoPwBhjQPR5VtM2+xf0Uwh9KtT"
            crossorigin="anonymous"></script>

    <title>Post</title>
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
                <td>ид:</td>
                <td><input type='text' name='id' readonly value="${post.id}"></td>
            </tr>
            <tr>
                <td>Название:</td>
                <td><input type='text' name='name' value="${post.name}"></td>
            </tr>
            <tr>
                <td>Описание:</td>
                <td><input type='text' name='desc' value="${post.desc}"></td>
            </tr>

            <tr>
                <td colspan='2'><input name="submit" type="submit" value="Сохранить"/></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
