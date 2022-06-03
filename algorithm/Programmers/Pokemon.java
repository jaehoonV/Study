package ex_programmers;

import java.util.HashMap;

public class Pokemon {
	
	/*
	 * 프로그래머스 - 포켓몬 (찾아라 프로그래밍 마에스터)
	 * https://programmers.co.kr/learn/courses/30/lessons/1845
	 */

	public static void main(String[] args) {
		int[] nums = { 3, 3, 3, 2, 2, 4 };

		System.out.println(Solution(nums));
	}

	private static int Solution(int[] nums) {
		int a = nums.length / 2; // 가질 수 있는 수
		HashMap<Integer, Integer> hm = new HashMap<>();

		for (int n : nums) { // HashMap에 담음
			hm.put(n, hm.getOrDefault(n, 0) + 1);
		}

		return hm.size() < a ? hm.size() : a;
	}

}
