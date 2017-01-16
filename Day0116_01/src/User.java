
public class User implements Runnable{
	BankAccount account;
	
	public User(BankAccount account) {
		this.account = account;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		for(int i=0; i<1000; i++){
			account.deposit(10000);
//			try {
//				Thread.sleep(99);
//			} catch (InterruptedException e){
//			}
			account.withdraw(10000);
			if(account.getBalance()<0 || account.getBalance()>20000) {
				System.out.println(account.getBalance());
			}
		}
	}
	
}
