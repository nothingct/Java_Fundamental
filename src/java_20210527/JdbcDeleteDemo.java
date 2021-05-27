package java_20210527;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JdbcDeleteDemo {
	//insert, delete ,update 직접 해봐서 알겠지만 , 패턴이 모두 똑같기 때문에 ==>보통 Template 화합니다. 
	public static void main(String[] args) {
		//1. 드라이버 로드한다.
		try {
			Class.forName("org.mariadb.jdbc.Driver");
			System.out.println("드라이버 로딩 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection con = null;
		PreparedStatement pstmt = null;
		//2 데이버에스와 연결할 Connection=> DB 마다 connection 횟수가 제한되있다. mariaDB->150 oracle->50언저리.

		try {//port 가 default 는 3306 이지만,아닌 경우에는 : 을 붙여서 port 를 명시.
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kpc","kpc12","kpc1212"); 
			System.out.println("연결성공");
			//3 SQL문 전송할 PreparedStatement 에 StringBuilder 를 toString해서 String인자로 받는다.

			StringBuilder sql = new StringBuilder();
			sql.append("delete from member ");
			sql.append("where num= ? ");
			//4 SQL문 생성 By StringBuilder, Binding 변수 사용

			pstmt= con.prepareStatement(sql.toString());
			//5 Binding변수 채우고. SQL 문 전송
			//인덱스를 이용해서 사용자 입력 실수 방지 : 칼럼이 많아지면 인덱스를 이용해서 코딩을 해야 스트레스 안받는다. 
			
			int index= 1;
			pstmt.setInt(index, 100);
			//pstmt.setString(index,String.valueOf("100"); <--가능하다. SQL내부에서 convert() : 문자->숫자 변환해줌.
			int rowCount = pstmt.executeUpdate();//insert, update, delete를 할 때 쓰는 함수.
			System.out.println(rowCount);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			//6.모든 자원을 반환한다.
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
