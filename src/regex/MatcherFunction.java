package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * matches()方法尝试对整个目标字符展开匹配检测，也就是只有整个目标字符串完全匹配时才返回真值。
 * lookingAt()方法将检测目标字符串是否以匹配的子串起始。 
 * find()方法尝试在目标字符串里查找下一个匹配子串。
 * @author sargeles
 */
public class MatcherFunction {

	public static void main(String[] args) {
		String regex = "s{1,2}[0-9]";
		Pattern p = Pattern.compile(regex);
		CharSequence input = "ss1 ss2 ss3 ss4 ss5";//不能用new，因为是接口，不可实例化
		Matcher m = p.matcher(input);
		//也可以这样创建，如果不需要用到pattern的split方法
		//Matcher m = Pattern.compile(regex).matcher(input);
		
		//以下三个方法都将返回一个布尔值来表明成功与否。 
		//方法尝试对整个目标字符展开匹配检测，也就是只有整个目标字符串完全匹配时才返回真值。 
		System.out.println(m.matches());
		
		//方法将检测目标字符串是否以匹配的子串起始。
		System.out.println(m.lookingAt());
		m.reset();
		//方法尝试在目标字符串里查找下一个匹配子串。 
		System.out.println(m.find());
		//先find后才能输出
		System.out.println(m.group());
		
		/*Pattern p = Pattern.compile("\\d{3,5}");
        String s = "123-34345-234-00";
        Matcher m = p.matcher(s);
        System.out.println(m.matches());
        System.out.println(m.find()+"start at:"+m.start()+" end at:"+m.end());
        System.out.println(m.find()+"start at:"+m.start()+" end at:"+m.end());
//        System.out.println(m.find()+"start at:"+m.start()+" end at:"+m.end());
//        System.out.println(m.find()+"start at:"+m.start()+" end at:"+m.end());
        m.reset();
        System.out.println(m.find()+"start at:"+m.start()+" end at:"+m.end());
        System.out.println(m.find()+"start at:"+m.start()+" end at:"+m.end());*/
		
	}

}
