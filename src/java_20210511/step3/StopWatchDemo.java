package java_20210511.step3;

import java_20210511.step3.StopNanoWatch;

/*
 * 여전히 문제점 : main에서는 기능이 있으면 안되요. 
 * 그냥 생성하고 실행하면 끝나야되요. main은 두 줄로 끝내야 한다.
 * 클래스는 잘 분리했는데..
 * 메소드로 빼던지,, 아니면 메니저를 만들어서 관리하든지.. 보통 이럴때는 메니저를 만듭니다. 
 * 그리고 메니저가 나오면 결국 또 추상 클래스가 나옵니다. 
 * 왜냐면 요구사항 변경이 된다 해도 논리는 그대로여야 하기 때문에.(구조)
 * 고객의 요구사항은 계~속 변해 .그때마다 update를 할순 없다는것.
 * 즉, 고객의 요구사항을 class화하면서 메니저 를 통해서 추상화 와 인터페이스가 나온다.==>코드의 가속성이 매우 빨라진다.
 * + 코드간의 결합도가 높아지는 것을 막는다. =>클래스가 하나 추가된다 하더라도 전체 시스템이 바뀌지 않는 구조를 만들어줘야 한다.
 */
public class StopWatchDemo {
	public static void main(String[] args) {
		StopNanoWatch s = new StopNanoWatch();
		s.start();
		for (long i = 0; i < 3_000_000_000l; i++) {

		}
		s.stop();
		s.print();
		
	}
}
