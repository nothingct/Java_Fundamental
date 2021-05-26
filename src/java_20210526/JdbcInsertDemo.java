package java_20210526;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcInsertDemo {
	public static void main(String[] args) {
		//1. 드라이버 로드한다.
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 로드 성공");
		} catch (ClassNotFoundException e) {
			System.err.println("드라이버 로드 실패 : "+e.getMessage());
		}
		//2. 데이터 베이스와 연결하는 Connection 객체를 생성한다.
		Connection conn=null;
		PreparedStatement pstmt = null;
		try {
			conn= DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/kpc",//url
					"kpc12",//user
					"kpc1212"//pw
					);
			System.out.println("데이터베이스 연결 성공");
			
			//3 SQL 문을 전송할 수 있는 PreparedStatement 객체 를 생성 
			StringBuilder sql = new StringBuilder();
			//JDBC에서 insert문 만들 때 오류가 많이 발생하니까, HeidSQL 에서 해보고, 에러 안나면 copy해서 하나씩 .
			sql.append("INSERT INTO member(num,NAME,addr)");
			sql.append("VALUES(?,?,?)"); //이 값이 고정되있는 경우는 없고 대개 입력을 사용자로부터 받은 경우가 많다.==>?처리.
			pstmt = conn.prepareStatement(sql.toString());
			
			//4 . 바인딩 변수 설정하기.
			pstmt.setInt(1, 11);
			pstmt.setString(2, "ohs");
			pstmt.setString(3, "korea");
			
			//5.SQL문 전송
			int resultCount = pstmt.executeUpdate();
			System.out.println("갱신된 행의 수 : "+resultCount);
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if(conn!= null) conn.close();
					if(pstmt!=null) pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}

	}
}
