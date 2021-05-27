package java_20210527;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDao {
	// MemberDao 객체는 보통 SingleTon으로 하나만 생성해서 작업한다.

	// singleton 만들기 : private 생성자를 사용하는 이유 :객체 하나만 생성하려고
	// 이 디자인 패턴 은 그냥 외우셔야됩니다.
	// 1.객체 변수인 single을 static 변수로 설정
	private static MemberDao single;

	// 2.생성자의 접근한정자를 private으로 설정
	// 이유 : 외부에서 객체 생성 못하게 하기 위함
	private MemberDao() {
		// 드라이버 로딩은 딱 1번만 하면 되니까, 딱 1번 호출되는 생성자에 집어넣어.
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	};

	// MemberDao 의 객체는 MemgerDao.getInstance() 메소드로만 생성이 가능함
	public static MemberDao getInstance() {
		// getInstance() : MemberDao(해당객체)는 객체를 한 개만 생성할 수 있도록 만들어야 함.
		// static Method로 구현한 이유 는 MemberDao(해당객체)가 static이고 외부에서 생성할 수 없기 때문임.
		if (single == null) {
			single = new MemberDao();
		}
		return single;
	}

	public boolean insert(MemberDTO dto) {
		boolean success = false;

		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/kpc", // url
					"kpc12", // user
					"kpc1212"// pw
			);

			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO member(num,NAME,addr)");
			sql.append("VALUES(?,?,?)"); // 이 값이 고정되있는 경우는 없고 대개 입력을 사용자로부터 받은 경우가 많다.==>?처리.
			pstmt = conn.prepareStatement(sql.toString());
			int index = 1;// column = 1부터 시작
			pstmt.setInt(index++, dto.getNum());
			pstmt.setString(index++, dto.getName());
			pstmt.setString(index++, dto.getAddr());

			pstmt.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (conn != null)
					conn.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return success;
		}
	}

	public boolean update(MemberDTO dto) {
		boolean success = false;

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kpc", "kpc12", "kpc1212");
			StringBuilder sql = new StringBuilder();
			sql.append("UPDATE member ");
			sql.append("SET NAME=? , addr = ? ");
			sql.append("WHERE num = ? ");
			pstmt = con.prepareStatement(sql.toString());
			int index = 1;
			pstmt.setString(index++, dto.getName());
			pstmt.setString(index++, dto.getAddr());
			pstmt.setInt(index, dto.getNum());

			pstmt.executeUpdate();
			success = true;
		} catch (SQLException e) {
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return success;
		}
	}

	public boolean delete(int num) {
		boolean success = false;

		Connection con = null;
		PreparedStatement pstmt = null;
		try {// port 가 default 는 3306 이지만,아닌 경우에는 : 을 붙여서 port 를 명시.
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kpc", "kpc12", "kpc1212");
			StringBuilder sql = new StringBuilder();
			sql.append("delete from member ");
			sql.append("where num= ? ");
			pstmt = con.prepareStatement(sql.toString());
			int index = 1;
			pstmt.setInt(index++, num);
			pstmt.executeUpdate();// insert, update, delete를 할 때 쓰는 함수.
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return success;
		}

	}

	public ArrayList<MemberDTO> select(int start, int len) {
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kpc", "kpc12", "kpc1212");
			StringBuilder sql = new StringBuilder();
			sql.append("select * ");
			sql.append("from member ");
			sql.append("order by num desc ");
			sql.append("limit ?,?"); // 보통 limit 절에는 바인딩 변수를 사용=> 원하는 범위를 개발자가 뽑아낼 수 있다.

			pstmt = con.prepareStatement(sql.toString());
			int index = 1;
			pstmt.setInt(index++, start);// limit 은 인덱스가 0부터 시작하는 것에 주의.
			pstmt.setInt(index, len);

			rs = pstmt.executeQuery();
			System.out.printf("num\tname\taddr%n");
			while (rs.next()) {
				index = 1;
				int num = rs.getInt(index++);
				String name = rs.getString(index++);
				String addr = rs.getString(index++);
				list.add(new MemberDTO(num,name,addr));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				// 7 모든 자원을 반납한다.
				if (con != null)
					con.close();
				if (pstmt != null)
					pstmt.close();
				if (rs != null)
					rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return list;
	}
}
