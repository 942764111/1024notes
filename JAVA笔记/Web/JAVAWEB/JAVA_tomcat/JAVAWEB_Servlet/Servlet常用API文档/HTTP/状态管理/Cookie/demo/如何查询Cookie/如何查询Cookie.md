#如何查询Cookie

- 当客户端向服务器发出请求时，
- 服务器端可以尝试着从请求数据包的消息头中获取是否携带了Cookie信息。
- 实现这一功能的代码如下：
<div class = "bg-blue">Cookie[] request.getCookies();</div>

----------

- 由于客户端是可以存放多个Cookie的，
- 所以request提供的获取Cookie的方法的返回值是Cookie数组，
- 如果想进一步获取某一个Cookie信息可以通过遍历数组，
- 分别获取每一个Cookie的name和value。代码如下：
<p>
Cookie[] cookies =  request.getCookies();</p>
if(cookies!=null){</p>
<p>        for(Cookie c : cookies){</p>
            String cookieName = c.getName();
            String cookieValue = c.getValue();
        }
}