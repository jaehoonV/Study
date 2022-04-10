package ex;

import java.util.Arrays;
import java.util.HashMap;

public class Marathon_runner {
	
	/*
	 * 프로그래머스 - 해시 (완주하지 못한 선수) https://programmers.co.kr/learn/courses/30/lessons/42576
	 * 수많은 마라톤 선수들이 마라톤에 참여하였습니다. 
	 * 단 한 명의 선수를 제외하고는 모든 선수가 마라톤을 완주하였습니다.
	 * 
	 * 마라톤에 참여한 선수들의 이름이 담긴 배열 participant와 완주한 선수들의 이름이 담긴 배열 completion이 
	 * 주어질 때, 완주하지 못한 선수의 이름을 return 하도록 solution 함수를 작성해주세요.
	 * 
	 * 제한사항 
	 * 마라톤 경기에 참여한 선수의 수는 1명 이상 100,000명 이하입니다. 
	 * completion의 길이는 participant의 길이보다 1 작습니다. 
	 * 참가자의 이름은 1개 이상 20개 이하의 알파벳 소문자로 이루어져 있습니다. 
	 * 참가자 중에는 동명이인이 있을 수 있습니다.
	 */

	public static void main(String[] args) {
//		String[] participant = { "leo", "kiki", "eden"};
//		String[] completion = {"eden", "kiki"};
		String[] participant = { "marina", "josipa", "nikola", "vinko", "filipa" };
		String[] completion = { "josipa", "filipa", "marina", "nikola" };
		System.out.println(solution1(participant, completion)); // count 방식 
		System.out.println(solution2(participant, completion)); // 정렬 후 not equals 값 찾는 방식
		System.out.println(solution3(participant, completion)); // HashMap 방식
	}

	// count하는 방식은 효율성 테스트 실패, 정확성 테스트 성공
	public static String solution1(String[] participant, String[] completion) {
        String answer = "";
        int i = 0;
        while(i < participant.length) {
        	int temp_count = 0;
        	int temp_count_c = 0;
        	int j = 0;
        	int k = 0;
        	while(j < participant.length) {
        		if(participant[i].equals(participant[j])) {
        			temp_count++;
        		}
        		j++;
        	}
        	while(k < completion.length) {
        		if(participant[i].equals(completion[k])) {
        			temp_count_c++;
        		}
        		k++;
        	}
        	if(temp_count != temp_count_c) {
        		answer = participant[i];
        		break;
        	}
        	i++;
        }
        return answer;
    }
	
	// 정렬 후 같지 않은 값 찾기(not equals) 효율성 테스트 성공, 정확성 테스트 성공
	public static String solution2(String[] participant, String[] completion) {
		String answer = "";

		Arrays.sort(participant);
		Arrays.sort(completion);

		for (int i = 0; i < completion.length; i++) {
			if (!participant[i].equals(completion[i])) {
				answer = participant[i];
				return answer;
			}
		}
		return participant[participant.length -1];
	}
	
	// HashMap 사용 / 선수 이름을 key값에 명 수를 value값에
	// 선수 이름이 중복일 경우 +1, 완주한 선수는 -1을 하고 value값이 0이 아닌 선수의 이름을 반환
	// 효율성 테스트 성공, 정확성 테스트 성공
	public static String solution3(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        // 중복된 값은 +1
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        // -1
        for (String player : completion) hm.put(player, hm.get(player) - 1);
        // value값이 0이 아니면 answer은 key값이 됨
        for (String key : hm.keySet()) if (hm.get(key) != 0) answer = key; 
        
        return answer;
	}
}
