package member;

public class Member {
	private static String name;
	private static String id;
	private static String pass;
	
	public static String getName() {
		return name;
	} 
	public static void setName(String name) {
		Member.name = name;
	}
	public static String getId() {
		return id;
	}
	public static void setId(String id) {
		Member.id = id;
	}
	public static String getPass() {
		return pass;
	}
	public static void setPass(String pass) {
		Member.pass = pass;
	}
	
	
}
