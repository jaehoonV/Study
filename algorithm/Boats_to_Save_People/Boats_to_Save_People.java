package ex;

import java.util.Arrays;

public class Boats_to_Save_People {
	/*
	 * You are given an array people where people[i] is the weight of the ith
	 * person, and an infinite number of boats where each boat can carry a maximum
	 * weight of limit. Each boat carries at most two people at the same time,
	 * provided the sum of the weight of those people is at most limit.
	 * 
	 * Return the minimum number of boats to carry every given person.
	 * 
	 * Example 1: Input: people = [1,2], limit = 3 Output: 1 Explanation: 1 boat (1,
	 * 2)
	 * 
	 * Example 2: Input: people = [3,2,2,1], limit = 3 Output: 3 Explanation: 3
	 * boats (1, 2), (2) and (3)
	 * 
	 * Example 3: Input: people = [3,5,3,4], limit = 5 Output: 4 Explanation: 4
	 * boats (3), (3), (4), (5)
	 * 
	 * Constraints: 1 <= people.length <= 5 * 104 1 <= people[i] <= limit <= 3 * 104
	 */
	public static void main(String[] args) {

		// people, limit 생성
		int[] people = { 3, 2, 2, 1 };
		int limit = 3;

		// people 배열의 왼쪽, 오른쪽 index생성
		int left = 0;
		int right = people.length - 1;

		// 합해지는 값 temp, count하는 output 생성
		int temp = 0;
		int output = 0;

		Arrays.sort(people); // 1, 2, 2, 3

		while (left <= right) { // 모든 배열을 다 더했다면 false
			temp = people[left] + people[right]; // 변수에 정렬된 값의 왼쪽, 오른쪽 더 함

			if (limit >= temp) { // 합한 값이 limit보다 작거나 같을 경우
				left++; // left + 1
			}
			output++; // count
			right--; // right - 1
		}
		System.out.println(output);
	}
}
