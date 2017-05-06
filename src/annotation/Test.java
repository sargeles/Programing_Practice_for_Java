package annotation;

import java.util.Arrays;

public class Test {

	// 完成 main 方法
	public static void main(String[] args) {
		int[] scores = { 89, -23, 64, 91, 119, 52, 79 };

		System.out.println(" 本次考试前三名是：");
		big3(scores);
	}

	// 定义方法完成成绩排序并输出前三名的功能

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