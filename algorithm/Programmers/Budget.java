package ex_programmers;

import java.util.Arrays;

public class Budget {
	
	/*
	 * 프로그래머스 - 예산(Summer/Winter Coding(~2018))
	 * https://programmers.co.kr/learn/courses/30/lessons/12982
	 */

	public static void main(String[] args) {
		int[]d = {1,3,2,5,4};
		int budget = 9;
		System.out.println(solution(d,budget));
	}

	private static int solution(int[] d, int budget) {
		
		int answer = 0;
		
		Arrays.sort(d);
		
		for(int i : d) {
			if(budget - i < 0) break;
			budget -= i;
			answer++;
		}
		
        return answer;
	}
}
