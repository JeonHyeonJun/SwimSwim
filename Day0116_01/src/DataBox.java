
public class DataBox {
	private String data;

	public synchronized void getData() {
		if (this.data == null) {
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("소비자 : " + data);
		data = null;
		notifyAll();
	}

	public synchronized void setData(String data) {
		if(this.data !=null){
			try{
				wait();
			} catch(InterruptedException e){
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("생산 : " + data);
		this.data = data;
		notifyAll();
	}
}
