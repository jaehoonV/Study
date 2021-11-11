package ex;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Add_Two_Numbers {

	public static void main(String[] args) {
//		You are given two non-empty linked lists representing two non-negative integers. 
//		The digits are stored in reverse order, and each of their nodes contains a single digit. 
//		Add the two numbers and return the sum as a linked list.
//		You may assume the two numbers do not contain any leading zero, except the number 0 itself.			
		/*
		 * example 1: Input: l1 = [2,4,3], l2 = [5,6,4] Output: [7,0,8] 
		 * Explanation: 342 + 465 = 807
		 * 
		 * example 2: Input: l1 = [0], l2 = [0] Output: [0]
		 * 
		 * example 3: Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9] Output:
		 * [8,9,9,9,0,0,0,1]
		 */

		Scanner sc = new Scanner(System.in);

		int input = 0; // 입력값
		// l1 리스트에 0~9까지 add 종료: 10
		List<Integer> l1 = new LinkedList<>();
		System.out.println("l1 input >(0~9)  exit(10)");
		while (true) {
			input = sc.nextInt();
			if (input == 10) {
				break;
			} else if (input > 10) {
				System.out.println("try again, l1 input >(0~9)  exit(10)");
			} else {
				l1.add(input);
			}
		}
		// l2 리스트에 0~9까지 add 종료: 10
		List<Integer> l2 = new LinkedList<>();
		System.out.println("l2 input >(0~9)  exit(10)");
		while (true) {
			input = sc.nextInt();
			if (input == 10) {
				break;
			} else if (input > 10) {
				System.out.println("try again, l2 input >(0~9)  exit(10)");
			} else {
				l2.add(input);
			}
		}
		// l1, l2 출력
		System.out.println("l1 = " + l1);
		System.out.println("l2 = " + l2);
		// l1을 int[]로 변환
		int[] arrl1 = new int[l1.size()];
		for (int i = 0; i < l1.size(); i++) {
			arrl1[i] = l1.get(i).intValue();
		}
		// l2를 int[]로 변환
		int[] arrl2 = new int[l2.size()];
		for (int i = 0; i < l2.size(); i++) {
			arrl2[i] = l2.get(i).intValue();
		}
		// int[]을 int로 변환
		int num1 = 0;
		int num2 = 0;
		for (int i = arrl1.length - 1; i >= 0; i--) {
			num1 += arrl1[i];
			if (i != 0) {
				num1 *= 10;
			}
		}
		for (int i = arrl2.length - 1; i >= 0; i--) {
			num2 += arrl2[i];
			if (i != 0) {
				num2 *= 10;
			}
		}
		// 합
		int sum = num1 + num2;
		// sum을 int[]로 변환
		String temp = Integer.toString(sum);
		int[] arrsum = new int[temp.length()];
		for (int i = 0; i < temp.length(); i++) {
			arrsum[i] = sum % 10;
			sum /= 10;
		}
		// sumlist
		List<Integer> sumlist = new LinkedList<>();
		for (int e : arrsum) {
			sumlist.add(e);
		}
		// 출력
		System.out.println("Output : " + sumlist);

		sc.close();
	}
}
