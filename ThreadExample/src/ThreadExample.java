

class Demo{
	public Demo() {
		for(int i=0; i<10; i++) {
			System.out.println("Constructor "+i);
		}
	}
	
	public void f1() {
		for(int i=0; i<10; i++) {
			System.out.println("f1 "+i);
		}
	}
	
	public static void f2() {
		for(int i=0; i<10; i++) {
			System.out.println("f2 "+i);
		}
	}
}

public class ThreadExample {

	public static void main(String[] args) {
		Thread t1 = new Thread(() -> new Demo());
		Thread t2 = new Thread(() -> new Demo().f1() );
		Thread t3 = new Thread(Demo::f2);
		t1.start();
		t2.start();
		t3.start();
	}

}
