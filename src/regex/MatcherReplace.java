package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * String replaceAll(String replacement) ��Ŀ���ַ����������ģʽ��ƥ����Ӵ�ȫ���滻Ϊָ�����ַ����� 
 * StringreplaceFirst(String replacement) ��Ŀ���ַ������һ�������ģʽ��ƥ����Ӵ��滻Ϊָ�����ַ�����
 * appendReplacement(StringBuffer sb, String replacement) ����ǰƥ���Ӵ��滻Ϊָ���ַ�����
 * ���ҽ��滻����Ӵ��Լ���֮ǰ���ϴ�ƥ���Ӵ�֮����ַ�������ӵ�һ��StringBuffer����� 
 * ��appendTail(StringBuffersb) ���������һ��ƥ�乤����ʣ����ַ�����ӵ�һ��StringBuffer�����
 * 
 * @author sargeles
 */
public class MatcherReplace {
	public static void main(String[] args) throws Exception {
		// ����Pattern�����ұ���һ���򵥵�������ʽ"Kelvin"
		Pattern p = Pattern.compile("Kelvin");
		// ��Pattern���matcher()��������һ��Matcher����
		Matcher m = p
				.matcher("Kelvin Li and Kelvin Chan are both working in Kelvin Chen's KelvinSoftShop company");
		StringBuffer sb = new StringBuffer();
		int i = 0;
		// ʹ��find()�������ҵ�һ��ƥ��Ķ���
		boolean result = m.find();
		// ʹ��ѭ�������������е�kelvin�ҳ����滻�ٽ����ݼӵ�sb��
		while (result) {
			i++;
			m.appendReplacement(sb, "Kevin");
			System.out.println("��" + i + "��ƥ���sb�������ǣ�" + sb);
			// ����������һ��ƥ�����
			result = m.find();
		}
		// ������appendTail()���������һ��ƥ����ʣ���ַ����ӵ�sb�
		m.appendTail(sb);
		System.out.println("����m.appendTail(sb)��sb������������:" + sb.toString());
	}
}