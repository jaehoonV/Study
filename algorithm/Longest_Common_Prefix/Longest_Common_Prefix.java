package ex;

import java.util.Arrays;
import java.util.Scanner;

public class Longest_Common_Prefix {
	/*
	 * Write a function to find the longest common prefix string amongst an array of
	 * strings.
	 * 
	 * If there is no common prefix, return an empty string "".
	 * 
	 * Example 1: Input: strs = ["flower","flow","flight"] Output: "fl"
	 * 
	 * Example 2: Input: strs = ["dog","racecar","car"] Output: "" Explanation:
	 * There is no common prefix among the input strings.
	 * 
	 * Constraints: 1 <= strs.length <= 200 0 <= strs[i].length <= 200 strs[i]
	 * consists of only lower-case English letters.
	 */
	public static void main(String[] args) {
		// 초기 input 생성
		// String[] input = { "flower", "flow", "flight" };

		// 초기 배열 길이 변수, 배열 입력 변수, output 생성
		int leng = 0;
		String temp_String = "";
		String output = "";

		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 길이 : ");
		leng = sc.nextInt();
		String[] input = new String[leng];
		for(int i = 0; i < leng; i ++) {
			System.out.print("배열 입력 : ");
			temp_String = sc.next();
			input[i] = temp_String;
		}

		// input 값이 null인 경우
		if (input == null || input.length == 0) {
			System.out.println(output);
		} else {
			Arrays.sort(input); // input 정렬
			String first = input[0];
			String last = input[input.length - 1];
			int i = 0;
			while (i < first.length()) { // 같은 문자일 때 i값을 증가시킴
				if (first.charAt(i) == last.charAt(i))
					i++;
				else
					break;
			}
			System.out.println(first.substring(0, i));
		}
		
		sc.close();
	}
}
