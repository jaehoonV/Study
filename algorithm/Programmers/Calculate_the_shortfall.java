package ex_programmers;

public class Calculate_the_shortfall {
	
	/*
	 * 프로그래머스 - 부족한 금액 계산하기 (위클리 챌린지)
	 * https://school.programmers.co.kr/learn/courses/30/lessons/82612
	 */
	
	public static void main(String[] args) {
		int price = 3;
		int money = 20;
		int count = 4;	
		
		System.out.println(solution(price, money, count));
	}

	private static long solution(int price, int money, int count) {
		long temp = 0;
        
        for(int i = 1; i <= count; i++){
            temp += price * i;
        }
        
        long answer = (long)money - temp;
        
        return answer < 0 ? answer * -1 : 0;
	}

}
