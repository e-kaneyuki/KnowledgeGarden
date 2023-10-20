<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>ユーザー登録画面</title>
    <style>
        body {
            font-family: Arial, sans-serif;
        }

        .login-container {
            width: 500px;
            margin: 0 auto;
            text-align: center;
        }

        .error-message {
            color: red;
            font-size: 14px;
            text-align: center;
            margin-bottom: 10px; /* 下部のマージンを追加 */
        }

        .form-group {
            display: flex;
            align-items: center; /* ラベルとフォームの縦方向の中央揃え */
            margin-bottom: 15px;
        }

        .form-group label {
            width: 150px; /* ラベルの固定幅を設定 */
            text-align: right;
            margin-right: 10px;
        }

        .form-group label {
            text-align: left; /* ラベルの文字を左揃えに変更 */
        }

        .form-group input {
            flex: 1; /* フォームを残りの幅いっぱいに広げる */
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
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2>ユーザー登録画面</h2>
        <div class="error-message" id="passwordMismatch" style="display: none;">
            パスワードとパスワード再確認が一致しません。
        </div>
        <form action="loginServlet" method="post" onsubmit="return validateForm();">
			<div class="form-group">
			    <label for="userID">ID:</label>
			    <input type="text" id="userID" name="userID" required>
			</div>
			<div class="form-group">
			    <label for="userName">ユーザー名:</label> <!-- for属性を"userName"に修正 -->
			    <input type="text" id="userName" name="userName" required> <!-- id属性を"userName"に修正 -->
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
                <button type="button" onclick="location.href='Login'" style="background-color: blue; color: white;">戻る</button>
                <button type="submit" style="background-color: blue; color: white;">登録</button>
            </div>
        </form>
    </div>
    <script>
        function validateForm() {
            const password = document.getElementById("password").value;
            const confirmPassword = document.getElementById("confirmPassword").value;
            const errorElement = document.getElementById("passwordMismatch");

            if (password !== confirmPassword) {
                errorElement.style.display = "block";
                return false;
            } else {
                errorElement.style.display = "none";
                return true;
            }
        }
    </script>
</body>
</html>