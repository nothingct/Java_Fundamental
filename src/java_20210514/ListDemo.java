package java_20210514;

import java.util.ArrayList;
import java.util.Iterator;


public class ListDemo {
	//이런 코딩의 형태는 너무나 많이 써요. 자주 활용할 수 있도록. main에서는 호출만 해야 되요.
	//앞으로는 객체를 반환하는 함수를 많이 쓸건데 
	//하나의 객체(사용자 정의 객체)==> 사용자 정의 객체
	public static Product selectByNumber() {
		//Product prod =new Product(1,"신발",100000);
		return new Product(1,"신발",100000);
	}
	//여러 객체를 담아야 할경우 => ArrayList(이 안에 사용자정의 객체들이 들어있음)
	public static ArrayList select() {
		ArrayList list = new ArrayList();
		list.add(new Product(2,"라면",1000));
		list.add(new Product(3,"계란",5000));
		list.add(new Product(4,"우유",6000));
		list.add(new Product(5,"요플레",1500));
		
		return list;
	}
	public static void main(String[] args) {
		//노란 줄이 나오는 이유 -> 제너릭선언을 안해서
		//ArrayList : 순서가 있고, 객체의 중복을 허용한다. 
		//가장 일반적인 활용 흐름 은 아래와 같다. 
		//리스트를 왜 많이 쓰는가? 웹 개발에서 多 사용+ Python에 또 사용. notepad 2021/05/14
		//실제 업무에서 list에 문자열은담지않아.
		//List 에 담는 것은 주로 사용자 정의 클래스 를 담아서 관리하는 용도로 쓰인다.
		//또한 객체(사용자정의 클래스)를 메인에서 담는것도 원래는 말이 안된다. 
		Product pro = selectByNumber();

		ArrayList list = select();
		list.add(pro);
		//Collection 에 한해서 이런 짧은 표현도 가능하다.
		for (Object p : list) {
			System.out.println(p);
		}
		System.out.println();
		
		//함수에서 list를 받아와서 그 list를 또 다른 list에 추가하기 
		ArrayList list2 = select();
		for (Object p : list2) {
			list.add(p);
		}
		for (Object p : list) {
			System.out.println(p);
		}
	}
}
