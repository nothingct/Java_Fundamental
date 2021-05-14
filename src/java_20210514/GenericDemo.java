package java_20210514;

import java.util.ArrayList;

public class GenericDemo {
	public static void main(String[] args) {
		//데이터의 안전성이 떨어짐. String이 아닌 3이 매개변수가 Object라 들어갔는데 , 
		//이제 꺼내서 데이터를 처리할 때 String으로 처리할려고 했는데 들어가있는게 String이라는 확신이 없는 거지.
		//==>Generic을 활용해야 하는 이유.
		ArrayList<String> list = new ArrayList<String>();
		list.add("1");
		list.add("2");
		//오류발생 : String 타입이 아니라서 ==>객체의 안전성 향상. 
		//list.add(3);
		list.add("3");
		
		for (String s : list) {
			System.out.println(s);
		}
	}
}
