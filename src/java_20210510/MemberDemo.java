package java_20210510;

public class MemberDemo {
	public static void print(Member m) {
		System.out.println(m.getName());
		System.out.println(m.getAge());
		System.out.println(m.getAddr1());
		System.out.println(m.getAddr2());
		System.out.println(m.getEmail());
		System.out.println(m.getZipcode());

	}
	public static void main(String[] args) {
		Member m = new Member();
		//m.name="오한승";(안되요)
		m.setName("오한승");
		m.setAge(13);
		m.setAddr1("XXX시");
		m.setAddr2("abc동d호");
		m.setEmail("asdf@gdf.com");
		m.setZipcode("8975456");
		print(m);
		//m.print();
	}
}
