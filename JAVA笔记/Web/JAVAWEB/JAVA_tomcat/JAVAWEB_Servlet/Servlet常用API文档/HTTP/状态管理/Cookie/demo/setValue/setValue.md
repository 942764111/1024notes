 - 所谓Cookie的修改，本质是获取到要变更值的Cookie，
 - 通过setValue方法将新的数据存入到cookie中，
 - 然后由response响应对象发回到客户端，
 - 对原有旧值覆盖后即实现了修改。主要实现代码：

----------

<p>Cookie[] cookies =  request.getCookies();</p>
<p>if(cookies!=null){</p>
        for(Cookie c : cookies){
            String cookieName = c.getName();
            if（name.equals(“uname”)){
                c.setValue(“Mark”);
                response.addCookie( c );
        }
}

----------
<div class = "bg-blue">
	注意：
	<ol>
		<li>其中response.addCookie（c）是非常重要的语句，如果没有这一行代码，</li>
		<li>那么就算是使用setValue方法修改了Cookie的值，</li>
		<li>但是不发回到客户端的话，也不会实现数值的改变。</li>
		<li>所以只要见到response.addCookie这行代码，即服务器端发回了带有Set-Cookie消息头的信息。</li>
	<ol>
</div>