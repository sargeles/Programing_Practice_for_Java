package bishe;

import java.util.Calendar;
import java.util.Random;

/**
 * ��Կ�����������ͬһ����Կ���ӽ��б任���任����ȷ�ϣ����������Ԥ֪��
 * 
 * @author sss
 * 
 */
public class KeyProducer {
	public static int n;
	public static final int l = 32;// ԭʼ��Կ�ĳ��ȣ��������λ����
	public static int[] seed = { 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0,
			1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1 };// ��Կ���ɵ�����
	static Calendar cal = Calendar.getInstance();
	static {
		n=1;
		//n = cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * ��Կ������
	 * 
	 * @return ����int���飬���������ݹ̶������Ӻ�����ı任�����õ���
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