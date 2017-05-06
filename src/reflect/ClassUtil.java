package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * �����������public static void��
 * ClassUtil.printClassMessage(Object obj);
 * ClassUtil.printFieldMessage(Object obj);
 * ClassUtil.printConstructorMessage(Object obj);
 * ClassUtil.printInterfacesMessage(Object obj);
 * ClassUtil.printSuperclassMessage(Object obj);
 * 
 * @author sargeles
 */
public class ClassUtil {
	/**
	 * ��ӡ�����Ϣ���������������
	 * 
	 * @param obj
	 * 
	 */
	public static void printClassMessage(Object obj) {
		// Ҫ��ȡ�����Ϣ������Ҫ��ȡ���������
		Class c = obj.getClass();// ���ݵ����ĸ�����Ķ���,c���Ǹ������������
		// ��ȡ�������
		System.out.println("��������ǣ�" + c.getName());
		System.out.println("��ĳ�Ա�����У�");
		/*
		 * Method�࣬�������� һ����Ա��������һ��Method����
		 * getMethods()������ȡ�������е�public�ķ����������Ӹ���̳ж�����
		 * getDeclareMethods()��ȡ�������и����Լ������ķ��������ʷ���Ȩ��
		 */
		Method[] ms = c.getMethods();
		for (Method m : ms) {
			// public int getModifiers()�����ǹ��еģ����Ի�ȡ���η���Ϣ�������װ��һ��int��
			int mo = m.getModifiers();
			// Modifier��װ�˽���������η���Ϣ��int�ķ�������Щ�������Ǿ�̬�ġ�����ֱ���á�
			System.out.print(Modifier.toString(mo) + " ");
			// �õ���������ֵ���͵�������
			Class returnType = m.getReturnType();
			System.out.print(returnType.getName() + " ");
			// �õ�����������
			System.out.print(m.getName() + "(");
			// ��ȡ��������--->�õ����ǲ����б�����͵�������
			Class[] paramTypes = m.getParameterTypes();

			for (int i = 0; i < paramTypes.length; i++) {
				if (i > 0)
					System.out.print(",");
				System.out.print(paramTypes[i].getName());
			}
			System.out.println(")");
		}
	}

	/**
	 * ��ȡ��Ա��������Ϣ���Լ������ģ�
	 * 
	 * @param obj
	 */
	public static void printFieldMessage(Object obj) {
		// Ҫ��ȡ�����Ϣ������Ҫ��ȡ���������
		Class c = obj.getClass();// ���ݵ����ĸ�����Ķ���,c���Ǹ������������
		System.out.println("��������ǣ�" + c.getName());
		System.out.println("��ĳ�Ա�����У�");
		/*
		 * ��Ա����Ҳ�Ƕ��� java.lang.reflect.Field Field���װ�˹��ڳ�Ա�����Ĳ���
		 * getFields()������ȡ��������public�ĳ�Ա��������Ϣ
		 * getDeclaredFields()��ȡ���Ǹ����Լ������ĳ�Ա��������Ϣ
		 */
		Field[] fs = c.getDeclaredFields();
		for (Field field : fs) {
			// ��ó�Ա���������͵�������
			Class fieldType = field.getType();
			String typeName = fieldType.getName();
			// �õ���Ա����������
			String fieldName = field.getName();
			System.out.println(typeName + " " + fieldName);
		}
	}

	/**
	 * ��ȡ��Ĺ��캯����Ϣ
	 * 
	 * @param obj
	 */
	public static void printConstructorMessage(Object obj) {
		Class c = obj.getClass();
		System.out.println("��������ǣ�" + c.getName());
		System.out.println("��Ĺ��캯���У�");
		/*
		 * ���캯��Ҳ�Ƕ��� java.lang.Constructor�з�װ�˹��캯������Ϣ
		 * getConstructors��ȡ���е�public�Ĺ��캯�� getDeclaredConstructors�õ����еĹ��캯��
		 */
		Constructor[] cs = c.getDeclaredConstructors();
		for (Constructor constructor : cs) {
			// java.lang.Class.getModifiers()�����ǹ��б��صģ����Ի�ȡ���η���Ϣ�������װ��һ��int��
			int mo = constructor.getModifiers();
			// Modifier��װ�˽���������η���Ϣ��int�ķ�������Щ�������Ǿ�̬�ġ�����ֱ���á�
			System.out.print(Modifier.toString(mo) + " ");
			System.out.print(constructor.getName() + "(");
			// ��ȡ���캯���Ĳ����б�--->�õ����ǲ����б��������
			Class[] paramTypes = constructor.getParameterTypes();
			for (int i = 0; i < paramTypes.length; i++) {
				if (i > 0)
					System.out.print(",");
				System.out.print(paramTypes[i].getName());
			}
			System.out.println(")");
		}
	}

	/**
	 * ��Ľӿ���Ϣ
	 * 
	 * @param obj
	 */
	public static void printInterfacesMessage(Object obj) {
		Class c = obj.getClass();
		System.out.println("��������ǣ�" + c.getName());
		System.out.println("��ʵ�ֵĽӿ��У�");
		/*
		 * �ӿ���Ҳ�Ƕ�����Ϊ�ӿ�Ҳ�������͵�һ�֣�������Class�ķ��͡�
		 */
		Class[] intes = c.getInterfaces();
		for (Class classes : intes) {
			// ��ȡÿ���ӿڵ����֣�Ȼ�������
			System.out.println(classes.getName());
		}
	}

	/**
	 * ��ĸ�����Ϣ
	 * 
	 * @param obj
	 */
	public static void printSuperclassMessage(Object obj) {
		Class c = obj.getClass();
		System.out.println("��������ǣ�" + c.getName());
		System.out.print("��ĸ����ǣ�");
		/*
		 * ����ֻ������һ�������Բ��ñ����������̳С�
		 */
		Class superclass = c.getSuperclass();
		System.out.println(superclass.getName());
	}
}
