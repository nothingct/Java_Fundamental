package java_20210517;

public class RunnableDemo implements Runnable{

	public void run() {
		for(int i=0; i<1000; i++) {
			String threadName=Thread.currentThread().getName();
			System.out.printf("%s : %d%n", threadName , i);
		}
	}
	public static void main(String[] args) {
		System.out.println("Start");
		
		RunnableDemo r1 =new RunnableDemo();
		Thread t1 = new Thread(r1,"첫번째 쓰레드");
		t1.start();
		
		RunnableDemo r2 =new RunnableDemo();		
		Thread t2 = new Thread(r2,"두번째 쓰레드");
		t2.start();
		
		System.out.println("End");
		
	}
}
