package bishe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.*;
import java.util.*;

/**
 * 发送端的密钥，数据包等信息的封装类。
 * 
 * @author sss
 * @version 1.0
 * @datatime 2016-05-06
 */
class Senderside {
	boolean f;
	private int[] key = new int[32];
	int keyhash;
	int[] data = new int[32];
	char[] datamd5 = new char[32];

	/**
	 * 构造函数，从密钥生成器得到密钥，从认证信息包生成器得到认证信息包，并计算该包的MD5值。
	 */
	Senderside() {
		key = KeyProducer.getKey();// 得到密钥

		randomGenerator();// 得到数据包
		getdatamd5();
	}

	/**
	 * 认证信息包生成器
	 */
	void randomGenerator() {// 生成数据包
		Random random = new Random();
		for (int i = 0; i < 32; i++)
			data[i] = random.nextInt(2);
	}

	/**
	 * 将认证信息包进行MD5算法加密
	 */
	void getdatamd5() {
		try {
			datamd5 = MD5Util.md5Encode(Arrays.toString(data)).toCharArray();
			// System.out.println("datamd5:"+Arrays.toString(datamd5)+datamd5.length);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * 把认证信息包用密钥进行加密
	 * 
	 * @return
	 */
	String jiamidata() {// 生成第一次发送的数据
		int[] e = new int[32];
		for (int i = 0; i < 32; i++)
			e[i] = data[i] ^ key[i];
		String result = Arrays.toString(e);
		return result;
	}

	/**
	 * 进行自己计算得到的MD5和接收并解码后得到的MD5码进行对比
	 * 
	 * @param str
	 */
	void compare(String str) {

		char[] ch = str.toCharArray();
		char[] a = new char[32];
		for (int i = 1, j = 0; j < 32; i += 3, j++)
			a[j] = (char) (ch[i] ^ key[j]);
		// System.out.println("解密后的datamd5"+Arrays.toString(a));
		f = (Arrays.toString(a)).equals(Arrays.toString(datamd5));
	}

	/**
	 * 得到密钥字符串的hash值
	 * 
	 * @return 返回keyhash
	 */
	int getkeyhash() {
		keyhash = Arrays.toString(key).hashCode();
		return keyhash;
	}

	/**
	 * 将密钥转成字符串
	 * 
	 * @return 目标字符串
	 */
	String getkey() {
		String st;
		st = Arrays.toString(key);
		return st;
	}

	/**
	 * 计算校验位
	 * 
	 * @param index
	 *            下标
	 * @param length
	 *            长度区间
	 * @return 校验结果
	 */
	int count(int index, int length) {
		int f = 0;
		for (int i = index; i < (length + index); i++)
			f += key[i];
		f = f % 2;
		if((int) (Math.random()*1000)<5)
			f = (f+1) % 2;
		return f;
	}

	/**
	 * 将密钥左移一位
	 */
	void upSetKey() {
		int k = key[0];
		int i;
		for (i = 0; i < 31; i++)
			key[i] = key[i + 1];
		key[i] = k;
	}

	/**
	 * 输出协调后的密钥，认证信息包，MD5结果和最终应答结果
	 */
	void show() {
		System.out.println("key:" + Arrays.toString(key) + key.length
				+ "hashcode:" + getkeyhash());
		System.out.println("data:" + Arrays.toString(data) + data.length);
		System.out.println("datamd5:" + Arrays.toString(datamd5)
				+ datamd5.length);
		System.out.println("将发出去和接收到的data的md5码进行对比的最终结果：" + f);
	}
}

/**
 * 发送端与接收端进行联络
 * 
 * @author sss
 * 
 */
public class Sender {

	static boolean keyAgreement() {
		Senderside sender = new Senderside();
		try {
			ServerSocket server = new ServerSocket(3030);
			Socket socket = server.accept();
			Writer writer = new OutputStreamWriter(socket.getOutputStream());
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			String sb = new String();

			boolean f = true;
			int index = 0;
			int loop = 1;

			while (f) {
				//System.out.println("这是第" + loop + "次协调！");// 循环前输出此次循环的次数
				writer.write("" + sender.count(index, 16) + "\n");
				writer.flush();// 向发送端发送第一次校验位。

				sb = reader.readLine();
				if (sb.equals("right")) {
					index += 16;
					writer.write("" + sender.count(index, 8) + "\n");
					writer.flush();
				} else {
					writer.write("" + sender.count(index, 8) + "\n");
					writer.flush();
				}

				sb = reader.readLine();
				if (sb.equals("right")) {
					index += 8;
					writer.write("" + sender.count(index, 4) + "\n");
					writer.flush();
				} else {
					writer.write("" + sender.count(index, 4) + "\n");
					writer.flush();
				}

				sb = reader.readLine();
				if (sb.equals("right")) {
					index += 4;
					writer.write("" + sender.count(index, 2) + "\n");
					writer.flush();
				} else {
					writer.write("" + sender.count(index, 2) + "\n");
					writer.flush();
				}

				sb = reader.readLine();
				if (sb.equals("right")) {
					index += 2;
					writer.write("" + sender.count(index, 1) + "\n");
					writer.flush();
				} else {
					writer.write("" + sender.count(index, 1) + "\n");
					writer.flush();
				}

				if (loop > 16) {
					writer.write("" + sender.count(0, 32) + "\n");
					writer.flush();// 一次更改后校验结果
					sb = reader.readLine();
					if (sb.equals("stop")) {
						//System.out.println("经过" + (loop) + "次协调完成！");
						f = false;
						break;
					}
				}

				sender.upSetKey();
				index = 0;
				loop++;// 密钥同向更变一次，重复循环
			}

			writer.write(sender.jiamidata() + "\n");// 生成传输串
			writer.flush();
			// System.out.println("发送的数据：加密后的data："+sender.jiamidata());

			sb = reader.readLine();
			// System.out.println("接收到的数据："+sb);

			sender.compare(sb);

			//sender.show();
			
			server.close();
			socket.close();
			writer.close(); 
			reader.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sender.f;
	
	}

	public static void main(String[] args) {
		int xx=7,yy=100;
		int[] x = new int[xx];
		int[] y = new int[yy];
		int n=0;
		String X="随机错码数",Y=yy+"次协商后成功次数";
		
		for(int i=1;i<=xx;i++){
			KeyProducer.n=i;
			x[i-1]=i;
			
			for(int j=0;j<yy;j++){
				if(keyAgreement())
					{n++;System.out.println("错码数为"+i+"时："+"第"+(j+1)+"次"+"调和成功");}
					else
						System.out.println("错码数为"+i+"时："+"第"+(j+1)+"次"+"调和失败");
			}
			y[i-1]=n;n=0;
		}
		new SinFrame(x,y,X,Y);
	}
}