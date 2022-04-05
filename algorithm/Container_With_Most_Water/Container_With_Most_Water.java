package ex;

public class Container_With_Most_Water {
	/*
	 * You are given an integer array height of length n. There are n vertical lines
	 * drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
	 * 
	 * Find two lines that together with the x-axis form a container, such that the
	 * container contains the most water.
	 * 
	 * Return the maximum amount of water a container can store.
	 * 
	 * Notice that you may not slant the container.
	 * 
	 * Example 1: 
	 * Input: height = [1,8,6,2,5,4,8,3,7] Output: 49 
	 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. 
	 * In this case, the max area of water (blue section) the container can contain is 49.
	 * 
	 * Example 2:
	 * Input: height = [1,1] Output: 1
	 * 
	 * Constraints:
	 * n == height.length 
	 * 2 <= n <= 105 
	 * 0 <= height[i] <= 104
	 */
	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

		System.out.println(maxArea(height));
	}

	public static int maxArea(int[] height) {

		int most_water = 0; // 최대 물의 양을 저장할 변수
		int i = 0; // index
		int j = height.length - 1; // index

		while (i < j) {
			/*
			 * int y = Math.min(height[i], height[j]); // 높이(세로축)
			 * int x = j - i; // 너비(가로축)
			 * int temp_water = y * x; // 임시 물의 양 
			 * most_water = Math.max(most_water, temp_water); // 최대값 저장
			 */
			most_water = Math.max(most_water,  Math.min(height[i], height[j]) * (j - i));

			if (height[i] < height[j]) // 높이가 낮은 index를 옮김
				i++;
			else if (height[i] > height[j])
				j--;
			else { // 높이가 같을 경우 index를 모두 옮김
				i++;
				j--;
			}
		}
		return most_water;
	}
}
