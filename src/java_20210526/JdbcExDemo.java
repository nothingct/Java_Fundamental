package java_20210526;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcExDemo {
	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con =null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kpc","kpc12","kpc1212");
			StringBuilder sql = new StringBuilder();
			//insert 
			sql.append("INSERT INTO MEMBER(NUM,NAME,ADDR) ");
			sql.append("VALUES(?,?,?) ");
			pstmt = con.prepareStatement(sql.toString());
			int index= 1;
			pstmt.setInt(index++, 100);
			pstmt.setString(index++, "HTML");
			pstmt.setString(index, "WEB");
			
			int rowCnt = pstmt.executeUpdate();
			System.out.println(rowCnt);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
				try {
					if(con!=null) con.close();
					if(pstmt!=null) pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
		
	}
}
