package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileExample {
	public static void main(String[] args) {
		createFile();
	}

	/**
	 * �ļ�����ʾ��
	 */
	@SuppressWarnings("resource")
	public static void createFile() {
		File f = new File("C://Users//sargeles//Workspaces//MyEclipse Professional 2014//Coding_practice//src//io//iofile1.txt");
		try {
			//f.delete(); // ɾ���˳���·������ʾ���ļ���Ŀ¼
			//f.mkdirs(); // �����˳���·����ָ����Ŀ¼���������б��赫�����ڵĸ�Ŀ¼��
			f.createNewFile(); // ���ҽ��������ھ��д˳���·����ָ�����Ƶ��ļ�ʱ�����ɷֵش���һ���µĿ��ļ���
			System.out.println("�÷�����С" + f.getTotalSpace()
					/ (1024 * 1024 * 1024) + "G");
			
			System.out.println("�ļ���  " + f.getName()); // �����ɴ˳���·������ʾ���ļ���Ŀ¼�����ơ�
			System.out.println("�ļ���Ŀ¼�ַ��� " + f.getParent());
			// ���ش˳���·������Ŀ¼��·�����ַ����������·����û��ָ����Ŀ¼���򷵻�null��
			int count=0;  //ͳ���ļ��ֽڳ���  
		    InputStream streamReader = null;   //�ļ�������  
			streamReader=new FileInputStream(f);  
			int n=streamReader.read();
			while(n!=-1) {  //��ȡ�ļ��ֽڣ�������ָ�뵽��һ���ֽ�  
				System.out.println(n);
				count++;
				n = streamReader.read();
	        }
			System.out.println("---�����ǣ� "+count+" �ֽ�");  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}