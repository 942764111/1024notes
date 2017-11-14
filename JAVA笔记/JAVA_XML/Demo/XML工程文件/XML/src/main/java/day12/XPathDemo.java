package day12;

import java.io.FileInputStream;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用XPath检索XML文档数据
 * @author adminitartor
 *
 */
public class XPathDemo {
	public static void main(String[] args) {
		try {
			SAXReader reader = new SAXReader();
			Document doc = reader.read(
				new FileInputStream("myemp.xml")
			);
			
			String path = "/list/emp[gender='男' and salary>4000]/name";
			/*
			 * List selectNodes(String path)
			 * 根据给定的XPATH检索xml文档数据
			 */
			List<Element> list = doc.selectNodes(path);
			for(Element e : list){
				System.out.println(e.getText());
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}








