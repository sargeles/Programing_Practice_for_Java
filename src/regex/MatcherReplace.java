package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String replaceAll(String replacement) 将目标字符串里与既有模式相匹配的子串全部替换为指定的字符串。 
 * StringreplaceFirst(String replacement) 将目标字符串里第一个与既有模式相匹配的子串替换为指定的字符串。
 * appendReplacement(StringBuffer sb, String replacement) 将当前匹配子串替换为指定字符串，
 * 并且将替换后的子串以及其之前到上次匹配子串之后的字符串段添加到一个StringBuffer对象里， 
 * 而appendTail(StringBuffersb) 方法则将最后一次匹配工作后剩余的字符串添加到一个StringBuffer对象里。
 * 
 * @author sargeles
 */
public class MatcherReplace {
	public static void main(String[] args) throws Exception {
		// 生成Pattern对象并且编译一个简单的正则表达式"Kelvin"
		Pattern p = Pattern.compile("Kelvin");
		// 用Pattern类的matcher()方法生成一个Matcher对象
		Matcher m = p
				.matcher("Kelvin Li and Kelvin Chan are both working in Kelvin Chen's KelvinSoftShop company");
		StringBuffer sb = new StringBuffer();
		int i = 0;
		// 使用find()方法查找第一个匹配的对象
		boolean result = m.find();
		// 使用循环将句子里所有的kelvin找出并替换再将内容加到sb里
		while (result) {
			i++;
			m.appendReplacement(sb, "Kevin");
			System.out.println("第" + i + "次匹配后sb的内容是：" + sb);
			// 继续查找下一个匹配对象
			result = m.find();
		}
		// 最后调用appendTail()方法将最后一次匹配后的剩余字符串加到sb里；
		m.appendTail(sb);
		System.out.println("调用m.appendTail(sb)后sb的最终内容是:" + sb.toString());
	}
}