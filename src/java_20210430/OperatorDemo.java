package java_20210430;

public class OperatorDemo {
	public static void main(String[] args) {
		int a = 10, b = 22;
		int c = 0;
		double d = 0.0;

		c = a + b;
		System.out.println(c);

		c = a - b;
		System.out.println(c);

		c = a * b;
		System.out.println(c);

		c = b / a;
		System.out.println(c);

		d = (double) b / a; // double / int =>double(2.2) why? casting priority
		System.out.println(d);

		d = b / a; // int / int => int (2) -> double (2.0)
		System.out.println(d);

		c = b % a;
		System.out.println(c);
		// 나머지연산의 활용예시
		if (a % 2 == 0) {
			System.out.println("짝");
		} else {
			System.out.println("홀");
		}
		// 복합대입 연산자
		a += b; // a = a+b ==> 반복문에서 활용될 수 있음.
		System.out.println(a);

		int sum = 0;
		for (int i = 1; i <= 100; i++) {
			sum += i; // sum = sum+i;
		}
		System.out.println(sum);
		// 증감연산자 ++,-- :앞에 있을 때 와 뒤에 있을 때 차이가 있다.
		// 단독으로 쓰일때는 차이가 없지만,
		a = 10; // a를 10으로 초기화한다. (초기화 : 값을 설정)
		b = 10;
		a++;
		++b;
		System.out.println(a);
		System.out.println(b);
		// 연산때는 차이가 있다. (대입 후 증가 a++ , 증가 후 대입 ++a)
		a = 10;
		b = 10;
		c = a++ + ++b; // c = 10+ 11(a : 대입후 증가 , b: 증가 후 대입)
		System.out.println(c);
		// 비교연산자 : true / false 를 반환한다. => boolean

		// reference data type : '주소'비교
		a = 10;
		b = 20;
		boolean isSuccess = a > b;
		System.out.println(isSuccess);
		// 비교연산자는 제어문 과 함께 많이 사용된다.
		if (isSuccess) {
			System.out.println("a가 b보다 큽니다.");
		} else {
			System.out.println("a가 b보다 작습니다.");
		}
		d = 10.0;
		// '=='연산자 : primitive data type : '값'비교, 자료형은 고려하지 않음 Ex) 10 ==10.0 : true
		isSuccess = a == b;
		if (isSuccess) {
			System.out.println("a 와 d는 같습니다.");
		} else {
			System.out.println("a 와 d는 다릅니다.");
		}
		// 비트 연산자 :...웹 개발에는 고려할 필요가 없다... & | ^ 연산
		// 논리 연산자 : && || ! =>true/ false 를 반환한다.
		// && : 두 개 모두 true 여야 true , ||: 두 개 모두 false 여야 false, !: true->false,
		// false->true
		// short circuit 발생 => A && B 에서 A가 false이면, B의 연산은 하지도 않고 넘어간다.
		// A || B 에서 A가 true이면, B의 연산은 하지도 않고 넘어간다.
		// B가 바뀌지 않았기 때문에 문제가 발생할 수 있다. (중요)
		a = 10;
		b = 20;
		isSuccess = a == b && ++a == b++; // short circuit 발생 -> B는 계산 X
		System.out.println(isSuccess);
		System.out.println(a);
		System.out.println(b);
		// 연산자 우선순위 중 && 가 ||보다 앞선다. (실수 방지) ex) A || B && C
		// 우선순위모르겠으면 무조건 ( ) 치자.

	}
}
