<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>可愛い回答ページ</title>
<style>
    body {
        font-family: Arial, sans-serif;
        background-color: #f6f6f6;
        text-align: center;
    }

    .container {
        width: 60%;
        margin: 20px auto;
        background-color: #fff;
        box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
        padding: 20px;
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
        width: 100%;
        padding: 10px;
    }

    .back-button {
        margin-top: 20px;
        text-align: center;
    }

    button {
        background-color: #ff6b6b;
        color: #fff;
        padding: 10px 20px;
        border: none;
        cursor: pointer;
        font-weight: bold;
    }

    .styled-button {
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
<div class="container">
    <h1>質問詳細</h1>
    <p>質問ID: ${question.id}</p>
    <p>質問タイトル: ${question.title}</p>
    <p>質問内容: ${question.content}</p>
    <p>質問者: ${question.user.name}</p>

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
            <button type="button" onclick="goBack()" class="styled-button">戻る</button>
            <input type="hidden" name="questionId" value="${question.id}">
            <input type="submit" value="投稿" class="styled-button">
        </div>
    </form>
</div>
<script>
    function goBack() {
        window.history.back();
    }
</script>
</body>
</html>
