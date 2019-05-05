package ch06;

abstract class MessageSender {

	String title;
	String senderName;
	
	public MessageSender() {
		// TODO Auto-generated constructor stub
	}
	MessageSender(String title, String senderName){
		this.title = title;
		this.senderName = senderName;
	}
	
	abstract void sendMessage(String recipient);
}
