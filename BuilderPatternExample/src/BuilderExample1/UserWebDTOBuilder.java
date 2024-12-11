package BuilderExample1;
import java.time.LocalDate;
import java.time.Period;

public class UserWebDTOBuilder implements UserDTOBuilder {
	
	private String fname;
	private String lname;
	private String age;
	private String address;
	private UserDTO dto;

	@Override
	public UserDTOBuilder withFname(String fname) {
		this.fname = fname;
		return this;
	}

	@Override
	public UserDTOBuilder withLname(String lname) {
		this.lname = lname;
		return this;
	}

	@Override
	public UserDTOBuilder withBirthdate(LocalDate date) {
		Period period = Period.between(date, LocalDate.now());
		age = Integer.toString(period.getYears());
		return this;
	}

	@Override
	public UserDTOBuilder withAddress(Address address) {
		this.address = address.getHouseNumber() + ", " + address.getCity()
					   + ", " + address.getState() + ", " + address.getZip();
		return this;
	}

	@Override
	public UserDTO build() {
		dto = new UserWebDTO(fname+" "+lname, address, age);
		return dto;
	}

	@Override
	public UserDTO getUserDTOP() {
		return dto;
	}

}
