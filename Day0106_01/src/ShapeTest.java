//
class Shape{
	protected int x,y;
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void draw(){
		System.out.println("Shape Draw");
	}
	
	public String toString(){
		return "(" +x+ "," +y+ ")";
	}
};

//
class Rectangle extends Shape {
	public int width;
	private int height;

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}
	
	public void draw(){
		System.out.println("Rectangle Draw");
	}
	
	public String toString(){
		return "width: " +width+ "height: " +height;
	}
};

//
class Triangle extends Shape{
	private int base, height;
	
	
	
	public int getBase() {
		return base;
	}

	public void setBase(int base) {
		this.base = base;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void draw(){
		System.out.println("Triangle Draw");
	}
	
	public String toString(){
		return "base: " +base+ "height: " +height;
	}
};

//
class Circle extends Shape{
	private int radius;
	

	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}
	
	public void draw(){
		System.out.println("Circle Draw");
	}
	
	public String toString(){
		return "radius: " +radius;
	}
};

class Cyilnder extends Shape{
	public void draw(){
		System.out.println("Cyiilnder의 Draw");
	}
}


//
public class ShapeTest {
	private static Shape arrayOfShapes[];
	
	public static void main(String[] args) {
		init();
		drawAll();
		calArea(arrayOfShapes[1]);
	}
	
	public static void init(){
		arrayOfShapes = new Shape[4];
		arrayOfShapes[0] = new Rectangle();
		arrayOfShapes[1] = new Triangle();
		arrayOfShapes[2] = new Circle();
		arrayOfShapes[3] = new Cyilnder();
	}
	
	public static void drawAll(){
		for(int i=0; i<arrayOfShapes.length; i++)
			arrayOfShapes[i].draw();
	}
	public static void calArea(Shape s){
		if(s instanceof Rectangle)		//instanceof -> 왼쪽 참조변수가 참고하고있는 객체가 오른쪽 클래스를 통해 만들어진 객체인지 검사
		((Rectangle)s).width = 10;
	}
}
