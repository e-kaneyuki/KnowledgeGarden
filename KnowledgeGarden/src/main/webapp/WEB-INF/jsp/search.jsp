<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html style="height: 100%;">
<head>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f8f9fa;
            margin: 0;
            padding: 0;
            display: flex;
            justify-content: center;
            align-items: center;
            height: 100%;
        }
        #search-container {
            width: 300px;
            padding: 20px;
            background-color: #fff;
            border-radius: 10px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            text-align: center;
        }
        #searchTerm {
            width: 80%;
            padding: 8px;
            border: 1px solid #ccc;
            border-radius: 5px;
            box-sizing: border-box;
            font-size: 16px;
        }
        button {
            background-color: #ff85a2;
            color: white;
            padding: 10px 20px;
            margin: 10px 0;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 16px;
            width: 100%;
        }
        button:hover {
            background-color: #ff6b8b;
        }
    </style>
    <script>
        function sendData() {
            const textValue = document.getElementById('searchTerm').value;
            window.opener.handleDataFromChild(textValue);
            window.close();
        }
    </script>
</head>
<body>
    <div id="search-container">
        <input type="text" id="searchTerm" name="searchTerm" placeholder="キーワードを入力">
        <button onclick="sendData()">検索</button>
    </div>
</body>
</html>

