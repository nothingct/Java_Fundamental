// 패키지명도 식별자 에 포함 되기 때문에 식별자 규칙을 지켜야 한다.
package java_20210429;
// 클래스명도 식별자에 포함됨

// 클래스명의 첫 글자는 대문자로 , 두 단어가 합쳐진 경우에는 두번째 단어의 첫글자도 대문자.

public class IdentifierDemo {
	// 메서드명도 식별자에 포함됨.
	// 클래스명을 제외한 모든 이름은 소문자로 시작.
	public static void main(String[] args) {
		int age = 20;
		String name = "hello";
		// 첫 글자는 숫자를 사용할 수 없음.
		// String 1fatherName = "john";
		// 공백을 사용할 수 없음
		// String mother Name = "Michell";
		// 예약어를 사용할 수 없음
		// String void = "empty";
		// 자바는 유니코드를 지원하기 때문에, 한글도 식별자로 사용가능. BUT 쓰지 않는 걸 권고(영어 추천)
		String 이름 = "오한승";
		System.out.println(age);
		System.out.println(name);
		System.out.println(이름);
		// 수업은 5시까지 , 남은 1시간은 정리할 시간 : 리뷰하고 도중 코딩에러 나면 질문하는 시간
		// 자바를 공부한 분 -> 정리하고 빅데이터를 공부하시고,
		// 정리하는 시간을 잘 활용하세요.
	}
}