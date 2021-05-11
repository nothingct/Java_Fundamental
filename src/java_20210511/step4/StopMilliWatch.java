package java_20210511.step4;

public class StopMilliWatch {
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
	public void run() {
		start();
		for(long i=0; i<3_000_000_000l; i++) {
			
		}
		stop();
		print();
	}
}
