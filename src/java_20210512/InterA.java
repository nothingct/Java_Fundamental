package java_20210512;
//interface 간에는 extends로 다중상속이 가능하다.
public interface InterA extends InterB, InterC{
	//인터페이스의 변수는 public static final 이 생략되어 있음 
	public static final double PI =3.14;
	//인터페이스의 접근한정자를 붙이지 않으면 public 생략되어 있음
	//abstract 생략 가능
	public abstract void mA();
}
