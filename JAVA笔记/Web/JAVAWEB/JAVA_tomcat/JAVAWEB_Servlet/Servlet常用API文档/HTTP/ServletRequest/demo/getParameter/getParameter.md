
#JAVA:

----------

- package web;

- import java.io.IOException;
- import java.io.PrintWriter;

- import javax.servlet.ServletException;
- import javax.servlet.http.HttpServlet;
- import javax.servlet.http.HttpServletRequest;
- import javax.servlet.http.HttpServletResponse;

public class RegServlet extends HttpServlet {


	protected void service(
		HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		//1.接收请求中的数据
- <div class="bg-blue">例：
		<p> String user = req.getParameter("userName");</p>
		<p>String pwd = req.getParameter("pwd");<p>
		<p>String sex = req.getParameter("sex");<p>
		<p>String[] interests = req.getParameterValues("interest");<p>
		</div>
		//采用第一种方案解决请求乱码问题
		//byte[] bs = user.getBytes("iso8859-1");
		//user = new String(bs, "utf-8");
		
		//2.利用这些数据处理业务
		System.out.println(user);
		System.out.println(pwd);
		System.out.println(sex);
		if(interests != null) {
			for(String interest : interests) {
				System.out.println(interest);
			}
		}
		//3.给浏览器返回响应信息
		res.setContentType(
			"text/html;charset=utf-8");
		PrintWriter out = res.getWriter();
		out.println("<p>Congratulations,注册成功。</p>");
		out.close();
	}

}

#WEB

----------
	<!-- 
		访问路径有3种方式：
		1.完整路径:
			http://localhost:8080/servlet2/reg
		2.绝对路径:
			规则：/项目名/servlet路径
			实例：/servlet2/reg
		3.相对路径:
			写出当前正在访问的网页和要访问的网页之间的相对关系
			当前：/servlet2/reg.html
			目标：/servlet2/reg
			相对路径为：reg
	 -->
	<form action="reg" method="post">
		<p>
			账号:<input type="text" name="userName"/>
		</p>
		<p>
			密码:<input type="password" name="pwd"/>
		</p>
		<p>
			性别:
			<input type="radio" name="sex" value="M"/>男
			<input type="radio" name="sex" value="F"/>女
		</p>
		<p>
			兴趣:
			<input type="checkbox" name="interest" value="coding"/>编程
			<input type="checkbox" name="interest" value="food"/>美食
			<input type="checkbox" name="interest" value="sleep"/>养生
		</p>
		<p><input type="submit" value="注册"/></p>
	</form>

