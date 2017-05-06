package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class DBManagerTest {
	Connection con;
	Statement stmt;
	PreparedStatement pstmt;
	ResultSet rs;
	Savepoint sp;

	@Before
	public void init() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("数据库加载成功！");
		String url = "jdbc:mysql://localhost:3306/test", user = "sargeles", password = "855525";
		con = DriverManager.getConnection(url, user, password);
		System.out.println("数据库连接成功！");

	}

	@After
	public void destroy() throws SQLException {
		con.close();
	}

	@Test
	public void testCreateStatement() throws SQLException {
		stmt = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
				ResultSet.CONCUR_READ_ONLY);
		stmt.executeUpdate("INSERT INTO dbtest (content) VALUES('aaa')");
		stmt.close();
	}

	@Test
	public void testPrepareStatement() throws SQLException {
		pstmt = con.prepareStatement("INSERT INTO dbtest (content) VALUES(?)");
		pstmt.setString(1, "bbb");
		pstmt.executeUpdate();
		pstmt.close();
	}

	@Test
	public void testTransactionStatement1() {
		try {
			pstmt = con
					.prepareStatement("INSERT INTO dbtest (content) VALUES(?)");

			con.setAutoCommit(true);

			pstmt.setString(1, "ccc");
			pstmt.executeUpdate();

			pstmt.setString(1, "ddd");
			pstmt.executeUpdate();

			int i = 1 / 0;

			pstmt.setString(1, "eee");
			pstmt.executeUpdate();

			con.commit();
		} catch (Exception e) {
			System.out.println("事务未提交！");
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

	}
	
	@Test
	public void testTransactionStatement2() {
		try {
			pstmt = con
					.prepareStatement("INSERT INTO dbtest (content) VALUES(?)");

			con.setAutoCommit(false);

			pstmt.setString(1, "ccc");
			pstmt.executeUpdate();

			sp = con.setSavepoint();

			pstmt.setString(1, "ddd");
			pstmt.executeUpdate();

			int i = 1 / 0;

			pstmt.setString(1, "eee");
			pstmt.executeUpdate();

			con.commit();
		} catch (Exception e) {
			try {
				con.rollback(sp);
				con.commit();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		} finally {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
