package java_20210504;

public class PrimitiveReferenceDiff {
	public static void main(String[] args) {
		// primitive 변수를 할당하면 값이 할당됨.
		int a = 10;
		int b = a;
		b = 30;
		System.out.println(a);
		System.out.println(b);
		// reference 변수를 할당하면 같은 객체를 참조함.
		int[] test = { 10, 20, 30, 40 };
		int[] test2 = { 10, 20, 30, 40 };
		int[] temp = test;

		System.out.printf("test[0] :%d, temp[0] : %d%n", test[0], temp[0]);
		System.out.printf("test[1] :%d, temp[1] : %d%n", test[1], temp[1]);
		System.out.printf("test[2] :%d, temp[2] : %d%n", test[2], temp[2]);
		System.out.printf("test[3] :%d, temp[3] : %d%n", test[3], temp[3]);
		System.out.println();
		temp[2] = 3000;
		System.out.printf("test[0] :%d, temp[0] : %d%n", test[0], temp[0]);
		System.out.printf("test[1] :%d, temp[1] : %d%n", test[1], temp[1]);
		System.out.printf("test[2] :%d, temp[2] : %d%n", test[2], temp[2]);
		System.out.printf("test[3] :%d, temp[3] : %d%n", test[3], temp[3]);

		System.out.println(test);
		System.out.println(test2); // 각 배열의 인덱스안에 있는 값이 같아도 test와는 다른 객체를 참조함.
		System.out.println(temp);  // test와 같은 객체를 참조함.
	}
}
