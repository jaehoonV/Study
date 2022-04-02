package ex;

public class Valid_Palindrome_II_Recursion_Function {
	
	// 배열로 변환하지 않고 재귀함수..
	
	public static void main(String[] args) {
		String s = "abca";
		//String s = "abc";
		System.out.println(validPalindrome(s));
	}
	
	public static boolean validPalindrome(String s) {
		int temp_count = 0; // 문자 삭제 횟수
		// index 설정
		int i = 0; 
		int j = s.length() - 1;
		return valid(s, temp_count, i, j);
	}

	private static boolean valid(String s, int temp_count, int i, int j) {
		if(temp_count > 1) { // 삭제 횟수가 1을 초과하면 false 반환
			return false;
		}
		
		while (i < j) { // 반복
			if (s.charAt(i) != s.charAt(j)) { // 앞 문자와 뒷 문자가 같지 않을 경우
				temp_count ++; // 문자 삭제 횟수 +1
				return valid(s, temp_count, i+1, j) || valid(s, temp_count, i, j-1); // 재귀함수
			}
			i++;
			j--;
		}
		return true;
	}
}
