package java_20210526;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcUpdateDemo {
	public static void main(String[] args) {
		//1 드라이버 로딩
		try {
			//mariaDB 드라이버 : org.mariadb.jdbc.Driver
			//Oracle 드라이버 :  oracle.jdbc.driver.OracleDriver
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로딩 실패");
		}
		//2 데이버에스와 연결할 Connection
		Connection con = null;
		PreparedStatement pstmt = null;	
		try {
			//oracle 연결 시 : mysql -> oracle로 변경.
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kpc","kpc12","kpc1212");
			System.out.println("DB 연결 성공");
			//4 SQL문 생성 By StringBuilder, Binding 변수 사용
			StringBuilder sql= new StringBuilder();
			//맨 끝에는 항상 space bar를 쳐서 구문 오류를 막자.
			sql.append("UPDATE member ");
			sql.append("SET NAME=? , addr = ? ");
			sql.append("WHERE num = ? ");
			//3 SQL문 전송할 PreparedStatement 에 StringBuilder 를 toString해서 String인자로 받는다.
			pstmt = con.prepareStatement(sql.toString());
			//5 Binding변수 채우고. SQL 문 전송
			//인덱스를 이용해서 사용자 입력 실수 방지 : 칼럼이 많아지면 인덱스를 이용해서 코딩을 해야 스트레스 안받는다. 
			int index = 1;
			pstmt.setString(index++, "손오공");
			pstmt.setString(index++, "용신네집");
			pstmt.setInt(index, 10);
			
			int rowCount = pstmt.executeUpdate();
			System.out.println("총 "+rowCount+"개의 행이 영향을 받았습니다.");
		} catch (SQLException e) {
			System.err.println("DB 연결 실패");
		} finally {
			//6 모든 자원은 반납한다.
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
