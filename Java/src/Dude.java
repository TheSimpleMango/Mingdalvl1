public class Dude {
	private String firstName;
	private String lastName;
	private int age;

	public Dude(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public String getName() {
		return firstName + " " + lastName;
	}

	public int getAge() {
		return age;
	}
}