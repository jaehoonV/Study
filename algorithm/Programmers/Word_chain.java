package ex_programmers;

import java.util.ArrayList;

public class Word_chain {
	
	/*
	 * 프로그래머스 - 영어 끝말잇기(Summer/Winter Coding(~2018))
	 * https://programmers.co.kr/learn/courses/30/lessons/12981
	 */

	public static void main(String[] args) {
		int n = 3;
		String[] words = { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" };
		int[] output = solution(n, words);

		int n1 = 5;
		String[] words1 = { "hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure",
				"establish", "hang", "gather", "refer", "reference", "estimate", "executive" };
		int[] output1 = solution(n1, words1);

		int n2 = 2;
		String[] words2 = { "hello", "one", "even", "never", "now", "world", "draw" };
		int[] output2 = solution(n2, words2);

		System.out.println(output[0] + ", " + output[1]);
		System.out.println(output1[0] + ", " + output1[1]);
		System.out.println(output2[0] + ", " + output2[1]);
	}

	private static int[] solution(int n, String[] words) {
		int[] answer = { 0, 0 }; // 초기값

		ArrayList<String> list = new ArrayList<>();
		list.add(words[0]);
		int i = 1;
		while (i < words.length) {
			// 이전글자의 끝문자와 현재글자의 첫문자 비교
			if (words[i - 1].charAt(words[i - 1].length() - 1) == words[i].charAt(0)) {
				if (!list.contains(words[i])) { // 중복 체크
					list.add(words[i]);
					i++;
				} else {
					answer[0] = i % n + 1; // 위치
					answer[1] = i / n + 1; // 횟수
					return answer;
				}
			} else {
				answer[0] = i % n + 1; // 위치
				answer[1] = i / n + 1; // 횟수
				return answer;
			}
		}
		return answer;
	}
}
