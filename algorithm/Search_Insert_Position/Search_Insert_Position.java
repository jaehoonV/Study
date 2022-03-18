package ex;

import java.util.Arrays;

public class Search_Insert_Position {
	/*
	 * Given a sorted array of distinct integers and a target value, return the
	 * index if the target is found. If not, return the index where it would be if
	 * it were inserted in order.
	 * 
	 * You must write an algorithm with O(log n) runtime complexity.
	 * 
	 * Example 1:
	 * Input: nums = [1,3,5,6], target = 5 Output: 2 
	 * 
	 * Example 2:
	 * Input: nums = [1,3,5,6], target = 2 Output: 1 
	 * 
	 * Example 3:
	 * Input: nums = [1,3,5,6], target = 7 Output: 4
	 * 
	 * Constraints:
	 * nums contains distinct values sorted in ascending order. 
	 */
	public static void main(String[] args) {
		
		// nums, target, output 생성
		int[] nums = {1,3,5,6}; 
		int target = 7;
		int output = nums.length; 
		
		for(int i = 0; i < nums.length; i++ ) {
			if(target <= nums[i]) { // target이 nums배열의 값보다 작거나 같을 경우
				output = i; // output에 i 저장하고 break
				break;
			}
		}
		
		System.out.println(output);
		
		// Use Arrays.binarySearch
		int index = Arrays.binarySearch(nums, target);
        System.out.println(index >= 0 ? index : -index-1);
	}
}
