package regex;

import java.util.regex.*;
/**
 * Pattern类的split分割功能
 * @author sargeles
 *
 */
public class Replacement {
	public static void main(String[] args) throws Exception {
		// 生成一个Pattern,同时编译一个正则表达式
		Pattern p = Pattern.compile("[/]+");
		// 用Pattern的split()方法把字符串按"/"分割
		String[] result = p
				.split("Kevin has seen《LEON》seveal times,because it is a good film."
						+ "/ 凯文已经看过《这个杀手不太冷》几次了，因为它是一部" + "好电影。/名词:凯文。");
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);
		
		result = p
				.split("Kevin has seen《LEON》seveal times,because it is a good film."
						+ "/ 凯文已经看过《这个杀手不太冷》几次了，因为它是一部" + "好电影。/名词:凯文。",2);
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	}
}