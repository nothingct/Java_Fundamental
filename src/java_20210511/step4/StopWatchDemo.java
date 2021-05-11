package java_20210511.step4;
/*
 * nano와 milli 를 합치고 싶어 
 * ==>manager 와 abstact 클래스를 이용해서 구조화 해야한다.+ 확장가능
 * 그 구조화를 할 수 있는 이유는 : 구조가 맞기 때문에 구조화가 가능한거야.
 */
public class StopWatchDemo {
	public static void main(String[] args) {
		StopNanoWatch s = new StopNanoWatch();
		s.run();
	}
}
