package ex;

public class Find_the_Duplicate_Number {
	
	/*
	 * Given an array of integers nums containing n + 1 integers where each integer
	 * is in the range [1, n] inclusive.
	 * 
	 * There is only one repeated number in nums, return this repeated number.
	 * 
	 * You must solve the problem without modifying the array nums and uses only
	 * constant extra space.
	 * 
	 * Example 1:
	 * Input: nums = [1,3,4,2,2] Output: 2 
	 * Example 2:
	 * Input: nums = [3,1,3,4,2] Output: 3
	 * 
	 * Constraints:
	 * nums.length == n + 1 
	 * 1 <= nums[i] <= n 
	 * All the integers in nums appear only once except for precisely one integer 
	 * which appears two or more times.
	 */
	
	public static void main(String[] args) {
		int[] nums = {1,3,4,2,2};
		
		int low = 1, high = nums.length - 1;
		
	    while (low <= high) { // 이진탐색 (Binary Search)
	        int mid = (int) (low + (high - low) * 0.5); // 가운데 숫자를 생성
	        int cnt = 0; 
	        for (int a : nums) { // 가운데 숫자보다 작으면 카운트
	            if (a <= mid) ++cnt;
	        }
	        if (cnt <= mid) low = mid + 1; // 카운트가 가운데 숫자보다 작으면 mid 값을 올리기 위해 low = mid + 1 (우측 탐색)
	        else high = mid - 1; // 카운트가 가운데 숫자보다 크면 mid 값을 내리기 위해 high = mid - 1 (좌측 탐색)
	    }
	    
		System.out.println(low);
		
	}
}
