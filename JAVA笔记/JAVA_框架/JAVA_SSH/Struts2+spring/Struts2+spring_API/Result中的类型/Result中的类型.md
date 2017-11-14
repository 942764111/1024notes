#Result的常用类型

##什么是？结果，服务器处理后的结果。处理结果的组件。
更多类型参考struts2-core包下的struts-defaul.xml中的 result-type标签
##常用类型：

dispatcher：转发（Struts2默认是dispatcher）

redirectAction：重定向Action

    语法：https://8080/xxxx/demo/hello
    <result name="" type="redirectAction">hello</result>
    或
    <result name="" type="redirectAction">
    	<param name="namespace">/demo</param>
    	<param name="actionName">hello</param>
    </result>

redirect：重定向URL

	 语法：http://doc.tedu.cn
	    <result type="redirect">
	    	http://doc.tedu.cn
	    </result>
	    或
	    <result type="redirect">
	    	<param name="location">
	    			http://doc.tedu.cn
	    	</param>
	    </result>

stream：流，处理图片或下载

    语法：
    <result name="success" type="stream">
       <param name="contentType">image/jpeg</param>
       <param name="inputName">imageStream</param>
       <param name="contentDisposition">attachment;filename="document.pdf"</param>
       <param name="bufferSize">1024</param>
    </result>

<div class="bg-blue">例：</div>
 - [点击查看JAVA实现类](demo/stream/ImageAction.java)
 
 <div class="bg-blue">例：</div>
- [点击查看struts.xml](demo/stream/struts.xml)

json  ：处理ajax请求 需要导入包Struts2-json-plugin

    语法：
	返回Action的所有属性
    <result type="json"></result>
    或
	返回指定的Action属性
    <result type="json">
    	<param name="root">
    		value
    	</param>
    </result>

<div class="bg-blue">例：</div>
 - [点击查看JAVA实现类](demo/json/JsAction.java)
 
 <div class="bg-blue">例：</div>
- [点击查看struts.xml](demo/json/struts.xml)