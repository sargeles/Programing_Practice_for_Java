package db;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Test;

public class DBUtilTest {
	Connection conn;
	PreparedStatement pstmt;
	
	
	@Test
	public void testGetconnection(){
		try{
			conn = C3P0DBUtil.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO dbtest (content) VALUES(?)");
			pstmt.setString(1, "nnn");
			pstmt.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			C3P0DBUtil.closeDB(pstmt, conn);
		}
		
	}
}
