package protocol;

import java.io.Serializable;
import java.util.Map;

public class Message implements Serializable{
	
	private static final long serialVersionUID = 1004;
	
	private int code;
	private Map<String,Object> params;
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public Map<String, Object> getParams() {
		return params;
	}
	public void setParams(Map<String, Object> params) {
		this.params = params;
	}
	
	
	
}
