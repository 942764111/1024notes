#Struts2+spring整合

----------

##为什么要整合Spring？
- 通过Spring管理组件，实现注入。

##如何整合？
- 1、导包：Struts2-spring-plugin.jar

- 2、配置文件:web.xml spirng-*.xml struts.xml

##步骤
1、创建项目-导包：Struts2-core2.3.8 Struts2-spring-plugin 2.3.8


2、配置web.xml spring-context.xml struts.xml

- 如果添加了Struts2-spring-plugin 2.3.8包必须实现Spring初始化监听配置不然启动服务器会抛出异常
<div class="bg-blue">例：</div>
- [web.xml点击查看](demo/步骤一/web.xml)
- [spring-context.xml点击查看](demo/步骤一/spring-context.xml)
- [struts.xml点击查看](demo/步骤一/struts.xml)

3、实现Action 注入service

<div class="bg-blue">例：</div>
- [点击查看Action.class](demo/步骤二/HelloAction.java)