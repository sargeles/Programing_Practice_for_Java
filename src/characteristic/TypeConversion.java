package characteristic;

public class TypeConversion {
	public static void main(String[] args) {
		
		byte b = 66;
		char c='c';
		//char c = b;//char���޷��ŵģ����Բ���ת���з��ŵ�
		short s = b;
		
		int i=c;
		long l=i;
		//���������ڴ��еĶ�����ֵ����ֱ��ת��Ϊʮ������ֵ�ģ����ǰ��չ�ʽ���������ͨ����ʽ����Ȼֻ�õ���4���ֽڣ����Ǹ�����ȴ�ȳ����͵����ֵҪ��
		float f=l;
		double d=l;
		
		
	    i=c;
	    System.out.println("output:"+i);

		 i = 99;
		 b = (byte) i;
		 c = (char) i;
		 f = i;
		 
		 System.out.println(String.valueOf(l));
	}

}
