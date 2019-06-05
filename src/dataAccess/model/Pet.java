package dataAccess.model;

public class Pet {

	private String name;
	private String age;
	private String owner;
	private String breed;
	private String doctor;
	private int online;
	public Pet(String name, String breed, String age, String doctor, String owner) {
		this.name=name;
		this.breed=breed;
		this.age=age;
		this.doctor=doctor;
		this.owner=owner;
		online=0;
	}
	public Pet() {}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getDoctor() {
		return doctor;
	}
	public void setDoctor(String doctor) {
		this.doctor = doctor;
	}
	public int getOnline() {
		return online;
	}
	public void setOnline(int online) {
		this.online = online;
	}
	
	
}
