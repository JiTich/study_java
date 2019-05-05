package ch06;

public class EMailSender extends MessageSender {
	String senderAddr;
	String emailBody;

	public EMailSender() {

	}

	EMailSender(String title, String senderName, String senderAddr, String emmailBody) {
		super(title, senderName);
		this.senderAddr = senderAddr;
		this.emailBody = emmailBody;
	}

	void sendMessage(String recipient) {
		System.out.println("---------------------------");
		System.out.println("제목 : " + title);
		System.out.println("보내는 사람 : " + senderName + " " + senderAddr);
		System.out.println("받는 사람 : " + recipient);
		System.out.println("내용 : " + emailBody);
	}

}
