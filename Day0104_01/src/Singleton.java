//싱글턴패턴 : 어떤 클래스의 객체가 한개만 유지되도록 하는 개발 패턴

//1. 생성자를 private으로 감춘다
//2. 정적변수로 자기자신 참조변수 타입을 준비한다.
//3. 자기자신의 객체를 만들어주는 정적메소드를 작성하되(2에 대한 게터)
//	2에서 만든 변수에 객체가 존재하지 않을때만 만들고
//	2에서 만든 변수가 존재하면 그 객체를 리턴한다
public class Singleton {
	private static Singleton instance;
	private Singleton(){
		
	}
	public static Singleton getInstance(){
		if(instance == null)
			instance = new Singleton();
		return instance;
	}
}
