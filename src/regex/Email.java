package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Email {
	public static void main(String[] args) throws Exception {
		String input = "www.!@$baidu.@#com";
		// ��������EMAIL��ַ�Ƿ��� �Ƿ�����"."��"@"��Ϊ��ʼ�ַ�
		Pattern p = Pattern.compile("^.|^@");
		Matcher m = p.matcher(input);
		if (!m.lookingAt()) {
			System.out.println("�Ƿ�����\".\"��\"@\"��Ϊ��ʼ�ַ�");
			return;
		}
		// ����Ƿ���"www."Ϊ��ʼ
		m.reset();
		p = Pattern.compile("^www.");
		m = p.matcher(input);
		if (!m.lookingAt()) {
			System.out.println("������\"www.\"Ϊ��ʼ ");
			return;
		}
		// ����Ƿ�����Ƿ��ַ�
		m.reset();
		p = Pattern.compile("[^A-Za-z0-9.@_-~#]+");
		m = p.matcher(input);
		StringBuffer sb = new StringBuffer();
		boolean result = m.find();
		while (result) {
			// �����������Ƿ��ַ���ð��˫���ŵȣ���ô�Ͱ�������ȥ���ӵ�SB����
			m.appendReplacement(sb, "");
			result = m.find();
		}
		m.appendTail(sb);
		System.out.println("�����ڵ�����Ϊ: " + input);
		System.out.println("�޸ĺ�Ϸ��ĵ�ַӦ����: " + sb);
	}
}
