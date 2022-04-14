package ex_programmers;

public class Lottos {
	
	/*
	 * 프로그래머스 - 로또의 최고 순위와 최저 순위(2021 Dev-Matching:웹 백엔드 개발자(상반기))
	 * https://programmers.co.kr/learn/courses/30/lessons/77484
	 */

	public static void main(String[] args) {
		int[] lottos = { 44, 1, 0, 0, 31, 25 };
		int[] win_nums = { 31, 10, 45, 1, 6, 19 };

		// int[] lottos = { 0, 0, 0, 0, 0, 0 };
		// int[] win_nums = { 38, 19, 20, 40, 15, 25 };

		// int[] lottos = { 45, 4, 35, 20, 3, 9 };
		// int[] win_nums = { 20, 9, 3, 45, 4, 35 };

		int[] output = solution(lottos, win_nums);

		for (int out : output) {
			System.out.print(out + " ");
		}
	}

	private static int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];

		int count = 0; // 맞은 로또 번호 카운트 변수 선언
		int zero_count = 0; // 0 카운트 변수 선언

		for (int i = 0; i < 6; i++) {
			if (lottos[i] == 0) {// 0 카운트
				zero_count++;
				continue;
			}
			for (int j = 0; j < 6; j++) {
				if (lottos[i] == win_nums[j]) { // 맞은 로또 번호 카운트
					count++;
					break;
				}
			}
		}
		// 최고 등수로 저장
		if (count + zero_count == 0) answer[0] = 6; 
		else answer[0] = 7 - (count + zero_count);
		
		 // 최저 등수로 저장
		if (count <= 1) answer[1] = 6; 
		else answer[1] = 7 - count;
		
		return answer;
	}

}
