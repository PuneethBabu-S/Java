import java.util.Optional;

class OptionalExample{
	public static void main(String[] args) {
		
		Integer a = 500;
		Integer b = 150;
		
		Optional<Integer> o1 = Optional.ofNullable(a);
		Optional<Integer> o2 = Optional.ofNullable(b);
		
		add(o1, o2);
	}

	private static void add(Optional<Integer> o1, Optional<Integer> o2) {
		Integer a = o1.orElse(0);
		Integer b = o2.orElse(0);
		//o1.ifPresentOrElse(System.out::println, () -> System.out.println("Nothing") );
		System.out.println(a+b);
	}
}