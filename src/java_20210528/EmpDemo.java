package java_20210528;

import java.util.ArrayList;

public class EmpDemo {
	public static void main(String[] args) {
		EmpDAO dao = EmpDAO.getInstance();
		EmpDTO dto = new EmpDTO(1111,"ET","gamer",7839,"1995-01-01",4869432.12f,1111.12f,50);
		dao.insert(dto);
		//name,job,mgr,sale,comm   empno
		dto.setName("faker");
		dto.setJob("SKT");
		dto.setMgr(7844);
		dto.setSal(9999999.f);
		dto.setComm(1111133.f);
		dao.update(dto);
		
//		dao.delete(1111);
		ArrayList<EmpDTO> results = dao.select(0, 15);
		for (EmpDTO e : results) {
			System.out.printf("%d %s %s %d %s %f %f %d %n",
					e.getNo(), e.getName(),e.getJob(),e.getMgr(),
					e.getHireDate(),e.getSal(),e.getComm(),e.getDeptNo());
		}
	}
}
