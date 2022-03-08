package ex;

import java.util.Scanner;

public class Reverse_Integer {
	/*
	 * Given a signed 32-bit integer x, return x with its digits reversed. If
	 * reversing x causes the value to go outside the signed 32-bit integer range
	 * [-231, 231 - 1], then return 0. Assume the environment does not allow you to
	 * store 64-bit integers (signed or unsigned).
	 *
	 * Example 1: Input: x = 123 Output: 321
	 * 
	 * Example 2: Input: x = -123 Output: -321
	 * 
	 * Example 3: Input: x = 120 Output: 21
	 */
	public static void main(String[] args) {
		// 초기 input, output, sign, temp 생성
		int input = 0;
		int output = 0;
		int sign = 0;
		int temp = 0;

		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("input : ");
		input = sc.nextInt();
		
		// 부호 저장, 입력값 양수로 저장
		if(input < 0) {
			sign = -1;
		}else {
			sign = 1;
		}
		input *= sign;
		
		// reverse integer
		while(input > 0) {
			temp = input % 10;
			input /= 10;
			// 32bit 범위를 벗어나면 0으로 저장
			if(output > (Integer.MAX_VALUE - temp)/10 ) {
				output = 0;
                break;
			}
			output = output * 10 + temp;
		}
		
		// 부호 붙여서 출력
		output *= sign;
		System.out.println(output);
		sc.close();
	}
	
}
