package reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class InvokeTest {
	public static void main(String[] args) {
		try {
			//��ȡ���������������ͺͲ���ʵ��
			Class<?> c = Class.forName("reflect.InvokeDemo");
			Object obj = c.newInstance();
			//�������
			Method m = c.getMethod("add1",int.class,int.class);
			int[] i={1,2};
			m.invoke(obj,i[1],i[0]);
			//û�б�Ҫͨ��������õ�static����
			InvokeDemo.add2(1, 3);
			//�����޸�����
			Field field = c.getDeclaredField("st");
			field.setAccessible(true);
	        field.set(obj, "��");
	        System.out.println(field.get(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}