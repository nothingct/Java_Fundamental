package java_20210512;
class Test{
	String name;
	Test(String name){
		this.name= name;
	}
	//모두 Alt Shift S 를 통해서 접근 가능. (함수 자동 생성 기능)
	public Test() {}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Test other = (Test) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	@Override
	//toString() 은 보통 디버깅 할 때 사용.
	public String toString() {
		return "Test [name=" + name + "]";
	}
	
}
class DoubleTest{
	String email;
	Test t;
	public DoubleTest(String email, Test t) {
		super();
		this.email = email;
		this.t = t;
	}
	public DoubleTest() {}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((t == null) ? 0 : t.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		DoubleTest other = (DoubleTest) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (t == null) {
			if (other.t != null)
				return false;
		} else if (!t.equals(other.t))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "DoubleTest [email=" + email + ", t=" + t + "]";
	}
	
}
public class ObjectDemo {
	public static void main(String[] args) {
		Test t1 = new Test("오한승");
		Test t2= new Test("오한승");
		Test t3 = t2;
		System.out.println(t1.hashCode());
		System.out.println(t2.hashCode());
		System.out.println(t3.hashCode());
		
		System.out.println(t1==t2);
		System.out.println(t1.equals(t2));
		
		System.out.println(t2==t3);
		System.out.println(t2.equals(t3));
		
		System.out.println(t1);
		System.out.println(t2);
		System.out.println(t3);
		
		
		System.out.println();
		DoubleTest dt1=new DoubleTest("nothing",t1);
		DoubleTest dt2=new DoubleTest("nothing",t2);
		System.out.println(dt1==dt2);
		System.out.println(dt1.equals(dt2));
		
		System.out.println(dt1);
		
	}
}
