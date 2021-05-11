package java_20210511.parentAndChild;

public class ChldDemo {
	public static void main(String[] args) {
		Child child = new Child("010-9000-8765",50.3,155.2); // 이름 , 주소, 나이 => NULL,NULL,0 가 나옴.
		System.out.println(child.name);
		System.out.println(child.address);
		System.out.println(child.age);
		System.out.println(child.phone);
		System.out.println(child.weight);
		System.out.println(child.height);
		System.out.println();
		
		Child child2 = new Child("성영한","서울",30,"010-9000-8765",50.3,155.2);//이름,주소,나이=>Parent생성자로
		System.out.println(child2.name);
		System.out.println(child2.address);
		System.out.println(child2.age);
		System.out.println(child2.phone);
		System.out.println(child2.weight);
		System.out.println(child2.height);
	}
}
