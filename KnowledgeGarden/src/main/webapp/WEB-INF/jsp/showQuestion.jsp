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
            margin: 0;
            padding: 0;
        }
        .container {
            background-color: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            border-radius: 5px;
        }
        h1 {
            color: #333;
        }
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            padding: 10px;
            border: 1px solid #ccc;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        .btn-container {
            display: flex;
            justify-content: space-between;
            margin: 20px 0;
        }
        button {
            background-color: #ff6b6b;
            color: #fff;
            padding: 10px 20px;
            border: none;
            cursor: pointer;
            font-weight: bold;
            border-radius: 5px;
        }
        .btn-container a {
            text-decoration: none;
            color: #fff;
        }
        .btn-container a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>質問詳細</h1>
        <table>
            <tr>
                <th>質問タイトル</th>
                <td>${question.title}</td>
            </tr>
            <tr>
                <th>質問内容</th>
                <td>${question.content}</td>
            </tr>
            <tr>
                <th>ユーザー名</th>
                <td>${question.user.name}</td>
            </tr>
        </table>

        <table>
            <tr>
                <th>回答番号</th>
                <th>回答内容</th>
                <th>回答者名</th>
            </tr>
            <c:forEach var="answer" items="${ansList}" varStatus="loop">
                <tr>
                    <td>${loop.index + 1}</td>
                    <td>${answer.content}</td>
                    <td>${answer.answererName}</td>
                </tr>
            </c:forEach>
        </table>

        <div class="btn-container">
            <button type="button" onclick="location.href='IndexQuestion'">質問一覧へ</button>
            <form action="CreateAnswer" method="Get">
                <input type="hidden" name="questionId" value="${question.id}">
                <button type="submit">回答作成</button>
            </form>
        </div>
    </div>
</body>
</html>

