package socket;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class DBManager {
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//�������ڸ�ʽ
	java.util.Date t;

	public DBManager() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("���ݿ���سɹ���");
			String url = "jdbc:mysql://localhost:3306/my data", user = "root", password = "940325";
			con = DriverManager.getConnection(url, user, password);
			System.out.println("���ݿ����ӳɹ���");
			stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	void stop(){
		try {
			con.close();
			System.out.println("���ӹر�");
			stmt.close();
			System.out.println("�������װ�ر�");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	ResultSet getRecord(){
		try {
			rs=stmt.executeQuery("SELECT time,username,content FROM chatrecord");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return rs;
	}
	
	void setRecord(String username,String content) throws SQLException, ParseException{
		pstmt= con.prepareStatement("INSERT INTO ChatRecord (time,username,content) VALUES(?,?,?)");
		pstmt.setTimestamp(1, new Timestamp(System.currentTimeMillis()));
		pstmt.setString(2, username);
		pstmt.setString(3, content);
		pstmt.executeUpdate();
	}
	
	
	
}
