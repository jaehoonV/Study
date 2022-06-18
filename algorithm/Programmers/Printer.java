package ex_programmers;

import java.util.ArrayList;

public class Printer {
	
	/*
	 * 프로그래머스 - 프린터 (스택/큐)
	 * https://programmers.co.kr/learn/courses/30/lessons/42587
	 */

	public static void main(String[] args) {
		int[] priorities = { 2, 1, 3, 2 };
		int location = 2;
		System.out.println(solution(priorities, location));

		int[] priorities1 = { 1, 1, 9, 1, 1, 1 };
		int location1 = 0;
		System.out.println(solution(priorities1, location1));
	}

	private static int solution(int[] priorities, int location) {

		// 배열 List 생성 (index와 값을 저장)
		ArrayList<int[]> list = new ArrayList<int[]>();
		for (int i = 0; i < priorities.length; i++) {
			list.add(new int[] { i, priorities[i] });
		}

		int cnt = 0;
		while (cnt < list.size()) {
			boolean b = true; // 해당값이 최대값인 경우를 체크하기 위한 boolean값
			int[] temp = list.get(cnt); // 임시 배열 변수

			// 더 큰 값이 있을 경우 해당 값을 지우고 add함
			for (int i = cnt; i < list.size(); i++) {
				if (temp[1] < list.get(i)[1]) {
					list.remove(cnt);
					list.add(temp);
					b = false; // 더 큰 값이 있을 경우 false
					break;
				}
			}
			if (b) { // 해당값이 최대값일 경우 cnt + 1
				cnt++;
			}
		}

		// location값을 찾아 해당 index + 1하여 반환
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i)[0] == location) {
				return i + 1;
			}
		}

		return 0;
	}

}
