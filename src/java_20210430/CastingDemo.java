package java_20210430;

public class CastingDemo {
	public static void main(String[] args) {
		// overflow 발생 하여 컴파일 에러
		// byte b1 = 120;

		// circuit 발생 (권장하지 않음 )
		byte b1 = (byte) (129);
		System.out.println(b1);

		// cut 발생 ( 유용하게 쓰일 때가 있음 )
		int i1 = (int) 129.25;
		System.out.println(i1);

		// auto-casting (자동 형변환 )
		double d1 = 124.5f;
		System.out.println(d1);

		byte b2 = 110;
		byte b3 = 20;

		// 산술 연산자 '+'의 반환값은 int
		// 결론 : 계산 때문에라도 왠만하면 정수로 변수를 만들 때는 int로 정의하도록 한다.
		int i2 = b2 + b3;
		byte b4 = (byte) (b2 + b3); // 권장하진 않음

		System.out.println(i2);
		System.out.println(b4);

		// 연결 연산자
		// 1.문자열 + 문자열 => 문자열
		// 2.문자열 + 숫자 => 문자열
		// 3.숫자 + 문자열 => 문자열
		String str1 = "abc" + 1 + 2;// 연결연산자 + 연결연산자 ( abc12)
		String str2 = 1 + 2 + "abc"; // 산술연산자 + 연결연산자( 3abc)
		String str3 = "abc" + (1 + 2); // 연셜연산자 + 산술연산자 -> 연결연산자 ( abc3)

		System.out.println(str1);
		System.out.println(str2);
		System.out.println(str3);

		// 비트 연산은 웹개발에는 별로의미가 없다.
		// 비트연산은 그렇지만 게임개발에는 필요하다.(코테에도 나오긴하는데 )

	}
}
