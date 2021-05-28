package java_20210528;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionDemo {
	public static void main(String[] args) {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		boolean success= false;
		
		Connection con =null;
		PreparedStatement pstmt1 = null;
		PreparedStatement pstmt2 = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mariadb://localhost:3306/kpc","kpc12","kpc1212");			
			StringBuilder sql = new StringBuilder();
			//트랜잭션 시작:AUTO COMMIT을 0으로한다.
			con.setAutoCommit(false);
			//트랜잭션 시작을 안한 경우
			//상황 : 결제는 정상적으로 들어가고
			sql.append("insert into member values(202,'kim5','kim6')" );
			
			pstmt1= con.prepareStatement(sql.toString());
			pstmt1.executeUpdate();
			//sql문 초기화용.
			sql.setLength(0);
			//상황 : 배송은 안들어감 (오류때문에)
			sql.append("insert into member values(203,'kim7','kim7" );//의도적으로 문법오류냄.
			
			pstmt2= con.prepareStatement(sql.toString());
			pstmt2.executeUpdate();
			//결론: 다 안들어가야는데 결제는 들어간 상황.
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				//트랜잭션의 끝 : 성공여부에 따라 commit/ rollback한다.
				if(success) {
					con.commit();
				}else {
					con.rollback();
				}
				//Connection pool 사용할 때는 반드시 해주어야 함. 
				con.setAutoCommit(true);
				if(con!=null) con.close();
				if(pstmt1!=null) pstmt1.close();
				if(pstmt2!=null) pstmt2.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}
