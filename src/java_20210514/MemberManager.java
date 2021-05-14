package java_20210514;

import java.util.ArrayList;
import java_20210514.Member;
public class MemberManager {
	//insert, update, select, delete 는 원래 DB에서 SQL 로 해야 하는데 아직 안배웠으니까 일단 간단하게 만들기.
	private ArrayList<Member> list;
	// singleton 만들기 : private 생성자를 사용하는 이유
	private static MemberManager single;

	private MemberManager() {
		list = new ArrayList<Member>();
	};

	public static MemberManager getInstance() {
		if (single == null) {
			single = new MemberManager();
		}
		return single;
	}
	//delete(id), select(id) 의 전제 : id가 식별자여야 한다.
	public void insert(String id, String name, int age) {
		list.add(new Member(id,name,age));
	}

	public void update(String id, String name, int age) {
		Member target= select(id);
		if(target!= null) {
			//ID가 식별자라고 하면 ID 가 이미 있다면 변경사항만 바꾸면 된다.
			target.setAge(age);
			target.setName(name);
		}
	}

	public void delete(String id) {
		for (Member member : list) {
			if(member.getId().equals(id)) {
				list.remove(member);
				return;
			}
		}
	}

	public ArrayList select() {
		return list;
	}

	public Member select(String id) {
		Member target=null;
		for (Member member : list) {
			if(member.getId().equals(id)) {
				target=member;
				break;
			}
		}
		return target;
	}
	public void print(ArrayList list) {
		System.out.println();
		System.out.println("=============검색결과======================");
		for (Object m : list) {
			System.out.println(m);
		}
		System.out.println("=============검색종료=======================");
		System.out.println();
	}
}
