package characteristic;

public class About_Structurecodeblock {

	public static void main(String[] args) {
		new Demo();
	}

}

class Demo {
	static {
		System.out.println("静态构造代码块");
	}
	{
		System.out.println("普通构造代码块");
	}

	Demo() {
		System.out.println("构造函数");
	}
}