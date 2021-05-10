package java_20210503;

public class WhileDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		int i = 0;// 초기값
		while (i < 11) {// 조건
			sum += i;
			i++;// 증감
		}
		// 초기값 , 조건, 증감 모두 있는 경우 for문 을 쓰는게 정상.
		System.out.printf("1~10까지의 합 : %d %n", sum);
		// 구구단을 while문 2번을 돌려서 짜봅시다.
		int first = 2;
		while (first < 10) {
			System.out.printf("%d단을 시작합니다.\n", first);
			int second = 1;
			while (second < 10) {
				System.out.printf("%d x %d = %d\n", first, second, first * second);
				second++;
			}
			first++;
			System.out.println();
		}
	}
}
