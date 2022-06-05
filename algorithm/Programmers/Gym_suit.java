package ex_programmers;

import java.util.Arrays;

public class Gym_suit {
	
	/*
	 * 프로그래머스 - 체육복 (탐욕법)
	 * https://programmers.co.kr/learn/courses/30/lessons/42862
	 */

	public static void main(String[] args) {
		int n = 5;
		// int[] lost = { 2, 4 };
		// int[] reserve = { 1, 3, 5 };
		int[] lost = { 2, 4 };
		int[] reserve = { 3 };

		System.out.println(solution(n, lost, reserve));
	}

	private static int solution(int n, int[] lost, int[] reserve) {

		int answer = n - lost.length; // 체육복을 가진 학생

		for (int i = 0; i < lost.length; i++) {
			for (int j = 0; j < reserve.length; j++) {
				if (lost[i] == reserve[j]) { // 체육복이 2 - 1 인 학생
					lost[i] = 0; // 비교하지 못하게 0으로 저장
					reserve[j] = 31; // 비교하지 못하게 31로 저장
					answer++;
					break;
				}
			}
		}
		// -1부터 체크하기 위해 정렬함
		Arrays.sort(lost);
		Arrays.sort(reserve);

		for (int i = 0; i < lost.length; i++) {
			if (search(lost[i], reserve, n))
				answer++;
		}

		return answer;
	}

	private static boolean search(int lost, int[] reserve, int n) {
		int a = 0;
		int b = 0;

		if (lost > 1) {
			a = lost - 1;
		}
		if (lost != n) {
			b = lost + 1;
		}

		for (int i = 0; i < reserve.length; i++) {
			// 체육복을 빌려줄 앞뒤 학생이 있을 경우 
			if (reserve[i] == a || reserve[i] == b) {
				reserve[i] = 31;
				return true;
			}
		}

		return false;
	}

}
