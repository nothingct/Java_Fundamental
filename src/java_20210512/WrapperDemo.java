package java_20210512;

import java.util.ArrayList;

public class WrapperDemo {
	public static void main(String[] args) {
		//Ctrl Shift O : 자동으로 import 해준다.
		
		//자바 1.4 이전 버전에서는 primitive data type 를 Collection에 
		//저장할 수 없었기 대문에 primitive data type을 객체화할 수 있는 
		//Wrapper Class 으로 변환하여 저장해야 했다.
		//아래와 같이 1를 저장할 수 없음.
		ArrayList list = new ArrayList();
		list.add(1);
		list.add(Integer.valueOf(30));
		//1.2. 현재는 자동으로 되서 안외워도 됨
		//1.primitive data type => Wrapper class (Wrapper.valueOf() 이용) 
		Integer i1 = Integer.valueOf(10);
		Integer i2 = Integer.valueOf("20");
		
		//2.Wrapper class => primitive data type(intValue() )
		int i3 = i1.intValue()+i2.intValue();
		//3 이걸 제일 많이 사용함으로 익혀둘 것.
		//3. 숫자로 구성된 String => primitive data type 으로 (Integer.parseInt("10");)
		String s1= "12345";
		int i4 = Integer.parseInt(s1);
		
		//4. auto-boxing : primitive data type -> wrapper class
		Integer i5 = 10;
		Integer i6 = 20;
		//5. auto-unboxing : Wrapper class->primitive data type 
		int i7 = i5+i6;
	}
}
