package ans;
import java.util.Scanner;

public class PersonInfo extends Person implements Personable {
	String phone;
	String addr;
	
	static int cnt = 0;
	
	PersonInfo()
	{
	}
	
	@Override
	public boolean input() {
		Scanner in = new Scanner(System.in);
		System.out.print("학번 입력 => ");
		hakbun = in.next();
		if (hakbun.toLowerCase().equals("exit"))
			return true;
		
		System.out.print("이름 입력 => ");
		irum = in.next();
		System.out.print("전화번호 입력 => ");
		phone = in.next();
		System.out.print("주소 입력 => ");
		addr = in.next();
		
		return false;
	}

	@Override
	public void output() {
		System.out.printf("%4s     %3s     %11s    %2s\n", this.hakbun, irum, phone, addr);
	}
}