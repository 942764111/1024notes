package cn.tedu.util;

import java.io.Serializable;

public class Result implements Serializable{

	private static final long serialVersionUID = 6906563598361667707L;
	
	private int status; //状态值：0表示成功
	private String msg; //保存提示信息
	private Object data;//保存返回的数据
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Result() {
	
	}
}





