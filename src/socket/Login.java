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
		DBManager();// 连接数据库
		Scanner sc = new Scanner(System.in);// 录入登陆数据
		String[] ss = sc.nextLine().split(",");// 记录登录数据
		System.out.println(Arrays.toString(ss));
		pstmt=con.prepareStatement("SELECT * FROM users WHERE username = ?");
		pstmt.setString(1,ss[0]); 
		rs = pstmt.executeQuery();
		while(rs.next())
		{
			username = rs.getString("username").toString();
			password = rs.getString("password").toString(); // 录入登陆
			//System.out.println(rs.getString("username")+"---"+rs.getString("password"));
			//System.out.println(username+password);
		}
		if (ss[0].equals(username))// 验证输入
		{
			if(ss[1].equals(password))
			System.out.println("登陆成功！");
			new Client(username);
		} else
			System.out.println("用户名未找到！请注册！");
		stopDB();// 关闭连接
	}

	static void DBManager() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("数据库加载成功！");
		String url = "jdbc:mysql://localhost:3306/my data", user = "root", password = "940325";
		con = DriverManager.getConnection(url, user, password);
		System.out.println("数据库连接成功！");
	}

	static void stopDB() throws SQLException {
		con.close();
	}
}
