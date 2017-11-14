package iotest;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class reader extends JFrame{
	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;//创建面板对象
	private JTextArea jTextArea = null;//创建文本域对象
	private JPanel controlPanel = null;
	private JButton openBtn = null;
	private JButton closeBtn = null;
	private File file = null;
	public reader(){
		file = new File("字符流读写Demo.txt");
		initFrame();
	}
	void initFrame(){
		this.setSize(300,200);
		this.setContentPane(getJContentPane());
		this.setTitle("字符流读写Demo!");
		this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	/**
	 * 读取按钮
	 * 
	 * */
 	 JButton getCloseBtn(){
 		 if(closeBtn==null){
 			closeBtn = new JButton();
 			closeBtn.setText("读取文本");
 			closeBtn.addActionListener(
 					new ActionListener() {
						
						@Override
						public void actionPerformed(ActionEvent e) {
							try {
								FileReader in = new FileReader(file);
								char arr[] = new char[1024];
								int leng = in.read(arr);
								jTextArea.setText(new String(arr,0,leng));
								System.out.println("读取成功="+file.getPath());
								in.close();

							} catch (Exception e1) {
								// TODO Auto-generated catch block
								e1.printStackTrace();
							}
							
						}
					}
 			);
 			 
 		 }
		return closeBtn;
 		 
 	 }
	
 	/**
 	 * 写入按钮
 	 * 
 	 * */
  	 JButton getOpenBtn(){
  		 if(openBtn==null){
  			openBtn = new JButton();
  			openBtn.setText("写入文本");
  			openBtn.addActionListener(
  					new ActionListener() {
 						
 						@Override
 						public void actionPerformed(ActionEvent e) {
 							try {
 								FileWriter out = new FileWriter(file);
 								String str = jTextArea.getText();
 								out.write(str);
 								out.close();
 								System.out.println("写入成功");
 							} catch (Exception e1) {
 								// TODO Auto-generated catch block
 								e1.printStackTrace();
 							}
 							
 						}
 					}
  			);
  		 }
 		return openBtn;
  	 }

  	 JPanel getJContentPane(){
  		 if(jContentPane==null){
  			 jContentPane = new JPanel();
  			 jContentPane.setLayout(new BorderLayout());
  			 JScrollPane pane = new JScrollPane(getJTextArea());
			 jContentPane.add(pane,BorderLayout.CENTER);
  			 jContentPane.add(getControlPanel(),BorderLayout.SOUTH);
  		 }
  		 return jContentPane;
  	 }
  	 
  	 /**
  	  * 初始化文本域
  	  * */
  	JTextArea getJTextArea(){
  		if(jTextArea==null){
  			jTextArea = new JTextArea(20,50);
  		}
  		return jTextArea;
  	}
  	
 	 JPanel getControlPanel(){
  		 if(controlPanel==null){
  			 controlPanel = new JPanel();
  			 controlPanel.setLayout(new GridLayout(1, 1, 5, 5));
  			 controlPanel.add(getOpenBtn());
  			 controlPanel.add(getCloseBtn());
  		 }
  		 return controlPanel;
  	 }
}
