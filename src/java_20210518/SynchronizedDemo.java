package java_20210518;

public class SynchronizedDemo implements Runnable{
	int x; 
	int y;
	@Override
	//동기화 1 : 함수에 synchronized 하는 방법
//	public synchronized void run() {
	public void run() {
		// TODO Auto-generated method stub
		//동기화 방법2 : 블록에 synchronized synchronized(클래스명.class OR this)
		synchronized (this) {
			for(int i=0; i<1000; i++) {
				x++;
				y++;
				String threadName = Thread.currentThread().getName();
				System.out.printf("x : %d . y : %d - %s %n",x,y,threadName);
			}			
		}
	} 
	public static void main(String[] args) {
		SynchronizedDemo s1 = new SynchronizedDemo();
		SynchronizedDemo s2 = new SynchronizedDemo();
		//서로 다른 객체라서 x,y 가 각각 1000 이 나옴 synchronized 해도 의미 없음..
//		Thread t1 = new Thread(s1);
//		Thread t2 = new Thread(s2);
		//서로 같은 객체를 보게 한 다음에 synchronized 를 함수에 선언해놓음
		Thread t1 = new Thread(s2);
		Thread t2 = new Thread(s2);
		t1.start();
		t2.start();
		
	}
}
