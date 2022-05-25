package ex_programmers;

import java.util.ArrayList;

public class Function_development {
	
	/*
	 * 프로그래머스 - 기능 개발(스택/큐)
	 * https://programmers.co.kr/learn/courses/30/lessons/42586
	 */

	public static void main(String[] args) {
		//int[] progresses = { 93, 30, 55 };
		int[] progresses = {95, 90, 99, 99, 80, 99};
		//int[] speeds = { 1, 30, 5 };
		int[] speeds = { 1, 1, 1, 1, 1, 1};

		int[] output = solution(progresses, speeds);
		for(int out : output) {
		System.out.print(out + " ");
		}
	}

	private static int[] solution(int[] progresses, int[] speeds) {

		ArrayList<Integer> list = new ArrayList<>(); // return할 list

		int i = 0; // index

		while (i < progresses.length) {
			int k = i;
			int cnt = 0; // 배포 카운트
			while (k < progresses.length) {
				if (progresses[k] >= 100) { // progress가 100이상 일때 배포카운트+1
					k++;
					i++;
					cnt++;
				} else
					break;
			}
			if (cnt > 0) { // 배포 카운트가 0이상일 때 list에 배포 카운트 추가
				list.add(cnt);
			}
			for (int j = 0; j < progresses.length; j++) { // progress에 해당 속도 더해줌
				progresses[j] += speeds[j];
			}
		}
		
		// list를 배열로 변환후 반환
		int[] answer = new int[list.size()];
		for (int j=0; j < list.size(); j++) {
			answer[j] = list.get(j);
		}

		return  answer;
	}

}
