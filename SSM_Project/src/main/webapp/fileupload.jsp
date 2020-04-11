<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>文件上传</title>
</head>
<body>
<h3>文件上传之SpringMVC方式上传</h3>
<form action="user/fileupload2" method="post" enctype="multipart/form-data">
    选择上传文件：<input type="file" name="upload" /> <br />
    <input type="submit" value="上传" />
</form>
<br />
<h3>文件上传之跨服务器方式上传</h3>
<form action="user/fileupload3" method="post" enctype="multipart/form-data">
    选择上传文件：<input type="file" name="upload" /> <br />
    <input type="submit" value="上传" />
</form>
</body>
</html>
