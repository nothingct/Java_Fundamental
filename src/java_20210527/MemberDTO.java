package java_20210527;
//1. member 테이블을 객체화
//용도 : 1. 매개변수를 줄일 목적 
//    : 2. 테이블의 한개의 ROW 정보를 객체화 하기 위한 목적.
public class MemberDTO {
	//member 테이블의 컬럼을 멤버변수로 설정한다
	private int num;
	private String name;
	private String addr;
	//alt shift s=>
	//디폴트 생성자, 모든 인수 생성자, setter&getter 모두 자동완성
	public MemberDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberDTO(int num, String name, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	
}

