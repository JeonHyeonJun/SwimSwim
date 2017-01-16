//synchronized키워드가 붙은 메소드 중 하나에 어떤 쓰레드가 진입해있으면
//그 놈이 함수를 다 수행할때까지 다른 쓰레드는 synchronized키워드가 붙은 메소드에 진입불가
public class BankAccount {
	int balance;
	public synchronized void deposit(int amount){
		balance += amount;
	}
	public synchronized void withdraw(int amount) {
		balance -= amount;
	}
	public synchronized int getBalance(){
		return balance;
	}
}

