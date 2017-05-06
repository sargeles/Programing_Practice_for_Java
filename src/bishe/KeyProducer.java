package bishe;

import java.util.Calendar;
import java.util.Random;

/**
 * 密钥生成器，会对同一的密钥种子进行变换，变换过程确认，但结果不可预知。
 * 
 * @author sss
 * 
 */
public class KeyProducer {
	public static int n;
	public static final int l = 32;// 原始密钥的长度，随机更变位数。
	public static int[] seed = { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
			1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 };// 密钥生成的种子
	static Calendar cal = Calendar.getInstance();
	static {
		n=1;
		//n = cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 密钥生成器
	 * 
	 * @return 返回int数组，这个数组根据固定的种子和随机的变换参数得到。
	 */
	public static int[] getKey() {
		int j;
		int[] key = new int[32];
		System.arraycopy(seed, 0, key, 0, 32);
		Random random = new Random();
		for (int i = 0; i < n; i++) {
			j = random.nextInt(32);
			key[j] = (seed[j] + 1) % 2;
		}
		return key;
	}
}
// System.out.println("seed:"+Arrays.toString(seed));