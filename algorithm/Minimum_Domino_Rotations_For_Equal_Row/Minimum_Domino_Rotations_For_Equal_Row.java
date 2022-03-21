package ex;

public class Minimum_Domino_Rotations_For_Equal_Row {
	/*
	 * In a row of dominoes, tops[i] and bottoms[i] represent the top and bottom
	 * halves of the ith domino. (A domino is a tile with two numbers from 1 to 6 -
	 * one on each half of the tile.)
	 * 
	 * We may rotate the ith domino, so that tops[i] and bottoms[i] swap values.
	 * 
	 * Return the minimum number of rotations so that all the values in tops are the
	 * same, or all the values in bottoms are the same.
	 * 
	 * If it cannot be done, return -1.
	 * 
	 * Example 1: 
	 * Input: tops = [2,1,2,4,2,2], bottoms = [5,2,6,2,3,2] Output: 2
	 * Explanation: 
	 * The first figure represents the dominoes as given by tops and bottoms: before we do any rotations. 
	 * If we rotate the second and fourth dominoes, we can make every value in the top row 
	 * equal to 2, as indicated by the second figure.
	 * 
	 * Example 2:
	 * Input: tops = [3,5,1,2,3], bottoms = [3,6,3,3,4] Output: -1 
	 * Explanation: In this case, it is not possible to rotate the dominoes to make one row of values equal.
	 * 
	 * Constraints:
	 * 2 <= tops.length <= 2 * 104 
	 * bottoms.length == tops.length 
	 * 1 <= tops[i], bottoms[i] <= 6
	 */
	public static void main(String[] args) {
		
		// tops, bottoms 생성
		int[] tops = {2,1,2,4,2,2};
		int[] bottoms = {5,2,6,2,3,2};
		
		// tops, bottoms의 수를 세는 배열 생성
		int[] count_tops = new int[6];
		int[] count_bottoms = new int[6];
		
		// tops, bottoms의 같은 인덱스에 값이 같을 경우 count하는 배열 생성
		int[] same_num = new int[6];
		int output = -1; // output은 -1로 생성
		int leng = tops.length;
		
		for(int i = 0; i < leng; i++) {
			// tops배열 값 - 1을 저장, bottoms도 같음
			// ex) count_tops[0] = 1을 카운트, count_tops[1] = 2를 카운트 ...
			count_tops[tops[i]-1]++; 
			count_bottoms[bottoms[i]-1]++;
			
			if(tops[i] == bottoms[i]) { // tops와 bottoms의 값이 같을 경우
				same_num[tops[i]-1]++; // count
			}
		}
		
		for(int i = 0; i < same_num.length; i++) {
			// 해당 수의 카운트를 더하고 같은 경우의 카운트를 뺐을 때 배열의 길이와 같다면 rotate가 됨
			if(count_tops[i] + count_bottoms[i] - same_num[i] == leng ) { 
				// 배열의 길이에서 count한 수 중 큰 수를 뺀 값이 rotate한 횟수가 됨
				output =  leng - Math.max(count_tops[i], count_bottoms[i]);
			}
		}
		System.out.println(output);
	}
}
