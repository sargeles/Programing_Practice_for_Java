package functional_unit;

public class GetFreeMemory {
	static char c;
	public static void main(String[] args) {
		System.out.println((int)c);
		/*
		 *Runtime中定义的public native long freeMemory();
		 * 返回当前空闲内存（B）
		 */
		long freememory = Runtime.getRuntime().freeMemory();
		System.out.println(freememory+"B");

	}

}
