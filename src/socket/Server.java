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
		// ����һ��ServerSocket�����ڶ˿�8899��
		ServerSocket server = new ServerSocket(port);
		
		while (f) {
			// server���Խ�������Socket����������server��accept����������ʽ��
			Socket socket = server.accept();
			// ÿ���յ�һ��Socket�ͽ���һ���µ��߳���������
			Task task=new Task(socket);
			executor.execute(task);
			BufferedReader readename=new BufferedReader(new InputStreamReader(socket.getInputStream()));
			map.put(readename.readLine(), socket);
			//System.out.print(map.toString());
			//readename.close();
			System.out.println("���������û���Ŀ��"+executor.getPoolSize()+"�������еȴ�ִ�е��û���Ŀ��"+
		             executor.getQueue().size()+"���Ѿ��˳�����û���Ŀ��"+executor.getCompletedTaskCount());
		}
	    executor.shutdown();
	
	}
	/**
	 * ��������Socket������ڲ���
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
		 * ���ͻ���Socket����ͨ��
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
				if ((index = temp.indexOf("eof")) != -1) {// ����eofʱ�ͽ�������
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
// �����дһ��
/*Writer writer = new OutputStreamWriter(socket.getOutputStream());
writer.write("Hello Client."+i++);
writer.flush();
writer.close();*/