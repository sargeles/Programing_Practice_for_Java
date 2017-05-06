package reflect;

public class InvokeDemo {
	 
	private String st="invoke";
	int[] i={1,5,6,9,8,2};
	
	public void add1(int a, int b) {
		System.out.println(a + b);
	}

	public static void add2(int a, int b) {
		System.out.println(a + b);
	}
}
