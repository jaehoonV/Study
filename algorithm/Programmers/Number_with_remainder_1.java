package ex_programmers;

public class Number_with_remainder_1 {
	
	/*
	 * 프로그래머스 - 나머지가 1이 되는 수 찾기 (월간 코드 챌린지 시즌3)
	 * https://programmers.co.kr/learn/courses/30/lessons/87389
	 */
	
	public static void main(String[] args) {
		int n = 10;
		int n1 = 12;
		
		System.out.println(solution(n));
		System.out.println(solution(n1));
	}

	private static int solution(int n) {
		int i = 2;
        int answer = 0;
        while(true){
            if(n % i == 1){
                answer = i;
                break;
            } 
            i++;
        }
        return answer;
	}
}
