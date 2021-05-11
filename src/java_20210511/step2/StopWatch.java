package java_20210511.step2;
/*
 * 가져갔더니 
 * 클래스는 하나의 기능만 가져야 한다고해서 
 * 다시 두개로 분리해오래..
 */
public class StopWatch {
	long startTime; 
	long endTime;
	public double getElapsedTime() {
		return (double)(endTime- startTime)/1000;
	}
	public void start() {
		startTime=System.currentTimeMillis();
	}
	public void stop() {
		endTime=System.currentTimeMillis();
	}
	public void print() {
		System.out.printf("경과시간 :%,.3f%n",getElapsedTime());
	}

	long startNanoTime; 
	long endNanoTime;
	public double getElapsedNanoTime() {
		return (double)(endNanoTime- startNanoTime)/1000000000;
	}
	public void startNano() {
		startNanoTime=System.nanoTime();
	}
	public void stopNano() {
		endNanoTime=System.nanoTime();
	}
	public void printNano() {
		System.out.printf("경과시간 :%,.9f%n",getElapsedNanoTime());
	}

}
