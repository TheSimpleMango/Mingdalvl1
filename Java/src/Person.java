public class Person {
	int character;
	private String firstName;
	private String lastName;
	private int age;
	
	public Person(String name, int age) {
		character = name.indexOf(" ");
		firstName = name.substring(0, character);
		lastName = name.substring(character+1);
		this.age = age;
	}
	
	public String getFirstName(){
		return firstName;
	}
	public void setName(String firstName){
		this.firstName = firstName;
	}
	
	public String getLastName(){
		return lastName;
	}
	public void setLastName(String lastName){
		this.lastName = lastName;
	}
	
	public int getAge(){
		return age;
	}
	public void setAge(int age){
		this.age = age;
	}
	
	public String toString(){
		return "first name:"+firstName+"last name:"+lastName+"\nage:"+age;
	}
}
