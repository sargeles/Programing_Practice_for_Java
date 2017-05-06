package functional_unit;

import java.util.Arrays;
import java.util.Date;

public class GetCurrenttimemillis  {
	public static void main(String[] args) {
		/*
		 * System中定义的public static native long currentTimeMillis();
		 * 返回自1970年1月1日0时起的毫秒数（ms）
		 */
		long currenttimemillis = System.currentTimeMillis();
		System.out.println(currenttimemillis+"ms");
		
		
	}
}
