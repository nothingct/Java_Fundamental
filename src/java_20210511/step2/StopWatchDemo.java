package java_20210511.step2;

public class StopWatchDemo {
	public static void main(String[] args) {
		StopWatch s = new StopWatch();
		s.start();
		for(long i =0; i<3_000_000_000l; i++) {
			
		}
		s.stop();
		s.print();
		
		s.startNano();
		for(long i =0; i<3_000_000_000l; i++) {
			
		}
		s.stopNano();
		s.printNano();
	}
}
