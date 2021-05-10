package java_20210430;

public class SsnDemo {
	public static void main(String[] args) {
		int a1 = 9;
		int a2 = 4;
		int a3 = 0;
		int a4 = 1;
		int a5 = 0;
		int a6 = 8;
		int b1 = 1;
		int b2 = 4;
		int b3 = 8;
		int b4 = 4;
		int b5 = 0;
		int b6 = 2;
		int b7 = 3;

		// 1. 각 자리수를 2부터 9까지 곱하고 다시 2부터 5까지 곱한 수를 모두 더한다.
		int ans = a1 * 2 + a2 * 3 + a3 * 4 + a4 * 5 + a5 * 6 + a6 * 7 +
				b1 * 8 + b2 * 9 + b3 * 2 + b4 * 3 + b5 * 4 + b6 * 5;
		// 2. 그 수를 11로 나눈 나머지를 구한다.
		ans %= 11;
		// 3. 그 수를 11에서 뺀다.
		ans = 11 - ans;
		// 4. 그 수를 10으로 나눈 나머지를 구한다.
		ans %= 10;
		// 5. 4의 결과와 마지막 숫자(b7)가 같으면 정상적인 주민번호, 그렇지 않으면
		// 비정상적인 주민번호 메시지를 출력한다.
		String msg = "";
		msg = b7 == ans ? "정상적인 주민번호입니다" : "비정상적인 주민번호입니다";
		System.out.println(msg);
	}
}
