package ex;

import java.util.Arrays;
import java.util.Scanner;

public class Rotate_List_to_array {
	/*
	 * Given the head of a linked list, rotate the list to the right by k places.
	 * Example 1: 
	 * Input: head = [1,2,3,4,5], k = 2 Output: [4,5,1,2,3] 
	 * Example 2:
	 * Input: head = [0,1,2], k = 4 Output: [2,0,1] 
	 * Constraints: 
	 * The number of nodes in the list is in the range [0, 500]. 
	 * -100 <= Node.val <= 100 
	 * 0 <= k <= 2 * 109
	 */
	// linked list를 배열로 품
	public static void main(String[] args) {
		
		// 초기 input 생성
		// int[] input = { 1, 2, 3, 4, 5 };

		// 초기 배열 길이 변수, 배열 입력 변수, k 생성
		int leng = 0;
		int temp_int = 0;
		int k = 0;
		
		// 입력
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 길이 : ");
		leng = sc.nextInt();
		int[] input = new int[leng];
		for (int i = 0; i < leng; i++) {
			System.out.print("배열 입력 : ");
			temp_int = sc.nextInt();
			input[i] = temp_int;
		}
		System.out.println("k : ");
		k = sc.nextInt();
		
		// k가 배열의 길이와 같을때 rotate를 해도 배열이 같음
		// 따라서 k = 5, 길이가 5면 배열이 같고
		// k = 5, 길이가 3이면 5%3인 2만큼 rotate를 함
		k %= leng;
		
		// k 길이 만큼의 뒷부분과 나머지 앞부분을 나눠서 저장하고 output배열에 합침
		int[] temp_output1 = Arrays.copyOfRange(input, (leng-k), leng);
		int[] temp_output2 = Arrays.copyOfRange(input, 0, (leng-k));
				
		int[] output = new int[leng];
		
		System.arraycopy(temp_output1, 0, output, 0, temp_output1.length);
		System.arraycopy(temp_output2, 0, output, temp_output1.length, temp_output2.length);
		
		for(int i = 0; i < leng; i++) {
		System.out.print(output[i]);
		}
		
		sc.close();
	}
}
