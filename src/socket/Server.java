package socket;

import java.io.*;
import java.net.*;
import java.text.ParseException;
import java.util.*;
import java.util.concurrent.*;
import java.sql.*;

public class Server {

	static ArrayList<String> List = new ArrayList<String>();
	static HashMap<String , Socket> map = new HashMap<String , Socket>();
	static DBManager db=new DBManager();
	static boolean f=true;
	
	public static void main(String[] args) throws Exception {   
        ThreadPoolExecutor executor = new ThreadPoolExecutor(5, 10, 200, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        int port = 8899;
		// 定义一个ServerSocket监听在端口8899上
		ServerSocket server = new ServerSocket(port);
		
		while (f) {
			// server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的
			Socket socket = server.accept();
			// 每接收到一个Socket就建立一个新的线程来处理它
			Task task=new Task(socket);
			executor.execute(task);
			BufferedReader readename=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			map.put(readename.readLine(), socket);
			//System.out.print(map.toString());
			//readename.close();
			System.out.println("聊天室中用户数目："+executor.getPoolSize()+"，队列中等待执行的用户数目："+
		             executor.getQueue().size()+"，已经退出别的用户数目："+executor.getCompletedTaskCount());
		}
	    executor.shutdown();
	
	}
	/**
	 * 用来处理Socket请求的内部类
	 */
	static class Task implements Runnable {
		
		private Socket socket;
	    

		public Task(Socket socket) {
			this.socket = socket;
		}

		public void run() {

			try {

				handleSocket();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		/**
		 * 跟客户端Socket进行通信
		 * 
		 * @throws Exception
		 */
		private void handleSocket() throws Exception {
			
			BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			StringBuffer sb = new StringBuffer();
			String temp;
			int index;
			A:
			while (true) {
				temp = reader.readLine();
				//System.out.println(temp);
				if ((index = temp.indexOf("eof")) != -1) {// 遇到eof时就结束接收
					sb.setLength(0);
					sb.append(temp.substring(0, index));
					putString(sb.toString());
					//System.out.println(Thread.currentThread());
					continue A;
				}
			}

			//reader.close();
			//socket.close();
		}
		
	 	synchronized void putString(String sb) throws SQLException, ParseException{
			List.add(sb);
			db.setRecord("songhao",sb);
		}

	}


}

//System.out.println("from client "+(i++)+":" + sb);
// 读完后写一句
/*Writer writer = new OutputStreamWriter(socket.getOutputStream());
writer.write("Hello Client."+i++);
writer.flush();
writer.close();*/