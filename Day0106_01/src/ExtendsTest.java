
//���� Ű����� �پ��� ��Ȳ������ overriding�� ���캾�ô�.
class ParentClass {
	protected int data = 100; // protected�� �ܺο��� ���ٺҰ�. �ڽĵ��� ���ٰ���.

	public void print() {
		System.out.println("�θ��� print()");
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
		System.out.println("�ڽ��� print()");
		System.out.println(data);
		System.out.println(this.data);
		System.out.println(super.data); // super�� �θ�Ŭ������ �ִ°� �ǹ��Ѵ�. �׷��Ƿ� data =
										// 100�� �ȴ�. ������ ������ private�� ���ٺҰ��� ������
		super.print();
	}
	
	public void hello(){
		System.out.println("Hello World");
	}
}

public class ExtendsTest {
	public static void main(String[] args) {
		ParentClass p = new ChildClass();		//�θ�Ŭ����Ÿ������ ���� �ڽ�Ŭ���� ��������, 
												//������ Parent()�� �����°��̱� ������ data,print()�� ���������ϰ�, hello()�� ��������.
		p.print();		//ChildClass�� print()�� ����ȴ�.
		((ChildClass)p).hello();		//ParentClassŸ���̾��� p�� ChildClass Ÿ������ �ٲپ��� ������ hello() ��������.
	}
}
