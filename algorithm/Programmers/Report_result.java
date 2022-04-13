package ex;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Report_result {
	
	/*
	 * 프로그래머스 - 신고 결과 받기( 2022 KAKAO BLIND RECRUITMENT)
	 * https://programmers.co.kr/learn/courses/30/lessons/92334
	 */
	public static void main(String[] args) {
		String[] id_list = { "muzi", "frodo", "apeach", "neo" };
		String[] report = { "muzi frodo", "apeach frodo", "frodo neo", "muzi neo", "apeach muzi" };
		int k = 2;

		String[] id_list_test = { "con", "ryan" };
		String[] report_test = { "ryan con", "ryan con", "ryan con", "ryan con" };
		int k_test = 3;

		int[] sop = solution2(id_list, report, k);
		int[] sop_test = solution(id_list_test, report_test, k_test);

		for (int s : sop) {
			System.out.print(s + " ");
		}
		System.out.println();
		for (int s : sop_test) {
			System.out.print(s + " ");
		}
	}
	
	// 정확성 8.3 테스트 케이스 24개 중 2개 통과
	private static int[] solution(String[] id_list, String[] report, int k) {

		int[] answer = new int[id_list.length];

		// report 중복 제거
		ArrayList<String> list = new ArrayList<String>();
		for (String r : report) {
			if (!list.contains(r)) { // list에 포함되어있는지 아닌지 체크
				list.add(r); // 해당 값이 없으면 넣기
			}
		}
		Map<String, Integer> map = new HashMap<String, Integer>();
		for (int i = 0; i < id_list.length; i++) { // 신고 당한 수를 저장하기 위한 map 생성
			map.put(id_list[i], 0);
		}

		for (int i = 0; i < list.size(); i++) { // 신고 당한 수를 저장
			String result = list.get(i).substring(list.get(i).lastIndexOf(" ") + 1); // 공백 이후의 문자
			map.put(result, map.get(result) + 1); // 해당 key의 value값에 +1
		}

		ArrayList<String> s_id = new ArrayList<String>();
		for (String il : id_list) {
			if (map.get(il) >= k) { // value값이 k 이상일 때 정지 아이디 list에 add
				s_id.add(il);
			}
		}

		for (int i = 0; i < id_list.length; i++) {
			for (int j = 0; j < report.length; j++) { // answer의 index 위치
				if (id_list[i].equals(report[j].substring(0, report[j].lastIndexOf(" ")))) {
					for (int l = 0; l < s_id.size(); l++) { // 정지당한 아이디일 경우 +1
						if (report[j].substring(report[j].lastIndexOf(" ") + 1).equals(s_id.get(l))) {
							answer[i] += 1;
						}
					}
				}
			}
		}

		return answer;
	}
	
	// 정확성 66.7 테스트 케이스 24개 중 16개 통과, 8개 시간 초과
	private static int[] solution2(String[] id_list, String[] report, int k) {

		int[] answer = new int[id_list.length];

		// report 중복 제거
		ArrayList<String> list = new ArrayList<String>();
		for (String r : report) {
			if (!list.contains(r)) { // list에 포함되어있는지 아닌지 체크
				list.add(r); // 해당 값이 없으면 넣기
			}
		}
		
		// 유저 ID와 신고한 ID 맵 생성
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		for (String s : id_list) { 
			ArrayList<String> reported_list = new ArrayList<String>();
			for (int j = 0; j < list.size(); j++) {
				if (s.equals(list.get(j).substring(0, list.get(j).lastIndexOf(" ")))) {
					reported_list.add(list.get(j).substring(list.get(j).lastIndexOf(" ") + 1));
				}
			}
			map.put(s, reported_list);
		}

		// 신고 당한 수를 저장하기 위한 map 생성
		Map<String, Integer> reported_count_map = new HashMap<String, Integer>();
		for (int i = 0; i < id_list.length; i++) { 
			reported_count_map.put(id_list[i], 0);
		}
		for (int i = 0; i < list.size(); i++) { // 신고 당한 수를 저장
			String result = list.get(i).substring(list.get(i).lastIndexOf(" ") + 1); // 공백 이후의 문자
			reported_count_map.put(result, reported_count_map.get(result) + 1); // 해당 key의 value값에 +1
		}
		
		ArrayList<String> s_id = new ArrayList<String>();
		for (String key : reported_count_map.keySet()) {
			if (reported_count_map.get(key) >= k) { // value값이 k 이상일 때 정지 아이디 list에 add
				s_id.add(key);
			}
		}
		
		int answer_index = 0;
		for (String key : id_list) {
			ArrayList<String> value = map.get(key);
			for (String s : s_id) { 
				if (value.contains(s)) { // value에 정지 아이디를 포함하고 있으면 +1
					answer[answer_index] ++;
				}
			}
			answer_index++;
		}

		return answer;
	}

}
