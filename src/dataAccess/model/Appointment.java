package dataAccess.model;

public class Appointment {
	private String data;
	private String namePet;
	private String type;
	private String nameOwner;
	private int check;
	public Appointment(String data, String type, String petOwner, String petOnline) {
		this.data=data;
		this.type=type;
		nameOwner=petOwner;
		namePet=petOnline;
		check=0;
	}
	public Appointment() {}
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public String getNamePet() {
		return namePet;
	}
	public void setNamePet(String namePet) {
		this.namePet = namePet;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getNameOwner() {
		return nameOwner;
	}
	public void setNameOwner(String nameOwner) {
		this.nameOwner = nameOwner;
	}
	public int getCheck() {
		return check;
	}
	public void setCheck(int check) {
		this.check = check;
	}
	
	

}
