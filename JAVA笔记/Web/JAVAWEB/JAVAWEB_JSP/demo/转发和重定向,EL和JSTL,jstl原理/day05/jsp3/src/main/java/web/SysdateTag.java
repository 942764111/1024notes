package web;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

public class SysdateTag extends SimpleTagSupport {

	private String format = 
			"yyyy/MM/dd HH:mm:ss";
	
	public String getFormat() {
		return format;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	public void doTag() throws JspException, IOException {
		//创建服务器时间
		Date date = new Date();
		//格式化时间
		SimpleDateFormat sdf = 
			new SimpleDateFormat(format);
		String now = sdf.format(date);
		//将时间输出给浏览器
		//PageContext extends JspContext
		//该方法声明返回JspContext，
		//但在实现时返回的是PageContext。
		//所以可以将其强转为PageContext，
		//从而获取其他8个隐含对象。
		PageContext ctx = 
			(PageContext) getJspContext();
		JspWriter out = ctx.getOut();
		out.println(now);
		//此处一定不能关闭流，因为其他的标签
		//也要用这个流。
	}

	
	
}




