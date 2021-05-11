package java_20210511.step5;

public class StopNanoWatch extends StopWatch{
	private double getElapsedTime() {
		return (double)(endTime- startTime)/1000000000;
	}
	private void start() {
		startTime=System.nanoTime();
	}
	private void stop() {
		endTime=System.nanoTime();
	}
	private void print() {
		System.out.printf("경과시간 :%,.9f%n",getElapsedTime());
	}
	public void execute() {
		start();
		for(long i=0; i<3_000_000_000l; i++) {
			
		}
		stop();
		print();
	}
}
