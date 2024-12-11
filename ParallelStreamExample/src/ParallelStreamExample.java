import java.util.function.Supplier;
import java.util.stream.IntStream;

public class ParallelStreamExample {

	public static long checkPerformance(Supplier<Integer> s, int n) {
		
		long start = System.currentTimeMillis();
		
		for(int i=0; i<n; i++) {
			s.get();
		}
		
		long end =  System.currentTimeMillis();
		
		return end-start;
	}
	
	public static int parallelStream() {
		int sum = IntStream.rangeClosed(1, 100000000).parallel().sum();
		return sum;
	}
	
	public static int withoutParallelStream() {
		int sum = IntStream.rangeClosed(1, 100000000).sum();
		return sum;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkPerformance(ParallelStreamExample::parallelStream, 20));
		System.out.println(checkPerformance(ParallelStreamExample::withoutParallelStream, 20));

	}

}
