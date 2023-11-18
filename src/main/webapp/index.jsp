


<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<meta charset="utf-8">
<body>
<h2>Hello World!</h2>


<form action="Port/t1" method="post">
    <input type="text" name="name" value="name">
    <input type="text" name="dateOn" value="dateOn">
    <input type="text" name="dateOff" value="dateOff">
    <input type="text" name="id" value="id">
    <input type="text" name="action" value="action">
    <input type="submit" value="提交2">
</form>

<hr>
<form method="post">
    <input type="submit" value="t1" formaction="Port/t1">
    <input type="submit" value="t2" formaction="Port/t2">
</form>




</body>
</html>
