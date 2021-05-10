package java_20210504;
import java.util.*;
public class SsnDemo2 {
	public static void main(String[] args) {
		//배열 사용
		Scanner sc = new Scanner(System.in);
		String ssnInput = sc.nextLine(); //-를 포함한 주민등록번호를 입력받는다. Ex) 123456-1234567
		
		int ssn[] = new int[13];
		int cur =0;
		int strLen = ssnInput.length();
		//입력받은 문자열을 정수배열로 -를 제외한 숫자들만을 저장한다 Ex)1234561234567
		for (int i = 0; i < strLen; i++) {
			if(i==6)continue;
			ssn[cur++] = ssnInput.charAt(i)-'0';
		}
		// 1. 각 자리수를 2부터 9까지 곱하고 다시 2부터 5까지 곱한 수를 모두 더한다.
		int ans =0;
		for (int i = 0,j=2; i < ssn.length-1; i++,j++) {
			ans += (ssn[i]*j);
			if(j==9) j=1;
		}
		
		// 2. 그 수를 11로 나눈 나머지를 구한다.
		ans %= 11;
		// 3. 그 수를 11에서 뺀다.
		ans = 11 - ans;
		// 4. 그 수를 10으로 나눈 나머지를 구한다.
		ans %= 10;
		// 5. 4의 결과와 마지막 숫자(b7)가 같으면 정상적인 주민번호, 그렇지 않으면
		// 비정상적인 주민번호 메시지를 출력한다.
		String msg = "";
		msg = ssn[ssn.length-1] == ans ? "정상적인 주민번호입니다" : "비정상적인 주민번호입니다";
		System.out.println(msg);
	}
}
