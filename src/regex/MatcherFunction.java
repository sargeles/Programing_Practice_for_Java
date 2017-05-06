package regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * matches()�������Զ�����Ŀ���ַ�չ��ƥ���⣬Ҳ����ֻ������Ŀ���ַ�����ȫƥ��ʱ�ŷ�����ֵ��
 * lookingAt()���������Ŀ���ַ����Ƿ���ƥ����Ӵ���ʼ�� 
 * find()����������Ŀ���ַ����������һ��ƥ���Ӵ���
 * @author sargeles
 */
public class MatcherFunction {

	public static void main(String[] args) {
		String regex = "s{1,2}[0-9]";
		Pattern p = Pattern.compile(regex);
		CharSequence input = "ss1 ss2 ss3 ss4 ss5";//������new����Ϊ�ǽӿڣ�����ʵ����
		Matcher m = p.matcher(input);
		//Ҳ���������������������Ҫ�õ�pattern��split����
		//Matcher m = Pattern.compile(regex).matcher(input);
		
		//��������������������һ������ֵ�������ɹ���� 
		//�������Զ�����Ŀ���ַ�չ��ƥ���⣬Ҳ����ֻ������Ŀ���ַ�����ȫƥ��ʱ�ŷ�����ֵ�� 
		System.out.println(m.matches());
		
		//���������Ŀ���ַ����Ƿ���ƥ����Ӵ���ʼ��
		System.out.println(m.lookingAt());
		m.reset();
		//����������Ŀ���ַ����������һ��ƥ���Ӵ��� 
		System.out.println(m.find());
		//��find��������
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
