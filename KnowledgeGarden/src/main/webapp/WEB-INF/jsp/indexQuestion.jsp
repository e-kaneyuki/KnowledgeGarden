<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>質問一覧</title>
    <style>
        body {
            font-family: 'Arial', sans-serif;
            background-color: #f6f6f6;
            text-align: center;
            margin: 0;
            padding: 0;
        }
        .container {
            max-width: 800px;
            margin: 20px auto;
            padding: 20px;
            border-radius: 10px;
            background-color: #ffffff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.2);
            position: relative; /* 親要素に position: relative; を設定 */
        }
        .styled-button {
            background-color: #ff6b6b;
            color: #fff;
            border: none;
            padding: 12px 24px;
            font-weight: bold;
            text-transform: uppercase;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .styled-button:hover {
            background-color: #ff4d4d;
        }
        .styled-table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
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
            align-items: center;
            margin-top: 20px;
        }
        .search-form {
            display: flex;
            align-items: center;
        }
        .search-input {
            flex: 1;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 5px;
            font-size: 14px;
        }
        .search-button {
            background-color: #009688;
            color: #fff;
            border: none;
            padding: 12px 24px;
            font-weight: bold;
            text-transform: uppercase;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s;
        }
        .search-button:hover {
            background-color: #007769;
        }
        .logout-link {
            position: absolute;
            top: 20px; /* 上からの距離を調整 */
            right: 20px; /* 右からの距離を調整 */
        }
    </style>
</head>
<body>
<script>
	function openWindow() {
	    window.open('Search', '小窓', 'width=400,height=300, left=50,top=165');
	}
	
	function handleDataFromChild(textValue) {
		const form = document.createElement('form');
	    
	    // formの基本設定
	    form.method = 'POST';
	    form.action = '/KnowledgeGarden/Search';
	    form.style.display = 'none';
	    
	    // hiddenのinput要素を作成して、受け取ったtextValueを値として設定
	    const input = document.createElement('input');
	    input.type = 'hidden';
	    input.name = 'searchTerm';
	    input.value = textValue;
	    
	    // inputをformに追加
	    form.appendChild(input);
	    
	    // formをページに追加
	    document.body.appendChild(form);
	    
	    // formを自動的に送信
	    form.submit();
	}

</script>
    <div class="container">
        <a href="Logout" class="logout-link">ログアウト</a>
        <h2>質問一覧</h2>
        
        <form action="Search" method="POST" class="search-form">
            <input type="text" name="searchTerm" placeholder="質問を検索" class="search-input">
            <button type="submit" class="search-button">検索</button>
            <button type="button" onclick="window.location.href = 'IndexQuestion'" class="styled-button">全てを表示</button>
        </form>
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
        <div class="button-container">
             <button type="button" onclick="window.location.href = 'CreateQuestion'" class="styled-button">新しい質問を作成</button>
            <button type="button" class="styled-button" onclick="openWindow()">検索</button>
        </div>
    </div>
</body>
</html>
