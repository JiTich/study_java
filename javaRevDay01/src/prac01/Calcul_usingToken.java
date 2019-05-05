package prac01;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Calcul_usingToken {
	static boolean input_check(String str) {
		// ù��° ��ū�� �������� Ȯ���ϴ� �޼���
		char ch;
		for (int i = 0; i < str.length(); i++) { //��ū�� ���޹޾� ���ڿ� ���̸�ŭ �ݺ�
			// str�� ���� �ƴѰ��� �ִ��� charAt���� Ȯ��
			ch = str.charAt(i);
			
			if('0'>ch ||ch>'9') {//ch�� �������� �˻�(�����ڵ�� ��)
				return true;//���ڰ� �ƴ� ���ڰ� �߰ߵ�
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// ��Ģ���� ���
		// �Է¼������ ���
		// 1) �����ڰ� ���ں��� ���� �Է¹޴°���
		// 2) �����ڰ� ���ÿ� ������ ���
		// 3) �����ڷ� ������ ����
		// ���Է��Ѵ�.

		Scanner s = new Scanner(System.in);

		int result = 0; // �����
		String str, token_str;
		// ���Է� �ޱ����� �ݺ���
		input_loop: while (true) {
			System.out.println("�����Է�=> ");
			// �Է¹��� ����
			str = s.next().trim();
		
			// stringtokenizer ���
			StringTokenizer token = new StringTokenizer(str, "+-*/", true);
			token_str = token.nextToken(); // ù��° ��ū ����

			if (input_check(token_str))// input_check (): ��ū�� �������� �˻�
			{
				System.out.println("�����Է¿���(1)!!\n"); // ��ū�� ���ڰ� �ƴ�
				continue; // input_loop ���������� �̵�
			}

			result = Integer.parseInt(token_str); // ��ū�� ���ڷ� ��ȯ
			while (token.hasMoreTokens()) {
				token_str = token.nextToken(); // ¦����° ��ū���� (������)
				char ch = token_str.charAt(0); // ���ڿ����� ������ ����
				if (token.hasMoreTokens()) {
					token_str = token.nextToken();	//Ȧ����° ��ū����(����)
				}
				else {
					System.out.println("�����Է¿���(2)!!\n");	//�����ڷ� ������ ����
					continue input_loop;
				}
				
				if(input_check(token_str))//input_check()��ū�� �������� �˻�
				{
					System.out.println("�����Է¿���(3)!!\n");
					continue input_loop;
				}
				
				switch (ch) {
				case '+':
					result +=Integer.parseInt(token_str);
					break;

				case '-':
					result -=Integer.parseInt(token_str);
					break;

				case '*':
					result *=Integer.parseInt(token_str);
					break;

				case '/':
					if(Integer.parseInt(token_str)==0) {
						System.out.println("������ ����!!\n");
						continue input_loop;
					}
					result /=Integer.parseInt(token_str);
					break;

				}//switch
			}//while
			break;
			// ArrayList<Integer> numberList = new ArrayList<Integer>();
//
//			ArrayList<String> operList = new ArrayList<String>();
//
//			while (st.hasMoreTokens()) {
//
//				// ù��° ��ū�� �����ΰ�
//				if (48 <= (int) st.nextToken().charAt(0) && (int) st.nextToken().charAt(0) <= 57) {
//					numberList.add(Integer.parseInt(st.nextToken()));
//					System.out.println(st.nextToken());
//				} else {
//					operList.add(st.nextToken());
//				}
//
//				result = numberList.get(0);
//				if (numberList.size() - operList.size() != 1)
//					break;
//
//				for (int j = 0; j < st.countTokens  (); j++) {
//					// ���ڰ� �ƴ� ��ū�� operList�� �߰�
//					if (st.nextToken().equals("+") || st.nextToken().equals("-") || st.nextToken().equals("*")
//							|| st.nextToken().equals("/")) {
//						operList.add(st.nextToken());
//					}
//
//					String operator = operList.get(j);
//					System.out.println("==");
//					if ("+".equals(operator)) {
//						result = result + numberList.get(j + 1);
//					} else if ("-".equals(operator)) {
//						result = result - numberList.get(j + 1);
//					} else if ("*".equals(operator)) {
//						result = result * numberList.get(j + 1);
//					} else if ("/".equals(operator)) {
//						result = result / numberList.get(j + 1);
//					}
//
//					// �ùٸ� ���°� �ƴ϶�� ���Է��Ѵ�.
//				}
//			}
//			System.out.println(result);
		}//while(true)
		System.out.println(str+" = "+result);
	}

}
