package day03;

import java.util.UUID;

/**
 * java生成UUID
 

通过系统时间,产生系统不重复唯一识别码的类，
一般长度是32位



GUID

GUID是一个128位长的数字，一般用16进制表示。
算法的核心思想是结合机器的网卡、当地时间、一个随即数来生成GUID。
用它可以产生一个号称全球唯一的ID
 * @author adminitartor
 *
 */
public class UUIDDemo {
	public static void main(String[] args) {
		String uuid = UUID.randomUUID()
				      .toString()
				      .replaceAll("-", "");
		System.out.println(uuid);
	}
}




