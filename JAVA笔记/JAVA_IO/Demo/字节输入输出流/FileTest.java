package iotest;
import java.io.*;
public class FileTest {
	private File file = null;
	String type = "io";
	public FileTest() {
		file = new File("test.txt");
		
		switch (type) {
		case "Creater":
			CreaterFile();
			break;
		case "io":
			ioFile();
			break;	
		default:
			break;
		}

	}
	void CreaterFile(){

		if(file.exists()){
			System.out.println(file.getAbsoluteFile());
		}else{
			try {
				file.createNewFile();
				System.out.println("文件已创建");
				System.out.println(file.getAbsoluteFile());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}
	void ioFile(){
		if(file.exists()){
			try {
				FileInputStream in = new FileInputStream(file);
				byte but[] = new byte[1024];
				int leng = in.read(but);
				
				System.out.println("文件内容："+new String(but,0,leng));
				in.close();
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
		}else{
		try {
			FileOutputStream output = new FileOutputStream(file);
			byte but[] = "哈哈哈哈哈哈".getBytes();
			output.write(but);
			output.close();
			System.out.println("创建成功："+file.getAbsoluteFile());
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	}
}
