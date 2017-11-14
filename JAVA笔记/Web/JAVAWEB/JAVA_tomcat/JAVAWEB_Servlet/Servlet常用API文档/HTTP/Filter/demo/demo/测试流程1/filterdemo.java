package filterdemo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class filterdemo implements Filter {
	private FilterConfig config;
	public filterdemo() {
		System.out.println("CommentFilter1's filterdemo...");
	}

	public void destroy() {
		System.out.println("CommentFilter1's destroy...");

	}
	 /*
	      	���������doFilter��������������(�൱��servlet��service����)��
	     	�����Ὣrequest����(arg0)��response����(arg1)��Ϊ��������doFilter������
	     	���������FilterChain(arg2)��doFilter(request,response)������
			����������ú����Ĺ���������servlet��������������ϡ�
      */
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
	     HttpServletRequest request = (HttpServletRequest)arg0;
         HttpServletResponse response =(HttpServletResponse)arg1;
         
         request.setCharacterEncoding("utf-8");
         response.setContentType("text/html;charset=utf-8");
         
         PrintWriter out = response.getWriter();
         
         String content = request.getParameter("content");
         String illegalStr = config.getInitParameter("illegalStr");
         
         if(content.indexOf(illegalStr) != -1){
             //��������
        	 System.out.println("û�����д�");
         }else{
             //û��������
        	 System.out.println("�����д�");
             // ִ��FilterChain��doFilter����ú����Ĺ���������servlet��
             arg2.doFilter(arg0, arg1);
         }
         System.out.println("Filter1's doFilter end.");

	}
	
	  /*
      	FilterConfig��������������ʹ������ĳ�ʼ��������
      	init����ֻ��ִ��һ�Ρ�
     */
	public void init(FilterConfig arg0) throws ServletException {
        System.out.println("CommentFilter1's init...");
        config = arg0;
	}

}
