package ex;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

	/*
	 * Given an array nums of distinct integers, return all the possible
	 * permutations. You can return the answer in any order.
	 * 
	 * Example 1: Input: nums = [1,2,3]
	 * Output:[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
	 * 
	 * Example 2: Input: nums = [0,1] Output: [[0,1],[1,0]]
	 * 
	 * Example 3: Input: nums = [1] Output: [[1]]
	 * 
	 * 1 <= nums.length <= 6 -10 <= nums[i] <= 10 All the integers of nums are
	 * unique.
	 */

	public static void main(String[] args) {

		// permute list, nums 생성
		List<List<Integer>> permute = new ArrayList<>();
		int[] nums = { 1, 2, 3 };
		
		// backtrack 함수 실행
		backtrack(permute, new ArrayList<>(), nums);

		System.out.println(permute);
	}
	
	// 백트래킹(backtracking)
	private static void backtrack(List<List<Integer>> permute, List<Integer> tempList, int[] nums) {
		if (tempList.size() == nums.length) { // 모든 요소를 포함하는 경우
			permute.add(new ArrayList<>(tempList)); // permute에 저장
		} else {
			for (int i = 0; i < nums.length; i++) {
				if (tempList.contains(nums[i]))
					continue; // 이미 요소가 포함될 경우 스킵
				tempList.add(nums[i]); // 아닐 경우 tempList 요소를 추가
				backtrack(permute, tempList, nums); // 재귀 함수
				tempList.remove(tempList.size() - 1); // 모든 요소가 추가되었다면 마지막 요소를 제거
			}
		}
	}
}
