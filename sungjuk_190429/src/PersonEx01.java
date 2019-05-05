import java.util.ArrayList;
import java.util.List;

public class PersonEx01 {

	public static void main(String[] args) {

		// 성적입력 객체List
		List<Sungjuk> sjList = new ArrayList<Sungjuk>();

		// 개인정보 객체List
		List<PersonInfo> piList = new ArrayList<PersonInfo>();

		System.out.println("<학생 성적 데이터 입력>");

		while (true) {
			Sungjuk sj = new Sungjuk();
			System.out.println(" * ");
			sj.input();

			// "학생성적데이터 입력"에서 "exit"를 입력하면
			// "성적 데이터" 입력 종료
			if (sj.firstInput.equals("exit")) {
				break;
			}

			sj.process();
			sjList.add(sj);
		}

		System.out.println("<개인정보 입력>");

		while (true) {
			PersonInfo pi = new PersonInfo();
			System.out.println(" * ");
			pi.input();

			// "개인정보 입력"에서 "exit"를 입력하면
			// "개인정보 " 입력 종료
			if (pi.firstInput.equals("exit")) {
				break;
			}

			piList.add(pi);
		}

		// 학생들의 정보 출력
		//학생 성적 정보
		outputForm("학생 성적 정보");
		System.out.println("학번\t 이름\t 국어\t 영어\t 수학\t 총점 \t 평균 \t 등급");
		printLine();
		int total = 0;
		double avg = 0;
		for (int i = 0; i < sjList.size(); i++) {
			sjList.get(i).output();
			total += sjList.get(i).avg;
		}

		avg = Math.round(total / sjList.size() * 10) / 10f;
		printLine();
		System.out.println("    총 학생수: " + sjList.size() + "명, 평균: " + avg + "\n");

		//개인 정보
		outputForm("개인 정보");
		System.out.println("학번 \t 이름 \t 전화번호 \t\t 주소");
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
