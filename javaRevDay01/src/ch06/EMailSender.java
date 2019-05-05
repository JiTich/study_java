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
		System.out.println("���� : " + title);
		System.out.println("������ ��� : " + senderName + " " + senderAddr);
		System.out.println("�޴� ��� : " + recipient);
		System.out.println("���� : " + emailBody);
	}

}
