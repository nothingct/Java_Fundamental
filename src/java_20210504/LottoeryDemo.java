package java_20210504;

public class LottoeryDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//System.out.println(random);
		int[] lotto = new int[6];
		boolean[] isPickedNum= new boolean[46]; //로또 만들기 1 : bucket활용
		for (int i = 0; i < lotto.length; i++) {
			//Math.random() => 0보다 크거나 같고 1보다 작은 임의 double 반환.
			int random = (int)(Math.random() *45)+1; //1<= <= 45 인 정수 반환
			while(isPickedNum[random]) { //중복이면
				random = (int)(Math.random() *45)+1; //1<= <= 45 인 정수 반환 
			}
			lotto[i] = random;
			isPickedNum[random]= true;
		}
		int cur=0;
		//정렬 1 : bucket을 활용.
		for (int i = 0; i < isPickedNum.length; i++) {
			if(isPickedNum[i]) lotto[cur++]=i;
		}
		//로또 만들기 2: 배열요소 순회
		lotto[0]= (int)(Math.random() *45)+1;
		for (int i = 1; i < lotto.length; i++) {
			lotto[i] = (int)(Math.random() *45)+1; //1<= <= 45 인 정수 반환
			for (int j = 0; j < i; j++) {
				if(lotto[j]==lotto[i]) {
					i--;
					break;
				}
			}
		}
		//정렬 2 : select sort
		
		for (int i = 0; i < lotto.length-1; i++) {
			for (int j = i+1; j < lotto.length; j++) {
				int temp;
				if(lotto[i] > lotto[j]) {
					temp=lotto[j];
					lotto[j]=lotto[i];
					lotto[i]=temp;
				}
			}
		}
		//정렬 3 : bubble 정렬 
		for (int i = 0; i < lotto.length; i++) {
			for (int j = 0; j < lotto.length-(i+1); j++) {
				if(lotto[j] > lotto[j+1]) {
					int temp = lotto[j];
					lotto[j]=lotto[j+1];
					lotto[j+1] = temp;
				}
			}
		}
		for (int i = 0; i < lotto.length; i++) {
			System.out.print(lotto[i]+"\t");
		}
	}
}
