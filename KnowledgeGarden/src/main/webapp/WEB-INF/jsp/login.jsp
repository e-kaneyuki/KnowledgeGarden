<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<%
    String loginMessage = (String) session.getAttribute("loginMessage");
%>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>ログイン</title>
    <style>
        body {
            background-color: #f9f9f9; /* 背景色を明るいグレーに設定 */
            font-family: "Arial", sans-serif;
        }
        .login-container {
            background-color: #fff;
            border-radius: 10px;
            padding: 20px;
            box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
            text-align: center;
            max-width: 400px;
            margin: 0 auto;
        }
        h2 {
            color: black;
        }
        .error-message {
            color: #ff0000;
            display: none;
        }
        .form-group {
            margin: 10px 0;
            text-align: left;
        }
        label {
            display: block;
            color: #333; /* テキストカラーを通常の黒に設定 */
        }
        input {
            width: 90%;
            padding: 10px;
            border: 1px solid #ccc; /* 枠線の色をグレーに設定 */
            border-radius: 5px;
        }
        .button-container {
            text-align: center;
            margin-top: 20px;
        }
        button {
            background-color: #ff5983;
            color: #fff;
            padding: 10px 20px;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        button:hover {
            background-color: #ff3551;
        }
    </style>
</head>
<body>
	<%
	if (loginMessage != null && !loginMessage.isEmpty()) {
	%>
	        <script>
	            alert("<%= loginMessage %>");
	        </script>
	        <% session.removeAttribute("loginMessage"); %>
	<%
	    }
	%>
    <div class="login-container">
    
        <h2>ログイン</h2>
        <c:if test="${not empty passwordErrorMessage}">
        	<div style="color:red;">${passwordErrorMessage}</div>
    	</c:if>
        <form action="Login" method="post" onsubmit="return validateForm();">
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
            <div class="button-container">
                <button type="button" onclick="location.href='UserRegistrationServlet'">ユーザー登録</button>
                <button type="submit">ログイン</button>
            </div>
        </form>
    </div>
</body>
</html>

