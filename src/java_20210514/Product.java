package java_20210514;

/*
 * 클래스 생성시 가장 기본 
 * 변수 만들자 말자
 * 디폴트 생성자, 매개변수 다 있는 생성자, setter , getter 
 * 다 자동생성 하고 alt shift s
 * 변수 private 로 감춰주는 것.
 */
public class Product{
	private int number;
	private String name; //상품 의 이름.
	private double price; //가격도 원래는 입고가격,출고가격 등 여러가지가 많아요.
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Product(int number, String name, double price) {
		super();
		this.number = number;
		this.name = name;
		this.price = price;
	}

	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return number + ", " + name + ", " + price;
	}
	
}
