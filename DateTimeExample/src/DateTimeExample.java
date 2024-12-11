import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

public class DateTimeExample {

	public static void main(String[] args) {
		Date d = new Date();
		System.out.println(d);
		
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		
		LocalTime localTime = LocalTime.now();
		System.out.println(localTime);
		
		LocalDateTime localDateTime = LocalDateTime.now();
		System.out.println(localDateTime);
	}

}
