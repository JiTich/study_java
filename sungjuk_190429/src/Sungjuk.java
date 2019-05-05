import java.util.Scanner;

public class Sungjuk extends Person implements Personable {
	// ���������� ó�� Ŭ����

	int kor; // ����
	int eng; // ����
	int math; // ����
	int tot; // �հ�
	double avg; // ���
 String  grade; // ���
	String firstInput;

	// ����, ���, ��� ���ϴ� ���
	public void process() {
		// ����
		tot = kor + eng + math;
		// ���
		avg = Math.round(tot / 3f * 10) / 10.0;
		// ���
		if (90 <= avg && avg <= 100) {
			grade = "수";
		} else if (80 <= avg) {
			grade = "수";
		} else if (70 <= avg) {
			grade = "수";
		} else if (60 <= avg) {
			grade = "수";
		} else {
			grade = "수";
		}
	}

	Scanner s = new Scanner(System.in);

	// �й�, �̸�, ����, ����, ���� �Է¹ޱ�
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
		System.out.print("���� ����: ");
		kor = Integer.parseInt(s.next());
		System.out.print("���� ����: ");
		eng = Integer.parseInt(s.next());
		System.out.print("���� ����: ");
		math = Integer.parseInt(s.next());

	}

	// �й�, ...., ��� ���
	@Override
	public void output() {

		System.out.println(hacbun + " \t" + irum + " \t" + kor + " \t" + eng + " \t" + math + " \t" + tot + " \t" + avg + " \t"
				+ grade);;
	}
}
