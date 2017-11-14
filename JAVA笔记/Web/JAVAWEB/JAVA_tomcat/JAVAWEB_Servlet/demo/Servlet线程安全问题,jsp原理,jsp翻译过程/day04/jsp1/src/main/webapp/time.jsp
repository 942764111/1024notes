<!-- 
pageEncoding：声明此jsp文件的编码。
contentType：向浏览器声明输出的格式。
 -->
<%@page pageEncoding="utf-8"
	contentType="text/html"
	import="java.util.*,java.text.*"%>
<%
	Date date = new Date();
	SimpleDateFormat sdf = 
		new SimpleDateFormat("HH:mm:ss");
	String now = sdf.format(date);
%>
<p><%=now %></p>










