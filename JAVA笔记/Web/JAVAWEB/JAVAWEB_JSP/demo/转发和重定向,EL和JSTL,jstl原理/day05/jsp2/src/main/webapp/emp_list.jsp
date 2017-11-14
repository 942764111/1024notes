<%@page pageEncoding="utf-8"
	import="java.util.*,entity.*"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8"/>
		<title>查询员工</title>
		<style>
			table {
				border: 1px solid red;
				border-collapse: collapse;
				width: 40%;
			}
			td {
				border: 1px solid red;
			}
		</style>
	</head>
	<body>
		<table>
			<tr>
				<td>编号</td>
				<td>姓名</td>
				<td>职位</td>
				<td>工资</td>
			</tr>
			<%
				List<Emp> list = (List<Emp>)
					request.getAttribute("emps");
				if(list != null) {
					for(Emp e : list) {
			%>
					<tr>
						<td><%=e.getEmpno() %></td>
						<td><%=e.getEname() %></td>
						<td><%=e.getJob() %></td>
						<td><%=e.getSal() %></td>
					</tr>
			<%			
					}
				}
			%>
		</table>
	</body>
</html>









