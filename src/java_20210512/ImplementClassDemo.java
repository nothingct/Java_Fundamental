package java_20210512;

public class ImplementClassDemo {
	public static void main(String[] args) {
		InterA i = new ImplementClass();
		i.mA();
		i.mB();
		i.mC();
		System.out.println(InterA.PI);
		
		System.out.println(Math.PI);
		System.out.println(Math.E);
	}
}