package ex;

import java.util.Arrays;

public class Kth_number {
	
	/*
	 * 프로그래머스 - 정렬 (K번째수) https://programmers.co.kr/learn/courses/30/lessons/43238
	 * 배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.
	 * 
	 * 예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면
	 * 
	 * array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다. 
	 * 1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다. 
	 * 2에서 나온 배열의 3번째 숫자는 5입니다. 
	 * 배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질때, commands의 모든 원소에 
	 * 대해 앞서 설명한 연산을 적용했을 때 나온 결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
	 * 
	 * 제한사항 
	 * array의 길이는 1 이상 100 이하입니다. 
	 * array의 각 원소는 1 이상 100 이하입니다. 
	 * commands의 길이는 1 이상 50 이하입니다. 
	 * commands의 각 원소는 길이가 3입니다.
	 */

	public static void main(String[] args) {

		int[] array = { 1, 5, 2, 6, 3, 7, 4 };

		int[][] commands = { { 2, 5, 3 }, { 4, 4, 1 }, { 1, 7, 3 } };
		
		int[] answer_print = Solution(array, commands);
		
		for(int p : answer_print) {
		System.out.print(p + " ");
		}
	}

	public static int[] Solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length]; // conmmands의 길이 만큼 answer 배열 생성
		int i = 0;
		int j = 0;
		while(i < commands.length) {
			// array를 특정 index 만큼 추출
			int[] temp_arr = Arrays.copyOfRange(array, commands[i][j]-1, commands[i][j+1]);
			Arrays.sort(temp_arr); // 오름차순 정렬
			answer[i] = temp_arr[commands[i][j+2]-1]; // k번째 수 answer에 저장
			i++;
		}
		return answer;
	}
}
