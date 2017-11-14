package cn.tedu;

import org.springframework.stereotype.Controller;

@Controller
public class JsonAction {
	private int id;
	private String message;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String execute(){
		id=100;
		message="你饿了吗？";
		return "success";
	}
}






