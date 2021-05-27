package java_20210527;

public class DeptDTO {
	//DB는 칼럼명의 중복을 극도로 혐오함(조인 때문에 ) 그래서 같은 부서번호 라도 앞에 테이블이름 dep 라든지 d를 포함시킨다.
	//자바는 클래스명을 절대로 포함시키지 않아. 예를들어서 Department 클래스라면 변수를 deptno 이렇게 안짓는다고.
	//그러니 자바는 deptNo(X) no 이렇게 변수명을 만들자. 
	private int no; 
	private String name;
	private String loc;
	public DeptDTO(int no, String name, String loc) {
		super();
		this.no = no;
		this.name = name;
		this.loc = loc;
	}
	public DeptDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	
}
