<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>質問登録</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f8f8;
            text-align: center;
        }
        h1 {
            color: #ff6f61;
        }
        form {
            max-width: 500px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        label {
            display: block;
            text-align: left;
            margin: 10px 0;
        }
        input[type="text"],
        textarea {
            width: 80%;
            padding: 10px;
            margin: 5px 0;
            border: 1px solid #ddd;
            border-radius: 5px;
        }
        textarea {
            resize: none;
        }
        input[type="submit"],
        button {
            background-color: #ff6f61;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
        }
        .form-group {
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .back-button {
            text-align: left;
            margin-top: 20px;
        }
    </style>
</head>
<body>
    <h1>質問投稿フォーム</h1>
    <form action="CreateQuestion" method="post">
        <div class="form-group">
            <label for="questionTitle">質問タイトル:</label>
            <input type="text" id="questionTitle" name="questionTitle" required>
        </div>
        <div class="form-group">
            <label for="questionAuthor">質問者:</label>
            <span><%= session.getAttribute("userName") %></span>
        </div>
        <div class="form-group">
            <label for="questionContent">質問本文:</label>
            <textarea id="questionContent" name="questionContent" rows="5" required></textarea>
        </div>
        <div class="back-button">
        	<button onclick="goBack()">戻る</button>
        	<input type="submit" value="投稿">
    	</div>
    </form>

    <script>
        function goBack() {
            window.history.back();
        }
    </script>
</body>
</html>




