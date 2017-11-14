<%@page pageEncoding="utf-8"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>第1个JSP</title>
	</head>
	<body>
		<!-- 3.jsp声明 -->
		<%!
			public double bai(double n) {
				return n*100;
			}
		%>
		<ul>
			<!-- 1.jsp脚本 -->
			<%
			for(int i=0;i<5;i++) {
			%>
				<!-- 2.jsp表达式 -->
				<li><%=bai(Math.random()) %></li>
			<%
			}
			%>
		</ul>
		<!-- 将time.jsp引入到此处 -->
		<%@include file="time.jsp"%>
	</body>
</html>














