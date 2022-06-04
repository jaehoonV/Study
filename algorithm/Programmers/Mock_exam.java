package ex_programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Mock_exam {
	
	/*
	 * 프로그래머스 - 모의고사 (완전탐색)
	 * https://programmers.co.kr/learn/courses/30/lessons/42840
	 */

	public static void main(String[] args) {
		int[] answers = { 1, 3, 2, 4, 2 };
		int[] answers1 = { 1, 2, 3, 4, 5 };

		int[] output = solution(answers);
		int[] output1 = solution(answers1);
		for (int n : output) {
			System.out.print(n + " ");
		}
		System.out.println();
		for (int n : output1) {
			System.out.print(n + " ");
		}
	}

	private static int[] solution(int[] answers) {

		TreeMap<Integer, Integer> tm = new TreeMap<Integer, Integer>();// TreeMap생성

		int[] s1 = { 1, 2, 3, 4, 5 };
		int[] s2 = { 2, 1, 2, 3, 2, 4, 2, 5 };
		int[] s3 = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 };

		int i = 0;
		int s1_i = 0, s2_i = 0, s3_i = 0;

		while (i < answers.length) { // 정답일 경우 TreeMap에 해당 학생의 value +1
			if (answers[i] == s1[s1_i++]) {
				tm.put(1, tm.getOrDefault(1, 0) + 1);
			}
			if (answers[i] == s2[s2_i++]) {
				tm.put(2, tm.getOrDefault(2, 0) + 1);
			}
			if (answers[i] == s3[s3_i++]) {
				tm.put(3, tm.getOrDefault(3, 0) + 1);
			}
			if (s1_i == s1.length)
				s1_i = 0;
			if (s2_i == s2.length)
				s2_i = 0;
			if (s3_i == s3.length)
				s3_i = 0;
			i++;
		}

		// value값으로 내림차순 정렬
		List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(tm.entrySet());
		entryList.sort(((o1, o2) -> tm.get(o2.getKey()) - tm.get(o1.getKey())));

		// 반환할 배열 생성
		ArrayList<Integer> arrayList = new ArrayList<>();
		int dup = entryList.get(0).getValue();
		for (Map.Entry<Integer, Integer> entry : entryList) {
			if(dup == entry.getValue())
				arrayList.add(entry.getKey());
		}

		return arrayList.stream().mapToInt(j->j.intValue()).toArray();
	}

}
