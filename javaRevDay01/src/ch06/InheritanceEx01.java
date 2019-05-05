package ch06;

public class InheritanceEx01 {

	public static void main(String[] args) {
	EMailSender obj1 = new EMailSender("생일을 축하합니다", "고객센터","admin@naver.com","10% 할인쿠폰이 발행되었습니다");
	SMSSender obj2 = new SMSSender ("생일을 축하합니다","고객센터","02-123-4567","10% 할인쿠폰이 발행되었습니다");
	send(obj1,"hatman@nate.com");
	send(obj1,"kjhkjh@naver.com");
	send(obj2,"010-1215-7894");
			

	}
	
	static void send(MessageSender obj, String recipient) {
		obj.sendMessage(recipient);
		
	}

}
