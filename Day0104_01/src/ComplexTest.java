
public class ComplexTest {
	public static void main(String[] args) {
		Complex c1 = new Complex(2, 3);
		Complex c2 = new Complex(-3, 8);
		
		Complex c3 = Complex.add(c1,c2);
		Complex c4 = Complex.gob(c1,c2);
		System.out.println(c1);
		System.out.println("µ¡¼À°á°ú "+c3);
		System.out.println("°ö¼À°á°ú "+c4);
	}
}
