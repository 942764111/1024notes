package cn.tedu;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

@Controller
@Scope("prototype")
public class ImageAction {
	private InputStream image;

	public InputStream getImage() {
		return image;
	}
	public void setImage(InputStream image) {
		this.image = image;
	}
	public String execute() throws IOException{
		//设置图片
		BufferedImage img
			=new BufferedImage(
			100,60,BufferedImage.TYPE_3BYTE_BGR);
		//获取画笔
		Graphics2D g=img.createGraphics();
		g.setColor(Color.white);
		g.drawString("Hello World", 10, 30);
		//将图片转换成字节数组
		ByteArrayOutputStream out
				=new ByteArrayOutputStream();
		ImageIO.write(img, "png", out);
		out.close();
		//将字节数组转换成字节流
		byte[] data=out.toByteArray();
		image=new ByteArrayInputStream(data);
		
		return "success";
	}

}








