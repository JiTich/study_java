import java.util.ArrayList;
import java.util.List;

public class PersonEx01 {

	public static void main(String[] args) {

		// �����Է� ��üList
		List<Sungjuk> sjList = new ArrayList<Sungjuk>();

		// �������� ��üList
		List<PersonInfo> piList = new ArrayList<PersonInfo>();

		System.out.println("<�л� ���� ������ �Է�>");

		while (true) {
			Sungjuk sj = new Sungjuk();
			System.out.println(" * ");
			sj.input();

			// "�л����������� �Է�"���� "exit"�� �Է��ϸ�
			// "���� ������" �Է� ����
			if (sj.firstInput.equals("exit")) {
				break;
			}

			sj.process();
			sjList.add(sj);
		}

		System.out.println("<�������� �Է�>");

		while (true) {
			PersonInfo pi = new PersonInfo();
			System.out.println(" * ");
			pi.input();

			// "�������� �Է�"���� "exit"�� �Է��ϸ�
			// "�������� " �Է� ����
			if (pi.firstInput.equals("exit")) {
				break;
			}

			piList.add(pi);
		}

		// �л����� ���� ���
		//�л� ���� ����
		outputForm("�л� ���� ����");
		System.out.println("�й�\t �̸�\t ����\t ����\t ����\t ���� \t ��� \t ���");
		printLine();
		int total = 0;
		double avg = 0;
		for (int i = 0; i < sjList.size(); i++) {
			sjList.get(i).output();
			total += sjList.get(i).avg;
		}

		avg = Math.round(total / sjList.size() * 10) / 10f;
		printLine();
		System.out.println("    �� �л���: " + sjList.size() + "��, ���: " + avg + "\n");

		//���� ����
		outputForm("���� ����");
		System.out.println("�й� \t �̸� \t ��ȭ��ȣ \t\t �ּ�");
		printLine();
		for (int i = 0; i < piList.size(); i++) {
			piList.get(i).output();
		}
		printLine();
	}

	static void outputForm(String title) {
		System.out.print("                    **** ");
		System.out.print(title);
		System.out.println(" ****");
		System.out.println("============================================================");
	}

	static void printLine() {
		System.out.println("============================================================");
	}

}
