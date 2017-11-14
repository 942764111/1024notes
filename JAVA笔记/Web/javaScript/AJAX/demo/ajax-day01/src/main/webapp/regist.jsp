<%@ page contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>

<script type="text/javascript" 
src="js/ajax.js">
</script>

<script type="text/javascript">
	function check(){
		//step1. 获得ajax对象
		var xhr = getXhr();
		//step2. 利用ajax对象发送请求
		
		var uri = 'check.do?adminCode=' 
			+ $F('adminCode');
		
		xhr.open('get',encodeURI(uri),true);
		
		xhr.onreadystatechange = function(){
			//step4. 处理服务器端返回的数据
			if(xhr.readyState == 4 && 
					xhr.status == 200){
				//获得服务器返回的数据
				var txt = xhr.responseText;
				//更新页面
				$('check_msg').innerHTML = txt;
			}
		};
		
		xhr.send(null);
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