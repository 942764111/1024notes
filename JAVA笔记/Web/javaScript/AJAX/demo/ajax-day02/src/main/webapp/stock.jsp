<%@ page 
 contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>
	<style>
		#d1{
			width:450px;
			height:380px;
			background-color:black;
			margin-left:400px;
			margin-top:30px;
		}
		#d2{
			color:yellow;
			background-color:red;
			height:32px;
		}
		table{
			color:white;
			font-style:italic;
			font-size:25px;
		}
	</style>
	<script type="text/javascript" 
		src="js/jquery-1.4.3.js">
	</script>
	<script type="text/javascript">
		$(function(){
			setInterval(quoto,5000);
		});
		
		function quoto(){
			$.ajax({
				"url":"getStock.do",
				"type":"post",
				"dataType":"json",
				"success":function(obj){
					/*
						obj:服务器返回的数据。
						如果是json字符串，会自动
						转换成对应的javascript对象。
					*/
					$('#tb1').empty();
					for(i = 0; i < obj.length; i ++){
						var s = obj[i];
						$('#tb1').append(
							'<tr><td>' + s.code
							+ '</td><td>' + s.name 
							+ '</td><td>' + s.price 
							+ '</td></tr>');
					}
				}
			});
		}
	</script>
</head>
<body style="font-size:30px;">
	<div id="d1">
		<div id="d2">股票实时行情</div>
		<div id="d3">
			<table width="100%">
				<thead>
					<tr>
						<td>代码</td>
						<td>名称</td>
						<td>价格</td>
					</tr>
				</thead>
				<tbody id="tb1">
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>




