package characteristic;

public class About_Structurecodeblock {

	public static void main(String[] args) {
		new Demo();
	}

}

class Demo {
	static {
		System.out.println("��̬��������");
	}
	{
		System.out.println("��ͨ��������");
	}

	Demo() {
		System.out.println("���캯��");
	}
}