package java_20210511.abstract_shape;

public class ShapeDemo {
	public static void main(String[] args) {
		//Shape s = new Shape(); //이건 안됨.추상클래스=>객체생성 X
//		Shape s = new Rectangle();
//		s.draw();
//		
//		s= new Triangle();
//		s.draw();
//		
//		s = new Circle();
//		s.draw();
		//ShapeManager를 이용하라고 해서 만듬 
		ShapeManager manager= ShapeManager.getInstance();
		manager.run(new Triangle());
		manager.run(new Circle());
		manager.run(new Rectangle());
	}
}
