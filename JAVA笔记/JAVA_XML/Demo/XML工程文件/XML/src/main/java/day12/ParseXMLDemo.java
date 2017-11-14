package day12;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

/**
 * 使用DOM4J解析XML文档
 * @author adminitartor
 *
 */
public class ParseXMLDemo {
	public static void main(String[] args) {
		/*
		 * 解析XML的大致步骤:
		 * 1:创建SAXReader
		 * 2:使用SAXReader读取XML文档并生成
		 *   Document对象
		 *   这一步也是DOM解析耗时耗资源的地方,
		 *   因为会将XML文档所有内容都读取完毕
		 *   然后将内容及结构设置到Document对象
		 *   中.
		 * 3:通过Document获取根元素
		 * 4:根据文档结构从根元素开始逐级获取子元素
		 *   已达到遍历XML文档信息的目的
		 */
		try {
			//1
			SAXReader reader = new SAXReader();
			
			//2
			Document doc = reader.read(
				new FileInputStream("emplist.xml")	
			);
			
			/*
			 * 3
			 * Document提供了获取根元素的方法
			 * Element getRootElement()
			 * 
			 * Element的每一个实例用来表示XML文档中
			 * 的一个元素,即:一对标签.
			 * 
			 */
			Element root = doc.getRootElement();
			/*
			 * Element提供了很多方法,用来操作一个元素
			 * 
			 * String getName()
			 * 获取该元素的名字
			 * 
			 * Element element(String name)
			 * 获取给定名字的子元素
			 * 
			 * List elements()
			 * 获取所有子元素
			 * 
			 * List elements(String name)
			 * 获取所有同名子元素
			 * 
			 * String getText()
			 * 获取当前元素中的文本(起始与结束标签中间的文本信息)
			 * 
			 * String getTextTrim()
			 * 获取当前元素中去除两边空白后的文本
			 * 
			 * String elementText(String name)
			 * 获取当前元素中指定名字的子元素中间的文本
			 */
			/*
			 * 4 根据xml文档结构获取xml文档中的数据
			 *   将所有员工信息解析出来并以若干的
			 *   Emp实例保存在一个集合中
			 * 
			 */
			//获取<list>中的所有<emp>标签
			List<Element> emps = root.elements();
			//用来保存所有解析出来的员工信息的集合
			List<Emp> empList = new ArrayList<Emp>();
			
			for(Element empEle : emps){
//				String name = empEle.getName();
//				System.out.println(name);
				
				//获取员工姓名<name>
				Element nameEle = empEle.element("name");
				String name = nameEle.getText();
//				System.out.println(name);
				
				//获取age
				int age = Integer.parseInt(
					empEle.elementText("age")
				);
				
				String gender = empEle.elementText("gender");
				
				int salary = Integer.parseInt(
					empEle.elementText("salary")	
				);
				
				/*
				 * 获取<emp>标签中的属性"id"
				 * 
				 * Attribute的每一个实例用于表示一个元素
				 * 中的属性
				 * 有两个常用方法:
				 * String getName()
				 * 获取属性名
				 * 
				 * String getValue()
				 * 获取属性值
				 */
				Attribute attr = empEle.attribute("id");
				int id = Integer.parseInt(
					attr.getValue()
				);
				
				Emp e = new Emp(id, name, age, gender, salary);
				empList.add(e);
			}
			
			System.out.println("解析完毕!");
			System.out.println("解析了"+empList.size()+"个员工信息");
			for(Emp emp : empList){
				System.out.println(emp);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}









