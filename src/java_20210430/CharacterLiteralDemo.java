package java_20210430;

public class CharacterLiteralDemo {
	public static void main(String[] args) {
		// char 리터럴 => 문자 표현법
		char ch1 = '오';
		char ch2 = '한';
		char ch3 = '승';

		System.out.print(ch1);
		System.out.print(ch2);
		System.out.println(ch3);
		// char 리터럴 => 유니코드 표현법
		char c4 = '\uc624';
		char c5 = '\ud55c';
		char c6 = '\uc2b9';

		System.out.print(c4);
		System.out.print(c5);
		System.out.println(c6);

//		char a='\uace0';
//		char b='\uc591';
//		char c='\uc774';
//		System.out.print(a);
//		System.out.print(b);
//		System.out.println(c);

		// char 리터럴 => 아스키코드 표현법
		char c7 = 48; // 0
		char c8 = 65; // A
		char c9 = 97; // a -A와 32 차이

		System.out.println(c7);
		System.out.println(c8);
		System.out.println(c9);

		// 문자에서 못 쓰는 것 2개 : ' \
		// 문자열에서 못 쓰는 것 2개 : " \
		// 사용하기 위해서는 \를 앞에 붙인다.

		char c10 = '\'';
		char c11 = '\\';
		char c12 = '"';

		System.out.println(c10);
		System.out.println(c11);

//		//경로 에 도 \를 하나 더 써줘야 한다.
//		String path ="C:\\Users\\user\\eclipse-workspace\\Java_Fundamental";

		// 특수 문자 : 실질적으로 쓰이는 것 은 \t 나 \n 이며 문자열에 주로 쓰인다.
		// 특수문자 \t \n
		System.out.println("안녕하세요.\n저는 오한승입니다.\n잘 부탁드립니다.");
		System.out.println("아이디\t\t이름\t지역");
		System.out.println("nothingct\t오한승\t서울");

	}
}
