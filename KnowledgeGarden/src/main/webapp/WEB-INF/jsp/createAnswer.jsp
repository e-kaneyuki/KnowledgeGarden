<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>回答登録</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f6f6f6;
        text-align: center;
        margin: 0;
        padding: 0;
    }

    .container {
        width: 60%;
        margin: 20px auto;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        padding: 20px;
        border-radius: 5px;
    }

    .form-group {
        margin: 10px 0;
        text-align: left;
    }

    label {
        display: block;
        font-weight: bold;
    }

    span {
        font-weight: bold;
        color: #ff6b6b;
    }

    textarea {
        width: 95%;
        padding: 8px;
        height: 100px;
    }

    .back-button {
        text-align: center;
        margin-top: 20px;
    }

    .back-button button {
        background-color: #ff6b6b;
        color: #fff;
        padding: 10px 20px;
        border: none;
        cursor: pointer;
        font-weight: bold;
        border-radius: 5px;
        margin-right: 10px;
    }

    .back-button button:hover {
        background-color: #ff4d4d;
    }

    .details-table {
        width: 100%;
        border-collapse: collapse;
        margin: 20px auto;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
    }

    .details-table th, .details-table td {
        border: 1px solid #dcdcdc;
        text-align: left;
        padding: 10px;
    }

    .details-table th {
        background-color: #f2f2f2;
    }
</style>
</head>
<body>
<div class="container">
    <h1>質問詳細</h1>
    <table class="details-table">
        <tr>
            <th>質問タイトル:</th>
            <td>${question.title}</td>
        </tr>
        <tr>
            <th>質問内容:</th>
            <td>${question.content}</td>
        </tr>
        <tr>
            <th>質問者:</th>
            <td>${question.user.name}</td>
        </tr>
    </table>

    <h2>回答作成</h2>
    <form action="CreateAnswer" method="post">
        <div class="form-group">
            <label for="answerAuthor">回答者:</label>
            <span><%= session.getAttribute("userName") %></span>
        </div>
        <div class="form-group">
            <label for="answerContent">回答本文:</label>
            <textarea id="answerContent" name="answerContent" rows="5" required></textarea>
        </div>
        <div class="back-button">
            <button type="button" onclick="location.href='ShowQuestion?id=${question.id}'">質問一覧へ戻る</button>
            <input type="hidden" name="questionId" value="${question.id}">
            <button type="submit">投稿</button>
        </div>
    </form>
</div>
</body>
</html>



