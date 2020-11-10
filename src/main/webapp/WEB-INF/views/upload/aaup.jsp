<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>Home</title>
    <script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
</head>
<body>
<script type="text/javascript">
    function doExcelUploadProcess(){
        var f = new FormData(document.getElementById('form1'));
        $.ajax({
            url: "aaup",
            data: f,
            processData: false,
            contentType: false,
            type: "POST",
            success: function(data){
                console.log(data);
                location.href='/index'
            }
        })
    }
    function back(){
		location.href='/index'
        }
    
</script>
<h3>AA UPLOAD </h3>
<form id="form1" name="form1" method="post" enctype="multipart/form-data">
    <input type="file" id="fileInput" name="fileInput">
    <br><hr>
    <button type="button" onclick="doExcelUploadProcess()">엑셀업로드 작업</button> ※기존 데이터는 삭제됩니다.※<br><hr>
    <button type="button" onclick="back()">뒤로 ></button>
</form>
<div id="result">
</div>
</body>
</html>
