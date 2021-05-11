package java_20210511.parentAndChild;

public class Child extends Parent {
	String phone;
	double weight;
	double height;
	public Child(String name, String address, int age, String phone, double weight, double height) {
		//부모 멤버변수 초기화는 부모 생성자를 통해서.
		super(name, address, age);
		this.phone = phone;
		this.weight = weight;
		this.height = height;
	}
	public Child(String phone, double weight, double height) {
		//부모 멤버변수 초기화는 부모 생성자를 통해서.
		//super();
		this.phone = phone;
		this.weight = weight;
		this.height = height;
	}
	public Child() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
