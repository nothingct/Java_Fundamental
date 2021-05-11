package java_20210511.superAndSub;
class A{
	int a; 
	public A(int a) {this.a = a;}
	public A() {}
}
class B extends A{
	public B() {
		super(10);
	}
}

public class SuperDemo {
	public static void main(String[] args) {
		B b = new B();//에러 발생 x 명시적으로 A 디폴트 생성자를 만들어줬기 때문. (디폴트생성자 로 호출 시 )
		B bb = new B();//에러 발생 X B 생성자 안에 super()디폴트 가 아닌 super(10)을 호출했기 때문.(생성자를 직접 구현시)
		System.out.println(bb.a);
	}
}
