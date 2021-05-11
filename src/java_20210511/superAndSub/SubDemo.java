package java_20210511.superAndSub;

public class SubDemo {
	public static void main(String[] args) {
		Sub sub = new Sub();
		System.out.println(sub.money);
		sub.makeMoney();
		System.out.println(sub.chicken);
		sub.gotoSchool();
		//overriding->super 의 play(~) 가 sub의 play(~)에 의해 가려짐.
		sub.play("starcraft");
		
		Super sup = new Super();
		System.out.println(sup.money);
		sup.makeMoney();
		sup.play("~~");
		System.out.println();
		//이게 제일 중요.
		Super sup1 = new Sub(); //주의 하위 클래스를 상위 클래스로 받는것 가능(Sub 객체 생성=> Object,Super,Sub로 참조 가능)
		//Sub객체를 Super 로 참조하였기 때문에, Sub의 멤버변수나 멤버함수는 접근 을 할 수 없는 것이 원칙=>chicken,gotoSchool X
		//Super로 참조하였기 때문에 money,makeMoney는 당연히 접근가능
		System.out.println(sup1.money);
		sup1.makeMoney();
		//근데 Super로 참조하였어도, Super의 함수가 Sub에서 오버라이딩 된 경우는.
		sup1.play("~~~"); //오버라이딩 된 함수가 하위클래스에 있는 경우, 자신의 함수가 아닌, 오버라이딩 된 하위의 함수가 호춛된다.
		
		
		//Sub a = new Super();// 이건 안되. 
		//WHY? 참조는 생성된 객체+상위클래스 만 되지, 하위로는 X(Super 객체 생성 =>Object, Super참조 가능, Sub 불가능)
		//Super+Object까지는 메모리에 로딩이 되지만,Sub는 메모리에 올라온 적도 없기 때문.
		System.out.println(sub);//객체를 출력 하면 자동으로 toString()을 호출함
		System.out.println(sub.toString()); //toString() : Object 객체에서 정의된 메소드 
											//이 toString() 을 Sub 객체에서(또는 Super에서) 오버라이딩 한다면, 원하는 결과 출력가능.
		
		Object obj = new Sub();
		System.out.println(obj);
	}
}
