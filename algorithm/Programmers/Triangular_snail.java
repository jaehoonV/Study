package ex_programmers;

public class Triangular_snail {
	
	/*
	 * 프로그래머스 - 삼각 달팽이 (월간 코드 챌린지 시즌1)
	 * https://programmers.co.kr/learn/courses/30/lessons/68645
	 */

	public static void main(String[] args) {
		int n = 5;

		int[] output = solution(n);

		for (int i : output) {
			System.out.print(i + ", ");
		}
	}

	private static int[] solution(int n) {
		int[][] temp = new int[n][n]; // 2차원 배열로 저장
		int start = 1; // 시작 
		int end = n * (n + 1) / 2; // 마지막 수
		int row = 0; // 행
		int col = 0; // 열
		temp[0][0] = 1;

		while (start < end) {
			while (row + 1 < n && temp[row + 1][col] == 0) {
				temp[++row][col] = ++start; // 왼쪽
			}
			while (col + 1 < n && temp[row][col + 1] == 0) {
				temp[row][++col] = ++start; // 오른쪽
			}
			while (row - 1 > 0 && col - 1 > 0 && temp[row - 1][col - 1] == 0) {
				temp[--row][--col] = ++start; // 아래
			}
		}
		
		// 1차원 배열로 변환하고 반환
		int[] output = new int[start];
		int i = 0;
		for (int j = 0; j < n; j++) {
			for (int k = 0; k < n; k++) {
				if (temp[j][k] == 0) {
					continue;
				}
				output[i++] = temp[j][k];
			}
		}
		return output;

	}

}
