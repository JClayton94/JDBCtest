package jdbc;

public class Actor {
	
	String fName, lName;
	
	public Actor(String fName, String lName) {
		
		this.fName = fName;
		this.lName = lName;
		
	}

	public String getfName() {
		return fName;
	}

	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getlName() {
		return lName;
	}

	public void setlName(String lName) {
		this.lName = lName;
	}
	
	public String getFullName() {
		
		return fName + " " + lName;
		
	}

}
