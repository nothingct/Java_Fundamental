package java_20210514;

import java.util.ArrayList;
//Ctrl Shift S : 띄운 모든 파일 저장.
public class MemberDemo {
	//일단은 main화면을 웹브라우저라고 생각하고 코딩해야함. (Logic 이 들어가면 안된다는 의미)
	public static void main(String[] args) {
		//멤버 메니저 생성
		MemberManager manager = MemberManager.getInstance();
		//데이터 삽입
		manager.insert("nothingct1","ohs1",1);
		manager.insert("nothingct2","ohs2",2);
		manager.insert("nothingct3","ohs3",3);
		manager.insert("nothingct4","ohs4",4);
		//데이터 모두 가져오기.
		ArrayList list = manager.select();
		//데이터 출력
		manager.print(list);
		//데이터 삭제
		manager.delete("nothingct1");
		list = manager.select();
		manager.print(list);
		//데이터 갱신
		manager.update("syh2022","성영한2",100);
		list = manager.select();
		manager.print(list);
		//특정 데이터 조회
		System.out.println(manager.select("syh2022"));
	}
}

