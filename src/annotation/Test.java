package annotation;

import java.util.Arrays;

public class Test {

	// ��� main ����
	public static void main(String[] args) {
		int[] scores = { 89, -23, 64, 91, 119, 52, 79 };

		System.out.println(" ���ο���ǰ�����ǣ�");
		big3(scores);
	}

	// ���巽����ɳɼ��������ǰ�����Ĺ���

	public static void big3(int[] scores) {
		Arrays.sort(scores);
		int num = 0;
		for (int i = scores.length - 1; i >= 0 && num < 3; i--) {
			if (scores[i] < 0 || scores[i] > 100)
				continue;
			num++;
			System.out.println(scores[i]);
		}
	}
}