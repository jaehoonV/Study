package ex;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Odd_Even_Sort {
	/*
	 * 자연수 리스트(홀수와 짝수의 개수가 같음)가 주어집니다.(예외 처리 필요) 이 리스트를 정렬해야 합니다. 
	 * 순서는 홀-짝-홀-짝-...으로 오게 해야 하며, 홀수는 오름차순 정렬로, 짝수는 내림차순 정렬로 배치해야 합니다.
	 * 
	 * Example 1: input : 4 1 3 2 6 5 output : 1 6 3 4 5 2
	 */
	public static void main(String[] args) {
		// 초기 input, even_list, odd_list, ouput 생성
		// int[] input = { 4, 1, 3, 2, 6, 5 };
		
		List<Integer> even_list = new ArrayList<>();
		List<Integer> odd_list = new ArrayList<>();
		List<Integer> output = new ArrayList<>();
		
		// 입력
		Scanner sc = new Scanner(System.in);
		int leng = 0;
		int temp_int = 0;
		while(true) {
			System.out.print("배열의 길이(짝수) : ");
			leng = sc.nextInt();
			if(leng % 2 != 0) {
				System.out.println("배열의 길이는 짝수입니다.");
				continue;
			} else {
				int[] input = new int[leng];
				
				for (int i = 0; i < leng; i++) {
					System.out.print("배열 입력 : ");
					temp_int = sc.nextInt();
					input[i] = temp_int;
				}

				for (int i = 0; i < input.length; i++) {
					if (input[i] % 2 == 0) {
						even_list.add(input[i]);
					} else {
						odd_list.add(input[i]);
					}
				}
				
				Collections.sort(odd_list);
				Collections.sort(even_list, Collections.reverseOrder());

				for (int i = 0; i < input.length / 2; i++) {
					output.add(odd_list.get(i));
					output.add(even_list.get(i));
				}

				System.out.println(output);
				break;
			}
		}
		sc.close();
	}
}
