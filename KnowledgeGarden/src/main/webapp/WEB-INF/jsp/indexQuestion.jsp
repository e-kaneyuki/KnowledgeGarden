<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>QuestionIndex</title>
<style>
    .styled-table {
        width: 500px;
        border-collapse: collapse;
        border: 1px solid #dcdcdc;
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
        font-size: 12px; /* カラム内のフォントサイズを調整 */
        padding: 5px; /* カラム内のパディングを調整 */
    }
</style>
</head>
<body>
<form action="CreateQuestion" method="get">
    <input type="submit" value="新しい質問を作成">
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