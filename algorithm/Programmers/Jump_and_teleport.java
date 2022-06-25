package ex_programmers;

public class Jump_and_teleport {
	
	/*
	 * 프로그래머스 - 점프와 순간이동(Summer/Winter Coding(~2018))
	 * https://programmers.co.kr/learn/courses/30/lessons/12980
	 */

	public static void main(String[] args) {
		int n = 5;

		System.out.println(solution(n));
	}

	public static int solution(int n) {

		int ans = 0;
		while (n > 0) {
			ans += n % 2;
			n /= 2;
		}

		return ans;
	}

}
