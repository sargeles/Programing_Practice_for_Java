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
 * ���ն˵ķ�װ��
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
	 * ����keyProducer.getKey()�õ�һ��32λ��������Կ
	 */
	Recieverside() {
		key = KeyProducer.getKey();// �õ���Կ
	}

	/**
	 * ����Կ������֤��Ϣ����MD5��
	 */
	void jiamimd5() {// ���ɵ�һ�η��͵�����
		char[] ch = new char[32];
		System.arraycopy(datamd5, 0, ch, 0, 32);
		for (int i = 0; i < 32; i++)
			ch[i] = (char) (ch[i] ^ key[i]);
		result = Arrays.toString(ch);
	}

	/**
	 * �����ַ����õ���֤��Ϣ��data
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
	 * ����֤��Ϣ������MD5�㷨����
	 */
	void getdatamd5() {
		try {
			datamd5 = MD5Util.md5Encode(Arrays.toString(data)).toCharArray();
			// System.out.println("datamd5:"+Arrays.toString(datamd5)+datamd5.length);
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}

	/**
	 * �õ���Կ�ַ�����hashֵ
	 * 
	 * @return
	 */
	int getkeyhash() {
		keyhash = Arrays.toString(key).hashCode();
		return keyhash;
	}

	/**
	 * ����У��λ
	 * 
	 * @param index
	 * @param length
	 * @return У����
	 */
	int count(int index, int length) {
		int f = 0;
		for (int i = index; i < (length + index); i++)
			f += key[i];
		f = f % 2;
		return f;
	}

	/**
	 * ��ָ���±�λ������Կ
	 * 
	 * @param index
	 */
	void resetKeyAt(int index) {
		key[index] = (key[index] + 1) % 2;
	}

	/**
	 * ����Կ����һλ
	 */
	void upSetKey() {
		int k = key[0];
		int i;
		for (i = 0; i < 31; i++)
			key[i] = key[i + 1];
		key[i] = k;
	}

	/**
	 * ���Э�������Կ����֤��Ϣ����MD5���
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
		System.out.println("������Կ��" + MD5Util.md5Encode(Arrays.toString(aa)));
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
			// System.out.println("���յ������ݣ�"+sb);

			reciever.data = reciever.jiemidata(sb);
			reciever.getdatamd5();
			reciever.jiamimd5();

			writer.write(reciever.result + "\n");
			writer.flush();
			// System.out.println("���͵����ݣ����ܵ������ݽ��н��ܺ�õ�data����data����hash�任��������Կ���ܺ�"+reciever.result);
			
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
