package bishe01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * 接收端的封装类
 * 
 * @author sss
 * 
 */
class Recieverside {
	private int[] key = new int[32];
	int keyhash;
	int[] data = new int[32];
	char[] datamd5 = new char[32];
	String result = "";

	/**
	 * 调用keyProducer.getKey()得到一个32位二进制密钥
	 */
	Recieverside() {
		key = KeyProducer.getKey();// 得到密钥
	}

	/**
	 * 用密钥加密认证信息包的MD5码
	 */
	void jiamimd5() {// 生成第一次发送的数据
		char[] ch = new char[32];
		System.arraycopy(datamd5, 0, ch, 0, 32);
		for (int i = 0; i < 32; i++)
			ch[i] = (char) (ch[i] ^ key[i]);
		result = Arrays.toString(ch);
	}

	/**
	 * 解密字符串得到认证信息包data
	 * 
	 * @param str
	 * @return
	 */
	int[] jiemidata(String str) {
		char[] ch = str.toCharArray();
		int[] a = new int[32];
		int j = 0;
		for (int i = 0; i < ch.length; i++) {
			if (Character.isDigit(ch[i]))
				a[j++] = ch[i] - '0';
		}
		for (int i = 0; i < 32; i++)
			a[i] = a[i] ^ key[i];
		return a;
	}

	/**
	 * 将认证信息包进行MD5算法加密
	 */
	void getdatamd5() {
		try {
			datamd5 = MD5Util.md5Encode(Arrays.toString(data)).toCharArray();
			// System.out.println("datamd5:"+Arrays.toString(datamd5)+datamd5.length);
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	/**
	 * 得到密钥字符串的hash值
	 * 
	 * @return
	 */
	int getkeyhash() {
		keyhash = Arrays.toString(key).hashCode();
		return keyhash;
	}

	/**
	 * 计算校验位
	 * 
	 * @param index
	 * @param length
	 * @return 校验结果
	 */
	int count(int index, int length) {
		int f = 0;
		for (int i = index; i < (length + index); i++)
			f += key[i];
		f = f % 2;
		return f;
	}

	/**
	 * 在指定下标位更改密钥
	 * 
	 * @param index
	 */
	void resetKeyAt(int index) {
		key[index] = (key[index] + 1) % 2;
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
	 * 输出协调后的密钥，认证信息包，MD5结果
	 * @throws Exception 
	 */
	void show() throws Exception {
		System.out.println("key:" + Arrays.toString(key) + key.length
				+ "hashcode:" + getkeyhash());
		System.out.println("data:" + Arrays.toString(data) + data.length);
		System.out.println("datamd5:" + Arrays.toString(datamd5)
				+ datamd5.length);

		int[] aa=data;
		for (int i = 0; i < 31; i++)
			aa[i]=aa[i]^key[i];
		System.out.println("最终密钥：" + MD5Util.md5Encode(Arrays.toString(aa)));
	}
}

public class Reciever {
	
	static void keyAgreement(){
		Recieverside reciever = new Recieverside();
		try {	
			Socket socket = new Socket("127.0.0.1", 3030);
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(
					socket.getOutputStream()));
			String sb = new String();

			boolean f = true;
			int index = 0;
			int loop = 1;

			while (f) {
				
				sb = reader.readLine();
				if (sb.equals("" + reciever.count(index, 16))) {
					writer.write("right" + "\n");
					writer.flush();
					index += 16;
				} else {
					writer.write("left" + "\n");
					writer.flush();
				}

				sb = reader.readLine();
				if (sb.equals("" + reciever.count(index, 8))) {
					writer.write("right" + "\n");
					writer.flush();
					index += 8;
				} else {
					writer.write("left" + "\n");
					writer.flush();
				}

				sb = reader.readLine();
				if (sb.equals("" + reciever.count(index, 4))) {
					writer.write("right" + "\n");
					writer.flush();
					index += 4;
				} else {
					writer.write("left" + "\n");
					writer.flush();
				}

				sb = reader.readLine();
				if (sb.equals("" + reciever.count(index, 2))) {
					writer.write("right" + "\n");
					writer.flush();
					index += 2;
				} else {
					writer.write("left" + "\n");
					writer.flush();
				}

				sb = reader.readLine();
				if (sb.equals("" + reciever.count(index, 1))) {
					reciever.resetKeyAt(index + 1);
					index = 0;
				} else {
					reciever.resetKeyAt(index);
					index = 0;
				}

				if (loop > 16) {
					sb = reader.readLine();
					if (sb.equals(reciever.count(0, 32) + "") || loop > 1000) {
						writer.write("stop" + "\n");
						writer.flush();
						f = false;
						break;
					} else {
						writer.write("continue" + "\n");
						writer.flush();
					}
				}

				reciever.upSetKey();
				index = 0;
				loop++;
			}

			sb = reader.readLine();
			// System.out.println("接收到的数据："+sb);

			reciever.data = reciever.jiemidata(sb);
			reciever.getdatamd5();
			reciever.jiamimd5();

			writer.write(reciever.result + "\n");
			writer.flush();
			// System.out.println("发送的数据：接受到的数据进行解密后得到data。将data进行hash变换后再用密钥加密后："+reciever.result);
			
			//reciever.show();
			
			socket.close();
			reader.close(); 
			writer.close();
			 
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		for(int i=0;i<100000;i++){
			keyAgreement();
		}

	}
}
