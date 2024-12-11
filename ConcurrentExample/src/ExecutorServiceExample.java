import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

class Sum implements Callable<Integer>{
	
	int n;
	
	Sum(int n){
		this.n = n;
	}
	
	@Override
	public Integer call() throws Exception {
		int sum = 0;
		for(int i=1; i<=n; i++) {
			sum += i;
		}
		return sum;
	}
	
}

class Cube implements Callable<Integer>{
	
	int n;
	
	Cube(int n){
		this.n = n;
	}
	
	@Override
	public Integer call() throws Exception {
		return n*n*n;
	}
	
}


public class ExecutorServiceExample {

	public static void main(String[] args) throws Exception{
		Runtime runtime = Runtime.getRuntime();
		int processorCount = runtime.availableProcessors();
		System.out.println("No. of processors: " + processorCount);
		
		ExecutorService executorService = Executors.newFixedThreadPool(processorCount);
		
		Future<Integer> f1 = executorService.submit(new Sum(5));
		Future<Integer> f2 = executorService.submit(new Cube(2));
		Future<Integer> f3 = executorService.submit(new Sum(10));
		
		System.out.println(f1.get());
		System.out.println(f2.get());
		System.out.println(f3.get());
		
		executorService.shutdown();
	}

}
