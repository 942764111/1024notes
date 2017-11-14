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
