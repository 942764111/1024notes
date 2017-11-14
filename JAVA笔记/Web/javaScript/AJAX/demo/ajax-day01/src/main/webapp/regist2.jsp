<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>

<script type="text/javascript" 
src="js/ajax.js">
</script>

<script type="text/javascript">
		function check(){
			var xhr = getXhr();
			xhr.open('post','check.do',true);
			//添加content-type消息头
			xhr.setRequestHeader('content-type',
					'application/x-www-form-urlencoded');
			xhr.onreadystatechange = function(){
				if(xhr.readyState == 4 && 
						xhr.status == 200){
					var txt = xhr.responseText;
					$('check_msg').innerHTML = txt;
				}
			};
			xhr.send('adminCode=' 
					+ $F('adminCode'));
		}
</script>

</head>
<body style="font-size:30px;">
	<form action="" method="post">
		帐号:<input id="adminCode" name="adminCode" 
		onblur="check();"/>
		<span id="check_msg"></span>
		<br/>
		密码:<input type="password" 
			name="pwd"/><br/>
		<input type="submit" value="注册"/>	
	</form>
</body>
</html>