package java_20210527;

import java.util.ArrayList;

public class DepeDemo {
	public static void main(String[] args) {
		DeptDAO dao = DeptDAO.getInstance();
		DeptDTO dto = new DeptDTO(50,"IT","MOON");
		dao.insert(dto);
		dto.setName("NETWORK");
		dto.setLoc("SUN");
		dao.update(dto);
		dao.delete(50);
		ArrayList<DeptDTO> results = dao.select(0, 10);
		for (DeptDTO dep : results) {
			System.out.printf("%d\t%s\t%s%n",dep.getNo(),dep.getName(),dep.getLoc());
		}
	}
}
