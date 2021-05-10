package java_20210510;

public class Member {
	private String name;
	private String email;
	private String zipcode;
	private String addr1;
	private String addr2;
	private int age;

	// setter,getter 자동완성 (이클립스에서 제공 )
	// Alt + Shift +S -> generate setter and getter(r) -> select All(tab-enter)
	// ->generate(tab4-enter)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getAddr1() {
		return addr1;
	}

	public void setAddr1(String addr1) {
		this.addr1 = addr1;
	}

	public String getAddr2() {
		return addr2;
	}

	public void setAddr2(String addr2) {
		this.addr2 = addr2;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void print() {
		System.out.println(this.getName());
		System.out.println(this.getAge());
		System.out.println(this.getAddr1());
		System.out.println(this.getAddr2());
		System.out.println(this.getEmail());
		System.out.println(this.getZipcode());
	}
}
