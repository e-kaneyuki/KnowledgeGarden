<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>ユーザー登録</title>
    <style>
        body {
            font-family: "Arial", sans-serif;
            background-color: #f9f9f9;
        }

        .login-container {
            width: 500px;
            margin: 0 auto;
            text-align: center;
            background-color: #fff;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
        }

        .error-message {
            color: red;
            font-size: 14px;
            text-align: center;
            margin-bottom: 10px;
        }

        .form-group {
            display: flex;
            align-items: center;
            margin-bottom: 15px;
        }

        .form-group label {
            width: 150px;
            text-align: right;
            margin-right: 10px;
        }

        .form-group label {
            text-align: left;
        }

        .form-group input {
            flex: 1;
            padding: 10px;
            margin-top: 5px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        .button-container {
            display: flex;
            justify-content: flex-end;
        }

        .button-container button {
            margin-left: 10px;
            background-color: #ff5983;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }

        .button-container button:hover {
            background-color: #ff3551;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>ユーザー登録画面</h2>
        <div class="error-message" id="passwordMismatch" style="display: none;">
            パスワードとパスワード再確認が一致しません。
        </div>
        <form action="UserRegistrationServlet" method="post">
            <div class="form-group">
                <label for="userID">ID:</label>
                <input type="text" id="userID" name="userID" required>
            </div>
            <div class="form-group">
                <label for="userName">ユーザー名:</label>
                <input type="text" id="userName" name="userName" required>
            </div>
            <div class="form-group">
                <label for="password">パスワード:</label>
                <input type="password" id="password" name="password" required>
            </div>
            <div class="form-group">
                <label for="confirmPassword">パスワード再確認:</label>
                <input type="password" id="confirmPassword" name="confirmPassword" required>
            </div>
            <div class="button-container">
                <button type="button" onclick="location.href='Login'">戻る</button>
                <button type="submit">登録</button>
            </div>
        </form>
    </div>
</body>
</html>
