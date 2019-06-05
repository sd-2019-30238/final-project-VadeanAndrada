package dataAccess.model;

public class Description {
	private int id;
	private String sex;
	private String age;
	private String breed;
	private String temperament;
	public Description(String sex, String age, String temperament) {
		this.sex=sex;
		this.age=age;
		this.temperament=temperament;
	}
	public Description() {}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getBreed() {
		return breed;
	}
	public void setBreed(String breed) {
		this.breed = breed;
	}
	public String getTemperament() {
		return temperament;
	}
	public void setTemperament(String temperament) {
		this.temperament = temperament;
	}
	
	

}
