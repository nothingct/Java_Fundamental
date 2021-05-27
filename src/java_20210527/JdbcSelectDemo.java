package java_20210527;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcSelectDemo {
	public static void main(String[] args) {
			try {
				//1 드라이버 로딩 : Class.forName()
				Class.forName("org.mariadb.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			try {
				//2 DB연결:Connection
				con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kpc","kpc12","kpc1212");
				//3 SQL문 생성 (select - 반드시 맨 마지막에 order by 절 을 써라,누구도 랜덤의 결과값을 원하지 않음)
				StringBuilder sql = new StringBuilder();
				sql.append("select * ");
				sql.append("from member ");
				sql.append("order by num desc ");
				sql.append("limit ?,?"); //보통 limit 절에는 바인딩 변수를 사용=> 원하는 범위를 개발자가 뽑아낼 수 있다.
				//4 SQL 전송(select) : PreparedStatement
				
				pstmt = con.prepareStatement(sql.toString());
				int index= 1;
				pstmt.setInt(index++, 0);//limit 은 인덱스가 0부터 시작하는 것에 주의.
				pstmt.setInt(index, 10);
				
				//5 Select 결과 -> ResultSet 에 저장 :executeQuery() + ResultSet
				rs = pstmt.executeQuery();
				System.out.printf("num\tname\taddr%n");
				//6 ResultSet안의 데이터 조회: next() + getXXX() 
				while(rs.next()) {
					index= 1;
					int num = rs.getInt(index++);
					String name = rs.getString(index++);
					String addr= rs.getString(index);
					System.out.printf("%d\t%s\t%s%n",num,name,addr);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				try {
					//7 모든 자원을 반납한다.
					if(con!=null) con.close();
					if(pstmt!=null) pstmt.close();
					if(rs!=null) rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
	}
}
