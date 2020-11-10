<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Home</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
<script type="text/javascript">
    function master(){
		location.href='excel/master'
    }
    
    function aa(){
    	location.href='excel/aa'
    }
</script>

<form id="form1" name="form1" method="post" enctype="multipart/form-data">
    <br><hr>
    <button type="button" onclick="master()">MASTER차트 넣기</button><br><hr>
    <button type="button" onclick="aa()">AA차트 넣기</button><br><hr>
</form>
<div id="result">
</div>
</body>
</html>
