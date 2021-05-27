package java_20210528;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class EmpDAO {
	private static EmpDAO single;
	private EmpDAO() {
		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static EmpDAO getInstance() {
		if(single==null) {
			single = new EmpDAO();
		}
		return single;
	}
	public boolean insert(EmpDTO dto) {
		boolean success=false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kpc","kpc12","kpc1212");
			StringBuilder sql = new StringBuilder();
			sql.append("INSERT INTO EMP ");
			sql.append("VALUES (?,?,?,?,?,?,?,?) ");
			
			pstmt=con.prepareStatement(sql.toString());
			int index =1; 
			pstmt.setInt(index++, dto.getNo());
			pstmt.setString(index++, dto.getName());
			pstmt.setString(index++,dto.getJob());
			pstmt.setInt(index++,dto.getMgr());
			pstmt.setString(index++, dto.getHireDate());
			pstmt.setFloat(index++, dto.getSal());
			pstmt.setFloat(index++, dto.getComm());
			pstmt.setInt(index++,dto.getDeptNo());
			pstmt.executeUpdate();
			success=true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null) con.close();
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return success;
		}
	}
	public boolean update(EmpDTO dto) {
		boolean success=false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kpc","kpc12","kpc1212");
			StringBuilder sql = new StringBuilder();
			sql.append("update EMP set ");
			sql.append("ename = ? , job = ? , mgr= ? , sal= ? , comm = ? ");
			sql.append("where empno = ? ");
			
			pstmt=con.prepareStatement(sql.toString());
			int index =1; 
			pstmt.setString(index++, dto.getName());
			pstmt.setString(index++,dto.getJob());
			pstmt.setInt(index++,dto.getMgr());
			pstmt.setFloat(index++, dto.getSal());
			pstmt.setFloat(index++, dto.getComm());
			pstmt.setInt(index++, dto.getNo());
			pstmt.executeUpdate();
			success=true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null) con.close();
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return success;
		}
	}
	public boolean delete(int no) {
		boolean success=false;
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kpc","kpc12","kpc1212");
			StringBuilder sql = new StringBuilder();
			sql.append("delete from EMP ");
			sql.append("where empno = ? ");
			
			pstmt=con.prepareStatement(sql.toString());
			int index =1; 
			pstmt.setInt(index++, no);
			pstmt.executeUpdate();
			success=true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null) con.close();
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return success;
		}
	}
	public ArrayList<EmpDTO> select(int start, int len){
		ArrayList<EmpDTO> list = new ArrayList<EmpDTO>();
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/kpc","kpc12","kpc1212");
			StringBuilder sql = new StringBuilder();
			sql.append("select empno,ename,job,mgr,hiredate,sal,comm,deptno ");
			sql.append("from emp ");
			sql.append("where sal > 1000 ");
			sql.append("order by empno desc, ename , sal desc ");
			sql.append("limit ?,? ");
			
			pstmt=con.prepareStatement(sql.toString());
			int index =1; 
			pstmt.setInt(index++,start);
			pstmt.setInt(index++,len);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				index=1;
				int no = rs.getInt(index++);
				String name = rs.getString(index++);
				String job = rs.getString(index++);
				int mgr = rs.getInt(index++);
				String hireDate = rs.getString(index++);
				float sal = rs.getFloat(index++);
				float comm = rs.getFloat(index++);
				int deptNo = rs.getInt(index++);
				list.add(new EmpDTO(no,name,job,mgr,hireDate,sal,comm,deptNo));
			}
			for (EmpDTO e : list) {
				System.out.printf("%d %s %s %d %s %f %f %d %n",
						e.getNo(),e.getName(),e.getJob(),e.getMgr(),e.getHireDate(),e.getSal(),e.getComm(),e.getDeptNo());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(con!=null) con.close();
				if(pstmt!=null) pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return list;
		}
	}
}
