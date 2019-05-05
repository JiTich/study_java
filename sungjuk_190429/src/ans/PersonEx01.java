package ans;
public class PersonEx01 {
	final static int MAX = 100;
	
	public static void main(String[] args) {
		Sungjuk obj1[] = new Sungjuk[MAX];
		PersonInfo obj2[] = new PersonInfo[MAX];
		int i;
	
		System.out.println("### 성적 입력 ###");
		for (i=0; i<MAX; i++)
		{
			obj1[i] = new Sungjuk();
			if (obj1[i].input())
				break;
			
			obj1[i].process();
			Sungjuk.cnt++;
			System.out.println();
		}
		
		System.out.println("\n### 개인정보 입력 ###");
		for (i=0; i<MAX; i++)
		{
			obj2[i] = new PersonInfo();
			if (obj2[i].input())
				break;
			PersonInfo.cnt++;
			System.out.println();
		}
		
		System.out.println();
		System.out.println("\n\t\t   *** 성적표 ***");
		System.out.println("=================================================");
		System.out.println("학번          이름      국어      영어      수학      총점      평균      등급");
		System.out.println("=================================================");
		//obj1 : 성적객체
		printData(obj1, Sungjuk.cnt);
		System.out.println("=================================================");
		System.out.printf("\t\t 학생수 : %d, 전체 평균 : %.2f\n", Sungjuk.cnt, Sungjuk.total_avg / Sungjuk.cnt);
		
		System.out.println("\n           *** 개인정보 ***");
		System.out.println("====================================");
		System.out.println("학번             이름             전화번호              주소");
		System.out.println("====================================");
		printData(obj2, PersonInfo.cnt);
		System.out.println("====================================");
	}
	
	static void printData(Personable obj[], int cnt)
	{
		for (int i=0; i<cnt; i++)
		{
			obj[i].output();  // output()메서드에 대한 다형성 구현
		}
	}
}