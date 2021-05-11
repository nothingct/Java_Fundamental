package java_20210511.step6;

public class StopMilliWatch extends StopWatch{
	private double getElapsedTime() {
		return (double)(endTime- startTime)/1000;
	}
	private void start() {
		startTime=System.currentTimeMillis();
	}
	private void stop() {
		endTime=System.currentTimeMillis();
	}
	private void print() {
		System.out.printf("경과시간 :%,.3f%n",getElapsedTime());
	}
	public void execute() {
		start();
		for(long i=0; i<3_000_000_000l; i++) {
			
		}
		stop();
		print();
	}
}
