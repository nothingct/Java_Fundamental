package java_20210507;

public class StaticMethodDemo {
	String name;
	static double interesetRate;
	public void m1() {
		System.out.println("instance method m1 호출");
	}
	public void m2() {
		//instance method 에서는 
		//모든 변수를 사용하고, 모든 메소드를 호출할 수 있음.
		this.name = "오한승"; //this. => 자기자신 인스턴스
		StaticMethodDemo.interesetRate = 3.4;
		this.m1();
		m3();
	}
	public static void m3() {
		System.out.println("static method m3() 호출");
	}
	public static void m4() {
		//static method 에서는 static 변수와 static 메서드만 사용할 수 있다.
		//static => 클래스명으로 접근해라.
		//name = "홍길동";
		interesetRate = 4.3;
		//m1();
		m3();
	}
	public static void main(String[] args) {
		m3();
		m4();
		interesetRate=4.3;
		StaticMethodDemo smd =new StaticMethodDemo();
		smd.name = "오한승";
		smd.m1();
		smd.m2();
		//static method 에서는 this 를 사용할 수 없다. => 직접 인스턴스를 생성해서 인스턴스명으로 접근.
		//static method <-when? 
		//1.static 변수를 활용하여 기능을 제공==>근 이런 경우는 거의 없다.
		//2.util method들을 위한 util class들을 static 으로 만들어서 util method들을 static으로 해서 사용하기 편하게
		//Ex) Math 클래스 -> 모든 함수가 static으로 되어있다. 기능들을 편하게 사용하기 위해.
	}
}
