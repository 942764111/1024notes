package cn.tedu;

import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.util.ValueStack;

@Controller
public class StackAction {
	private String message;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute(){
		ActionContext ctx
				=ActionContext.getContext();
		ValueStack stack=ctx.getValueStack();
		Person p=new Person(
				1,"Jack","Hello Jack");
		stack.push(p);
		ctx.getSession().put(
				"loginName", "Robin");
		message="demo stack";
		
		return "success";
	}

}




