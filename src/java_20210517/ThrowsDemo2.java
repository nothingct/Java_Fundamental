package java_20210517;
//에러가 발생하지는 않지만 예외처리를 해야 하는 경우. 
public class ThrowsDemo2 {
	public static double getAverage(int[] exam) throws ArrayIndexOutOfBoundsException {
		int korean = exam[0];
		int math = exam[1];
		int english = exam[2];
		int history = exam[3];
		int sum = korean+math+english+history;
		return sum/4.0;
	}
	public static void main(String[] args) {
		int[] exam = {10,20,30};
		try {
		double avg= getAverage(exam);
		}catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("4개의 배열을 입력해야 합니다. ");
		}
	}
}
