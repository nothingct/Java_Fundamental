package java_20210512;
//Util 클래스 인 Math 클래스의 다양한 함수를 활용해보자.
public class MathDemo {
	public static void main(String[] args) {
		
		System.out.println(Math.ceil(4.2));
		System.out.println(Math.floor(4.9));
		long i = Math.round(4.2);//double 이 argument 면 long을 반환함.
		int j = Math.round(4.2f);//float 이 argument 면 int 을 반환함.
		System.out.println(Math.round(-123.4f));
		System.out.println(Math.round(1.234234));
		//값이 변질되서 망할 수 있는 경우(억지로 반환값 long인데 int로 형변환 한경우 ) 
		int k = (int)Math.round(2200000000.34);
		System.out.println(k);
		long kk = Math.round(2200000000.34);
		System.out.println(kk);
		System.out.println();
		double absD = Math.abs(-4.1);
		int absI = Math.abs(-5);
		float absF = Math.abs(-2.3f);
		long absL  = Math.abs(-22000000000l);
		//abs() : double float long int 로 오버로딩 되어있음..
		System.out.println(absD);
		System.out.println(absI);
		System.out.println(absF);
		System.out.println(absL);
		System.out.println();
		//max() min() 도 double, float, long , int 형 다 있어서 생략하겠습니다.
		System.out.println("4.2와 5.3중 큰 값: "+Math.max(4.2, 5.3));
		System.out.println("4.2와 5.3중 작은 값: "+Math.min(4.2, 5.3));
		System.out.println("14x3 과 8x7 중 큰 값: "+Math.max(14*3, 8*7));
		System.out.println("14x3 과 8x7 중 작은 값: "+Math.min(14*3, 8*7));
		System.out.println();
		//sqrt() : 제곱근 구하기 , 매개변수 double 밖에없음. 
		System.out.println("루트3 = "+Math.sqrt(3));
		long l =(long)Math.sqrt(4);
		System.out.println(l);
		//pow() : 승 수 구하기 : 매개변수 두개 와 반환형이 모두 double 값임.
		long l2 =(long)Math.pow(5, 20);
		System.out.println("5^20 = "+l2);
		//random() : 0~ 1 사이의 double 값 반환 
		System.out.println("0~1사이의 랜덤 실수 : "+ Math.random());
		double d3 = Math.random()*200-100;
		System.out.println("-100~100 사이의 랜덤 실수 : " + d3);
		long l3 = (long)( Math.random()*200000000)  -100000000;
		System.out.println("-100000000~100000000사이의 랜덤 정수 : " + l3);
		
	}
}
