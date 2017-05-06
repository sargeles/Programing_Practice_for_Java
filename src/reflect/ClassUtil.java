package reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

import org.omg.CORBA.PUBLIC_MEMBER;

/**
 * 五个函数：（public static void）
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
	 * 打印类的信息，包括五个函数。
	 * 
	 * @param obj
	 * 
	 */
	public static void printClassMessage(Object obj) {
		// 要获取类的信息，首先要获取类的类类型
		Class c = obj.getClass();// 传递的是哪个子类的对象,c就是该子类的类类型
		// 获取类的名称
		System.out.println("类的名称是：" + c.getName());
		System.out.println("类的成员方法有：");
		/*
		 * Method类，方法对象 一个成员方法就是一个Method对象
		 * getMethods()方法获取的是所有的public的方法，包括从父类继承而来的
		 * getDeclareMethods()获取的是所有该类自己声明的方法，不问访问权限
		 */
		Method[] ms = c.getMethods();
		for (Method m : ms) {
			// public int getModifiers()方法是公有的，可以获取修饰符信息，将其包装成一个int。
			int mo = m.getModifiers();
			// Modifier封装了解读带有修饰符信息的int的方法。这些方法都是静态的。可以直接用。
			System.out.print(Modifier.toString(mo) + " ");
			// 得到方法返回值类型的类类型
			Class returnType = m.getReturnType();
			System.out.print(returnType.getName() + " ");
			// 得到方法的名称
			System.out.print(m.getName() + "(");
			// 获取参数类型--->得到的是参数列表的类型的类类型
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
	 * 获取成员变量的信息（自己声明的）
	 * 
	 * @param obj
	 */
	public static void printFieldMessage(Object obj) {
		// 要获取类的信息，首先要获取类的类类型
		Class c = obj.getClass();// 传递的是哪个子类的对象,c就是该子类的类类型
		System.out.println("类的名称是：" + c.getName());
		System.out.println("类的成员变量有：");
		/*
		 * 成员变量也是对象 java.lang.reflect.Field Field类封装了关于成员变量的操作
		 * getFields()方法获取的是所有public的成员变量的信息
		 * getDeclaredFields()获取的是该类自己声明的成员变量的信息
		 */
		Field[] fs = c.getDeclaredFields();
		for (Field field : fs) {
			// 获得成员变量的类型的类类型
			Class fieldType = field.getType();
			String typeName = fieldType.getName();
			// 得到成员变量的名字
			String fieldName = field.getName();
			System.out.println(typeName + " " + fieldName);
		}
	}

	/**
	 * 获取类的构造函数信息
	 * 
	 * @param obj
	 */
	public static void printConstructorMessage(Object obj) {
		Class c = obj.getClass();
		System.out.println("类的名称是：" + c.getName());
		System.out.println("类的构造函数有：");
		/*
		 * 构造函数也是对象 java.lang.Constructor中封装了构造函数的信息
		 * getConstructors获取所有的public的构造函数 getDeclaredConstructors得到所有的构造函数
		 */
		Constructor[] cs = c.getDeclaredConstructors();
		for (Constructor constructor : cs) {
			// java.lang.Class.getModifiers()方法是公有本地的，可以获取修饰符信息，将其包装成一个int。
			int mo = constructor.getModifiers();
			// Modifier封装了解读带有修饰符信息的int的方法。这些方法都是静态的。可以直接用。
			System.out.print(Modifier.toString(mo) + " ");
			System.out.print(constructor.getName() + "(");
			// 获取构造函数的参数列表--->得到的是参数列表的类类型
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
	 * 类的接口信息
	 * 
	 * @param obj
	 */
	public static void printInterfacesMessage(Object obj) {
		Class c = obj.getClass();
		System.out.println("类的名称是：" + c.getName());
		System.out.println("类实现的接口有：");
		/*
		 * 接口类也是对象，因为接口也是类类型的一种，所以是Class的泛型。
		 */
		Class[] intes = c.getInterfaces();
		for (Class classes : intes) {
			// 获取每个接口的名字，然后输出。
			System.out.println(classes.getName());
		}
	}

	/**
	 * 类的父类信息
	 * 
	 * @param obj
	 */
	public static void printSuperclassMessage(Object obj) {
		Class c = obj.getClass();
		System.out.println("类的名称是：" + c.getName());
		System.out.print("类的父类是：");
		/*
		 * 父类只可能有一个，所以不用遍历，单根继承。
		 */
		Class superclass = c.getSuperclass();
		System.out.println(superclass.getName());
	}
}
