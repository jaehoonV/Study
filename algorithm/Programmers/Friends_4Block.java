package ex_programmers;

public class Friends_4Block {

	public static void main(String[] args) {
		
		/*
		 * 프로그래머스 - 프렌즈4블록 (2018 KAKAO BLIND RECRUITMENT)
		 * https://school.programmers.co.kr/learn/courses/30/lessons/17679
		 */

		int m = 4;
		int n = 5;
		String[] board = { "CCBDE", "AAADE", "AAABF", "CCBBF" };

		System.out.println(solution(m, n, board));

		int m1 = 6;
		int n1 = 6;
		String[] board1 = { "TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ" };

		System.out.println(solution(m1, n1, board1));
	}

	private static int solution(int m, int n, String[] board) {

		int answer = 0;

		// 2차원 배열 생성
		char[][] arr = new char[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = board[i].charAt(j);
			}
		}

		while (true) {
			int a = 0; // 지워지는 블록 수
			int[][] temp = new int[m][n];
			char[][] c_temp = new char[m][n];

			for (int i = 0; i < m - 1; i++) { // 블록 지우는 로직
				for (int j = 0; j < n - 1; j++) {
					if (arr[i][j] != '-' && arr[i][j] == arr[i + 1][j] && arr[i][j] == arr[i][j + 1]
							&& arr[i][j] == arr[i + 1][j + 1]) {
						temp[i][j] = 1;
						temp[i + 1][j] = 1;
						temp[i][j + 1] = 1;
						temp[i + 1][j + 1] = 1;
					} else {
						if (temp[i][j] != 1) {
							temp[i][j] = 0;
						}
					}
				}
			}

			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (temp[i][j] == 1) {
						arr[i][j] = '-';
						a++;
					}
				}
			}

			if (a == 0)
				break; // 지울 블록이 없으면 break;

			for (int i = 0; i < n; i++) { // '-'칸이면 값을 아래로 저장
				int index = m - 1;
				for (int j = m - 1; j >= 0; j--) {
					for (; index >= 0 && arr[index][i] == '-'; index--)
						;
					if (index >= 0) {
						c_temp[j][i] = arr[index--][i];
					} else {
						c_temp[j][i] = '-';
					}
				}
			}
			for (int y = 0; y < m; y++) {
				for (int x = 0; x < n; x++) {
					arr[y][x] = c_temp[y][x];
				}
			}

			answer += a;
		}

		return answer;
	}

}
