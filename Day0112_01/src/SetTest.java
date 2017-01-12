
import java.util.HashSet;
import java.util.Set;

public class SetTest {
	public static void main(String[] args) {
		
		Set<Account> accountSet = new HashSet<Account>();
		
		accountSet.add(new Account("1","123",0));
		accountSet.add(new Account("2","2123",0));
		accountSet.add(new Account("3","3123",0));
		accountSet.add(new Account("4","4123",0));
		accountSet.add(new Account("1","5123",0));
		System.out.println(accountSet);
		
//		Set<String> set = new HashSet<String>();
//		
//		set.add("Milk");		
//		set.add("Bread");		
//		set.add("Butter");		
//		set.add("Cheese");	
//		set.add("Ham");	
//		set.add("Ham");
//		
//		//순서는 랜덤,중복x
//		System.out.println(set);
	}
}
