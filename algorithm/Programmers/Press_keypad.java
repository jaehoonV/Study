package ex_programmers;

public class Press_keypad {
	
	/*
	 * 프로그래머스 - 키패드 누르기(2020 카카오 인턴십)
	 * https://programmers.co.kr/learn/courses/30/lessons/67256
	 */

	public static void main(String[] args) {
		int[] numbers = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		String hand = "right";

		System.out.println(solution(numbers, hand));
	}

	static int[][] keypad = { // keypad 2차원 정적 배열 선언
			{ 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 }, { 10, 0, 10 } };

	private static String solution(int[] numbers, String hand) {

		// 초기 엄지손가락 위치
		int[] left_p = { 3, 0 };
		int[] right_p = { 3, 2 };

		StringBuilder answer = new StringBuilder();

		for (int n : numbers) {
			answer.append(rule(n, hand, left_p, right_p));
		}

		return answer.toString();

	}

	private static String rule(int n, String hand, int[] left_p, int[] right_p) {

		int[] temp = new int[2];

		loop: for (int i = 0; i < 4; i++) { // n의 index를 찾기 위한 loop
			for (int j = 0; j < 3; j++) {
				if (keypad[i][j] == n) {
					temp = new int[] { i, j };
					break loop;
				}
			}
		}

		if (temp[1] == 0) { // 1,4,7 입력일 경우
			left_p[0] = temp[0];
			left_p[1] = 0;
			return "L"; // L 반환
		} else if (temp[1] == 2) { // 3,6,9 입력일 경우
			right_p[0] = temp[0];
			right_p[1] = 2;
			return "R"; // R 반환
		} else { // 2,5,8,0 입력일 경우 해당 입력과의 거리를 구함
			int ld = Math.abs(temp[0] - left_p[0]) + Math.abs(temp[1] - left_p[1]);
			int rd = Math.abs(temp[0] - right_p[0]) + Math.abs(temp[1] - right_p[1]);
			if (ld < rd) {
				left_p[0] = temp[0];
				left_p[1] = 1;
				return "L";
			} else if (ld > rd) {
				right_p[0] = temp[0];
				right_p[1] = 1;
				return "R";
			} else { // 왼손 엄지손가락과 오른손 엄지손가락의 거리가 같을 경우 hand로 판별함
				if (hand.equals("left")) {
					left_p[0] = temp[0];
					left_p[1] = 1;
					return "L";
				} else {
					right_p[0] = temp[0];
					right_p[1] = 1;
					return "R";
				}
			}

		}
	}
}
