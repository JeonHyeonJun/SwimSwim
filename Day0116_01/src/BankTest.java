
public class BankTest {
	static BankAccount account = new BankAccount();
	
	public static void main(String[] args) {
		Thread one = new Thread(new User(account));
		Thread two = new Thread(new User(account));
		
		one.start();
		two.start();
	}
}
