
//슈퍼 키워드와 다양한 상황에서의 overriding을 살펴봅시다.
class ParentClass {
	protected int data = 100; // protected는 외부에선 접근불가. 자식들은 접근가능.

	public void print() {
		System.out.println("부모의 print()");
	}
}

class ChildClass extends ParentClass {
	public int data = 200;

	public ChildClass() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void print() {
		int data = 300;
		System.out.println("자식의 print()");
		System.out.println(data);
		System.out.println(this.data);
		System.out.println(super.data); // super는 부모클래스에 있는걸 의미한다. 그러므로 data =
										// 100이 된다. 하지만 받을때 private면 접근불가라 오류남
		super.print();
	}
	
	public void hello(){
		System.out.println("Hello World");
	}
}

public class ExtendsTest {
	public static void main(String[] args) {
		ParentClass p = new ChildClass();		//부모클래스타입으로 만들어도 자식클래스 참조가능, 
												//하지만 Parent()를 가져온것이기 때문에 data,print()만 참조가능하고, hello()는 쓸수없다.
		p.print();		//ChildClass의 print()가 실행된다.
		((ChildClass)p).hello();		//ParentClass타입이었던 p를 ChildClass 타입으로 바꾸었기 때문에 hello() 참조가능.
	}
}
