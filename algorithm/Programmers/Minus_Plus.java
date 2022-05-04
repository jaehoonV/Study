package ex_programmers;

public class Minus_Plus {
	
	/*
	 * 프로그래머스 - 음양 더하기(월간 코드 챌린지 시즌2)
	 * https://programmers.co.kr/learn/courses/30/lessons/76501
	 */
	
	public static void main(String[] args) {
		int[] absolutes = {4,7,12};
		boolean[] signs = {true,false,true};
		
		System.out.println(solution(absolutes,signs));
	}

	private static int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		
		for(int i = 0; i < signs.length; i++) {
			if(signs[i] == true) { 
				answer += absolutes[i]; // true일 경우 더 함 
			} else {
				answer -= absolutes[i]; // true가 아닐 경우 뺌
			}
		}
        return answer;
	}

}
