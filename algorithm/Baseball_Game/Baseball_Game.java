package ex;

import java.util.Stack;

public class Baseball_Game {
	
	/*
	 * You are keeping score for a baseball game with strange rules. 
	 * The game consists of several rounds, where the scores of past rounds may affect future rounds' scores.
	 * 
	 * At the beginning of the game, you start with an empty record. 
	 * You are given a list of strings ops, where ops[i] is the ith operation you must apply to the record and is one of the following:
	 * 
	 * 1. An integer x - Record a new score of x. 
	 * 2. "+" - Record a new score that is the sum of the previous two scores. 
	 *    It is guaranteed there will always be two previous scores. 
	 * 3. "D" - Record a new score that is double the previous score.
	 *    It is guaranteed there will always be a previous score. 
	 * 4. "C" - Invalidate the previous score, removing it from the record. 
	 *    It is guaranteed there will always be a previous score. 
	 * 
	 * Return the sum of all the scores on the record.
	 * 
	 * Example 1:
	 * Input: ops = ["5","2","C","D","+"] Output: 30 
	 * Explanation: 
	 * "5" - Add 5 to the record, record is now [5]. 
	 * "2" - Add 2 to the record, record is now [5, 2].
	 * "C" - Invalidate and remove the previous score, record is now [5]. 
	 * "D" - Add 2 * 5 = 10 to the record, record is now [5, 10]. 
	 * "+" - Add 5 + 10 = 15 to the record, record is now [5, 10, 15]. 
	 * The total sum is 5 + 10 + 15 = 30.
	 * 
	 * Constraints:
	 * 1 <= ops.length <= 1000 
	 * ops[i] is "C", "D", "+", or a string representing an integer in the range [-3 * 104, 3 * 104]. 
	 * For operation "+", there will always be at least two previous scores on the record. 
	 * For operations "C" and "D", there will always be at least one previous score on the record.
	 */

	public static void main(String[] args) {
		// String[] ops = { "5", "2", "C", "D", "+" };
		String[] ops = { "5", "-2", "4", "C", "D", "9", "+", "+" };
		// String[] ops = { "1" };
		System.out.println(calPoints(ops));
	}

	public static int calPoints(String[] ops) {

		Stack<Integer> cal_stack = new Stack<Integer>(); // 스택 선언
		int output = 0;
		int i = 0;
		while (i < ops.length) {
			switch (ops[i]) {
			case "C": // "C"일 경우 스택 pop
				cal_stack.pop();
				break;
			case "D": // "D"일 경우 마지막 값의 두 배를 push
				cal_stack.push(cal_stack.peek() * 2);
				break;
			case "+": // "+"일 경우 마지막 값과 마지막 전 값을 더해서 push
				cal_stack.push(cal_stack.peek() + cal_stack.get(cal_stack.size()-2));
				break;
//				int a = cal_stack.peek();
//				cal_stack.pop();
//				int b = cal_stack.peek();
//				cal_stack.push(a);
//				cal_stack.push(a+b);
				
			default: // 숫자일 경우 integer 형변환해서 push
				cal_stack.push(Integer.parseInt(ops[i]));
				break;
			}
			i++;
		}

		for (int c : cal_stack) { // 스택의 모든 값을 더 함
			output += c;
		}

		return output;
	}

}
