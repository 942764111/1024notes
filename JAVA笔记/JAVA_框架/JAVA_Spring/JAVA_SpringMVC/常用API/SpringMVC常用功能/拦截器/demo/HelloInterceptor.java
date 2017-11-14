package interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * 拦截器类
 *
 */
public class HelloInterceptor implements 
HandlerInterceptor{

	/**
	执行顺序：3
	preHandle返回true执行
	
	 * 最后执行的方法
	 * e:是处理器抛出的异常。
	 */
	public void afterCompletion(
			HttpServletRequest req, 
			HttpServletResponse res, 
			Object arg2, Exception e)
			throws Exception {
		System.out.println("afterCompletion()");
	}

	/**
	执行顺序：2
	preHandle返回true执行
	
	 * 处理器已经执行完毕，准备将处理结果(
	 * ModelAndVew)返回给DispatcherServlet之前
	 * 执行postHandle方法。
	 * 可以在该方法里面，修改处理结果。
	 */
	public void postHandle(
			HttpServletRequest req, 
			HttpServletResponse res, 
			Object arg2, ModelAndView mav)
			throws Exception {
		System.out.println("postHandle()");
	}

	/**
		执行顺序：1
		
	 * 如果该方法返回值为true,表示继续向后
	 * 调用（即调用后续的拦截器或者处理器），
	 * 如果返回值为false,则中断请求。
	 * arg2:处理器方法对象(可以获得处理器方法的
	 * 一些特征，比如方法名，参数类型等)。
	 */
	public boolean preHandle(
			HttpServletRequest req, 
			HttpServletResponse res, 
			Object arg2) throws Exception {
		System.out.println("preHandle()");
		return true;
	}

}




