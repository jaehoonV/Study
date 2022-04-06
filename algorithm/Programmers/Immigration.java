package ex;

import java.util.Arrays;

public class Immigration {
	
	/*
	 * 프로그래머스 - 이분탐색 (입국심사) https://programmers.co.kr/learn/courses/30/lessons/43238
	 * 문제 설명 n명이 입국심사를 위해 줄을 서서 기다리고 있습니다. 
	 * 각 입국심사대에 있는 심사관마다 심사하는데 걸리는 시간은 다릅니다.
	 * 
	 * 처음에 모든 심사대는 비어있습니다. 한 심사대에서는 동시에 한 명만 심사를 할 수 있습니다. 
	 * 가장 앞에 서 있는 사람은 비어 있는 심사대로 가서 심사를 받을 수 있습니다. 
	 * 하지만 더 빨리 끝나는 심사대가 있으면 기다렸다가 그곳으로 가서 심사를 받을 수도 있습니다.
	 * 
	 * 모든 사람이 심사를 받는데 걸리는 시간을 최소로 하고 싶습니다.
	 * 
	 * 입국심사를 기다리는 사람 수 n, 각 심사관이 한 명을 심사하는데 걸리는 시간이 담긴 배열 times가 매개변수로 주어질 때, 모든 사람이
	 * 심사를 받는데 걸리는 시간의 최솟값을 return 하도록 solution 함수를 작성해주세요.
	 * 
	 * 제한사항 
	 * 입국심사를 기다리는 사람은 1명 이상 1,000,000,000명 이하입니다. 
	 * 각 심사관이 한 명을 심사하는데 걸리는 시간은 1분
	 * 이상 1,000,000,000분 이하입니다. 
	 * 심사관은 1명 이상 100,000명 이하입니다.
	 */

	public static void main(String[] args) {
//		int n = 6;
//		int[] times = {7, 10};

		int n = 10;
		int[] times = { 6, 8, 10 };
		System.out.println(solution(n, times));
	}

	private static long solution(int n, int[] times) {

		long answer = 0;

		Arrays.sort(times); // 정렬

		long left = 0;
		long right = (long)times[times.length - 1] * (long)n; // 최대 시간

		while (left <= right) { // 이진 탐색
			long mid = (left + right) / 2;

			long people = 0; // 심사받은 사람을 count할 변수

			for (int temp : times) {
				people += mid / temp; // count 누적
				if (people >= n)
					break;
			}

			if (people >= n) { // 심사 받아야 할 사람보다 심사받은 사람이 많은 경우
				answer = mid;
				right = mid - 1;
			} else { // 심사 받아야 할 사람보다 심사받은 사람이 적은 경우
				left = mid + 1;
			}
		}
		return answer;
	}
}
