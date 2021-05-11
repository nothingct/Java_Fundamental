package java_20210511.step3;

public class StopNanoWatch {
	long startTime; 
	long endTime;
	public double getElapsedTime() {
		return (double)(endTime- startTime)/1000000000;
	}
	public void start() {
		startTime=System.nanoTime();
	}
	public void stop() {
		endTime=System.nanoTime();
	}
	public void print() {
		System.out.printf("경과시간 :%,.9f%n",getElapsedTime());
	}
	public void run() {
		start();
		for(long i=0; i<3_000_000_000l; i++) {
			
		}
		stop();
		print();
	}
}
