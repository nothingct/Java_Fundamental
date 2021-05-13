package java_20210513;

public class StringBufferDemo {
	public static void main(String[] args) {
		StringBuffer s1 = new StringBuffer("hello");
		StringBuffer s2 = new StringBuffer("hello");
		//+ String Buffer 클래스는 String 클래스와는 어떠한 상속관계도 X ==> String 함수를 StringBuffer 에서 사용 X
		//equals() 함수 재정의가 되어있지 않음.==> 아래와 같은 문자열 조작 여부는 String 에서만 해야 함.
		System.out.println(s1==s2);
		System.out.println(s1.equals(s2));
		System.out.println(s1);		
		
		//StringBuffer -> String 으로 활용하기 위한 메커니즘 
		//when? 문자열 비교(equals() ) 나 기타 String 함수를 사용하고자 할때.
		String str1 = s1.toString();
		String str2 = s2.toString();
		
		//string 객체는 equals() 재정의 되어있어서 true 반환
		System.out.println(str1.equals(str2));
		//String : 불변 / StringBuffer : 가변 인건 알아도 StringBuffer.equals() 가 재정의 되어있지않은건 몰라서 
		//실수를 많이함. 
		
		//StringBuffer의 본연의 기능은 무엇인가? sql 문 작성과 같이 문자열을 쭈욱 연결하고자 할 때 
		//즉 가변문자열 클래스 의 특징을 활용하고자 할때.
		StringBuffer sql = new StringBuffer();
		sql.append("select name,age \n");
		sql.append("from member \n");
		sql.append("where name = '오한승' \n");
		System.out.println(sql);
		
		//sql의 모든 문자열 지우기. ==> 빈 가변문자열로 다시 sql 변수를 활용할 수 잇음 . 
		sql.setLength(0);
		//다시 새로운 sql문 작성 가능.
		sql.append("select no, writer from board ");
		System.out.println(sql);
		//StringBuffer 는 결국 append와 setLength(0) 만 잘 알고있으면된다.
		//StringBuffer 끝. 
		//java 7 부터는 Collection => Calendar 를 일단 Collection으로 개선할 것. ==> Collection 그 다음 공부.
	}
}
