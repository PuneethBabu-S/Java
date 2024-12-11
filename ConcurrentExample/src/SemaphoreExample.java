import java.util.concurrent.Semaphore;

class Shared1 {
    static int count = 1;
}

class DemoThread1 implements Runnable {
    String name;
    Semaphore sem;

    public DemoThread1(String name, Semaphore sem) {
        this.name = name;
        this.sem = sem;
        new Thread(this).start();
    }

    @Override
    public void run() {
    	System.out.println(name + " waiting for permission");
    	try {
			sem.acquire();
			System.out.println(name + " lock acquired");
			for(int i=0; i<5; i++) {
				System.out.println(name + " " + Shared1.count++);
			}
			System.out.println(name + " lock released");
			sem.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    }
}

class DemoThreadDec implements Runnable {
    String name;
    Semaphore sem;

    public DemoThreadDec(String name, Semaphore sem) {
        this.name = name;
        this.sem = sem;
        new Thread(this).start();
    }

    @Override
    public void run() {
    	System.out.println(name + " waiting for permission");
    	try {
			sem.acquire();
			System.out.println(name + " lock acquired");
			for(int i=0; i<5; i++) {
				System.out.println(name + " " + Shared1.count--);
			}
			System.out.println(name + " lock released");
			sem.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
    	
    }
}



public class SemaphoreExample {

	public static void main(String[] args) {
		Semaphore sem = new Semaphore(2);
		
		new DemoThread1("PBS", sem);
		new DemoThreadDec("Dec", sem);
		new DemoThread1("Test", sem);
	}

}
