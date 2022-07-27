package ex_programmers;

import java.util.Stack;

public class Remove_by_pair {
	
	/*
	 * 프로그래머스 - 짝지어 제거하기 (2017 팁스타운)
	 * https://school.programmers.co.kr/learn/courses/30/lessons/12973
	 */

	public static void main(String[] args) {
		String s = "baabaa";
		String s1 = "cdcd";

		System.out.println(solution(s));
		System.out.println(solution(s1));
	}

	private static int solution(String s) {
		
		if(s.length() % 2 != 0) return 0; // 길이가 홀수면 무조건 0 반환
		
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < s.length(); i++) {
            if(!stack.isEmpty() && stack.peek() == s.charAt(i)){
                stack.pop(); // 같은 문자일 경우 pop
            }else{
                stack.push(s.charAt(i)); // 다른 문자일 경우 push
            }
		}

		return stack.size() == 0 ? 1 : 0; // 남아있는 문자가있으면 0 반환
	}

}
