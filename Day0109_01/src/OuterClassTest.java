
class OuterClass{
	private String secret = "Time is money";
	
//	public OuterClass(){
//		InnerClass obj = new InnerClass();
//		obj.method();
//	}
	
	public void setSecret(String secret) {
		this.secret = secret;
	}

	class InnerClass{
//		public InnerClass(){
//			System.out.println("내부 클래스 생성잠돠");
//		}		
		public void method(){
			System.out.println(secret);
		}
	}
}

public class OuterClassTest {
	public static void main(String[] args) {
		OuterClass outer = new OuterClass();
		OuterClass outer2 = new OuterClass();
		outer.setSecret("Time is not money");
		
		OuterClass.InnerClass inner = outer.new InnerClass();
		OuterClass.InnerClass inner2 = outer2.new InnerClass();
		
		inner.method();
		inner2.method();
		//		new OuterClass();
	}
}
