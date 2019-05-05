import java.util.Scanner;

public class PersonInfo extends Person implements Personable {
	// 개인정보 처리 클래스

	String phone; // 전화번호
	String addr; // 주소
	String firstInput;
	Scanner s = new Scanner(System.in);

	@Override
	public void input() {
		System.out.print("학번 : ");
		firstInput = s.next();

		if (firstInput.equals("exit")) {
			return;
		}
		hacbun = firstInput;
		System.out.print("이름 : ");
		irum = s.next();
		System.out.print("전화번호 : ");
		phone = s.next();
		System.out.print("주소 : ");
		addr = s.next();

	}

	@Override
	public void output() {

		System.out.println(hacbun + " \t" + irum + " \t" + phone + " \t" + addr);

	}
}
