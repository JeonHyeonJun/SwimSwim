
public class Professor {
	public String id,passward,name;
	private Lecture lecture;
	
	public String getId() {
		return id;
	}


	public String getPassward() {
		return passward;
	}


	public void setLecture(Lecture lecture) {
		this.lecture = lecture;
	}


	public Professor(String id, String passward, String name){
		this.id = id;
		this.passward = passward;
		this.name = name;
	}
}
