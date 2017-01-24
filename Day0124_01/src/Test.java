
public class Test {
	public static void main(String[] args) {
		AccountDao dao = AccountDao.getInstance();
		
		dao.insert("123", "123", 123);
		dao.update("123", "456", 777);
		dao.delete("1111111");
		
		dao.close();
	}
}
