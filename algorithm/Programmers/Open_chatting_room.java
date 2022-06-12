package ex_programmers;

import java.util.ArrayList;
import java.util.HashMap;

public class Open_chatting_room {
	
	/*
	 * 프로그래머스 - 오픈채팅방 (2019 KAKAO BLIND RECRUITMENT)
	 * https://programmers.co.kr/learn/courses/30/lessons/42888
	 */

	public static void main(String[] args) {
		String[] record = { "Enter uid1234 Muzi", "Enter uid4567 Prodo", "Leave uid1234", "Enter uid1234 Prodo",
				"Change uid4567 Ryan" };

		String[] output = solution(record);
		for (String s : output) {
			System.out.println(s);
		}
	}

	private static String[] solution(String[] record) {
		ArrayList<String> arr = new ArrayList<>(); // record 저장할 List
		HashMap<String, String> hm = new HashMap<>(); // user ID와 닉네임을 저장할 Map

		for (int i = 0; i < record.length; i++) {
			String ELC = record[i].split(" ")[0]; // 입장, 퇴장, 변경
			
			switch (ELC) {
			case "Enter":
				enter_user(record[i].split(" ")[1],record[i].split(" ")[2], hm, arr);
				break;
			case "Leave":
				leave_user(record[i].split(" ")[1], hm, arr);
				break;
			case "Change":
				change_user(record[i].split(" ")[1],record[i].split(" ")[2], hm, arr);
				break;
			}
		}
		
		// Map에 담긴 닉네임으로 List를 변환하여 반환
		String[] answer = new String[arr.size()];
		for(int i = 0; i < arr.size(); i++) {
			String id = arr.get(i).split(" ")[0];
			String message = arr.get(i).split(" ")[1];
			String name = hm.get(id) + "님이 ";
			answer[i] = name + message;
		}

		return answer;
	}
	
	// 닉네임 변경 
	private static void change_user(String id, String name, HashMap<String, String> hm, ArrayList<String> arr) {
		hm.put(id, name);
	}
	
	// 퇴장
	private static void leave_user(String id, HashMap<String, String> hm, ArrayList<String> arr) {
		String message = id + " 나갔습니다.";
		arr.add(message);
	}
	
	// 입장
	private static void enter_user(String id, String name, HashMap<String, String> hm, ArrayList<String> arr) {
		hm.put(id, name);
		String message = id + " 들어왔습니다.";
		arr.add(message);
	}

}
