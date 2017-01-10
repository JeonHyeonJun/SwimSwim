package v5;

//PunchAttack과 MissileAttack은 Attack이라는 인터페이스를 구현한 구현체, Attack참조변수로 모두 참조가능해짐
public class MissileAttack implements Attack{
	public void attack(){
		System.out.println("미사일공격");
	}
}
