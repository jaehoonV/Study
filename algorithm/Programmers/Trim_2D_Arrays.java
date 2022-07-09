package ex_programmers;

import java.util.Arrays;

public class Trim_2D_Arrays {
	
	/*
	 * 프로그래머스 - n^2 배열 자르기 (월간 코드 챌린지 시즌3)
	 * https://school.programmers.co.kr/learn/courses/30/lessons/87390
	 */
	
	/*
	 * 배열의 크기가 크기 때문에 배열을 생성후 반환할 값만을 추출하는 것이 아닌 
	 * 반환할 배열 값 자체만을 생성해서 반환해야함
	 */

	public static void main(String[] args) {
		int n = 3;
		int left = 2;
		int right = 5;

		int[] output = solution(n, left, right);
		for (int i : output) {
			System.out.print(i + " ");
		}
		System.out.println();
		int[] output_s1 = solution1(n, left, right);
		for (int i : output_s1) {
			System.out.print(i + " ");
		}

		System.out.println();

		int n1 = 4;
		int left1 = 7;
		int right1 = 14;

		int[] output1 = solution(n1, left1, right1);
		for (int i : output1) {
			System.out.print(i + " ");
		}
		System.out.println();
		int[] output1_s1 = solution1(n1, left1, right1);
		for (int i : output1_s1) {
			System.out.print(i + " ");
		}
	}

	// 정확성 45 (메모리 초과, 런타임 에러)
	private static int[] solution(int n, int left, int right) {
		// 일차원 배열 생성
		int[] temp = new int[n * n];
		int k = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				temp[k++] = Math.max(i, j) + 1;
			}
		}
		// 배열의 left 부터 right까지 복사하여 반환
		return Arrays.copyOfRange(temp, left, right + 1);
	}
	
	// 정확성 100
	private static int[] solution1(int n, long left, long right) {
		// 일차원 배열 생성
		int[] temp = new int[(int) (right - left) + 1];
		int x = (int) (left / n) + 1;
		int y = (int) (left % n) + 1;
		
		// 해당 행과 열을 비교하여 배열에 값 저장
		for (int i = 0; i < temp.length; i++) {
			temp[i] = Math.max(x, y++);
			if (y > n) {
				x++;
				y = 1;
			}
		}
		return temp;
	}
}
