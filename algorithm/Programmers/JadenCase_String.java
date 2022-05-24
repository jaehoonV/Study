package ex_programmers;

public class JadenCase_String {
	
	/*
	 * 프로그래머스 - JadenCase 문자열 만들기
	 * https://programmers.co.kr/learn/courses/30/lessons/12951
	 */

	public static void main(String[] args) {
		String s = "3people unFollowed me";

		System.out.println(solution(s));
	}

	private static String solution(String s) {
		StringBuilder answer = new StringBuilder(); // append하기 위함
		int sign = 1; // 빈 칸 판별을 위한 변수
		
		for(int i=0; i < s.length(); i++) {
			// 숫자일 경우 그대로 append, sign = 0
			if('0' <= s.charAt(i) && s.charAt(i) <= '9') {
				answer.append(s.charAt(i));
				sign = 0;
				continue;
			}
			
			if(s.charAt(i) == ' ') { // 빈 칸일 경우
				answer.append(' '); // 빈 칸 append
				sign = 1; // sign = 1
			}else { // 숫자도 아니고 빈 칸이 아닐 경우
				if(sign == 1) { // sign이 1이면 대문자로 append, 아니면 소문자로 append
					answer.append(Character.toUpperCase(s.charAt(i)));
				}else {
					answer.append(Character.toLowerCase(s.charAt(i)));
				}
				sign = 0;
			}
		}
		
		return answer.toString();
	}

}
