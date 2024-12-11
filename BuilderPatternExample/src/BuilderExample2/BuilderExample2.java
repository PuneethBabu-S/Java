package BuilderExample2;

import java.time.LocalDate;
import BuilderExample2.UserDTO.UserDTOBuilder;
import BuilderExample1.User;
import BuilderExample1.Address;

public class BuilderExample2 {

	public static void main(String[] args) {
		
		Address address = new Address("#21","Bengaluru","Karnataka","561203");
		User user = new User("PB", "S", LocalDate.now(), address);
		
		UserDTO userDTO = userDTODirector(UserDTO.getUserDTOBuilder(), user);
		
		System.out.println(userDTO);
	}
	
	public static UserDTO userDTODirector(UserDTOBuilder userDTOBuilder, User user) {
		return userDTOBuilder.withFname(user.getFirstName()).withLname(user.getLastName())
			   .withBirthdate(user.getBirthday()).withAddress(user.getAddress()).build();
	}

}
