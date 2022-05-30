package ex_programmers;

public class Secret_map {
	
	/*
	 * 프로그래머스 - 비밀지도(2018 KAKAO BLIND RECRUITMENT)
	 * https://programmers.co.kr/learn/courses/30/lessons/17681
	 */

	public static void main(String[] args) {
		int n = 5;
		int[] arr1 = { 9, 20, 28, 18, 11 };
		int[] arr2 = { 30, 1, 21, 17, 28 };

		int n1 = 6;
		int[] arr11 = { 46, 33, 33, 22, 31, 50 };
		int[] arr21 = { 27, 56, 19, 14, 14, 10 };

		String[] output = solution(n, arr1, arr2);
		for (String s : output) {
			System.out.println(s);
		}
		
		String[] output1 = solution(n1, arr11, arr21);
		for (String s : output1) {
			System.out.println(s);
		}
	}

	private static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		for (int i = 0; i < n; i++) {
			answer[i] = merge(arr1[i], arr2[i], n);
		}

		return answer;
	}

	private static String merge(int a, int b, int n) {
		String[] out = new String[n]; // 반환할 String

		Long a_int = Long.parseLong(Long.toString(a, 2)); // 2진법으로 나타내고 정수로 변환
		Long b_int = Long.parseLong(Long.toString(b, 2)); // 2진법으로 나타내고 정수로 변환
		String sum = Long.toString(a_int + b_int);

		// System.out.println(a_int + ", " + b_int + ", " + sum);

		int i = 0;
		int j = 0;
		while (i < n - sum.length()) { // 앞자리가 비어있을 경우 빈 칸으로 채움
			out[i++] = " ";
		}

		while (j < sum.length()) {
			if (sum.charAt(j++) >= '1') { // 1이상일 경우 #
				out[i++] = "#";
			} else {
				out[i++] = " "; // 아닐 경우 빈 칸
			}
		}

		return String.join("", out); // String으로 반환
	}

}
