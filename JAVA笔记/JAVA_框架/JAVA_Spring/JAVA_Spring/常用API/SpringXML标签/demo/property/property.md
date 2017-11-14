		<!-- 注入基本类型的值 
			<property name="name" value="仓松"/>
			参数：
			name：调用 class中 set方法
			value：给set方法赋值
		-->
	 <bean id="vb1" class="Value.ValueBean">
	 	<property name="name" value="仓松"/>
	 	<property name="age" value="18"/>
	 	<property name="list" >
	 		<list>
	 			<value>^_^</value>
	 			<value>o(∩∩)o...哈哈</value>
	 		</list>
	 	</property>
	 	
	 	<property name="city" >
	 		<set>
	 			<value>gg</value>
	 			<value>hh</value>
	 			<value>hh</value>
	 		</set>
	 	</property>
	 	
	 	<property name="score" >
	 		<map>
				<entry key ="english" value="59.5" />
				<entry key ="null" value="2.0" />
	 		</map>
	 	</property>
	 	
	 	
	 	<property name="db" >
	 		<props>
				<prop key ="null">www</prop>
				<prop key ="uuu">qqq</prop> 
	 		</props>
	 	</property>
	 	
	 </bean>	
	 
	 <!-- 以引用的方式注入集合的值 
	 	  赋值和注入类似
	 
	 util:XXX
	 -->
	 <util:list id="list2">
	 	<value>仍然</value>
	 	<value>童童</value>
	 	<value>应用</value>
	 </util:list>
	 
	 <bean id="vb2" class="Value.ValueBean" >
	 	<property name="list" ref="list2"></property>
	 </bean>
	 
	 
	 <!-- 读取properties文件内容 -->
	 <util:properties id="config" location="classpath:config.properties"/>
	 
	 <!-- spring表达式 
	 	<property name = "name" value="#{vb1.Name}" />
	 	参数：
	 	value：获取其他bean对象中的Get属性方法
	 -->
	 <bean id ="sb1" class="Value.SpelBean">
	 	<property name = "name" value="#{vb1.name}" />
	 	<property name = "interest" value="#{vb1.list[0]}" />
	 	
	 	<!-- 如果访问的map属性中key是中文用
	 		#{vb1.score['key']}
	 		因为spring容器只支持 ASCII码
	 	-->
	 	<property name = "score" value="#{vb1.score['english']}" />
	 	<property name = "pageSize" value="#{config.id}" />
	 </bean>