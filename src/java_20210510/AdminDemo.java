package java_20210510;

public class AdminDemo {
	public static void main(String[] args) {
		//클래스 접근한정자 : default | public => 만약 서로다른 패키지 일경우 클래스 때문에 에러발생할수 있다.
		//Admin a = new Admin();
		/*
		 * why private 생성자 ?? : 어차피 Math 클래스는 static method로만 이루어져있어서 
							  객체를 생성할 필요가 없어서 막아논 것.
		 */
		Admin a= new Admin("nothingct","gkstmd12","nothingct@naver.com",5);
		Admin a1= new Admin("nothingct","gkstmd12","nothingct@naver.com");
		System.out.println(a.getId());
		System.out.println(a.getPwd());
		System.out.println(a.getEmail());
		System.out.println(a.getLevel());
	}
}
