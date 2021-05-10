package java_20210430;

// Ctrl +Shift + F: 코드를 정돈해준다.=> 코딩 후에 한번씩 눌러주자.
public class IfDemo {
	public static void main(String[] args) {
		// 매개변수를 넣어줘야한다.
		// Run-RunConfigurations-Arguments-program Arguments에서 매개변수 입력
		int month = Integer.parseInt(args[0]);
		String season = "";
		if (month == 12 || month == 1 || month == 2) {
			season = "겨울";
		} else if (month == 3 || month == 4 || month == 5) {
			season = "봄";
		} else if (month == 6 || month == 7 || month == 8) {
			season = "여름";
		} else if (month == 9 || month == 10 || month == 11) {
			season = "가을";
		} else {
			season = "없는 계절";
		}
		System.out.println(month + "월은 " + season + "입니다.");

		int a = 1259999;
		double d = 1232324.569058;
		String name = "오한승";
		// printf 사용해보기
		System.out.printf("a는 %,d입니다.\n", a); // 10자리 정수로 3자리마다 , 채운다.
		System.out.printf("a는 %010d입니다.\n", a); // 10자리 정수로 0을 채우고
		System.out.printf("d는 %,.2f입니다.\n", d); // 소숫점 이하 둘째자리까지 표현, 밑에는 반올림, 3자리마다 , 채운다.
		System.out.printf("저는 %s입니다.\n", name);

		// 삼항연산자 사용해보기
		int a1 = 100;
		// 조건식 ? 참일경우 실행 : 거짓일경우 실행
		String msg = a1 % 2 == 0 ? "짝수" : "홀수";
		System.out.println(msg);
		
	}
}
