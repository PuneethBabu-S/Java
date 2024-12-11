package factoryMethodPattern;

public abstract class Message {
	public abstract String getContent();
	
	public void defaultPrint() {
		System.out.println("From abstract Message class");
	}
}
