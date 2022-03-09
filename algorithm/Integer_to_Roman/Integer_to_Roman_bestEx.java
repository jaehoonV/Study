package ex;

import java.util.Scanner;

public class Integer_to_Roman_bestEx {
	public static void main(String[] args) {

		// 초기 input, output, keys, values 생성
		int input = 0;
		String output = "";
		String[] keys = { "M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I" };
		int[] values = { 1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1 };
		int i = 0;

		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("input : ");
		input = sc.nextInt();
		
		// input값에 value값을 빼면서 key값을 output을 더 함
		// input값에 value값을 뺀 값이 0보다 작으면 다음 value값으로 넘어서 실행
		while (input > 0) {
			if (input - values[i] < 0) {
				i++;
				continue;
			} else {
				output += keys[i];
				input -= values[i];
			}
		}

		System.out.println(output);

		sc.close();
	}
}
