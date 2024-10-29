<%--
  Created by IntelliJ IDEA.
  User: rmtj7
  Date: 10/12/2024
  Time: 11:29 PM
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


<div class="headder">
    <h1>Таджеддинов Рамиль Эмильевич</h1>
    <p>Группа P3208, Вариант 75389</p>
</div>

<div class="main">
    <div class="graph-wrapper">
        <svg xmlns="http://www.w3.org/2000/svg" width="300" height="300">
            <rect x="30" y="150" width="120" height="60" fill-opacity="0.4" stroke="navy" fill="blue"></rect>
            <polygon points="150,150 210,150 150,210" fill-opacity="0.4" stroke="navy" fill="blue"></polygon>
            <path d="M150 150 L 30 150 C 30 80 80 30 150 30 L 150 150 Z" fill-opacity="0.4" stroke="navy"
                  fill="blue"></path>
            <circle id="pointer" r="5" cx="150" cy="150" fill-opacity="0.7" fill="red" stroke="firebrick"
                    visibility="hidden"></circle>

            <line x1="0" y1="150" x2="300" y2="150" stroke="#FFFFFF"></line> <!-- Ось X -->
            <line x1="150" y1="0" x2="150" y2="300" stroke="#FFFFFF"></line> <!-- Ось Y -->
            <line x1="270" y1="148" x2="270" y2="152" stroke="#FFFFFF"></line> <!-- Стрелочка на оси X -->
            <text x="265" y="140" fill="#FFFFFF">R</text>
            <line x1="210" y1="148" x2="210" y2="152" stroke="#FFFFFF"></line> <!-- Стрелочка на оси X -->
            <text x="200" y="140" fill="#FFFFFF">R/2</text>
            <line x1="90" y1="148" x2="90" y2="152" stroke="#FFFFFF"></line> <!-- Стрелочка на оси X -->
            <text x="75" y="140" fill="#FFFFFF">-R/2</text>
            <line x1="30" y1="148" x2="30" y2="152" stroke="#FFFFFF"></line> <!-- Стрелочка на оси X -->
            <text x="20" y="140" fill="#FFFFFF">-R</text>
            <line x1="148" y1="30" x2="152" y2="30" stroke="#FFFFFF"></line> <!-- Стрелочка на оси Y -->
            <text x="156" y="35" fill="#FFFFFF">R</text>
            <line x1="148" y1="90" x2="152" y2="90" stroke="#FFFFFF"></line> <!-- Стрелочка на оси Y -->
            <text x="156" y="95" fill="#FFFFFF">R/2</text>
            <line x1="148" y1="210" x2="152" y2="210" stroke="#FFFFFF"></line> <!-- Стрелочка на оси Y -->
            <text x="156" y="215" fill="#FFFFFF">-R/2</text>
            <line x1="148" y1="270" x2="152" y2="270" stroke="#FFFFFF"></line> <!-- Стрелочка на оси Y -->
            <text x="156" y="275" fill="#FFFFFF">-R</text>
            <polygon points="300,150 295,155 295,145" fill="#FFFFFF" stroke="#FFFFFF"></polygon>
            <!-- Стрелочка на оси X -->
            <polygon points="150,0 145,5 155,5" fill="#FFFFFF" stroke="#FFFFFF"></polygon> <!-- Стрелочка на оси Y -->
        </svg>
    </div>

    <div class="input-wrapper">

        <form method="POST" class="data-form">
            <table>
                <tr>
                    <td><p>Введите X:</p></td>
                    <td><label for="y"></label><input type="text" id="x" required></td>
                </tr>
                <tr>
                    <td><p>Введите Y:</p></td>
                    <td id="y">
                        <label><input type="radio" name="y" value="-2">-2</label>
                        <label><input type="radio" name="y" value="-1.5">-1.5</label>
                        <label><input type="radio" name="y" value="-1">-1</label>
                        <label><input type="radio" name="y" value="-0.5">-0.5</label>
                        <label><input type="radio" name="y" value="0">0</label>
                        <label><input type="radio" name="y" value="0.5">0.5</label>
                        <label><input type="radio" name="y" value="1">1</label>
                        <label><input type="radio" name="y" value="1.5">1.5</label>
                        <label><input type="radio" name="y" value="2">2</label>
                    </td>
                </tr>
                <tr>
                    <td><p>Введите R:</p></td>
                    <td id="r">
                        <label><input type="radio" name="r" value="1">1</label>
                        <label><input type="radio" name="r" value="1.5">1.5</label>
                        <label><input type="radio" name="r" value="2">2</label>
                        <label><input type="radio" name="r" value="2.5">2.5</label>
                        <label><input type="radio" name="r" value="3">3</label>
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <div style="display: flex; justify-content: center; align-items: center;">
                            <button id="resultButton" type="submit" onclick="sendData()">Отправить</button>
                        </div>
                    </td>
                </tr>
            </table>
        </form>

    </div>

</div>


<jsp:include page="template.jsp" />

<script src="script.js"></script>

</body>
</html>