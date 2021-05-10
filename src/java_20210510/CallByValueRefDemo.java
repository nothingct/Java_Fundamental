package java_20210510;

public class CallByValueRefDemo {
	public static void ascending(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr.length-(i+1); j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j]=arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	public static void change(int i , int[] j) {
		i=20;
		j[3]=400;
	}
	public static void main(String[] args) {
		int i=10;
		int[]j = {1,2,3,4};
		System.out.println(i+","+j[3]);
		change(i,j);
		System.out.println(i+","+j[3]);
		
		int []lotto = {3,5,12,45,23,1};
		for(int value : lotto) {
			System.out.printf("%d ", value);
		}
		System.out.println();
		ascending(lotto);
		for(int value : lotto) {
			System.out.printf("%d ", value);
		}
		System.out.println();
		//call by reference 를 제대로 이해함으로써 참조변수의 개수를 줄이자==> Garbage Collection 이 빠르게 회수할 수 있도록
		//GC : RC(Reference Counter ) 가 0일 때 회수한다. 
		//CLASS 는 여기까지가 끝.
	}
}
