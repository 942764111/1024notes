package iotest;
import java.io.*;
public class BufferedDemo {
	File file = null;
	
	public BufferedDemo() {
		file = new File("带缓存的输出输入流Demo.txt");
		Writer();
		Reader();
	}
	/**
	 * 写入
	 * */
	void Writer(){
		String str[] = {"好久","不见"};
		try {
			FileWriter write = new FileWriter(file);
			BufferedWriter bufwrite = new BufferedWriter(write);
			for (String string : str) {
				bufwrite.write(string);
				bufwrite.newLine();
			}
			bufwrite.close();
			write.close();
			System.out.println("写入成功!");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	/**
	 * 读取 字符流
	 * */
	void Reader(){
		try {
			FileReader fr = new FileReader(file);
			BufferedReader buf = new BufferedReader(fr);
			String s = null;
			int line = 0;
			while ((s=buf.readLine())!=null) {
					line++;		
					System.out.println("第"+line+"行："+s);
			}
			buf.close();
			fr.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}	
