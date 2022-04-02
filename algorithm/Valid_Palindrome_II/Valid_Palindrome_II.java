package ex;

public class Valid_Palindrome_II {
	/*
	 * Given a string s, return true if the s can be palindrome after 
	 * deleting at most one character from it.
	 * 
	 * Example 1:
	 * Input: s = "aba" Output: true 
	 * 
	 * Example 2:
	 * Input: s = "abca" Output: true 
	 * Explanation: You could delete the character 'c'. 
	 * 
	 * Example 3:
	 * Input: s = "abc" Output: false
	 * 
	 * Constraints:
	 * 1 <= s.length <= 105 
	 * s consists of lowercase English letters.
	 */

	public static void main(String[] args) {
		String s = "abca";
		//String s = "abc";
		
		System.out.println(validPalindrome(s));
	}

	public static boolean validPalindrome(String s) {
		char[] s_arr = s.toCharArray(); // 배열로 변환

		// index 설정
		int i = 0; 
		int j = s_arr.length - 1;

		while (i < j) { // 반복
			if (s_arr[i] != s_arr[j]) { // 앞 문자와 뒷 문자가 같지 않을 경우
				// 앞글자나 뒷글자를 지우고 메소드 실행
				return valid(s_arr, i + 1, j) || valid(s_arr, i, j - 1); 
			}
			i++;
			j--;
		}
		return true;
	}
	
	// 최대 한 문자를 지울 수 있으므로 같지 않은 앞글자나 뒤글자를 지우고 실행할 메소드
	private static boolean valid(char[] s_arr, int i, int j) {
		while (i < j) {
			// 한문자를 지우고 실행 했으므로 문자가 같지 않을 경우 false 반환
			if (s_arr[i] != s_arr[j]) { 
				return false;
			}
			i++;
			j--;
		}
		return true;
	}
}
