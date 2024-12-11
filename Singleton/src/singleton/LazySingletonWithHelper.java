package singleton;

public class LazySingletonWithHelper {
	private LazySingletonWithHelper(){
		
	}
	
	
	private static class LazySingletonHelper{
		private static LazySingletonWithHelper INSTANCE = new LazySingletonWithHelper();
	}
	
	public static LazySingletonWithHelper getInstance() {
		return LazySingletonHelper.INSTANCE;
	}
	
}
