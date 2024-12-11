
import java.util.Arrays;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamsExample {

	public static void main(String[] args) {
		List<Integer> list = Arrays.asList(10,23,35,41,49,66,23,52,89,54);
		
		list.stream().filter(x -> x%2==0).forEach(System.out::println);
		
		System.out.println("------------------------------------");
		
		list.stream().map(x -> x+x).filter(x -> x%3==0).forEach(System.out::println);
		
		System.out.println("------------------------------------");
		
		Set<Integer> set = list.stream().collect(Collectors.toSet());
		System.out.println(set);
		
		System.out.println("------------------------------------");
		
		list.stream().sorted(Comparator.reverseOrder())
		.skip(1).limit(1).forEach(System.out::println);
		
		System.out.println("------------------------------------");
		
		IntStream.range(1, 6).forEach(System.out::print);
		System.out.println("\n------------------------------------");
		IntStream.rangeClosed(1, 6).forEach(System.out::print);
		System.out.println("\n------------------------------------");
		OptionalInt n1 = IntStream.range(1, 6).reduce((x,y) -> x+y);
		System.out.println(n1.getAsInt());

		System.out.println("------------------------------------");
		
		int n2 = IntStream.range(1, 6).reduce(10, (x,y) -> x+y);
		System.out.println(n2);
		
		System.out.println("------------------------------------");
		
		IntSummaryStatistics stats = IntStream.range(1, 6).summaryStatistics();
		System.out.println(stats.getMin());
		System.out.println(stats.getMax());
		System.out.println(stats.getAverage());
		System.out.println(stats.getCount());
		System.out.println(stats.getSum());
		
		System.out.println("------------------------------------");
		
		List<Integer> l1 = Arrays.asList(1,2,3);
		List<Integer> l2 = Arrays.asList(4,5,6,7);
		List<Integer> l3 = Arrays.asList(8,9,10);
		
		List<List<Integer>> cl = Arrays.asList(l1,l2,l3);
		System.out.println(cl);
		
		List<Integer> fl = cl.stream().flatMap(x -> x.stream()).collect(Collectors.toList());
		System.out.println(fl);
		
		
		
	}

}
