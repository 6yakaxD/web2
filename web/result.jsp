<%@ page import="model.Point" %>
<%@ page import="java.util.ArrayList" %>

<%--
  Created by IntelliJ IDEA.
  User: rmtj7
  Date: 10/22/2024
  Time: 4:50 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link rel="stylesheet" href="style.css">

    <title>Лабораторная 2 по вебу</title>
</head>
<body>


<a href="index.jsp">На Главную</a>

<% ArrayList<Point> history = (ArrayList<Point>) session.getAttribute("history"); %>
<div class="results-section">
    <table id="result-table">
        <thead>
        <tr>
            <th>X</th>
            <th>Y</th>
            <th>R</th>
            <th>Результат</th>
            <th>Время</th>
            <th>Время выполнения</th>
        </tr>
        </thead>
        <tbody id="results">
        <% if (history != null && !history.isEmpty()) {
            for (Point p : history) {
        %>
        <tr>
            <th><%= p.getX() %></th>
            <th><%= p.getY() %></th>
            <th><%= p.getR() %></th>
            <th><%= p.getStatus() %></th>
            <th><%= p.getLocalTime() %></th>
            <th><%= p.getExecutionTime() %></th>
        </tr>
        <% } }%>
        </tbody>
    </table>
</div>


</body>
</html>