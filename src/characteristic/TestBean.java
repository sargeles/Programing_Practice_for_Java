package characteristic;

import java.sql.*;
import java.text.ParseException;
import java.io.File;
import java.io.FileInputStream;
import java.net.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.*;


public class TestBean {
	 private String url = "D:\\test.txt";
	    private  void  read()
	    {     
	    	File  file=new File(url);
	          try {
	   FileChannel  channel=new FileInputStream(file).getChannel();
	   ByteBuffer  buffer=ByteBuffer.allocate(1024*1024);
	   //��û�ж����ݵ�ʱ��
	   System.out.println("��û�ж����ݵ�ʱ��");
	   System.out.println("��û�ж����ݵ�ʱ��:"+buffer.limit());
	   System.out.println("��û�ж����ݵ�ʱ��"+buffer.position());
	   channel.read(buffer);
	   System.out.println("�ڶ����ݵ�ʱ��");
	   System.out.println("�ڶ����ݵ�ʱ��:"+buffer.limit());
	   System.out.println("�ڶ����ݵ�ʱ��"+buffer.position());
	   //��ʹ�õ�filp()��
	   buffer.flip();
	   System.out.println("��ʹ�õ�filp()��");
	   System.out.println("��ʹ�õ�filp()��"+buffer.limit());
	   System.out.println("��ʹ�õ�filp()��"+buffer.position());
	   //��ʹ�õ�clear()
	   buffer.clear();
	   System.out.println("��ʹ�õ�clear()��");
	   System.out.println("��ʹ�õ�clear()��"+buffer.limit());
	   System.out.println("��ʹ�õ�clear()��"+buffer.position());
	   buffer.rewind();
	   System.out.println("��ʹ�õ�rewind()��");
	   System.out.println("��ʹ�õ�rewind()��"+buffer.limit());
	   System.out.println("��ʹ�õ�rewind()��"+buffer.position());
	   Charset chaset=Charset.forName("gb2312");
	   CharBuffer   charBuffer=chaset.decode(buffer);
	 
	  } catch (Exception e) {
	   e.printStackTrace();
	  }
	    }
	  
	 public static void main(String[] args) {
	  new TestBean().read();
	 }
	}