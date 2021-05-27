package java_20210527;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DeptDAO {
	//singleton 만들기 : private 생성자를 사용하는 이유
	private static DeptDAO single;

	private DeptDAO() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static DeptDAO getInstance() {
		if (single == null) {
			single = new DeptDAO();
		}
		return single;
	}
	
	boolean insert(DeptDTO dto) {
		boolean success=false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/kpc","kpc12","kpc1212");
			StringBuilder sql = new StringBuilder();
			sql.append("insert into dept(deptno, dname, loc) ");
			sql.append("values (?, ?, ?) ");
			pstmt = con.prepareStatement(sql.toString());
			int index= 1; 
			pstmt.setInt(index++, dto.getNo());
			pstmt.setString(index++, dto.getName());
			pstmt.setString(index++, dto.getLoc());
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) con.close();
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return success;
		}
	}
	
	boolean update(DeptDTO dto) {
		boolean success=false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/kpc","kpc12","kpc1212");
			StringBuilder sql = new StringBuilder();
			sql.append("update dept set dname=? , loc=? ");
			sql.append("where deptno= ? ");
			pstmt = con.prepareStatement(sql.toString());
			int index=1;
			pstmt.setString(index++, dto.getName());
			pstmt.setString(index++, dto.getLoc());
			pstmt.setInt(index++, dto.getNo());
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if(con!=null) con.close();
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return success;
		}
	}
	
	boolean delete(int no) {
		boolean success=false;
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/kpc","kpc12","kpc1212");
			StringBuilder sql = new StringBuilder();
			sql.append("delete from dept ");
			sql.append("where deptno = ? ");
			
			pstmt = con.prepareStatement(sql.toString());
			
			int index= 1; 
			pstmt.setInt(index++, no);
			pstmt.executeUpdate();
			success = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) con.close();
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return success;
		}
	}
	ArrayList<DeptDTO> select(int start, int len)
	{
		ArrayList<DeptDTO> list = new ArrayList<DeptDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try {
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/kpc","kpc12","kpc1212");
			StringBuilder sql = new StringBuilder();
			sql.append("select deptNo, dname, loc ");
			sql.append("from dept ");
			sql.append("order by deptNo desc ");
			sql.append("limit ?,? ");
			pstmt = con.prepareStatement(sql.toString());
			int index=1;
			pstmt.setInt(index++, start);
			pstmt.setInt(index++, len);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				index=1;
				int no = rs.getInt(index++);
				String name = rs.getString(index++);
				String loc = rs.getString(index++);
				list.add(new DeptDTO(no,name,loc));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(con!=null) con.close();
				if(pstmt!=null) pstmt.close();
				if(rs!=null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return list;
		}
	}
}
