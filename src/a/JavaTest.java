package a;

public class JavaTest {

	public static void main(String[] args) {
		Other o = new Other();
		//new JavaTest();
		System.out.println(o.i);
	}

	public void addOne(final Other o) {
		o.i++;
	}
}

class Other {
	public int i;
}