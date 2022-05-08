package ex_programmers;

public class Target_number {
	
	/*
	 * 프로그래머스 - 타겟 넘버(깊이/너비 우선 탐색(DFS/BFS))
	 * https://programmers.co.kr/learn/courses/30/lessons/43165
	 */
	
	public static void main(String[] args) {
		int[] numbers = {4, 1, 2, 1};
		int target = 4;
		
		System.out.println(solution(numbers, target));
	}
	public static int answer = 0;

	private static int solution(int[] numbers, int target) {
		
		dfs(0,0, numbers,target);
		
        return answer;
	}

	private static void dfs(int i, int sum, int[] numbers, int target) {
		
		if(i == numbers.length) { // 모두 탐색했을 때
			if(sum == target) { // 합계가 target일 경우 answer++
				answer++;
			}
			return;
		}
		
		int plus = sum+numbers[i]; // 다음 값을 +
		int minus = sum-numbers[i]; // 다음 값을 -
		
		dfs(i+1,plus,numbers,target);
		dfs(i+1,minus,numbers,target);
		
	}

}
