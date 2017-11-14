<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!-- 引入Struts提供的标签库 -->
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Hello Struts2</title>
</head>
<body>
	<!-- 利用ONGL表达式获取数据 -->
	<s:property value="message" /><br>
	<s:property value="[1].message" />
	<s:property value="#session.loginName"/><br>
	<!-- 利用EL表达式获取数据 -->
	${message}<br>
	${loginName}<br>
	<!-- 输出ValueStack中的数据 -->
	<s:debug></s:debug>
</body>
</html>





