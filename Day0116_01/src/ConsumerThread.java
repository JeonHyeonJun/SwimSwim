
public class ConsumerThread extends Thread{
	private DataBox dataBox;
	
	public ConsumerThread(DataBox dataBox){
		this.dataBox = dataBox;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
//		super.run();
		for(int i =0; i<10; i++)
			dataBox.getData();
	}
}
