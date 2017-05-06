package reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class InvokeTest2 {
	public static void main(String[] args) {
	  String	str = "I'm not changed!";
	  change(str);
	  System.out.println(str);
	}
	
	static void change(String str){
		try {
            Class<?> clazz = str.getClass();
            Field field = clazz.getDeclaredField("value");
            field.setAccessible(true);
            Object obj = field.get(str);
            char[] charValue = (char [] )obj;
            charValue = new char [str.length()];
            String st = "I'm changed!";
            charValue = st.toCharArray();
             field.set(str, charValue);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
