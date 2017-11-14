#Struts2简介

1- Struts2 apache基金会产品

2- Struts1和Struts2没有任何关系

3- Struts2的前身是webwork

4- Struts1和Struts2都是MVC设计模式

##一、Struts2作用？

作用于表现层

1、将浏览器数据发送给服务器

2、将服务器处理后的数据以一定的格式返回给客户端

##二、什么时候用？
替代springmvc框架时使用


##三、如何使用？
1、导包（Struts2-core 2.3.8）

2、配置文件（web.xml/struts.xml）

3、使用

##四、Struts标签

    匹配请求路径
    <package namespace="" extends="">
    
    匹配具体请求
    <action name="" class=""></action>
    
    匹配结果处理
    <result name="success"></result>
    
    </package>


##五、步骤：

1、创建项目-导包

	<dependency>
	  	<groupId>org.apache.struts</groupId>
	  	<artifactId>struts2-core</artifactId>
	  	<version>2.3.8</version>
	</dependency>

2、配置文件-web.xml

	 <!-- 配置主控制器及过滤条件 -->
	  <filter>
	  		<filter-name>mvc</filter-name>
	  		<filter-class>
	  			org.apache.struts2.dispatcher.ng.filter.StrutsPrepareAndExecuteFilter
	  		</filter-class>
	  </filter>
	  <filter-mapping>
	  		<filter-name>mvc</filter-name>
	  		<url-pattern>/*</url-pattern>
	  </filter-mapping>
3、添加struts.xml 
 
- 参考struts2-core包下的struts-defaul.xml

		<?xml version="1.0" encoding="UTF-8"?>
		<!DOCTYPE struts PUBLIC
		    "-//Apache Software Foundation//DTD Struts Configuration 2.3//EN"
		    "http://struts.apache.org/dtds/struts-2.3.dtd">
		<struts>
			<!-- 匹配请求路径及具体请求 -->
			<package name="demo" 
				namespace="/demo" 
				extends="struts-default">
				
				<!-- 匹配hello请求，
				使用HelloAction类中的execute()方法处理 -->
				<action name="hello" 
						  class="cn.tedu.action.HelloAction">
				
				<!-- 当execute方法返回值是“success”的时候
				实现转发到msg.jsp -->		    
					<result name="success">
						/WEB-INF/msg.jsp
					</result>
				</action>
			</package>
		</struts>

4、实现处理类

- struts2跳转到这个action后。
- 默认执行execute()方法。
- 并根据返回字符返回结果，
- 然后struts.xml根据返回的字符跳到相应的页面


		package cn.tedu.action;
		
		public class HelloAction {
			/**
			 * 默认处理方法名为execute()
			 */
			private String message;
			
			public String getMessage() {
				return message;
			}
		
			public String execute(){
				System.out.println("Hello Struts2!!!");
				//通过返回值"success"与result组件匹配
				message="HI......";
				return "success";
			}
		
		}
5、jsp实现

		<%@ page language="java" contentType="text/html; charset=utf-8"
		    pageEncoding="utf-8"%>
		<!DOCTYPE html>
		<html>
		<head>
		<meta charset="utf-8">
		<title>Hello Struts2</title>
		</head>
		<body>
			<h1>Hello Struts2!!!</h1>
			<h1>${message}</h1>
			<h1>您好：${username}</h1>
			<h1>欢迎：${user.name}</h1>
		</body>
		</html>