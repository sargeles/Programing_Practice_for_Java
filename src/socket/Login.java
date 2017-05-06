package socket;

import java.sql.*;
import java.util.*;

public class Login {
	//static HashMap<String, String> user = new HashMap<String, String>();
	static Connection con;
	static PreparedStatement pstmt;
	static ResultSet rs;
	static String username=null, password=null;

	public static void main(String[] args) throws Exception {
		DBManager();// �������ݿ�
		Scanner sc = new Scanner(System.in);// ¼���½����
		String[] ss = sc.nextLine().split(",");// ��¼��¼����
		System.out.println(Arrays.toString(ss));
		pstmt=con.prepareStatement("SELECT * FROM users WHERE username = ?");
		pstmt.setString(1,ss[0]); 
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			username = rs.getString("username").toString();
			password = rs.getString("password").toString(); // ¼���½
			//System.out.println(rs.getString("username")+"---"+rs.getString("password"));
			//System.out.println(username+password);
		}
		if (ss[0].equals(username))// ��֤����
		{
			if(ss[1].equals(password))
			System.out.println("��½�ɹ���");
			new Client(username);
		} else
			System.out.println("�û���δ�ҵ�����ע�ᣡ");
		stopDB();// �ر�����
	}

	static void DBManager() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("���ݿ���سɹ���");
		String url = "jdbc:mysql://localhost:3306/my data", user = "root", password = "940325";
		con = DriverManager.getConnection(url, user, password);
		System.out.println("���ݿ����ӳɹ���");
	}

	static void stopDB() throws SQLException {
		con.close();
	}
}
