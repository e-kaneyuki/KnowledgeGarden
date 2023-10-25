<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>質問詳細</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f6f6f6;
            text-align: center;
        }
        table {
            border-collapse: collapse;
            margin: 20px auto;
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
        }
        th {
            background-color: #f2f2f2;
        }
        form {
            margin: 20px;
        }
        input[type="submit"] {
            background-color: #ff6b6b;
            color: #fff;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <table>
        <tr>
            <th>質問ID</th>
            <th>質問タイトル</th>
            <th>質問内容</th>
            <th>ユーザー名</th>
        </tr>
        <tr>
            <td>${question.id}</td>
            <td>${question.title}</td>
            <td>${question.content}</td>
            <td>${question.user.name}</td>
        </tr>
    </table>

    <table>
        <tr>
            <th>回答番号</th>
            <th>回答内容</th>
            <th>質問ID</th>
            <th>回答者ID</th>
        </tr>
        <c:forEach var="answer" items="${ansList}" varStatus="loop">
            <tr>
                <td>${loop.index + 1}</td>
                <td>${answer.content}</td>
                <td>${answer.questionId}</td>
                <td>${answer.answererId}</td>
            </tr>
        </c:forEach>
    </table>

    <form action="CreateAnswer" method="Get">
        <input type="hidden" name="questionId" value="${question.id}">
        <input type="submit" value="回答作成">
    </form>
</body>
</html>
