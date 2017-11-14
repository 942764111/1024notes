package day12;

import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;

/**
 * 使用DOM4J生成XML文档
 * @author adminitartor
 *
 */
public class WriteXMLDemo {
	public static void main(String[] args) {
		List<Emp> empList = new ArrayList<Emp>();
		empList.add(new Emp(1,"张三",22,"男",3000));
		empList.add(new Emp(2,"李四",23,"女",4000));
		empList.add(new Emp(3,"王五",24,"男",5000));
		empList.add(new Emp(4,"赵六",25,"女",6000));
		empList.add(new Emp(5,"钱七",26,"男",7000));
		
		
		/*
		 * 生成XML文档的大致步骤:
		 * 1:创建一个Document对象表示一个空白文档
		 * 2:向文档中添加根元素
		 * 3:向根元素中按照预定结构逐级添加子元素
		 *   以及数据信息
		 * 4:创建XMLWriter
		 * 5:通过XMLWriter将Document对象写出
		 *   写出后就形成了XML文档.  
		 */
		try {
			//1
			Document doc = DocumentHelper.createDocument();
			
			/*
			 * 2
			 * Document提供了添加根元素的方法:
			 * 
			 * Element addElement(String name)
			 * 向当前文档中添加给定名字的根元素,并将该元素
			 * 以Element实例的形式返回,以便于继续操作.
			 * 注意,该方法只能调用一次,因为一个文档中只能有
			 * 一个根元素.
			 * 
			 */
			Element root = doc.addElement("list");
			
			for(Emp emp : empList){
				/*
				 * Element也提供了添加子元素的方法:
				 * Element addElement(String name)
				 * 
				 * String addText(String text)
				 * 向当前元素中添加给定的文本信息
				 */
				//向根元素<list>中添加子元素<emp>
				Element empEle = root.addElement("emp");
				
				//向<emp>标签中添加<name>标签
				Element nameEle = empEle.addElement("name");
				nameEle.addText(emp.getName());
				
				//<age>
				Element ageEle = empEle.addElement("age");
				ageEle.addText(emp.getAge()+"");
				
				Element genderEle = empEle.addElement("gender");
				genderEle.addText(emp.getGender());
				
				empEle.addElement("salary").addText(emp.getSalary()+"");
				//添加属性"id"
				empEle.addAttribute("id", emp.getId()+"");
			
			}
			
			//4
			XMLWriter writer = new XMLWriter(
				new FileOutputStream("myemp.xml"),
				OutputFormat.createPrettyPrint()
			);
			//5
			writer.write(doc);
			
			System.out.println("写出完毕!");
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}







