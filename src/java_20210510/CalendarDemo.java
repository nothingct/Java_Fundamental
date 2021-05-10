package java_20210510;

public class CalendarDemo {
	public static void main(String[] args) {
		Calendar c1 = new Calendar(2021,5,10);
		Calendar c2= new Calendar(2021,5);
		Calendar c3 = new Calendar(2021);
		
		c1.print();
		System.out.println();
		c2.print();
		System.out.println();
		c3.print();
	}
}
