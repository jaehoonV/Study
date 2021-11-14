package ex;

import java.util.Scanner;

public class Zigzag_Conversion {
	public static void main(String[] args) {
//		The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: 
//		(you may want to display this pattern in a fixed font for better legibility)
//
//		P   A   H   N
//		A P L S I I G
//		Y   I   R
//		And then read line by line: "PAHNAPLSIIGYIR"
//
//		Write the code that will take a string and make this conversion given a number of rows:
//
//		string convert(string s, int numRows);
//		
//		Example :
//		Input: s = "PAYPALISHIRING", numRows = 4
//				Output: "PINALSIGYAHRPI"
//				Explanation:
//				P     I    N
//				A   L S  I G
//				Y A   H R
//				P     I
//		
//		numRows가 3일 때 1. 4칸	2. 2칸	3. 4칸
//		numRows가 4일 때 1. 6칸	2. 4칸 2칸 4칸 반복		3. 2칸 4칸 2칸 반복		4. 6칸
//		numRows가 5일 때 1. 8칸	2. 6칸 2칸 6칸 반복		3. 4칸	4. 2칸 6칸 2칸 반복    5. 8칸 
		
		
		// 초기 input, numRows 생성
		String input = "";
		int numRows = 0;
		
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.println("Input : ");
		input = sc.nextLine();
		System.out.println("numRows : ");
		numRows = sc.nextInt();
		
		// Zigzag_Conversion을 한 input값을 저장할 StringBuilder 생성
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < numRows; i++) {
			int j = i;
			while (j < input.length()) { // 각 열의 규칙을 반복하여 나온 input의 문자 값을 sb에 더함
				sb.append(input.charAt(j));
				j += numRows * 2 - 2;
				int k = j - 2 * i;
				if (i != numRows - 1 && i != 0 && k < input.length()) {
					sb.append(input.charAt(k));
				}
			}
		}
		// 출력
		System.out.println("Output : " + sb.toString());

		sc.close();
	}
}
