package characteristic;

/**
 * java中只有副本传递，对于值，拷贝值，对于引用，拷贝引用（对于数组，数组名传递的都是引用）。
 * @author sargeles
 */
public class About_Onlycopytransmit {
	/**
	 * 测试一组：基本类型传递是按值传递，意味着当将一个参数传递给一个函数时，函数接收的是原始值的一个副本。
	 * String因为两个原因表现出基本类型的特征： 一个是String实际上操作的是char[]，可以理解为String是char[]的包装类
	 * 二是给String变量重新赋值后，实际上没有改变这个变量的值，而是重新new了一个String对象，这里涉及到String不可变这一特性。
	 */
	static void ceshi1() {
		int i = 1;
		String s = new String("I'll change you!");

		A a = new A();

		a.change(i, s);
		a.show();

		System.out.println("被传入并修改的i=" + i);
		System.out.println("被传入并修改的s=" + s);
	}

	/**
	 * 测试二组：引用类型传递是副本传递，意味着当将一个参数传递给一个函数时，函数接收的是原始值的内存地址，而不是值的副本。
	 * 但需要注意到的是，ceshi2里定义的b，会被直接传递给a，作为a的属性，而不是复制给a,
	 * 也就是说对象b并不会被拷贝，对change()传递参数后,A.b与b指向同一个对象。 也是遵循‘引用传递’这四个字。
	 */
	static void ceshi2() {
		int[] intarray = { 0, 1, 2 };
		String[] strarray = { "aaa", "bbb", "ccc" };

		A a = new A();
		B b = new B(1);

		a.change(intarray, strarray, b);
		a.show();

		System.out.println("被传入的i=" + intarray[1]);
		System.out.println("被传入的s=" + strarray[1]);
		System.out.println("被传入的b.index=" + b.index);
		System.out.println("被传入的b的hash值=" + b.hashCode());
	}

	/**
	 * 为了进一步证实ceshi2中的引用传递，这次我们测试的是数组的引用，而不是对象的引用。
	 */
	static void ceshi3() {
		int[] intarray = { 0, 1, 2 };

		A a = new A();

		a.change(intarray);
		a.show();

		System.out.println("被传入的intarray=" + intarray);
		System.out.println("被传入的intarray[0]=" + intarray[0]);

	}

	public static void main(String[] args) {
		//	ceshi1();
	//	ceshi2();
	ceshi3();
	}
}

class A {
	int i = 0;
	int[] ii = { 0, 1, 2 };
	String s = "I'm not changed!";
	B b = new B(0);

	/**
	 * ceshi1专用
	 */
	void change(int i, String s) {
		this.i = i;
		i++;
		this.s = s;
		s = "I'll change you!But I have been changed too!";
	}

	/**
	 * ceshi2专用
	 */
	void change(int[] i, String[] s, B b) {
		this.i = i[1];
		i[1]++;
		this.s = s[1];
		s[1] = "I'll change you!But I have been changed too!";
		this.b = b;
		// 下面的语句改为 this.b.index++; 效果不变。
		b.index++;
	}

	/**
	 * ceshi3专用
	 */
	public void change(int[] intarray) {
		this.ii = intarray;
		intarray[0]++;
	}

	public void show() {
		if (i != 0)
			System.out.println("A的对象a中i=" + i);

		if (ii[0] != 0) {
			System.out.println("A的对象a中ii=" + ii);
			System.out.println("A的对象a中ii[0]=" + ii[0]);
		}

		if (!s.equals("I'm not changed!"))
			System.out.println("A的对象a中s=" + s);
		System.out.println();

		try {
			if (b.index != 0) {
				System.out.println("A的对象a中b.index=" + b.index);
				System.out.println("A的对象a中b的hash值=" + b.hashCode());
				System.out.println();
			}
		} catch (java.lang.NullPointerException e) {
			System.out.println("未得到B对象！");
		}

	}

}

class B {
	int index = 0;

	public B(int i) {
		index = i;
	}

}