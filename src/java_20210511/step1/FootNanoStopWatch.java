package java_20210511.step1;
/*
 * 1번째 요구사항 : 밀리 세컨드로 경과 시간을 만들어주세요.
 * 2번째 요구사항 : 나노 세컨드로 경과 시간을 만들어주세요. + OOP 스럽게 만들어야..
 * ==> 그래서 스탑와치 클래스 2개를 만들어가면 ==> main은 별도로 하나의 클래스에만 있어야 한다..
 * ==>main은 별도로 하나에 놓고, 그리고 FootStopWatch 랑 FootNanoStopWatch는 합쳐도 되고,, 나눠도 되고,,
 */
public class FootNanoStopWatch {
	long startTime; 
	long endTime;
	public double getElapsedTime() {
		return (double)(endTime- startTime)/1000000000;
	}
	
	public static void main(String[] args) {
		FootNanoStopWatch f = new FootNanoStopWatch();
		f.startTime = System.nanoTime();
		for(long i =0; i<30_000_000_000l; i++) {
		
		}
		f.endTime = System.nanoTime();
		
		double elapsedTime = f.getElapsedTime();
		System.out.printf("경과시간 : %,.9f %n",elapsedTime);;
	}
}