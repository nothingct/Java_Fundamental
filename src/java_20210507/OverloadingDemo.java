package java_20210507;

public class OverloadingDemo {
		//OverloadingDemo 클래스에서는 print() 메서드를 4가지로 오버로딩
		//Overloading 의 작성 규칙
		//1.같은 클래스 내에서
		//2.메서드 이름은 같아야 한다.
		//3.매개변수의 갯수가 같으면 서로 다른 자료형으로 구현
		//4.매개변수의 갯수가 달라야 한다. 
		//5.접근한정자와 반환형은 같거나 달라도 무방하다.
		public void print(String str) {
			System.out.print(str);
		}
		public void print(int i) {
			System.out.print(i);
		}
		public void print(double d) {
			System.out.print(d);
		}
		public void print(boolean b) {
			System.out.print(b);
		}
		public static void main(String[] args) {
			OverloadingDemo demo = new OverloadingDemo();
			demo.print("오한승");
			demo.print(10);
			demo.print(true);
			demo.print(42.34);
		}
}
