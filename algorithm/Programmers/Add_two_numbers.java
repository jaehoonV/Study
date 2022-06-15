package ex_programmers;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Add_two_numbers {
	
	/*
	 * 프로그래머스 - 2개 뽑아서 더하기 (월간 코드 챌린지 시즌1)
	 * https://programmers.co.kr/learn/courses/30/lessons/68644
	 */

	public static void main(String[] args) {
		int[] numbers = { 2, 1, 3, 4, 1 };
		
		for(int n : solution(numbers))
		System.out.print(n + ", ");
	}

	private static int[] solution(int[] numbers) {
		Set<Integer> set = new TreeSet<>(); // 두 수를 더한값을 저장할 set 생성
		for (int i = 0; i < numbers.length - 1; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				set.add(numbers[i] + numbers[j]);
			}
		}
		
		// 배열로 변환하여 정렬하고 반환
		int[] output = new int[set.size()];
		Iterator<Integer> it = set.iterator();
		for (int i = 0; i < output.length; i++) {
			output[i] = it.next();
		}
		
		return output;
	}

}
