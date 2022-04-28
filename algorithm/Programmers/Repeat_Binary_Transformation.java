package ex_programmers;

import java.util.ArrayList;

public class Repeat_Binary_Transformation {
	/*
	 * 프로그래머스 - 이진 변환 반복하기(월간 코드 챌린지 시즌1)
	 * https://programmers.co.kr/learn/courses/30/lessons/70129
	 */

	public static void main(String[] args) {

		String s = "110010101001";

		int[] answer = solution(s);

		System.out.println(answer[0] + "," + answer[1]);

	}

	public static int[] solution(String s) {
		int[] answer = { 0, 0 };
		
		// ArrayList에 s 담기
		ArrayList<Character> list = new ArrayList<>();
		for (int i = 0; i < s.length(); i++) {
			list.add(s.charAt(i));
		}

		while (true) {
			int i_temp = 0; // 0이 제거된 길이를 저장하는 변수
			for (char s1 : list) {
				if (s1 == '1') {
					i_temp++;
				} else {
					answer[1]++; // 0일 때 ++
				}
			}
			answer[0]++; // 한번 이진 변환이 실행되었을 때 ++
			String s_temp = Integer.toBinaryString(i_temp); // 길이를 이진 변환
			if (s_temp.equals("1")) // 1이 될 때 break;
				break;
			
			// list에 이진 변환한 값을 담음
			list.clear();
			for (int i = 0; i < s_temp.length(); i++) {
				list.add(s_temp.charAt(i));
			}
		}

		return answer;
	}
}
