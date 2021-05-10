package java_20210504;

public class ArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//방법 1 : 배열을 선언,생성 후 할당->출력
		//배열 선언, 생성 
		int []a = new int[4]; // 맨 처음 생성시 초기화 디폴트 값으로 각 값은 0이 들어가있다.(모든 수)
							  // boolean의 경우 초기값은 false.
		
		//배열 할당
//		a[0]=100;
//		a[1]=200;
//		a[2]=300;
//		a[3]=400;
		//배열 ~ 반복문과 함께[할당하는 값도 규칙성이 있을 경우에,아니라면 직접 할당
		for (int i = 0; i < a.length; i++) {
			a[i]=(i+1)*100;
		}
		//배열의 출력
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
		
		//방법2 : 배열의 선언,생성, 할당을 동시에 -> 출력
		//선언,생성,할당
		int [] b = {100,200,300,400};
		//출력
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
		
		
		System.out.println();
		
		//Quiz) 9월 15일 까지 의 일수를 구하세요
		int totalSumOfDay =0;
		int[] monthArray = {31,28,31,30,31,30,31,31,30,31,30,31};
		//1월~8월까지의 총 일수를 구한다.
		for (int i = 0; i < 8; i++) {
			totalSumOfDay+= monthArray[i];
		}
		//9월 1일~15일까지의 일수를 더해준다.
		totalSumOfDay+= 15;
		//9월 15일까지의 일수 출력
		System.out.println("9월 15일까지의 총 일수 : "+totalSumOfDay);
		
	}
}
