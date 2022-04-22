package ex_programmers;

public class New_ID_recommendation {
	
	/*
	 * 프로그래머스 - 신규 아이디 추천(2021 KAKAO BLIND RECRUITMENT)
	 * https://programmers.co.kr/learn/courses/30/lessons/72410
	 */
	
	public static void main(String[] args) {
		//String new_id = "...!@BaT#*..y.abcdefghijklm";
		String new_id = "123_.def";
		
		System.out.println(solution(new_id));
	}

	public static String solution(String new_id) {
		
		// 1단계 소문자 치환
		new_id = new_id.toLowerCase(); 
		
		// 2단계 특수문자 제거
		new_id = new_id.replaceAll("[^a-z\\d\\-_.]*", ""); 
		
		// 3단계 마침표(.)가 2번 이상 연속되면 하나로 치환
		new_id = new_id.replaceAll("[.]{2,}", "."); 
		
		// 4단계 마침표(.)가 처음이나 끝에 위치하면 제거
		new_id = new_id.replaceAll("^[.]|[.]$", "");
		
		// 5단계 빈문자일 경우 a 대입
		if(new_id.equals("")) new_id = "a";
		
		// 6단계 16자 이상이면 15자까지 자르고 마침표(.)가 끝에 위치하면 제거
		if(new_id.length() >= 16) {
			new_id = new_id.substring(0, 15);
		}
		new_id = new_id.replaceAll("[.]$", "");
		
		// 7단계 길이가 2자 이하라면 마지막 문자를 길이가 3이 될 때까지 반복해서 붙임
		if(new_id.length() <= 2) { 
			while(new_id.length() < 3) {
				new_id += new_id.charAt(new_id.length()-1);
			}
		}
		
        return new_id;
	}
}
