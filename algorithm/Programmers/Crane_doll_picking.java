package ex_programmers;

import java.util.Stack;

public class Crane_doll_picking {
	
	/*
	 * 프로그래머스 - 크레인 인형 뽑기(2019 카카오 개발자 겨울 인턴십)
	 * https://programmers.co.kr/learn/courses/30/lessons/64061
	 */

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };
		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };

		System.out.println(solution(board, moves));
	}

	public static int solution(int[][] board, int[] moves) {
		int answer = 0;
		
		// 인형을 담아줄 Stack 배열 선언
		Stack[] game = new Stack[board[0].length];
		
		// 뽑힌 인형을 담아줄 바구니 
		Stack<Integer> bag = new Stack<>();
		
		// 인형 Stack 배열 생성
		for (int i = 0; i < board[0].length; i++) {
			game[i] = new Stack<Integer>();
		}
		for (int i = board.length - 1; i >= 0; i--) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != 0) { // 인형이 있을 경우에만 push
					game[j].push(board[i][j]);
				}
			}
		}
		
		// 인형 뽑기(첫 칸부터 1이기 때문에 'moves[i] - 1' 로 표현)
		for (int i = 0; i < moves.length; i++) {
			if (game[moves[i] - 1].empty()) // 비어있으면 continue
				continue;
			
			// 비어있지 않으면 해당 위치의 Stack pop
			int temp = (int) game[moves[i] - 1].pop();
			
			if (bag.size() == 0) // 바구니에 아무것도 없을 경우
				bag.push(temp); // push
			else {
				if (temp == bag.peek()) { // 맨 위 값을 뽑은 값이 temp랑 같으면
					answer += 2; // 두개의 인형이 사라지기 때문에 +2
					bag.pop(); // pop
				} else // temp랑 다르면
					bag.push(temp); // push
			}
		}
		return answer;
	}
}
