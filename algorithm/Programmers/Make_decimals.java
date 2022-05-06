package ex_programmers;

public class Make_decimals {
	
	/*
	 * 프로그래머스 - 소수만들기(Summer/Winter Coding(~2018))
	 * https://programmers.co.kr/learn/courses/30/lessons/12977
	 */

	public static void main(String[] args) {
		int[] nums = { 1, 2, 7, 6, 4 };

		System.out.println(solution(nums));
	}

	private static int solution(int[] nums) {
		int answer = 0;

		for (int i = 0; i < nums.length - 2; i++) {
			for (int j = i + 1; j < nums.length - 1; j++) {
				for (int k = j + 1; k < nums.length; k++) {
					int temp = 2; // 소수 판별을 위한 변수
					int num3 = nums[i] + nums[j] + nums[k]; // 3개의 수의 합
					boolean b = true; // 소수 판별
					while (temp < num3) {
						if (num3 % temp == 0) { // 소수 판별
							b = false;
							break;
						}
						temp++;
					}
					if (b) { // 소수일 경우 answer + 1
						answer++;
					}
				}
			}
		}

		return answer;
	}
}
