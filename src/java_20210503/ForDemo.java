package java_20210503;

public class ForDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		for (int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.printf("1부터 10까지의 합은 %d입니다 %n", sum);

		int evenSum = 0;
		for (int i = 2; i <= 10; i += 2) {
			evenSum += i;
		}
		System.out.printf("1부터 10까지의 짝수 합은 %d입니다 %n", evenSum);

		// 이중 for문 => 구구단 만들기
		for (int first = 2; first <= 9; first++) {
			System.out.printf("%d단입니다.%n", first);
			for (int second = 1; second <= 9; second++) {
				System.out.printf("%d x %d = %d %n", first, second, first * second);
			}
		}
		System.out.println();
		// 과제 : 1~100까지의 소수 개수 / 소수들의 합 구하기
		int numOfPrime = 0;
		int sumOfPrime = 0;
		int cnt = 0;
		int oneLinePerFiveNum=0;
		System.out.println("1~100까지의 소수 구하는 프로그램");
		for (int num = 2; num < 101; num++) {
			boolean isDivided = false;
			for (int i = 2; i * i <= num; i++) {
				cnt++;
				if (num % i == 0) {
					isDivided = true;
					break;
				}
			}
			if (!isDivided) {
				System.out.printf("%d \t", num);
				numOfPrime++;
				sumOfPrime += num;
				oneLinePerFiveNum++;
				if(oneLinePerFiveNum==5) {
					System.out.println();
					oneLinePerFiveNum=0;
				}
			}
		}
		System.out.println();
		System.out.printf("1~100까지의 소수 개수 :\t %d  %n", numOfPrime);
		System.out.printf("1~100까지의 소수 합 :\t %d %n", sumOfPrime);
		System.out.printf("실행횟수 : \t %d %n",cnt);
		
		//기초 별찍기 
//		*
//		* *
//		* * * 
//		* * * * 
		for(int i=1; i<=4; i++) {
			for(int j=1; j<=i; j++) {
				System.out.printf("* ");
			}
			System.out.println();
		}
		System.out.println();
		//기초 별찍기 2
//		* * * *
//		* * *
//		* *
//		*
		for (int i = 0; i < 4; i++) {
			for(int j=3-i; j>=0; j--) {
				System.out.printf("* ");
			}
			System.out.println();
		}
		// 기초 별찍기 3
//		       *
//		     * *
//		   * * *
//		 * * * *
		for (int i = 1; i <= 4; i++) {
			for (int j = 4-i; j >0; j--) {
				System.out.printf("  ");
			}
			for (int j = 1; j <=i; j++) {
				System.out.printf(" *");
			}
			System.out.println();
		}
	}
}
