
public class Circle {
	private int radius;
	private Point center;
	
	public Circle(){
		radius = 0;
		center = new Point();
	}
	public Circle(int radius, Point center){
		this.radius = radius;
		this.center = new Point(center.getX(),center.getY());		//Circle c1 = new Circle(5,p);  c1의 center에 독립적인 Point클래스를 생성해줌.Point클래스의 값은 p의 x,y값을 받아옴
	//	this.center = center;										//얕은복사
	}
	public int getRadius() {
		return radius;
	}
	public void setRadius(int radius) {
		this.radius = radius;
	}
	public Point getCenter() {
		return center;
	}
	public void setCenter(Point center) {
		this.center.setX( center.getX() );    	//this.center.setX( p.getX() );  center의 x값을 설정해줌.x값은 p의 x값에서 받아옴.
		this.center.setY( center.getY() );		//깊은복사	
//		this.center = center;					//얕은복사
	}
		
	public String toString(){
		return "Circle [radius=" +radius+ ", center=" +center+ "]";
	}
}
