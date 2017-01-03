
public class MemberService {
	private boolean login;
	
	public boolean login(String id, String password){
		if(id == "hong" && password == "12345")
			login = true;
		return login;
	}
	public void logout(String id){
		System.out.println("로그아웃 되었습니다");
	}
}
