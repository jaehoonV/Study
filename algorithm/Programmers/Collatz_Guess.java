package ex_programmers;

public class Collatz_Guess {

	public static void main(String[] args) {
		int n = 6;
		int n1 = 16;
		int n2 = 626331;

		System.out.println(solution(n));
		System.out.println(solution(n1));
		System.out.println(solution(n2));
	}

	private static int solution(int num) {
		int answer = 0;
		
		long n = num;
		
		if(n == 1) return 0;

		while (n != 1) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n = n * 3 + 1;
			}
			answer++;
			if(answer > 500) return -1;
		}

		return answer;
	}

}
