<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>質問一覧</title>
<style>
    .styled-table {
        width: 80%; /* テーブルの幅を調整 */
        border-collapse: collapse;
        border: 1px solid #dcdcdc;
        margin: 20px auto; /* テーブルを中央揃え */
    }

    .styled-table th {
        background-color: #f2f2f2;
        border: 1px solid #dcdcdc;
        text-align: left;
        padding: 10px;
    }

    .styled-table td {
        border: 1px solid #dcdcdc;
        text-align: left;
        padding: 10px;
    }

    .small-column {
        font-size: 14px; /* カラム内のフォントサイズを調整 */
        padding: 8px; /* カラム内のパディングを調整 */
    }

    .styled-table a {
        text-decoration: none; /* リンクの下線を削除 */
        color: #0066cc; /* リンクのテキスト色を変更 */
    }

    .styled-table a:hover {
        text-decoration: underline; /* リンクをホバー時に下線表示 */
    }

    .styled-button {
        background-color: #ff6b6b;
        color: #fff;
        border: none;
        padding: 10px 20px;
        font-weight: bold;
        text-transform: uppercase; /* ボタンのテキストを大文字に */
    }
</style>
</head>
<body>
<form action="CreateQuestion" method="get">
    <input class="styled-button" type="submit" value="新しい質問を作成">
</form>
<br> 
<table class="styled-table">
    <thead>
        <tr>
            <th class="small-column">No.</th>
            <th>質問</th>
            <th class="small-column">質問者</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach var="question" items="${questions}">
            <tr>
                <td class="small-column">${question.id}</td>
                <td><a href="ShowQuestion?id=${question.id}">${question.title}</a></td>
                <td class="small-column">${question.user.name}</td>
            </tr>
        </c:forEach>
    </tbody>
</table>
</body>
</html>
