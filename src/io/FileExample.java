package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class FileExample {
	public static void main(String[] args) {
		createFile();
	}

	/**
	 * 文件处理示例
	 */
	@SuppressWarnings("resource")
	public static void createFile() {
		File f = new File("C://Users//sargeles//Workspaces//MyEclipse Professional 2014//Coding_practice//src//io//iofile1.txt");
		try {
			//f.delete(); // 删除此抽象路径名表示的文件或目录
			//f.mkdirs(); // 创建此抽象路径名指定的目录，包括所有必需但不存在的父目录。
			f.createNewFile(); // 当且仅当不存在具有此抽象路径名指定名称的文件时，不可分地创建一个新的空文件。
			System.out.println("该分区大小" + f.getTotalSpace()
					/ (1024 * 1024 * 1024) + "G");
			
			System.out.println("文件名  " + f.getName()); // 返回由此抽象路径名表示的文件或目录的名称。
			System.out.println("文件父目录字符串 " + f.getParent());
			// 返回此抽象路径名父目录的路径名字符串；如果此路径名没有指定父目录，则返回null。
			int count=0;  //统计文件字节长度  
		    InputStream streamReader = null;   //文件输入流  
			streamReader=new FileInputStream(f);  
			int n=streamReader.read();
			while(n!=-1) {  //读取文件字节，并递增指针到下一个字节  
				System.out.println(n);
				count++;
				n = streamReader.read();
	        }
			System.out.println("---长度是： "+count+" 字节");  
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}