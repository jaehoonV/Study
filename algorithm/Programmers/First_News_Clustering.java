package ex_programmers;

import java.util.HashMap;
import java.util.Set;

public class First_News_Clustering {
	
	/*
	 * 프로그래머스 - [1차] 뉴스 클러스터링 (2018 KAKAO BLIND RECRUITMENT)
	 * https://school.programmers.co.kr/learn/courses/30/lessons/17677
	 */
	
	public static void main(String[] args) {
		String str1 = "FRANCE";
		String str2 = "french";

		String str3 = "handshake";
		String str4 = "shake hands";

		String str5 = "aa1+aa2";
		String str6 = "AAAA12";

		String str7 = "E=M*C^2";
		String str8 = "e=m*c^2";

		System.out.println(solution(str1, str2));// 16384
		System.out.println(solution(str3, str4));// 65536
		System.out.println(solution(str5, str6));// 43690
		System.out.println(solution(str7, str8));// 65536
	}

	private static int solution(String str1, String str2) {

		// 소문자
		String s1 = str1.toLowerCase();
		String s2 = str2.toLowerCase();

		HashMap<String, Integer> map1 = new HashMap<>();
		HashMap<String, Integer> map2 = new HashMap<>();

		// HashMap에 String을 substring(2글자)해서 put
		for (int i = 0; i < s1.length() - 1; i++) {
			String temp = s1.substring(i, i + 2);
			if (97 <= temp.charAt(0) && temp.charAt(0) <= 122 && 97 <= temp.charAt(1) && temp.charAt(0) <= 122) {
				System.out.println(temp);
				map1.put(temp, map1.getOrDefault(temp, 0) + 1);
			}
		}
		for (int i = 0; i < s2.length() - 1; i++) {
			String temp = s2.substring(i, i + 2);
			if (97 <= temp.charAt(0) && temp.charAt(0) <= 122 && 97 <= temp.charAt(1) && temp.charAt(0) <= 122) {
				System.out.println(temp);
				map2.put(temp, map2.getOrDefault(temp, 0) + 1);
			}
		}

		if (map1.size() == 0 && map2.size() == 0)
			return 65536;
		if (map1.size() == 0 || map2.size() == 0)
			return 0;

		int cnt = 0;

		Set<String> keys = map2.keySet();
		for (String key : keys) {
			System.out.println("map " + key + "1 = " + map1.getOrDefault(key, 0) + ", 2 = " + map2.get(key));
			if (map1.getOrDefault(key, 0) == map2.get(key)) {
				cnt += map2.get(key);
			} else if (map1.getOrDefault(key, 0) < map2.get(key)) {
				cnt += map1.getOrDefault(key, 0);
			} else {
				cnt += map2.get(key);
			}
		}

		if (cnt == 0)
			return 0;

		int a = map1.values().stream().mapToInt(Integer::intValue).sum();
		int b = map2.values().stream().mapToInt(Integer::intValue).sum();

		System.out.println("a = " + a + " , b = " + b + "   " + cnt);

		return (int) Math.floor((float) cnt / (a + b - cnt) * 65536);
	}

}
