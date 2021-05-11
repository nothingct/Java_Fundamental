package java_20210511.parentAndChild;
//클래스 만들 때, 디폴트 생성자는 그냥 무조건 만들고 시작.
public class Parent {
	String name;
	String address;
	int age;
	//생성자 생성 단축키 : Alt Shift S => o(매개변수 있는 생성자) || C(디폴트 생성자)
	public Parent(String name, String address, int age) {
		super();
		this.name = name;
		this.address = address;
		this.age = age;
	}
	public Parent() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
