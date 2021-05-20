package java_20210517;

import java.util.ArrayList;

public class ExceptionDemo {
	public static void main(String[] args) {
		//java.lang.NumberFormatException==>예외처리를 해야 함
		//aaaa1-> 예외처리를 해야 함. 
		//12.34 => 코드를 변경해야 함.
		int i = Integer.parseInt("aaaa1");
		System.out.println(i);       
		double d = Double.parseDouble("12.34");
		System.out.println(d);
		
		//jva.lang.arrayIndexOutOfBoundsException

		//배열의 범위를 벗어나면 발생하는 예외.
		int[] a= {1,2,3,4};
		System.out.println(a[4]);
		System.out.println(a[-1]);

		//java.lang.IndexOutOf
		//Collection 에서 범위를 벗어나면 발생하는 예외
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(123);//auto boxing
		System.out.println(list.get(1));
		//java.lang.NullPointerException
		//객체를 생성하지 않고 메소드를 사용하면 발생하는 에러[제일 많이 발생하는 에러 ]
		String str = null;
		System.out.println(str);                                                                                                                                                                                                                                                                                         
		
		//java.lang.ArithmetcExcdption 
		System.out.println(2/0);
	}
}
