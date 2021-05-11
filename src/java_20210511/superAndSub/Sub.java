package java_20210511.superAndSub;

public class Sub extends Super {
	String chicken;
	public void gotoSchool() {
		System.out.println("Sub gotoSchool() 호출");
	}
	//overriding : 부모의 메서드를 재정의  
	/*
	 * 작성 규칙 
	 * 1. 반환형, 메서드 이름 , 매개변수 일치
	 * 2. 접근한정자는 부모보다 자식이 상위이거나 같으면 된다. 
	 * 
	 */
	public void play(String starcraft) {
		//super.play("badook");
		System.out.println("Sub play(~) 호출");
	}
	public String toString() {
		return "서브클래스입니다.";
	}
}
