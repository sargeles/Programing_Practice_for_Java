package regex;

import java.util.regex.*;
/**
 * Pattern���split�ָ��
 * @author sargeles
 *
 */
public class Replacement {
	public static void main(String[] args) throws Exception {
		// ����һ��Pattern,ͬʱ����һ��������ʽ
		Pattern p = Pattern.compile("[/]+");
		// ��Pattern��split()�������ַ�����"/"�ָ�
		String[] result = p
				.split("Kevin has seen��LEON��seveal times,because it is a good film."
						+ "/ �����Ѿ����������ɱ�ֲ�̫�䡷�����ˣ���Ϊ����һ��" + "�õ�Ӱ��/����:���ġ�");
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);
		
		result = p
				.split("Kevin has seen��LEON��seveal times,because it is a good film."
						+ "/ �����Ѿ����������ɱ�ֲ�̫�䡷�����ˣ���Ϊ����һ��" + "�õ�Ӱ��/����:���ġ�",2);
		for (int i = 0; i < result.length; i++)
			System.out.println(result[i]);
	}
}