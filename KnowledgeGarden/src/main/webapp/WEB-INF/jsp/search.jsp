<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
  <script>
  function sendData() {
	    const textValue = document.getElementById('searchTerm').value;
	    window.opener.handleDataFromChild(textValue);
	    window.close();
  }
  </script>
</head>
<body>
  <input type="text" id="searchTerm" name="searchTerm">
  <button onclick="sendData()">検索</button>
</body>
</html>