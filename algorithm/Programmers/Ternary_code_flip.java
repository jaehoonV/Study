package ex_programmers;

public class Ternary_code_flip {
	
	/*
	 * 프로그래머스 - 3진법 뒤집기 (월간 코드 챌린지 시즌1)
	 * https://programmers.co.kr/learn/courses/30/lessons/68935
	 */

	public static void main(String[] args) {
		int n = 45;
		int n1 = 125;

		System.out.println(solution(n));
		System.out.println(solution(n1));

	}

	private static int solution(int n) {
		// n을 3진법 char 배열로 생성
		char[] n3 = Integer.toString(n,3).toCharArray();
		
		// flip
		String flip = "";
		for(int i = n3.length -1; i >= 0; i--) {
			flip += n3[i];
		}
		
		// 10진법으로 변환하여 반환
		return Integer.parseInt(flip,3);
	}
}
