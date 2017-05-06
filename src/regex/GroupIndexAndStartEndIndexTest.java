package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * String group() 返回当前查找而获得的与组匹配的所有子串内容 
 * String group(int group)返回当前查找而获得的与指定的组匹配的子串内容 
 * int groupCount() 返回当前查找所获得的匹配组的数量。
 * start() 返回当前查找所获子串的开始字符在原目标字符串中的位置。 
 * int end() 返回当前匹配的子串的最后一个字符在原目标字符串中的索引位置 。 
 * @author sargeles
 */
public class GroupIndexAndStartEndIndexTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello,World! in Java.World! ";
		Pattern pattern = Pattern.compile("W(or)(ld!)");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			System.out.println("Group 0:" + matcher.group(0));// 得到第0组——整个匹配,相当于matcher.group()
			System.out.println("Group 1:" + matcher.group(1));// 得到第一组匹配——与(or)匹配的
			System.out.println("Group 2:" + matcher.group(2));// 得到第二组匹配——与(ld!)匹配的，组也就是子表达式
			System.out.println("Start 0:" + matcher.start(0) + " End 0:"
					+ matcher.end(0));// 总匹配的索引
			System.out.println("Start 1:" + matcher.start(1) + " End 1:"
					+ matcher.end(1));// 第一组匹配的索引
			System.out.println("Start 2:" + matcher.start(2) + " End 2:"
					+ matcher.end(2));// 第二组匹配的索引
			System.out.println(str.substring(matcher.start(0), matcher.end(2)));// 从总匹配开始索引到第1组匹配的结束索引之间子串——Wor
		}
	}

}