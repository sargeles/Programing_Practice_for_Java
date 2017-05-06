package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * 测试两种基本的控制台输入读取方法。
 * @author sargeles
 */
public class About_IO {
	public static void main(String[] args) throws IOException {
		// 第一种方式
		/*
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); int
		 * i=br.read();//默认读取一个字符，输出其字符的ascii编码 char c =
		 * (char)br.read();//需要强制转换才能得到字符 //这里的读取一行，读取的是未被输出的，仍在缓冲区的内容。 String
		 * str =br.readLine();
		 */

		// 第二种方式
		Scanner sc = new Scanner(System.in);
		// 可以预测下次的输入，
		int i = sc.nextInt();
		/*
		 * 下面两个语句的区别 next识别一段字符串，若匹配这段字符串，就输入这段。 next识别回车符
		 */
		String c = sc.next("aaa");
		String str = sc.nextLine();
		/*
		 * 可以自定义分隔符，将输入分解为标记。
		 */
		String input = "1 fish 2 fish red fish blue fish";
		Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
		System.out.println(s.nextInt());
		System.out.println(s.nextInt());
		System.out.println(s.next());
		System.out.println(s.next());

		System.out.println(i);
		System.out.println(c);
		System.out.println(str);
		/* br.close(); */
		sc.close();
	}
}
