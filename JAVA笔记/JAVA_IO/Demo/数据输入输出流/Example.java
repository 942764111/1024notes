package ioTest;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Example {
	public Example() {
		Dataio();
	}
	void Dataio(){
		try {
			FileOutputStream fs = new FileOutputStream("DataDemo.txt");
			DataOutputStream ds = new DataOutputStream(fs);
			ds.writeUTF("д������123 Dataio()");
			ds.writeChars("д������123 Dataio()");
			ds.writeBytes("д������123 Dataio()");
			ds.close();
			
			FileInputStream fis = new FileInputStream("DataDemo.txt");
			DataInputStream dis = new DataInputStream(fis);
			System.out.println(dis.readUTF());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
