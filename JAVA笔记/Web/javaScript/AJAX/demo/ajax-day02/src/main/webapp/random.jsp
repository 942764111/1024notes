<%@ page 
 contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<html>
<head>

<script type="text/javascript"
src="js/jquery-1.4.3.js">
</script>

<script type="text/javascript">
	$(function(){
		$('#a1').click(f1);
	});
	
	function f1(){
		$.ajax({
			"url":"getScore.do",
			"type":"post",
			"dataType":"text",
			"success":function(obj){
				$('#s1').html(obj);
			}
		});
	}
</script>

</head>
<body style="font-size:30px;">
	<a id="a1" href="javascript:;">
		点这儿，显示苍老师的分数</a><br/>
	<span id="s1"></span>
</body>
</html>




