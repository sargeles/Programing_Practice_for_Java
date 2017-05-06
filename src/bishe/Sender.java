package bishe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.*;
import java.util.*;

/**
 * ���Ͷ˵���Կ�����ݰ�����Ϣ�ķ�װ�ࡣ
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
	 * ���캯��������Կ�������õ���Կ������֤��Ϣ���������õ���֤��Ϣ����������ð���MD5ֵ��
	 */
	Senderside() {
		key = KeyProducer.getKey();// �õ���Կ

		randomGenerator();// �õ����ݰ�
		getdatamd5();
	}

	/**
	 * ��֤��Ϣ��������
	 */
	void randomGenerator() {// �������ݰ�
		Random random = new Random();
		for (int i = 0; i < 32; i++)
			data[i] = random.nextInt(2);
	}

	/**
	 * ����֤��Ϣ������MD5�㷨����
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
	 * ����֤��Ϣ������Կ���м���
	 * 
	 * @return
	 */
	String jiamidata() {// ���ɵ�һ�η��͵�����
		int[] e = new int[32];
		for (int i = 0; i < 32; i++)
			e[i] = data[i] ^ key[i];
		String result = Arrays.toString(e);
		return result;
	}

	/**
	 * �����Լ�����õ���MD5�ͽ��ղ������õ���MD5����жԱ�
	 * 
	 * @param str
	 */
	void compare(String str) {

		char[] ch = str.toCharArray();
		char[] a = new char[32];
		for (int i = 1, j = 0; j < 32; i += 3, j++)
			a[j] = (char) (ch[i] ^ key[j]);
		// System.out.println("���ܺ��datamd5"+Arrays.toString(a));
		f = (Arrays.toString(a)).equals(Arrays.toString(datamd5));
	}

	/**
	 * �õ���Կ�ַ�����hashֵ
	 * 
	 * @return ����keyhash
	 */
	int getkeyhash() {
		keyhash = Arrays.toString(key).hashCode();
		return keyhash;
	}

	/**
	 * ����Կת���ַ���
	 * 
	 * @return Ŀ���ַ���
	 */
	String getkey() {
		String st;
		st = Arrays.toString(key);
		return st;
	}

	/**
	 * ����У��λ
	 * 
	 * @param index
	 *            �±�
	 * @param length
	 *            ��������
	 * @return У����
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
	 * ���Э�������Կ����֤��Ϣ����MD5���������Ӧ����
	 */
	void show() {
		System.out.println("key:" + Arrays.toString(key) + key.length
				+ "hashcode:" + getkeyhash());
		System.out.println("data:" + Arrays.toString(data) + data.length);
		System.out.println("datamd5:" + Arrays.toString(datamd5)
				+ datamd5.length);
		System.out.println("������ȥ�ͽ��յ���data��md5����жԱȵ����ս����" + f);
	}
}

/**
 * ���Ͷ�����ն˽�������
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
				//System.out.println("���ǵ�" + loop + "��Э����");// ѭ��ǰ����˴�ѭ���Ĵ���
				writer.write("" + sender.count(index, 16) + "\n");
				writer.flush();// ���Ͷ˷��͵�һ��У��λ��

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
					writer.flush();// һ�θ��ĺ�У����
					sb = reader.readLine();
					if (sb.equals("stop")) {
						//System.out.println("����" + (loop) + "��Э����ɣ�");
						f = false;
						break;
					}
				}

				sender.upSetKey();
				index = 0;
				loop++;// ��Կͬ�����һ�Σ��ظ�ѭ��
			}

			writer.write(sender.jiamidata() + "\n");// ���ɴ��䴮
			writer.flush();
			// System.out.println("���͵����ݣ����ܺ��data��"+sender.jiamidata());

			sb = reader.readLine();
			// System.out.println("���յ������ݣ�"+sb);

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
		String X="���������",Y=yy+"��Э�̺�ɹ�����";
		
		for(int i=1;i<=xx;i++){
			KeyProducer.n=i;
			x[i-1]=i;
			
			for(int j=0;j<yy;j++){
				if(keyAgreement())
					{n++;System.out.println("������Ϊ"+i+"ʱ��"+"��"+(j+1)+"��"+"���ͳɹ�");}
					else
						System.out.println("������Ϊ"+i+"ʱ��"+"��"+(j+1)+"��"+"����ʧ��");
			}
			y[i-1]=n;n=0;
		}
		new SinFrame(x,y,X,Y);
	}
}