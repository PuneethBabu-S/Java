package BuilderExample1;
import java.time.LocalDate;

public class User {
	private String firstName;
	private String lastName;
	private LocalDate birthdate;
	private Address address;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public LocalDate getBirthday() {
		return birthdate;
	}
	public void setBirthday(LocalDate birthday) {
		this.birthdate = birthday;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public User(String firstName, String lastName, LocalDate birthdate, Address address) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.address = address;
	}

	
	
}
