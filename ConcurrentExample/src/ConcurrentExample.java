import java.util.concurrent.atomic.AtomicInteger;

class Shared {
    static AtomicInteger count = new AtomicInteger(1);
}

class DemoThread implements Runnable {
    String name;

    public DemoThread(String name) {
        this.name = name;
        new Thread(this).start();
    }

    @Override
    public void run() {
        while (true) {
            int currentValue = Shared.count.getAndIncrement();
            if (currentValue > 15) {
                break;
            }
            System.out.println(name + " : " + currentValue);
        }
    }
}

public class ConcurrentExample {
    public static void main(String[] args) {
        new DemoThread("PBS");
        new DemoThread("Test");
        new DemoThread("Demo");
    }
}
