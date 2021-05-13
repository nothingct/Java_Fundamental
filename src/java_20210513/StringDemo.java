package java_20210513;

import java.util.Iterator;

public class StringDemo {
	public static void main(String[] args) {
		char[] c = {'h','e','l','l','o'};
		String str = new String(c);
		System.out.println(str);
		//index번째 문자를 반환하는 함수.
		char c1 = str.charAt(1);
		//문자열 연결하는 메서드
		str = str.concat("123");
		System.out.println(str);
		//endsWitdh(String msg) =>msg 문자열로 끝나면treu /그렇지않으면 false
		str = new String("abc.zip");
		if(str.endsWith("zip")) {
			System.out.println("압축 파일입니다.");
		}else if(str.endsWith("doc")){
			System.out.println("워드 파일입니다.");
		}else {
			System.out.println("파일입니다.");
		}
		
		String url = new String("http://www.naver.com");
		String path = new String("/new/sboard/do?id=123&cat=1");
		//startssWitdh(String msg) =>msg 문자열로 시작하면treu /그렇지않으면 false
		if(path.startsWith("/news")) {
			System.out.println("뉴스 페이지입니다.");
		}else if(path.startsWith("/sport")){
			System.out.println("스포츠 페이지입니다.");
		}else {
			System.out.println("페이지가 존재하지 않습니다.");
		}
		
		//equals()=>문자열 비교,
		//equalsIgnoreCase() => 대소문자 구분하지 않고 비교 
		//trim() => 앞뒤 공백제거
		String m1 = new String("hello").trim();
		String m2 = new String("hello ");//공백을 포함하면 비교해도 같은 결과 X
		System.out.println(m1.length());
		System.out.println(m2.length());
		//  다른 곳에서 받아왔으면 ( 사용자가 X ) 무조건 trim 해야합니다. 그래야 이런 오류 줄임.
		if(m1.equalsIgnoreCase(m2)) {
			System.out.println("true");
		}else {
			System.out.println("false");
		}
		String m3 = new String("안녕하세요");
		//getBytes() => 문자열을 바이트 배열로 변환-> 네트워크 통신에 사용
		byte [] b = m3.getBytes();
		System.out.println(b.length);
		//indexOf(문자열,문자) ==> 문자열/ 문자의 index를 반환=> For 추출이 가능 substr 을 이용하여
		String m4 = new String("111111-1111118");
		int index = m4.indexOf("-");
		System.out.println(index);
		//lastIndexOf: 파일명과 확장자를 구분할 때 많이 사용한다.
		//Ex) 한글 이름일 때, 그리고 이름이 막 . 으로 되어있고 이럴때.. 
		//lastIndexOf 로 확장자 전까지 가 어차피 이름이니까 이 이름을 갱신하려고 할 때 사용.
		String m5 = new String("asdfkadfkadjs.kejrwjraw.sdfkdfsgs.zip");
		int lastIndexOf = m5.lastIndexOf(".");
		System.out.println(lastIndexOf);
		//앞뒤 뽑아내는 대표적인 코드 (암기 ) 
		System.out.println(m4.substring(0, m4.indexOf("-")));
		System.out.println(m4.substring(m4.indexOf("-")+1));
		
		//파일명과확장자 분리하기 
		System.out.println(m5.substring(0,m5.lastIndexOf(".")));
		System.out.println(m5.substring(m5.lastIndexOf(".")+1));
		//휴대폰 번호 3개를 쪼개야 할 때
		String m6 = new String("010-8306-0034");
		System.out.println(m6.substring(0,m6.indexOf('-')));
		System.out.println(m6.substring(m6.indexOf('-')+1, m6.lastIndexOf('-')));
		System.out.println(m6.substring(m6.lastIndexOf('-')+1));
		
		
		//문자열에서 한 문자씩 가져와서 (주민번호 경우) 다른 자료형으로 얻고 싶을 때 
		int a1= Integer.parseInt(m4.substring(0,1));
		//valueOf(primitive type ) : primitive type 을 String으로 바꿔준다.
		String m7= String.valueOf(true);
		System.out.println(m7);
		
		//replaceAll(a1,a2) :a1을 a2로 모두 바꾼다.==> HTML 에서 개행을 위해 데이터베이스 입력을 위해 등등 많이 활용된다.  
		//정규표현식과 함께 사용할 수 있다. 
		String m8= m6.replaceAll("-", "_");
		System.out.println(m8);
		//toLowerCase() toUppercase() : 거의 쓸일없긴함. 
		String m10= new String("hello");
		String m11= m10.toUpperCase();
		System.out.println(m11);
		String m12= m11.toLowerCase();
		System.out.println(m12);
		
		String m13=new String("쿠팡은 손실 규모와 상관없이 성장을 위한 공격적 투자에 속도를 낼 계획이다. e커머스 시장 점유율을 더 넓히기 위한 물류 인프라 조성뿐 아니라 고객 락인(Rock-in)을 위한 마케팅, 신규 서비스 강화에도 공을 들인다. 쿠팡은 상장 이후 물류센터 건립에만 8000억원 규모의 투자 계획을 발표하며 외형 성장 기대감을 높였다. 서울을 제외한 전국 7개 지역에 풀필먼트센터를 세워 현재 전국 70%인 로켓배송 지역을 100%로 확대한다는 목표다.");
		//split(구분자) 구분자가 뭐가 등장하는지가 확실하다면, split()을 활용하여 구분자로 구분된 문자열 배열을 반환해준다.
		String[] phoneNums =m6.split("-");
		for(String phoneNum: phoneNums) {
			System.out.println(phoneNum);
		}
		String[] coopangs = m13.split(" ");
		for(String coo:coopangs) {
			System.out.println(coo);
		}
		//format() 을 활용하는 시나리오. (3자리수마다 , 를 찍어야 하는 경우가 많다.)
		double d = 123456.345; //database에서 받아온 값 d
		String m14 = String.format("%,.2f", d);//이거를 웹에다가 출력하려고 그래,그럼 형식에 맞춰줘야지.
		System.out.println(m14);
		//이 과정을 한 번에 하면 이렇게 된다.(익숙해지길 권장)
		System.out.format("%s",String.format("%,.2f%n",123456.345));
	}
}
