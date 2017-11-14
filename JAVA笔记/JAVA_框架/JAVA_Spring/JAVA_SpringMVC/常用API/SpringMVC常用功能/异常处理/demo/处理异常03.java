package com.tarena.web;
import java.io.Serializable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/demo")
public class HelloController implements Serializable {
    
    @ExceptionHandler
    public String handleException(Exception e, 
        HttpServletRequest request, HttpServletResponse response) 
        throws Exception {
        if(e instanceof NumberFormatException) {
            request.setAttribute("message", "亲,请输入数字哦.");
            return "jsp/message";
        } else {
            throw e;
        }
    }
    
    @RequestMapping("/hello.do")
    public String hello() {
        System.out.println("hello");
        Integer.valueOf("abc");
        return "jsp/hello";
    }
    
    @RequestMapping("/hi.do")
    public String hi() {
        System.out.println("hi");
        String name = "abc";
        name.charAt(9);
        return "jsp/hello";
    }
}