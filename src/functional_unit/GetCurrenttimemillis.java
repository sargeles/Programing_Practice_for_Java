package functional_unit;

import java.util.Arrays;
import java.util.Date;

public class GetCurrenttimemillis  {
	public static void main(String[] args) {
		/*
		 * System�ж����public static native long currentTimeMillis();
		 * ������1970��1��1��0ʱ��ĺ�������ms��
		 */
		long currenttimemillis = System.currentTimeMillis();
		System.out.println(currenttimemillis+"ms");
		
		
	}
}
