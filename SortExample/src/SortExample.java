import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortExample {

	public static void main(String[] args) {
		List<Developer> developers = new ArrayList<>();
		developers.add(new Developer("PBS", new BigDecimal(101000), 24));
		developers.add(new Developer("Arun", new BigDecimal(90000), 26));
		developers.add(new Developer("Suni", new BigDecimal(30000), 12));
		developers.add(new Developer("Hamsa", new BigDecimal(200000), 26));
		developers.add(new Developer("Reddy", new BigDecimal(87600), 16));
		developers.add(new Developer("Test", new BigDecimal(50000), 24));
		developers.add(new Developer("Kiran", new BigDecimal(101000), 65));
		
		developers.sort((x,y) -> x.getAge()-y.getAge());
		//developers.forEach(System.out::println);
		
		Comparator<Developer> salaryComparator = (x,y) -> x.getSalary().compareTo(y.getSalary());
		developers.sort(salaryComparator.reversed().thenComparing((x,y)->x.getAge()-y.getAge()));
		developers.forEach(System.out::println);
		
	}

}
