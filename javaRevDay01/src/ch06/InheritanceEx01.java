package ch06;

public class InheritanceEx01 {

	public static void main(String[] args) {
	EMailSender obj1 = new EMailSender("������ �����մϴ�", "������","admin@naver.com","10% ���������� ����Ǿ����ϴ�");
	SMSSender obj2 = new SMSSender ("������ �����մϴ�","������","02-123-4567","10% ���������� ����Ǿ����ϴ�");
	send(obj1,"hatman@nate.com");
	send(obj1,"kjhkjh@naver.com");
	send(obj2,"010-1215-7894");
			

	}
	
	static void send(MessageSender obj, String recipient) {
		obj.sendMessage(recipient);
		
	}

}
