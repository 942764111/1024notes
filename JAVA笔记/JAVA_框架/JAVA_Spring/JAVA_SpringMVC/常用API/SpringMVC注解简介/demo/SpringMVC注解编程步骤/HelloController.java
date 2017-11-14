package controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * 处理器类
 *
 */
@Controller
public class HelloController {
	
	@RequestMapping("/hello.do")
	public String hello(){
		System.out.println("hello()");
		return "hello";
	}
	
	@RequestMapping("/toLogin.do")
	public String toLogin(){
		System.out.println("toLogin()");
		return "login";
	}
	
	@RequestMapping("/login.do")
	/*
	 * DispatcherServlet在调用处理器的方法之前，
	 * 会利用java反射机制分析方法的结构，在这儿，
	 * 发现需要request对象，就会将request对象
	 * 传进来(了解)。
	 */
	public String login(
			HttpServletRequest request){
		System.out.println("login()");
		String adminCode = 
				request.getParameter("adminCode");
		System.out.println("adminCode:"
				+ adminCode);
		return "index";
	}
	
	@RequestMapping("/login2.do")
	/*
	 * DispatcherServlet在调用处理器的方法之前，
	 * 会利用java反射机制分析方法的结构，在这儿，
	 * 会调用request提供的方法(getParameter)
	 * 获得参数值，然后赋给对应的形参。
	 * 如果形参与请求参数名不一样，使用@RequestParam
	 * 注解。
	 */
	public String login2(String adminCode,
			@RequestParam("pwd") 
			String password){
		
		System.out.println("login2()");
		System.out.println("adminCode:" 
		+ adminCode);
		System.out.println("pwd:" 
				+ password);
		return "index";
	}
	
	@RequestMapping("/login3.do")
	/**
	 * DispatcherServlet会负责创建AdminParam
	 * 对象，并将相应的参数值赋给对应的属性。
	 */
	public String login3(AdminParam ap){
		System.out.println("login3()");
		System.out.println("adminCode:"
		+ ap.getAdminCode());
		return "index";
	}
	
	
	@RequestMapping("/login4.do")
	//向页面传值的第一种方式 ：将数据绑订到request
	public String login4(AdminParam ap,
			HttpServletRequest request){
		System.out.println("login4()");
		String adminCode = 
				ap.getAdminCode();
		request.setAttribute("adminCode",
				adminCode);
		//DispatcherServlet默认使用转发
		return "index";
	}
	
	@RequestMapping("/login5.do")
	//向页面传值的第二种方式：返回ModelAndView对象。
	/*
	 * DispatcherServlet会负责将ModelAndView对象
	 * 中的数据到出来，绑订到request对象。
	 */
	public ModelAndView login5(AdminParam ap){
		System.out.println("login5()");
		String adminCode = 
			ap.getAdminCode();
		//先将数据添加到Map
		Map<String,Object> data = 
			new HashMap<String,Object>();
		//相当于request.setAttribute(
		//"adminCode",adminCode");
		data.put("adminCode", adminCode);
		//创建ModelAndView对象
		ModelAndView mav = 
				new ModelAndView("index",data);
		return mav;
	}
	
	@RequestMapping("/login6.do")
	//向页面传值的第三种方式：将数据添加到
	//ModelMap对象里面。
	/*
	 * DispatcherServlet会将数据从ModelMap中
	 * 取出来，绑订到request对象。
	 */
	public String login6(AdminParam ap,
			ModelMap mm){
		System.out.println("login6()");
		String adminCode = 
				ap.getAdminCode();
		//相当于request.setAttribute(
		//"adminCode",adminCode);
		mm.addAttribute("adminCode", 
				adminCode);
		return "index";
	}
	
	@RequestMapping("/login7.do")
	//向页面传值的第四种方式：绑订数据到session
	public String login7(AdminParam ap,
			HttpSession session){
		System.out.println("login7()");
		String adminCode  = 
				ap.getAdminCode();
		session.setAttribute("adminCode",
				adminCode);
		return "index";
	}
	
	@RequestMapping("/login8.do")
	//重定向方式一
	public String login8(){
		return "redirect:toIndex.do";
	}
	
	@RequestMapping("/toIndex.do")
	public String toIndex(){
		return "index";
	}
	
	@RequestMapping("/login9.do")
	public ModelAndView login9(){
		RedirectView rv = 
			new RedirectView("toIndex.do"); 
		ModelAndView mav =
		new ModelAndView(rv); 
		return mav;
	}
}














