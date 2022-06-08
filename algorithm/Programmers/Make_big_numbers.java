package ex_programmers;

public class Make_big_numbers {
	
	/*
	 * 프로그래머스 - 큰 수 만들기 (탐욕법)
	 * https://programmers.co.kr/learn/courses/30/lessons/42883
	 */

	public static void main(String[] args) {
		String number = "4177252841";
		int k = 4;

		String number1 = "1231234";
		int k1 = 3;

		System.out.println(solution(number, k));
		System.out.println(solution(number1, k1));
	}

	private static String solution(String number, int k) {
		StringBuilder sb = new StringBuilder();

		int temp = 0; // 범위를 위한 변수
		int n = number.length() - k; // 선택할 개수

		for (int i = 0; i < n; i++) {
			int max = 0; // 최대값을 저장 변수
			for (int j = temp; j <= k + i; j++) { // 범위안에서 가장 큰 수를 찾기 위한 반복문
				if (max < number.charAt(j)-'0') {
					max = number.charAt(j)-'0';
					temp = j + 1;
				}
			}
			sb.append(max); // 가장 큰 수를 저장
		}
		return sb.toString();
	}
}
