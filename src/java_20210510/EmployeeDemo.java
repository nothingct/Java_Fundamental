package java_20210510;

public class EmployeeDemo {
	public static void main(String[] args) {
		Employee e = new Employee();
		e.name = "오한승";//Employee 부모 클래스인 Customer의 모든 멤버변수+멤버함수 사용가능.
						//name, phone1, phone2, phone3-->Customer 의 멤버변수.
		e.phone1="010";
		e.phone2="8306";
		e.phone3="0034";
		e.zipcode="1231231";
		e.addr1="서울";
		e.addr2="종로구";
		e.id="nothingct";
		e.pwd="1234";
	}
}
