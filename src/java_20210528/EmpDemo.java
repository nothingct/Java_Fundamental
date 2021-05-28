package java_20210528;

import java.util.ArrayList;

public class EmpDemo {
	public static void main(String[] args) {
		EmpDAO dao = EmpDAO.getInstance();
		EmpDTO dto = new EmpDTO(9003,"KIM","MANAGER",7839,null,50000.f,40000.f,30);
//		dao.insert(dto);
		//name,job,mgr,sale,comm   empno
//		dto.setName("faker");
//		dto.setJob("SKT");
//		dto.setMgr(7844);
//		dto.setSal(9999999.f);
//		dto.setComm(1111133.f);
//		dao.update(dto);
//		dao.delete(9003);
		ArrayList<EmpDTO> results = dao.select(0, 15);
		for (EmpDTO e : results) {
			System.out.printf("%d %s %s %d %s %.1f %.1f %d %n",
					e.getNo(), e.getName(),e.getJob(),e.getMgr(),
					e.getHireDate(),e.getSal(),e.getComm(),e.getDeptNo());
		}
	}
}
