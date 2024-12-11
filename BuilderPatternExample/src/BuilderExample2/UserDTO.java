package BuilderExample2;

import java.time.LocalDate;
import java.time.Period;
import BuilderExample1.Address;

public class UserDTO {
	
	private String name;
	private String age;
	private String address;
	
	public String getName() {
		return name;
	}
	private void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	private void setAge(String age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	private void setAddress(String address) {
		this.address = address;
	}
	
	public static UserDTOBuilder getUserDTOBuilder() {
		return new UserDTOBuilder();
	}
	
	
	
	@Override
	public String toString() {
		return "UserDTO [name=" + name + ", age=" + age + ", address=" + address + "]";
	}



	static class UserDTOBuilder{
		
		private String fname;
		private String lname;
		private String age;
		private String address;
		private UserDTO dto;
		
		public UserDTOBuilder withFname(String fname) {
			this.fname = fname;
			return this;
		}


		public UserDTOBuilder withLname(String lname) {
			this.lname = lname;
			return this;
		}


		public UserDTOBuilder withBirthdate(LocalDate date) {
			Period period = Period.between(date, LocalDate.now());
			age = Integer.toString(period.getYears());
			return this;
		}


		public UserDTOBuilder withAddress(Address address) {
			this.address = address.getHouseNumber() + ", " + address.getCity()
						   + ", " + address.getState() + ", " + address.getZip();
			return this;
		}


		public UserDTO build() {
			dto = new UserDTO();
			dto.setName(fname + " " + lname);
			dto.setAge(age);
			dto.setAddress(address);
			return dto;
		}

		
		public UserDTO getUserDTOP() {
			return dto;
		}
	}
	
	
}
