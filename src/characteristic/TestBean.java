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
	   //在没有读数据的时候
	   System.out.println("在没有读数据的时候");
	   System.out.println("在没有读数据的时候:"+buffer.limit());
	   System.out.println("在没有读数据的时候"+buffer.position());
	   channel.read(buffer);
	   System.out.println("在读数据的时候");
	   System.out.println("在读数据的时候:"+buffer.limit());
	   System.out.println("在读数据的时候"+buffer.position());
	   //在使用的filp()后
	   buffer.flip();
	   System.out.println("在使用的filp()后");
	   System.out.println("在使用的filp()后"+buffer.limit());
	   System.out.println("在使用的filp()后"+buffer.position());
	   //在使用的clear()
	   buffer.clear();
	   System.out.println("在使用的clear()后");
	   System.out.println("在使用的clear()后"+buffer.limit());
	   System.out.println("在使用的clear()后"+buffer.position());
	   buffer.rewind();
	   System.out.println("在使用的rewind()后");
	   System.out.println("在使用的rewind()后"+buffer.limit());
	   System.out.println("在使用的rewind()后"+buffer.position());
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