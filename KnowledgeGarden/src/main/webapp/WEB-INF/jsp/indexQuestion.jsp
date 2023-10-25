<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問一覧</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f6f6f6;
        text-align: center;
        margin: 0;
        padding: 0;
    }
    .styled-button {
        background-color: #ff6b6b;
        color: #fff;
        border: none;
        padding: 10px 20px;
        font-weight: bold;
        text-transform: uppercase;
        border-radius: 5px;
    }
    .styled-button:hover {
        background-color: #ff4d4d;
    }
    .container {
        max-width: 800px;
        margin: 20px auto;
        padding: 20px;
        border-radius: 5px;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    }
    .styled-table {
        width: 100%;
        border-collapse: collapse;
    }
    .styled-table th, .styled-table td {
        border: 1px solid #dcdcdc;
        text-align: left;
        padding: 10px;
    }
    .styled-table th {
        background-color: #f2f2f2;
    }
    .styled-table a {
        text-decoration: none;
        color: #0066cc;
        font-weight: bold;
    }
    .styled-table a:hover {
        text-decoration: underline;
    }
    .small-column {
        font-size: 14px;
    }
    .button-container {
        display: flex;
        justify-content: space-between;
    }
</style>
</head>
<body>
<div class="container">
    <div class="button-container">
        <form action="CreateQuestion" method="get">
            <input class="styled-button" type="submit" value="新しい質問を作成">
        </form>
        <div><!-- This empty div creates space between the button and the table --></div>
    </div>
    <br> 
    <table class="styled-table">
        <thead>
            <tr>
                <th class="small-column">No.</th>
                <th>質問</th>
                <th class="small-column">質問者</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="question" items="${questions}" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td><a href="ShowQuestion?id=${question.id}">${question.title}</a></td>
                    <td class="small-column">${question.user.name}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>


