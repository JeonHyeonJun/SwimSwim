package v3; // 객체관리를 각자하다보니 중복사용되는 객체에 댛서 공유하거나 기타 여지가 없음

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
