package ex;

import java.util.ArrayList;
import java.util.Collections;

public class Biggest_number {
	
	/*
	 * 프로그래머스 - 정렬 (가장 큰 수) https://programmers.co.kr/learn/courses/30/lessons/42746
	 * 0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.
	 * 
	 * 예를 들어, 주어진 정수가 [6, 10, 2]라면 [6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고, 
	 * 이중 가장 큰 수는 6210입니다.
	 * 
	 * 0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때, 순서를 재배치하여 만들 수 있는 
	 * 가장 큰 수를 문자열로 바꾸어 return 하도록 solution 함수를 작성해주세요.
	 * 
	 * 제한 사항 numbers의 길이는 1 이상 100,000 이하입니다. numbers의 원소는 0 이상 1,000 이하입니다. 
	 * 정답이 너무 클 수 있으니 문자열로 바꾸어 return 합니다.
	 */

	public static void main(String[] args) {
		int[] numbers = { 6, 10, 2 };
		System.out.println(solution(numbers));
	}

	public static String solution(int[] numbers) {
		String answer = "";
		// numbers string 배열로 변환
		ArrayList<String> Numbers_to_string = new ArrayList<String>();
		for (Integer num : numbers) Numbers_to_string.add(String.valueOf(num));
		
		// 내림차순 정렬 (ex. 610 compare 106)
		Collections.sort(Numbers_to_string, (a, b) -> (b + a).compareTo(a + b));
		// '0' 으로 시작하는경우 '0' 반환
		if (Numbers_to_string.get(0).startsWith("0")) return "0";
		// 배열 합쳐서 string으로 반환
		for (String s : Numbers_to_string) {
			answer += s;
		}
		return answer;
	}
}
