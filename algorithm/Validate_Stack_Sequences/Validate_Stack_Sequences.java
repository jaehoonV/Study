package ex;

import java.util.Stack;

public class Validate_Stack_Sequences {
	/*
	 * Given two integer arrays pushed and popped each with distinct values, return
	 * true if this could have been the result of a sequence of push and pop
	 * operations on an initially empty stack, or false otherwise. 
	 * 
	 * Example 1:
	 * Input: pushed = [1,2,3,4,5], popped = [4,5,3,2,1] 
	 * Output: true 
	 * Explanation: 
	 * We might do the following sequence: push(1), push(2), push(3), push(4), pop()
	 * -> 4, push(5), pop() -> 5, pop() -> 3, pop() -> 2, pop() -> 1 
	 * 
	 * Example 2:
	 * Input: pushed = [1,2,3,4,5], popped = [4,3,5,1,2] 
	 * Output: false 
	 * Explanation: 1 cannot be popped before 2.
	 * 
	 * Constraints:
	 * 1 <= pushed.length <= 1000 
	 * 0 <= pushed[i] <= 1000 
	 * All the elements of pushed are unique. 
	 * popped.length == pushed.length 
	 * popped is a permutation of pushed.
	 */
	
	public static void main(String[] args) {
		// input값, stack 생성
//		int[] pushed = {1,2,3,4,5};
//		int[] popped = {4,5,3,2,1};
		
		int[] pushed = {1,2,3,4,5};
		int[] popped = {4,3,5,1,2};
		
		Stack<Integer> stack = new Stack<>();
		
		int j = 0;
		for(int i = 0; i <pushed.length; i++) {
			stack.push(pushed[i]); // pushed[]을 차례대로 stack에 push
			
			while(!stack.isEmpty() && stack.peek() == popped[j]) { //push할 값과 popped[]의 값이 같다면 
				stack.pop(); // stack pop하고 j값 1 증가
				j++;
			}
		}
		
		System.out.println(stack.isEmpty()); //stack에 값이 남아있을 경우 false
	}
}
