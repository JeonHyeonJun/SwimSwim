
public class ProducerThread extends Thread{
	private DataBox dataBox;
	
	public ProducerThread(DataBox dataBox){
		this.dataBox = dataBox;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
//		super.run();
		for(int i =0; i<10; i++)
			dataBox.setData("Data"+i);
	}
	
	
}
