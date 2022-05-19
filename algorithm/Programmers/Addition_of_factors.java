package ex_programmers;

public class Addition_of_factors {
	
	/*
	 * 프로그래머스 - 약수의 개수와 덧셈(월간 코드 챌린지 시즌2)
	 * https://programmers.co.kr/learn/courses/30/lessons/77884
	 */

	public static void main(String[] args) {
		int left = 13;
		int right = 17;

		System.out.println(solution(left, right));
	}

	private static int solution(int left, int right) {

		int answer = 0;

		for (int i = left; i <= right; i++) {
			int temp = 0; // 약수의 개수를 저장하는 변수 생성
			for (int j = 1; j <= i; j++) {
				if (i % j == 0) // 약수일 경우
					temp++; // temp++
			}
			if (temp % 2 == 0) { // 약수의 개수가 짝수일 경우
				answer += i; // +i
			} else {
				answer -= i; // -i
			}
		}

		return answer;

	}
}
