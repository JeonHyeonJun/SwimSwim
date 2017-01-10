package v2;	//중복된 기능구현이 발생함

public abstract class Robot {
	protected String name;
	
	//템플릿메소드 : 전체 흐름중 일부기능을 추상메소드로 남겨두고 자식클래스에서 세부 구현하는것.
	public void fight(){
		System.out.println("싸움을 시작한다");
		move();
		attack();
		System.out.println("싸움을 끝낸다");
	}
	
	public abstract void move();
	
	public abstract void attack();
}
