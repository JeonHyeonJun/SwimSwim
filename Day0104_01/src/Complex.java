
public class Complex {
	private double real;
	private double imag;
	
	public Complex(double r, double i){
		real = r;
		imag = i;
	}

	public double getReal() {
		return real;
	}

	public void setReal(double real) {
		this.real = real;
	}

	public double getImag() {
		return imag;
	}

	public void setImag(double imag) {
		this.imag = imag;
	}
	
	public static Complex add(Complex c, Complex d){
		double resultReal = c.real + d.real;
		double resultImag = c.imag + d.imag;
		return new Complex(resultReal, resultImag);
	}
	
	public static Complex gob(Complex c, Complex d){
		double resultReal = c.real*d.real - c.imag*d.imag;
		double resultImag = c.real*d.imag + c.imag*d.real;
		return new Complex(resultReal, resultImag);
	}
	
	public String toString(){
		return "real: " +real+ " imag: " +imag+ "i";
	}
}
