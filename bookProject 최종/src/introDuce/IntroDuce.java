package introDuce;

import javax.servlet.http.HttpServletRequest;

public class IntroDuce {
	
	private String introDuceId;
	private String role;
	private String name;
	private String function;
	
	public IntroDuce() {
		// TODO Auto-generated constructor stub
	}

	public IntroDuce(HttpServletRequest req) {
		// TODO Auto-generated constructor stub
	}

	public String getIntroDuceId() {
		return introDuceId;
	}

	public void setIntroDuceId(String introDuceId) {
		this.introDuceId = introDuceId;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFunction() {
		return function;
	}

	public void setFunction(String function) {
		this.function = function;
	}
	
	public IntroDuce(String role, String name, String function) {
		this.role = role;
		this.name = name;
		this.function = function;
	}
	
	public IntroDuce(String introDuceId) {
		this.introDuceId = introDuceId;
	}

}
