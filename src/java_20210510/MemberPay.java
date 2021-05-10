package java_20210510;

public class MemberPay {
	// 정보은닉 : 멤버변수는 private 로, 접근은 메소드를 통해 이루어지도록.
	private int seq;
	private int group;
	private String name;
	private int price;
	private boolean valid;
	private String status;
	private String sdate;
	private String edate;
	private String regdate;

	// 접근을 위해 각각의 멤버변수 에 대한 setter,getter를 만들어줘야함
	// seq의 setter=> seq를 수정할 때 사용.
	public void setSeq(int seq) {
		// this를 사용한 이유는 로컬 변수와 멤버변수를 구분하기 위해서.
		this.seq = seq;// 왼쪽 : 멤버변수 || 오른쪽 : 로컬 변수
	}

	// seq 의 getter=>seq의 정보를 가져올 때 사용.
	public int getSeq() {
		return this.seq;
	}

	// group의 setter
	public void setGroup(int group) {
		this.group = group;
	}

	// group의 getter
	public int getGroup() {
		return this.group;
	}

	// name의 setter
	public void setName(String name) {
		this.name = name;
	}

	// name의 getter
	public String getName() {
		return this.name;
	}

	// price의 setter
	public void setPrice(int price) {
		this.price = price;
	}

	// price 의 getter
	public int getPrice() {
		return this.price;
	}

	// valid의 setter
	public void setValid(boolean valid) {
		this.valid = valid;
	}

	// valid의 getter 생성 =>valid 자료형이 boolean일 경우는 getXXX가
	// 아니라 isXXX로 생성한다.
	public boolean isValid() {
		return this.valid;
	}

	// status의 setter
	public void setStatus(String status) {
		this.status = status;
	}

	// status 의 getter
	public String getStatus() {
		return this.status;
	}

	// sdate의 setter
	public void setSdate(String sdate) {
		this.sdate = sdate;
	}

	// sdate 의 getter
	public String getSdate() {
		return this.sdate;
	}
	// edate의 setter
	public void setEdate(String edate) {
		this.edate = edate;
	}

	// edate 의 getter
	public String getEdate() {
		return this.edate;
	}
	// regdate의 setter
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}

	// regdate 의 getter
	public String getRegdate() {
		return this.regdate;
	}
}