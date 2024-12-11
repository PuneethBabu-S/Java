package factoryMethodPattern;

public abstract class MessageCreator {
	public Message getMessage() {
		Message msg = createMessage();
		msg.defaultPrint();
		return msg;
	}
	
	public abstract Message createMessage();
}
