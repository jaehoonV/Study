package ex_programmers;

import java.util.PriorityQueue;

public class More_spicy {
	
	/*
	 * 프로그래머스 - 더 맵게 (힙 Heap)
	 * https://programmers.co.kr/learn/courses/30/lessons/42626
	 */

	public static void main(String[] args) {
		int[] scoville = { 1, 2, 3, 9, 10, 12 };
		int k = 7;

		System.out.println(solution(scoville, k));
	}

	private static int solution(int[] scoville, int k) {
		int answer = 0;
		// 우선순위 큐
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int i : scoville) {
			pq.add(i);
		}

		while (true) {
			int min1 = 0; // 가장 낮은 지수
			int min2 = 0; // 두 번째로 낮은 지수
			if (pq.peek() < k) { // k보다 낮은 지수가 있을 경우
				min1 = pq.poll();
				if (pq.peek() == null) {
					answer = -1;
					break;
				} else {
					min2 = pq.poll();
					pq.add(min1 + min2 * 2);
					answer++;
				}
			} else { // 모든 지수가 k이상이면 break
				break;
			}
		}
		return answer;
	}
}
