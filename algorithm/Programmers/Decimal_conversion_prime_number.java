package ex_programmers;

public class Decimal_conversion_prime_number {
	
	/*
	 * 프로그래머스 - k진수에서 소수 개수 구하기(2022 KAKAO BLIND RECRUITMENT)
	 * https://programmers.co.kr/learn/courses/30/lessons/92335
	 */

	public static void main(String[] args) {
		int n = 437674;
		int k = 3;

		int n1 = 110011;
		int k1 = 10;

		System.out.println(solution(n, k));
		System.out.println("---");
		System.out.println(solution(n1, k1));
	}

	private static int solution(int n, int k) {
		int answer = 0;

		// 진법 변환후 char[]로 저장
		char[] conversion = Integer.toString(n, k).toCharArray();

		int i = 0;
		while (i < conversion.length) {
			int j = i;
			String s = ""; // 찾을 값
			while (j < conversion.length) {
				if (conversion[j] != '0') {
					s += conversion[j];
					j++;
					i = j;
				} else { // 0일 경우 추가하지않음
					i++;
					break;
				}
			}
			
			long s_long = 0;
			
			try {
				s_long = Long.parseLong(s); // String - long 변환
			} catch(NumberFormatException e) {
				s_long = 0;
			}catch(Exception e){
	            e.printStackTrace();
	        }
			
			// 소수 판별
			if (s_long != 0) {
				if (distinction(s_long))
					answer++;
			}
		}

		return answer;
	}

	private static boolean distinction(long s_long) { // 소수 판별
		
		if(s_long == 1) return false; // 1은 소수가 아님
		
		// 소수 판별
		for (int l = 2; l <= Math.sqrt(s_long); l++) {
			if (s_long % l == 0)
				return false;
		}
		return true;
	}

}
