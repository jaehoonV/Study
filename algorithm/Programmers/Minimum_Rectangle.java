package ex_programmers;

public class Minimum_Rectangle {
	
	/*
	 * 프로그래머스 - 최소직사각형 (완전탐색)
	 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
	 */
	
	public static void main(String[] args) {
		
		int[][] sizes = {{60, 50}, {30, 70}, {60, 30}, {80, 40}};
		
		System.out.println(solution(sizes));
		
	}

	private static int solution(int[][] sizes) {
		int a = 0;
		int b = 0;
		
		for(int i = 0; i < sizes.length; i++) {			
			a = Math.max(Math.max(sizes[i][0], sizes[i][1]), a);
			b = Math.max(Math.min(sizes[i][0], sizes[i][1]), b);
		}
		
        return a * b;
	}

}
