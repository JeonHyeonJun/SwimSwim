
public class Circle {
	private int radius;
	private Point center;
	
	public Circle(){
		radius = 0;
		center = new Point();
	}
	public Circle(int radius, Point center){
		this.radius = radius;
		this.center = new Point(center.getX(),center.getY());		//Circle c1 = new Circle(5,p);  c1�� center�� �������� PointŬ������ ��������.PointŬ������ ���� p�� x,y���� �޾ƿ�
	//	this.center = center;										//��������
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
		this.center.setX( center.getX() );    	//this.center.setX( p.getX() );  center�� x���� ��������.x���� p�� x������ �޾ƿ�.
		this.center.setY( center.getY() );		//��������	
//		this.center = center;					//��������
	}
		
	public String toString(){
		return "Circle [radius=" +radius+ ", center=" +center+ "]";
	}
}
