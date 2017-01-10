
public class Student {
	public String id,passward,name;
	public int attendance;
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
	
	public Student(String id, String passward, String name, int attendence){
		this.id = id;
		this.passward = passward;
		this.name = name;
		this.attendance = attendence;
	}
}
