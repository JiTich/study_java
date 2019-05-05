package prac01;

import java.util.Scanner;
import java.util.StringTokenizer;

public class Calcul_usingToken {
	static boolean input_check(String str) {
		// 첫번째 토큰이 숫자인지 확인하는 메서드
		char ch;
		for (int i = 0; i < str.length(); i++) { //토큰을 전달받아 문자열 길이만큼 반복
			// str에 숫자 아닌값이 있는지 charAt으로 확인
			ch = str.charAt(i);
			
			if('0'>ch ||ch>'9') {//ch가 숫자인지 검사(유니코드로 비교)
				return true;//숫자가 아닌 문자가 발견됨
			}
		}
		return false;
	}

	public static void main(String[] args) {
		// 사칙연산 계산
		// 입력순서대로 계산
		// 1) 연산자가 숫자보다 먼저 입력받는경우와
		// 2) 연산자가 동시에 나오는 경우
		// 3) 연산자로 끝나는 경우는
		// 재입력한다.

		Scanner s = new Scanner(System.in);

		int result = 0; // 결과값
		String str, token_str;
		// 재입력 받기위한 반복문
		input_loop: while (true) {
			System.out.println("수식입력=> ");
			// 입력받은 연산
			str = s.next().trim();
		
			// stringtokenizer 사용
			StringTokenizer token = new StringTokenizer(str, "+-*/", true);
			token_str = token.nextToken(); // 첫번째 토큰 읽음

			if (input_check(token_str))// input_check (): 토큰이 숫자인지 검사
			{
				System.out.println("수식입력오류(1)!!\n"); // 토큰이 숫자가 아님
				continue; // input_loop 마지막으로 이동
			}

			result = Integer.parseInt(token_str); // 토큰을 숫자로 변환
			while (token.hasMoreTokens()) {
				token_str = token.nextToken(); // 짝수번째 토큰읽음 (연산자)
				char ch = token_str.charAt(0); // 문자열에서 연산자 추출
				if (token.hasMoreTokens()) {
					token_str = token.nextToken();	//홀수번째 토큰읽음(숫자)
				}
				else {
					System.out.println("수식입력오류(2)!!\n");	//연산자로 수식이 끝남
					continue input_loop;
				}
				
				if(input_check(token_str))//input_check()토큰이 숫자인지 검사
				{
					System.out.println("수식입력오류(3)!!\n");
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
						System.out.println("나눗셈 오류!!\n");
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
//				// 첫번째 토큰이 숫자인가
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
//					// 숫자가 아닌 토큰을 operList에 추가
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
//					// 올바른 형태가 아니라면 재입력한다.
//				}
//			}
//			System.out.println(result);
		}//while(true)
		System.out.println(str+" = "+result);
	}

}
