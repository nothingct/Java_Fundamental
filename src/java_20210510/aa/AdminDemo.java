package java_20210510.aa;
//import도 에러 가 나옴 why? : 클래스 접근한정자 (default) 라서 
import java_20210510.Admin;

public class AdminDemo {
	public static void main(String[] args) {
		//클래스 접근한정자 : default | public => 만약 서로다른 패키지 일경우 클래스 때문에 에러발생할수 있다.
		Admin a = new Admin(); //패키지가 달라서 에러발생
		/*
		 * why private 생성자 ?? : 어차피 Math 클래스는 static method로만 이루어져있어서 
							  객체를 생성할 필요가 없어서 막아논 것.
		 */
		
	}

}
