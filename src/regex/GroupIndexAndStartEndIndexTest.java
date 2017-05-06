package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * String group() ���ص�ǰ���Ҷ���õ�����ƥ��������Ӵ����� 
 * String group(int group)���ص�ǰ���Ҷ���õ���ָ������ƥ����Ӵ����� 
 * int groupCount() ���ص�ǰ��������õ�ƥ�����������
 * start() ���ص�ǰ���������Ӵ��Ŀ�ʼ�ַ���ԭĿ���ַ����е�λ�á� 
 * int end() ���ص�ǰƥ����Ӵ������һ���ַ���ԭĿ���ַ����е�����λ�� �� 
 * @author sargeles
 */
public class GroupIndexAndStartEndIndexTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "Hello,World! in Java.World! ";
		Pattern pattern = Pattern.compile("W(or)(ld!)");
		Matcher matcher = pattern.matcher(str);
		while (matcher.find()) {
			System.out.println("Group 0:" + matcher.group(0));// �õ���0�顪������ƥ��,�൱��matcher.group()
			System.out.println("Group 1:" + matcher.group(1));// �õ���һ��ƥ�䡪����(or)ƥ���
			System.out.println("Group 2:" + matcher.group(2));// �õ��ڶ���ƥ�䡪����(ld!)ƥ��ģ���Ҳ�����ӱ��ʽ
			System.out.println("Start 0:" + matcher.start(0) + " End 0:"
					+ matcher.end(0));// ��ƥ�������
			System.out.println("Start 1:" + matcher.start(1) + " End 1:"
					+ matcher.end(1));// ��һ��ƥ�������
			System.out.println("Start 2:" + matcher.start(2) + " End 2:"
					+ matcher.end(2));// �ڶ���ƥ�������
			System.out.println(str.substring(matcher.start(0), matcher.end(2)));// ����ƥ�俪ʼ��������1��ƥ��Ľ�������֮���Ӵ�����Wor
		}
	}

}