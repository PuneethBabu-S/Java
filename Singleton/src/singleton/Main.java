package singleton;

public class Main {

	public static void main(String[] args) {
		
		//Eager singleton
		EagerSingleton instance1 = EagerSingleton.getInstance();
		EagerSingleton instance2 = EagerSingleton.getInstance();
		System.out.print(instance1 + " - " + instance2 + " : " );
		System.out.println(instance1 == instance2);
		
		//Lazy singleton with synchronized
		LazySingleton lazySingletonInstance1 = LazySingleton.getInstance();
		LazySingleton lazySingletonInstance2 = LazySingleton.getInstance();
		System.out.print(lazySingletonInstance1 + " - " + lazySingletonInstance2 + " : " );
		System.out.println(lazySingletonInstance1 == lazySingletonInstance2);
		
		//Lazy singleton with helper class
		LazySingletonWithHelper i1 = LazySingletonWithHelper.getInstance();
		LazySingletonWithHelper i2 = LazySingletonWithHelper.getInstance();
		System.out.print(i1 + " - " + i2 + " : " );
		System.out.println(i1 == i2);
		
	}

}
