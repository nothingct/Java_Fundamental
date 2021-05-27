package java_20210527;

import java.util.ArrayList;

//main: 객체생성->메소드 호출  로 끝나는거야
public class MemberDemo {
	public static void main(String[] args) {
		MemberDao dao =MemberDao.getInstance();
		/* 진짜 객체 하나만 만들어지는지 확인 (singleton인지 확인)
		MemberDao dao1 =MemberDao.getInstance();
		System.out.println(dao==dao1);
		*/
		MemberDTO dto = new MemberDTO(5,"ㅁㅁㅁ","ㅁㅁㅁㅁ");
		dao.insert(dto);
		dto.setName("김범수1");
		dto.setAddr("한국1");
		dao.update(dto);
		dao.delete(dto.getNum());
		ArrayList<MemberDTO> results = dao.select(0, 10);
		for (MemberDTO member : results) {
			System.out.printf("%d\t%s\t%s%n",member.getNum(),member.getName(),member.getAddr());
		}
	}
}
