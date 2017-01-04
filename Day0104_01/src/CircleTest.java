
public class CircleTest {
	public static void main(String[] args) {
		Point p = new Point(2,3);
		Circle c1 = new Circle(5,p);
		Circle c2 = new Circle();
		
		p.setX(4);
		p.setY(5);
		System.out.println(p);

		c2.setCenter(p);
	
		System.out.println(c1);		
		System.out.println(c2);
		
		//swallow copy deep copy problem 얕은복사와 깊은복사 문제
		//얕은복사 : 주어진 객체의 참조값을 복사
		//깊은복사 : 주어진 객체의 내부 상태값을 복사
	}
}
