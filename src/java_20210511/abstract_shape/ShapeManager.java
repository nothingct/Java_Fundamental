package java_20210511.abstract_shape;

public class ShapeManager {
	//template 만들기 Windows - preferences-templates 입력- java - new - 만들기 
	//Alt + W=>P =>tempates ...단축키
	//singleton 만들기 : private 생성자를 사용하는 이유
	private static ShapeManager single;

	private ShapeManager() {
	};

	public static ShapeManager getInstance() {
		if (single == null) {
			single = new ShapeManager();
		}
		return single;
	}
	/*이렇게 만들지 말고 하나로 만들라고.
	 * why? 확장 -> 5각형, 6각형 ... 계속 update 되도 구조는 그대로 유지해야 하기 때문에 
	 * ==> 추상 클래스 : 무엇을 만들던간에 공통된 추상클래스 로 draw를 하면되는것. 그리고 new는 ShapeDemo에서
	 * 구조적 통일성 + 경각심(WHY? overriding 반드시 자식클래스는 해야되서)
	public void run1() {
		Rectangle r = new Rectangle();
		r.draw();
	}
	public void run2() {
		Triangle t = new Triangle();
		t.draw();
	}	
	public void run3() {
		Circle c = new Circle();
		c.draw();*/
	public void run(Shape s) {
		s.draw();
	}
	
	
	
	
	
	
	
}     