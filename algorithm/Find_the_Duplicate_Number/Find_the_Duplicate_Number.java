package ex;

public class Find_the_Duplicate_Number {
	
	
	public static void main(String[] args) {
		int[] nums = {1,3,4,2,2};
		
		int output = 0;
		
		for(int i = 0; i < nums.length; i++) {
			int s = nums[nums[i]];
			nums[nums[i]] = nums[i];
			nums[i] = s;
			
		}
		for(int i = 0; i < nums.length; i++) {
			System.out.print(nums[i]);
		}
		System.out.println();
		System.out.println(output);
		
	}
}
