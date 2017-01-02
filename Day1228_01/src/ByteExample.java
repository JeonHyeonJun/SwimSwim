
public class ByteExample {
	public static void main(String[] args) {
		byte var1 = -128;
		byte var2 = -30;
		byte var3 = 0;
		byte var4 = 30;
		byte var5 = 127;
//		byte var6 = 128;	//byte 범위초과로 인해 에러
		
		System.out.println(var1);
		System.out.println(var2);
		System.out.println(var3);
		System.out.println(var4);
		System.out.println(var5);
		
		var5++;
		System.out.println(var5);	//byte 최대값인 127을 넘었기때문에 넘침(overflow) 제일작은숫자로 돌아감
	}
}
