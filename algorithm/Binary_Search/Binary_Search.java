package ex;

public class Binary_Search {
	/*
	 * Given an array of integers nums which is sorted in ascending order, and an
	 * integer target, write a function to search target in nums. If target exists,
	 * then return its index. Otherwise, return -1.
	 * 
	 * You must write an algorithm with O(log n) runtime complexity.
	 * 
	 * Example 1: Input: nums = [-1,0,3,5,9,12], target = 9 Output: 4 Explanation: 9
	 * exists in nums and its index is 4
	 * 
	 * Example 2: Input: nums = [-1,0,3,5,9,12], target = 2 Output: -1 Explanation:
	 * 2 does not exist in nums so return -1
	 * 
	 * 
	 * Constraints: 1 <= nums.length <= 104 -104 < nums[i], target < 104 All the
	 * integers in nums are unique. nums is sorted in ascending order.
	 */
	public static void main(String[] args) {

		int[] nums = { -1, 0, 3, 5, 9, 12 };
		int target = 9;

		int output = -1;

		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == target) {
				output = i;
			}
		}
		
		System.out.println(output);
		System.out.println("--------------Binary_Search----------------");
		
		int[] nums2 = { -1, 0, 2, 3, 9, 14 };
		int target2 = 2;

		int low = 0;
		int high = nums2.length - 1;

		while (low <= high) { // 이진 탐색
			int mid = low + (high - low) / 2;

			if (nums2[mid] > target2) {
				high = mid - 1;
			} else if (nums2[mid] == target2) {
				output = mid;
				break;
			} else {
				low = mid + 1;
			}
		}

		System.out.println(output);

	}
}
