package ex_programmers;

import java.util.ArrayList;

public class Remove_the_same_number {
	
	/*
	 * 프로그래머스 - 같은 숫자는 싫어(스택/큐)
	 * https://school.programmers.co.kr/learn/courses/30/lessons/12906
	 */
	
	public static void main(String[] args) {
		
		int[] arr = {1,1,3,3,0,1,1};	// [1,3,0,1]
		int[] arr1 = {4,4,4,3,3}; 		// [4,3]
		
		int[] output = solution(arr);
		int[] output1 = solution(arr1);
		
		for(int i = 0; i < output.length; i++) {
			System.out.print(output[i] + " ");
		}
		System.out.println();
		for(int i = 0; i < output1.length; i++) {
			System.out.print(output1[i] + " ");
		}
	}

	private static int[] solution(int[] arr) {
		ArrayList<Integer> list = new ArrayList<>();
        int n = arr.length;
        if(n != 0){
            list.add(arr[0]);
        }
        for(int i = 1; i < n; i++){
            if(arr[i] != arr[i - 1]){
                list.add(arr[i]);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
	}

}
