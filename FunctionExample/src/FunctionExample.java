import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.function.*;
import java.util.stream.Collectors;

public class FunctionExample {

	public static void main(String[] args) {
		Function<String, Integer> f = x -> x.length();
		System.out.println(f.apply("Dummy string"));
		
		int[] arr = {1,2,3,4,5,6,7,8,9,10,12,18};
		
		Predicate<Integer> p1 = x -> x%3==0;
		Predicate<Integer> p2 = x -> x%2==0;
		
		for(int i: arr) {
			System.out.print(p1.and(p2).test(i) ? i+"\n" : "");
		}
		
		System.out.println();

		for(int i: arr) {
			System.out.print(p1.or(p2).test(i) ? i+"\n" : "");
		}
		
		System.out.println("------------------------------");
		
		Arrays.stream(arr).filter(x -> x%2==0 && x%3==0).forEach(System.out::println);
		
		System.out.println("------------------------------");
		
		Map<String, Integer> map = new HashMap<>();
		
		map.put("ab", 1); map.put("aa", 2); map.put("bx", 3); map.put("bx", 4); map.put("as", 5); 
		
		Map<String, Integer> resMap = map.entrySet().stream()
				.filter(x -> x.getKey().startsWith("a"))
				.collect(Collectors.toMap(x -> x.getKey(), x -> x.getValue()));
		
		System.out.println(resMap);
	}

}
