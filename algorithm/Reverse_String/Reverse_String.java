package ex;

public class Reverse_String {
	/*
	 * Write a function that reverses a string. The input string is given as an
	 * array of characters s.
	 * 
	 * You must do this by modifying the input array in-place with O(1) extra memory.
	 * 
	 * Example 1:
	 * Input: s = ["h","e","l","l","o"] Output: ["o","l","l","e","h"] 
	 * 
	 * Example 2:
	 * Input: s = ["H","a","n","n","a","h"] Output: ["h","a","n","n","a","H"]
	 * 
	 * Constraints:
	 * 1 <= s.length <= 105 
	 * s[i] is a printable ascii character.
	 */
	public static void main(String[] args) {
		 char[] s = {'h','e','l','l','o'};
		 
		 // index로 사용할 변수 생성
		 int i = 0;
		 int j = s.length-1;
		 
		 while(i < j) { // reverse
			 char temp = s[j]; // 임시변수에 저장
			 s[j] = s[i];
			 s[i] = temp;
			 i++;
			 j--;
		 }
		 
		 for(int k = 0; k < s.length; k++) {
			 System.out.print(s[k] + " ");
		 }
	}
}
