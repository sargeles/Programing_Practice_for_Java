package socket;

import java.io.*;
import java.net.*;

public class Client {
	
	public Client(String str) throws Exception {
		boolean f=true;
		String username = str;
		System.out.print(username);
		StringBuilder content = null;
		int index;
		// 与服务端建立连接
		Socket client = new Socket("127.0.0.1", 8899);
		// 建立连接后就可以往服务端写数据了
		Writer writer = new OutputStreamWriter(client.getOutputStream());
		writer.write(username+"\n");
		writer.flush();
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(f){
			//if ((index = content.indexOf("all")) != -1)
			writer.write(br.readLine());
			writer.write("eof\n");
			writer.flush();
		}
		
		br.close();
		writer.close();
		client.close();
	}
/*	public static void main(String[] args) throws Exception{
		new Client("songhao");
	}*/
		
}
