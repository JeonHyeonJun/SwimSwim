import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

class Car implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8497921706053871184L;
	private int speed;
	private int mileage;
	private String color;
	@Override
	public String toString() {
		return "Car [speed=" + speed + ", mileage=" + mileage + ", color=" + color + "]";
	}
	public Car(int s, int m, String c){
		speed =s; mileage =m; color =c;
	}
}

public class ObjectStreamTest {
	public static void main(String[] args) {
		ObjectInputStream oi = null;
		ObjectOutputStream oo = null;
		
		try{
			oo = new ObjectOutputStream(new FileOutputStream("data.dat"));
			oi = new ObjectInputStream(new FileInputStream("data.dat"));
			
			List<Car> carList = new ArrayList<>();
			carList.add(new Car(1,2,"파랑"));
			carList.add(new Car(2,9,"검정"));
			carList.add(new Car(3,8,"은빛"));
			carList.add(new Car(99,99,"빨강"));
			oo.writeObject(carList);
			oo.flush();
			
			for(Car c : (List<Car>) oi.readObject()){
				System.out.println(c);
			}
			
//			Car c = new Car(100,2000,"하얀색");
//			oo.writeObject(c);
//			oo.flush();
//			System.out.println(oi.readObject());
			
			
//			Date date = new Date();
//			oo.writeObject(date);
//			oo.flush();
//			System.out.println(oi.readObject());
			
		} catch (IOException e){
			e.printStackTrace();
		} catch (ClassNotFoundException e){
			e.printStackTrace();
		}
		finally {
			try{
				if(oi != null)
					oi.close();
				if(oo != null)
					oo.close();
			} catch( IOException e){
				e.printStackTrace();
			}
		}
	}
}
