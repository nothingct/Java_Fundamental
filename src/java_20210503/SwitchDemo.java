package java_20210503;
import java.util.*;
//OCJP 시험문제로는 switch case 단골로 무조건 나옵니다.
public class SwitchDemo {
	public static void main(String[] args) {
		// IfDemo 를 Switch-Case문으로 바꿔보자
		Scanner sc = new Scanner(System.in);
		int month = sc.nextInt();
		String season = "없는 계절";
		switch (month) {
		case 12, 1, 2:
			season = "겨울";
			break;
		case 3, 4, 5:
			season = "봄";
			break;
		case 6, 7, 8:
			season = "여름";
			break;
		case 9, 10, 11:
			season = "가을";
			break;
		default:
			System.out.println("올바른 월 을 입력해주세요");
		}
		System.out.printf("%d월(은)는 %s입니다. \n", month, season);
		
	}
}
