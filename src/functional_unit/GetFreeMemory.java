package functional_unit;

public class GetFreeMemory {
	static char c;
	public static void main(String[] args) {
		System.out.println((int)c);
		/*
		 *Runtime�ж����public native long freeMemory();
		 * ���ص�ǰ�����ڴ棨B��
		 */
		long freememory = Runtime.getRuntime().freeMemory();
		System.out.println(freememory+"B");

	}

}
