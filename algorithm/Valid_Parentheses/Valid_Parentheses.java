package ex;

import java.util.Stack;

public class Valid_Parentheses {
	/*
	 * Given a string s containing just the characters '(', ')', '{', '}', '[' and
	 * ']', determine if the input string is valid.
	 * 
	 * An input string is valid if:
	 * 1. Open brackets must be closed by the same type of brackets. 
	 * 2. Open brackets must be closed in the correct order.
	 * 
	 * Example 1:
	 * Input: s = "()" 
	 * Output: true 
	 * 
	 * Example 2: 
	 * Input: s = "()[]{}"
	 * Output: true 
	 * 
	 * Example 3: 
	 * Input: s = "(]" 
	 * Output: false
	 */
	
	public static void main(String[] args) {
		// input, output, stack 생성
		String input = "()";
//		String input = "()[]{}";
//		String input = "(]";
		boolean output = true;
		Stack<Character> stack = new Stack<>();
		
		for (char c : input.toCharArray()) {
			if (c == '{') {
				stack.push('}');
			} else if (c == '[') {
				stack.push(']');
			} else if (c == '(') {
				stack.push(')');
			} else {
				if (stack.isEmpty() || c != stack.pop()) {
					output = false;
				}
			}
		}
		
		System.out.println(output);
	}
}
