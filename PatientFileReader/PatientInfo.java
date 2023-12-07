import java.util.Scanner;

public class PatientInfo {
	int iD;
	String name, dob, yearAdded;
	
	public PatientInfo() {
		setiD(0);
		setName("");
		setDob("");
		setYearAdded("");
	}
	
	public PatientInfo(Scanner source) {
		if(source.hasNext()) {
			setName(source.nextLine());
			setDob(source.nextLine());
			setYearAdded(source.nextLine());
		}
	}

	public int getiD() {
		return iD;
	}

	public void setiD(int iD) {
		this.iD = iD;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getYearAdded() {
		return yearAdded;
	}

	public void setYearAdded(String yearAdded) {
		this.yearAdded = yearAdded;
	}
}
