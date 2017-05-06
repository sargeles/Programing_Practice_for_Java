package characteristic;

/**
 * java��ֻ�и������ݣ�����ֵ������ֵ���������ã��������ã��������飬���������ݵĶ������ã���
 * @author sargeles
 */
public class About_Onlycopytransmit {
	/**
	 * ����һ�飺�������ʹ����ǰ�ֵ���ݣ���ζ�ŵ���һ���������ݸ�һ������ʱ���������յ���ԭʼֵ��һ��������
	 * String��Ϊ����ԭ����ֳ��������͵������� һ����Stringʵ���ϲ�������char[]���������ΪString��char[]�İ�װ��
	 * ���Ǹ�String�������¸�ֵ��ʵ����û�иı����������ֵ����������new��һ��String���������漰��String���ɱ���һ���ԡ�
	 */
	static void ceshi1() {
		int i = 1;
		String s = new String("I'll change you!");

		A a = new A();

		a.change(i, s);
		a.show();

		System.out.println("�����벢�޸ĵ�i=" + i);
		System.out.println("�����벢�޸ĵ�s=" + s);
	}

	/**
	 * ���Զ��飺�������ʹ����Ǹ������ݣ���ζ�ŵ���һ���������ݸ�һ������ʱ���������յ���ԭʼֵ���ڴ��ַ��������ֵ�ĸ�����
	 * ����Ҫע�⵽���ǣ�ceshi2�ﶨ���b���ᱻֱ�Ӵ��ݸ�a����Ϊa�����ԣ������Ǹ��Ƹ�a,
	 * Ҳ����˵����b�����ᱻ��������change()���ݲ�����,A.b��bָ��ͬһ������ Ҳ����ѭ�����ô��ݡ����ĸ��֡�
	 */
	static void ceshi2() {
		int[] intarray = { 0, 1, 2 };
		String[] strarray = { "aaa", "bbb", "ccc" };

		A a = new A();
		B b = new B(1);

		a.change(intarray, strarray, b);
		a.show();

		System.out.println("�������i=" + intarray[1]);
		System.out.println("�������s=" + strarray[1]);
		System.out.println("�������b.index=" + b.index);
		System.out.println("�������b��hashֵ=" + b.hashCode());
	}

	/**
	 * Ϊ�˽�һ��֤ʵceshi2�е����ô��ݣ�������ǲ��Ե�����������ã������Ƕ�������á�
	 */
	static void ceshi3() {
		int[] intarray = { 0, 1, 2 };

		A a = new A();

		a.change(intarray);
		a.show();

		System.out.println("�������intarray=" + intarray);
		System.out.println("�������intarray[0]=" + intarray[0]);

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
	 * ceshi1ר��
	 */
	void change(int i, String s) {
		this.i = i;
		i++;
		this.s = s;
		s = "I'll change you!But I have been changed too!";
	}

	/**
	 * ceshi2ר��
	 */
	void change(int[] i, String[] s, B b) {
		this.i = i[1];
		i[1]++;
		this.s = s[1];
		s[1] = "I'll change you!But I have been changed too!";
		this.b = b;
		// ���������Ϊ this.b.index++; Ч�����䡣
		b.index++;
	}

	/**
	 * ceshi3ר��
	 */
	public void change(int[] intarray) {
		this.ii = intarray;
		intarray[0]++;
	}

	public void show() {
		if (i != 0)
			System.out.println("A�Ķ���a��i=" + i);

		if (ii[0] != 0) {
			System.out.println("A�Ķ���a��ii=" + ii);
			System.out.println("A�Ķ���a��ii[0]=" + ii[0]);
		}

		if (!s.equals("I'm not changed!"))
			System.out.println("A�Ķ���a��s=" + s);
		System.out.println();

		try {
			if (b.index != 0) {
				System.out.println("A�Ķ���a��b.index=" + b.index);
				System.out.println("A�Ķ���a��b��hashֵ=" + b.hashCode());
				System.out.println();
			}
		} catch (java.lang.NullPointerException e) {
			System.out.println("δ�õ�B����");
		}

	}

}

class B {
	int index = 0;

	public B(int i) {
		index = i;
	}

}