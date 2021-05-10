package java_20210506;

public class CustomerDemo {
	public static void main(String[] args) {
		Customer c1 = new Customer();
		c1.name = "오한승";
		c1.age = 99;
		c1.email = "nct@naver.com";
		c1.phone = "010-1234-2345";
		c1.balance = 45_000_000;
		c1.relaesed = false;
		// 클래스 변수(static 변수 )는 클래스 이름으로 접근하는것이 관례
		// 변수로도 접근가능하나 권장하지 않음 예) c1.interestRate=6.2;
		Customer.interestRate = 6.2;
		// final 변수는 값을 재할당 할 수 없음.
		// Customer.BANKNAME="국민은행";
		System.out.printf("%s, %d, %s, %s, %f, %s %n", c1.name, c1.age, c1.email, c1.phone, c1.balance, c1.relaesed);

		Customer c2 = new Customer();
		c2.name = "손정의";
		c2.age = 30;
		c2.email = "ceo@softbank.com";
		c2.phone = "010-1231-2232";
		c2.balance = 50_000_000_000_000.;
		c2.relaesed = false;
		Customer.interestRate = 8.2;
		System.out.printf("%s, %d, %s, %s, %f, %s %n", c2.name, c2.age, c2.email, c2.phone, c2.balance, c2.relaesed);

		// c3 가 c2를 가리키도록(참조)
		Customer c3 = c2;
		c3.name = "손정의1";
		System.out.printf("%s, %s%n", c2.name, c3.name);
		System.out.printf("%f %n", Customer.interestRate);
	}
}
