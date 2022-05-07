package ex;

public class Number124 {
	
	/*
	 * 프로그래머스 - 124 나라의 숫자
	 * https://programmers.co.kr/learn/courses/30/lessons/12899
	 */

	public static void main(String[] args) {

		// int n = 500000000;
		int n = 20;

		System.out.println(solution(n));
	}

	private static String solution(int n) {

		String output = "";

		while (n > 0) {
			if (n % 3 == 0) {
				output = "4" + output;
				n--; // 3으로 나누어 떨어질 경우 자리수 바뀜
			} else if (n % 3 == 2) {
				output = "2" + output;
			} else {
				output = "1" + output;
			}
			n /= 3;
		}

		return output;
	}
}
