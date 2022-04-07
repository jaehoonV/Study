package ex;

import java.util.Collections;
import java.util.PriorityQueue;

public class Last_Stone_Weight {
	
	/*
	 * You are given an array of integers stones where stones[i] is the weight of
	 * the ith stone.
	 * 
	 * We are playing a game with the stones. On each turn, we choose the heaviest
	 * two stones and smash them together. Suppose the heaviest two stones have
	 * weights x and y with x <= y. The result of this smash is:
	 * 
	 * If x == y, both stones are destroyed, and If x != y, the stone of weight x is
	 * destroyed, and the stone of weight y has new weight y - x. At the end of the
	 * game, there is at most one stone left.
	 * 
	 * Return the smallest possible weight of the left stone. If there are no stones
	 * left, return 0.
	 * 
	 * Example 1:
	 * Input: stones = [2,7,4,1,8,1] Output: 1
	 * 
	 * Example 2:
	 * Input: stones = [1] Output: 1
	 * 
	 * Constraints:
	 * 1 <= stones.length <= 30 
	 * 1 <= stones[i] <= 1000
	 */
			
	public static void main(String[] args) {

		int[] stones = { 2, 7, 4, 1, 8, 1 };
		// int[] stones = { 1 };
		// int[] stones = { 3, 7, 2 };
		System.out.println(lastStoneWeight(stones));
	}

	public static int lastStoneWeight(int[] stones) {
		
		// 우선순위가 높은 순으로 정렬
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		
		for (int st : stones) { // 우선순위 큐에 값 추가
            pq.add(st);
        }

		while (pq.size() > 1) {
			int x = pq.poll(); // poll : 우선순위가 높은 값을 반환하고 큐에서 삭제
			int y = pq.poll();
			if (x - y > 0) { 
				pq.add(x - y); // 뺀 값을 추가
			}
		}

		return pq.size() > 0 ? pq.poll() : 0;
	}
}
