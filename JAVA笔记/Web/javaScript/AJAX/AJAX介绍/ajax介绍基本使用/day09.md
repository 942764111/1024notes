# 1. ajax (asynchronous javascript and xml)
## (1)ajax是什么?
是一种用来改善用户体验的技术。其本质是利用浏览器提供的一个
特殊对象(ajax对象，即XMLHttpRequest对象)向服务器发送异步
请求,服务器返回部分数据（通常不是一个完整的页面）。浏览器
利用这些数据对当前页面做局部更新。整个过程页面无刷新，不打断
用户的操作。<br/>
注：异步请求指的是，当ajax对象发送请求时，浏览器不会销毁当前
页面，用户仍然可以对当前页面做其它的操作。<br/>
![](ajax.png)

## (2)如何获得ajax对象?
![](a1.png)

## (3)重要属性
![](a2.png)

## (4)编程步骤
step1. 获得ajax对象。比如:<br/>
var xhr = getXhr(); <br/>
step2. 利用ajax对象发生请求。<br/>

方式一：发送get请求 <br/>
	    xhr.open('get','check.do?adminCode=tom',true); <br/>
    	xhr.onreadystatechange=f1; <br/>
    	xhr.send(null); <br/>
注：<br/>
true:异步 <br/>
false:同步（发送请求时，浏览器会锁定当前页面，用户对当前页面不能
做任何操作）。<br/>

方式二：发送post请求 <br/>
		xhr.open('post','check.do',true);
		xhr.setRequestHeader('content-type',
		'application/x-www-form-urlencoded');
		xhr.onreadystatechange = f1;
		xhr.send('adminCode=tom');
注:按照http协议的要求，如果发送的是post请求，必须添加content-type
消息头，默认情况下，ajax对象不会添加该消息头，所以需要调用
setRequestHeader方法。<br/>

step3. 编写服务器端的程序。<br/>
注：通常只需要返回部分的数据。<br/>
step4. 编写事件处理函数。<br/>
function f1(){  <br/>
	//先获得服务器返回的数据  <br/>
	if(xhr.readyState == 4 &&   <br/>
		xhr.status == 200){   <br/>
		//文本数据   <br/>
		var txt = xhr.responseText; <br/>
		//更新页面  <br/>
		...
	} <br/>
}  <br/>

## (5)缓存问题
### 什么是缓存问题?
使用ie浏览器提供的ajax对象发送get请求时，会比较请求地址是否
访问过，如果访问过了，则不再发送新的请求，而是显示之前缓存的
结果。<br/>
### 如何解决?
在请求地址后面添加上随机数。<br/>

练习：
	利用ajax技术实现级联下拉列表。
![](exec.png)



	
