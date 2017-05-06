package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
	public static void main(String[] args) throws Exception {
		String input = "www.!@$baidu.@#com";
		// 检测输入的EMAIL地址是否以 非法符号"."或"@"作为起始字符
		Pattern p = Pattern.compile("^.|^@");
		Matcher m = p.matcher(input);
		if (!m.lookingAt()) {
			System.out.println("非法符号\".\"或\"@\"作为起始字符");
			return;
		}
		// 检测是否以"www."为起始
		m.reset();
		p = Pattern.compile("^www.");
		m = p.matcher(input);
		if (!m.lookingAt()) {
			System.out.println("不是以\"www.\"为起始 ");
			return;
		}
		// 检测是否包含非法字符
		m.reset();
		p = Pattern.compile("[^A-Za-z0-9.@_-~#]+");
		m = p.matcher(input);
		StringBuffer sb = new StringBuffer();
		boolean result = m.find();
		while (result) {
			// 如果里面包含非法字符如冒号双引号等，那么就把他们消去，加到SB里面
			m.appendReplacement(sb, "");
			result = m.find();
		}
		m.appendTail(sb);
		System.out.println("您现在的输入为: " + input);
		System.out.println("修改后合法的地址应类似: " + sb);
	}
}
