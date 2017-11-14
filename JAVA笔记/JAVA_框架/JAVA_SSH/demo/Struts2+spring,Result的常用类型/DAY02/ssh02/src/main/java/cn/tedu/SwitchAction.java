package cn.tedu;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class SwitchAction {
	int num;
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String doSwitch(){
		return Integer.toString(num);
	}

}








