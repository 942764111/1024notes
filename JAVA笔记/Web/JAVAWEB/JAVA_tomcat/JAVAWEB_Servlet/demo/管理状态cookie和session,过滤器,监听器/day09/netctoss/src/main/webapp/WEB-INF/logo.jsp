<%@page pageEncoding="utf-8"%>
<img src="images/logo.png" alt="logo" class="left"/>
<!-- 
	EL默认的取值范围是:
		page->request->session->application
	EL也支持从cookie中取值,语法是:
		cookie.name.value
 -->
<%-- <span>${cookie.user.value }</span> --%>
<span>${user }</span>
<a href="#">[退出]</a>





