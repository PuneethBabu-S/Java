package BuilderExample1;
import java.time.LocalDate;

public interface UserDTOBuilder {
	
	UserDTOBuilder withFname(String fname);
	UserDTOBuilder withLname(String lname);
	UserDTOBuilder withBirthdate(LocalDate date);
	UserDTOBuilder withAddress(Address address);
	UserDTO build();
	UserDTO getUserDTOP();
	
}
