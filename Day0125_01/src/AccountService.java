import java.util.List;

public class AccountService {
	private AccountDao ad;
	
	public AccountService(){
		ad = AccountDao.getInstance();
	}
	
	public boolean createAccount(String ano, String name, int bal) {

		Account a = ad.SelectOne(ano);
		if (a != null) {
			return false;
		} else {
			ad.InsertAccount(ano, name, bal);
			return true;
		}
	}

	public List<Account> accountList() {

		List<Account> temp = ad.SelectAll();
		return temp;
	}

	public int deposit(String ano, int bal) {

		Account temp = ad.SelectOne(ano);
		if (temp == null) {
			return 2;
		} else {

			if (bal > 0) {
				ad.UpdateAccount(temp.getAno(), temp.getName(), temp.getBal() + bal);
				return 1;
			} else
				return 3;
		}
	}

	public int withdraw(String ano, int bal) {

		Account temp = ad.SelectOne(ano);
		if (temp == null) {
			return 2;
		} else {
			if (bal < 0)
				return 3;
			else if (temp.getBal() < bal)
				return 4;
			else {
				ad.UpdateAccount(temp.getAno(), temp.getName(), temp.getBal() - bal);
				return 1;
			}
		}
	}

	public int delete(String ano) {

		Account a = ad.SelectOne(ano);
		if (a != null) {
			ad.DeleteAccount(ano);
			return 1;
		} else {
			return 2;
		}
	}

	public int transit(String ano, String ano2, int bal) {

		Account temp = ad.SelectOne(ano);

		Account temp2 = ad.SelectOne(ano2);

		if (temp == null || temp2 == null) {
			return 2;
		} else {
			if (bal < 0)
				return 3;
			else if (temp.getBal() < bal)
				return 4;
			else {
				ad.UpdateAccount(temp.getAno(), temp.getName(), temp.getBal() - bal);
				ad.UpdateAccount(temp2.getAno(), temp2.getName(), temp2.getBal() + bal);
				return 1;
			}

		}
	}
	
}
