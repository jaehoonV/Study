package ex_programmers;

import java.util.ArrayList;

public class SkillTree {
	
	/*
	 * 프로그래머스 - 스킬트리(Summer/Winter Coding(~2018))
	 * https://programmers.co.kr/learn/courses/30/lessons/49993
	 */

	public static void main(String[] args) {
		String skill = "CBD";
		String[] skill_trees = { "BACDE", "CBADF", "AECB", "BDA" };

		System.out.println(solution(skill, skill_trees));
	}

	private static int solution(String skill, String[] skill_trees) {
		int answer = 0;

		for (int i = 0; i < skill_trees.length; i++) {
			ArrayList<Character> arr = new ArrayList<>();
			String s = skill_trees[i];
			for (int j = 0; j < s.length(); j++) {
				// 문자가 포함되면 ArrayList에 add
				if (skill.contains(String.valueOf(s.charAt(j)))) {
					arr.add(s.charAt(j));
				}
			}
			
			if(compare(arr, skill)) { // 비교
				answer++;
			}
		}
		return answer;
	}

	private static boolean compare(ArrayList<Character> arr, String skill) {
		for(int k = 0; k < arr.size(); k++) {
			if(skill.charAt(k) != arr.get(k)) return false;
		}
		return true;
	}
}
