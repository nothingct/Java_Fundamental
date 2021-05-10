package java_20210504;

public class TwoArrayDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 2차원 배열의 선언과 생성
		int[][] a = new int[3][2];

		// 2차원 배열의 할당 : 값이 확정되어있을 때 
		a[0][0] = 10;
		a[0][1] = 20;
		a[1][0] = 30;
		a[1][1] = 40;
		a[2][0] = 50;
		a[2][1] = 60;
		//값이 확정된 경우
		int[][] b = {{10,20},{30,40},{50,60}};
		
		//2차원 배열의 출력
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				System.out.println(a[i][j]);
			}
		}
		
		//Enhanced For loop
		int[] temp = {10,20,30,40,50};
		for(int value : temp ) {
			System.out.println(value);
		}
		String[] fruits = {"banana","melon","strawberry"};
		for(String fruit:fruits) {
			System.out.println(fruit);
		}
		//System.arraycopy
		
	}	

}
