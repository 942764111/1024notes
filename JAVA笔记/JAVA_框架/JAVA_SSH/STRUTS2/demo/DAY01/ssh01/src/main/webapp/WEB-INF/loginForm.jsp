<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    
<%@ taglib prefix="c" 
   uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Login</title>
</head>
<body>
	<c:url var="url" value="/login/login.action"/>
	<h1>${message}</h1>
	<form action="${url}" method="post">
		<div>用户：<input name="user.name" type="text"/></div>
		<div>密码：<input name="user.pwd" type="password"/></div>
		<div><input type="submit" value="登录" /></div>
	</form>
</body>
</html>





