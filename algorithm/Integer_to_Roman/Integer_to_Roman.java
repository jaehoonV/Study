package ex;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Integer_to_Roman {
	/*
	 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D
	 * and M. Symbol Value I = 1, V = 5, X = 10, L = 50, C = 100, D = 500, M = 1000
	 * For example, 2 is written as II in Roman numeral, just two one's added
	 * together. 12 is written as XII, which is simply X + II. The number 27 is
	 * written as XXVII, which is XX + V + II. Roman numerals are usually written
	 * largest to smallest from left to right. However, the numeral for four is not
	 * IIII. Instead, the number four is written as IV. Because the one is before
	 * the five we subtract it making four. The same principle applies to the number
	 * nine, which is written as IX. There are six instances where subtraction is
	 * used:
	 * 
	 * I can be placed before V (5) and X (10) to make 4 and 9. X can be placed
	 * before L (50) and C (100) to make 40 and 90. C can be placed before D (500)
	 * and M (1000) to make 400 and 900. Given an integer, convert it to a roman
	 * numeral.
	 * 
	 * Example : Input: num = 58 list: "LVIII" Explanation: L = 50, V = 5, III = 3.
	 * Constraints: 1 <= num <= 3999
	 */
	public static void main(String[] args) {

		// 초기 input, list 생성
		int input = 0;
		List<String> list = new ArrayList<>();

		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("input : ");
		input = sc.nextInt();
		
		// 천의 자리
		if(input / 1000 > 0) {
			int temp = input / 1000;
			for(int i = 0; i < temp; i++) {
				list.add("M");
			}
			input %= 1000;
		}
		
		// 백의 자리
		if(input / 100 > 0) {
			int temp = input / 100;
			if(temp == 9) {
				list.add("CM");
				input %= 100;
			} else if(temp > 4){
				list.add("D");
				temp -= 5;
				if(temp > 0) {
					for(int i = 0; i < temp; i++) {
						list.add("C");
					}	
				}
				input %= 100;
			} else if(temp == 4) {
				list.add("CD");
				input %= 100;
			} else {
				for(int i = 0; i < temp; i++) {
					list.add("C");
				}
				input %= 100;
			}
		}
		
		// 십의 자리
		if(input / 10 > 0) {
			int temp = input / 10;
			if(temp == 9) {
				list.add("XC");
				input %= 10;
			} else if(temp > 4){
				list.add("L");
				temp -= 5;
				if(temp > 0) {
					for(int i = 0; i < temp; i++) {
						list.add("X");
					}	
				}
				input %= 10;
			} else if(temp == 4) {
				list.add("XL");
				input %= 10;
			} else {
				for(int i = 0; i < temp; i++) {
					list.add("X");
				}
				input %= 10;
			}
		}
		
		// 일의 자리
		if(input == 9) {
			list.add("IX");
		} else if(input > 4){
			list.add("V");
			input -= 5;
			if(input > 0) {
				for(int i = 0; i < input; i++) {
					list.add("I");
				}	
			}
		} else if(input == 4) {
			list.add("IV");
		} else {
			for(int i = 0; i < input; i++) {
				list.add("I");
			}
		}
		String output = String.join("",list);
		
		System.out.println(output);
		
		sc.close();
	}
}
