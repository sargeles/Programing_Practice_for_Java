package io;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {  
	   
	  public static void main(String[] args) {  
	     byte[] buffer=new byte[512];   //һ��ȡ�����ֽ�����С,��������С  
	     int numberRead=0;  
	     FileInputStream input=null;  
	     FileOutputStream out =null;  
	     try {  
	        input=new FileInputStream("C://Users//sargeles//Workspaces//MyEclipse Professional 2014//Coding_practice//src//io//iofile1.txt");  
	        out=new FileOutputStream("C://Users//sargeles//Workspaces//MyEclipse Professional 2014//Coding_practice//src//io//iofile2.txt"); //����ļ������ڻ��Զ�����  
	         
	        while ((numberRead=input.read(buffer))!=-1) {  //numberRead��Ŀ�����ڷ�ֹ���һ�ζ�ȡ���ֽ�С��buffer���ȣ�  
	           out.write(buffer, 0, numberRead);       //������Զ������0  
	        }  
	     } catch (final IOException e) {  
	        e.printStackTrace();  
	     }finally{  
	        try {  
	           input.close();  
	           out.close();  
	        } catch (IOException e) {  
	           e.printStackTrace();  
	        }  
	         
	     }  
	  }  
	   
	}  