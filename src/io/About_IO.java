package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

/**
 * �������ֻ����Ŀ���̨�����ȡ������
 * @author sargeles
 */
public class About_IO {
	public static void main(String[] args) throws IOException {
		// ��һ�ַ�ʽ
		/*
		 * BufferedReader br = new BufferedReader(new
		 * InputStreamReader(System.in)); int
		 * i=br.read();//Ĭ�϶�ȡһ���ַ���������ַ���ascii���� char c =
		 * (char)br.read();//��Ҫǿ��ת�����ܵõ��ַ� //����Ķ�ȡһ�У���ȡ����δ������ģ����ڻ����������ݡ� String
		 * str =br.readLine();
		 */

		// �ڶ��ַ�ʽ
		Scanner sc = new Scanner(System.in);
		// ����Ԥ���´ε����룬
		int i = sc.nextInt();
		/*
		 * ���������������� nextʶ��һ���ַ�������ƥ������ַ�������������Ρ� nextʶ��س���
		 */
		String c = sc.next("aaa");
		String str = sc.nextLine();
		/*
		 * �����Զ���ָ�����������ֽ�Ϊ��ǡ�
		 */
		String input = "1 fish 2 fish red fish blue fish";
		Scanner s = new Scanner(input).useDelimiter("\\s*fish\\s*");
		System.out.println(s.nextInt());
		System.out.println(s.nextInt());
		System.out.println(s.next());
		System.out.println(s.next());

		System.out.println(i);
		System.out.println(c);
		System.out.println(str);
		/* br.close(); */
		sc.close();
	}
}
