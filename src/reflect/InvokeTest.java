package reflect;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;


public class InvokeTest {
	public static void main(String[] args) {
		try {
			//获取测试样例的类类型和测试实例
			Class<?> c = Class.forName("reflect.InvokeDemo");
			Object obj = c.newInstance();
			//反射调用
			Method m = c.getMethod("add1",int.class,int.class);
			int[] i={1,2};
			m.invoke(obj,i[1],i[0]);
			//没有必要通过反射调用的static方法
			InvokeDemo.add2(1, 3);
			//反射修改属性
			Field field = c.getDeclaredField("st");
			field.setAccessible(true);
	        field.set(obj, "男");
	        System.out.println(field.get(obj));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}