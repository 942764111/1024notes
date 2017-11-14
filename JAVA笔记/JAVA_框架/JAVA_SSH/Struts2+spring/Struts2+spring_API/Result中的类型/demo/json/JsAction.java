package cn.tedu;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;

@Controller
public class JsAction {
	private int id;
	private String message;
	private Map<String,Object> value
			=new HashMap<String,Object>();
	public Map<String, Object> getValue() {
		return value;
	}
	public String execute(){
		id=100;
		message="Hello";
		value.put("title", "盲僧三定律");
		value.put("law1", "RQ");
		value.put("law2", "尾Q");
		value.put("law3", "回旋踢");
		
		return "success";
	}

}






