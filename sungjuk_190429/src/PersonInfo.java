import java.util.Scanner;

public class PersonInfo extends Person implements Personable {
	// �������� ó�� Ŭ����

	String phone; // ��ȭ��ȣ
	String addr; // �ּ�
	String firstInput;
	Scanner s = new Scanner(System.in);

	@Override
	public void input() {
		System.out.print("�й� : ");
		firstInput = s.next();

		if (firstInput.equals("exit")) {
			return;
		}
		hacbun = firstInput;
		System.out.print("�̸� : ");
		irum = s.next();
		System.out.print("��ȭ��ȣ : ");
		phone = s.next();
		System.out.print("�ּ� : ");
		addr = s.next();

	}

	@Override
	public void output() {

		System.out.println(hacbun + " \t" + irum + " \t" + phone + " \t" + addr);

	}
}
