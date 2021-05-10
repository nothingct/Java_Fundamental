package java_20210506.bb;

import java_20210506.aa.Notice;

public class NoticeDemo2 extends Notice{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 서로 다른 패키지 의 클래스를 사용하기 위해서는
		// import 구문을 사용해야 한다.
		// package => import => class 순으로 코딩해야 한다.
		Notice n1 = new Notice();
		n1.number = 1;// public은 서로 다른 패키지에서 접근가능
		//n1.title = "공지사항 입니다.";// protected 서로 다른 패키지에서 접근하려면 상속받은 경우만 가능.
		// n1.hit = 0;// default 서로 다른 패키지에서 접근 불가능
		// n1.regdate = "2021-05-06";// 서로 다른 패키지에서 접근 불가능
		
		NoticeDemo2 n2 = new NoticeDemo2();
		n2.number=2;
		n2.title=""; //protected 서로 다른 패키지에서 상속받은 경우는 접근 가능.
		//n2.hit=10;
		//n2.regdate ="";
	}
}
