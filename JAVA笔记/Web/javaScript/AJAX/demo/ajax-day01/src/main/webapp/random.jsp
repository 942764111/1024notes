<%@ page 
 contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>

<script type="text/javascript"
src="js/ajax.js">

</script>
<script type="text/javascript">
	function showScore(){
		var xhr = getXhr();
		xhr.open('get','getScore.do?' + Math.random(),true);
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && 
					xhr.status == 200){
				var txt = xhr.responseText;
				$('s1').innerHTML = txt;
			}
		};
		xhr.send(null);
	}
</script>
</head>
<body style="font-size:30px;">
	<a href="javascript:showScore();">
	点这儿，显示苍老师的分数</a> <br/>
	<span id="s1"></span>
</body>
</html>

