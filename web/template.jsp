<%@ page import="model.Point" %>
<%@ page import="java.util.ArrayList" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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