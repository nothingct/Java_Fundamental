package java_20210517;

public class TryCatchDemo {
	public static double getAvgs(int k, int e) {
		return (k+e)/2.0;
	}
	public static void main(String[] args) {
		//javac TryCatchDemo.java => compile
		//java TryCatchDemo 10 20 => args 에 10,20 이 배열로 옴.
		//1.예외 만들기 : a 20==>NumberFormatException 발생 ( 실행 결과로 알 수 있음. ) 
		//2.예외 만들기 : 10 ==>ArrayIndexOutOfBoundsException 발생
		//대략 이 2가지 경우가 발생할 거 같으니 이에 대한 예외처리를 해주어야 하지.
		try {
			int korean = Integer.parseInt(args[0]);
			int english = Integer.parseInt(args[1]);
			
			double average = getAvgs(korean,english);
			System.out.printf("국어와 영어의 평균점수는 %.1f입니다. %n", average);
		}catch(NumberFormatException e) {
			//catch 블럭의 수행문을 만들 때 2가지 형태로 코딩한다. 
			//1. 에러 메시지를 출력. ==>(개발자-개발단계에서) : e.printstackTrace(); e.getMessage();
			//2. 에러 메시지를 출력. ==> (사용자-서비스단계에서) : 사용법이 잘못 됐다고 알려줌.
			//e.printStackTrace(); // stack 모두 다 보고 싶은 경우
			System.err.println(e.getMessage()); //에러 메시지만 보고 싶은 경우.
			System.err.println("인자에 정수를 넣어야해!");
		}catch(ArrayIndexOutOfBoundsException e) {
			//e.printStackTrace();
			System.err.println(e.getMessage());
			System.err.println("인자를 2개가 필요해!");
			}finally {
			System.out.println("무조건 수행되는 블럭 - finally ");
		}
	}
}
