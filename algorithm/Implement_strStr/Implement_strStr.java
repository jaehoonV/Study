package ex;

public class Implement_strStr {
	/*
	 * Implement strStr().
	 * 
	 * Return the index of the first occurrence of needle in haystack, or -1 if
	 * needle is not part of haystack.
	 * 
	 * Example 1:
	 * Input: haystack = "hello", needle = "ll" Output: 2 
	 * Example 2:
	 * Input: haystack = "aaaaa", needle = "bba" Output: -1 
	 * Example 3:
	 * Input: haystack = "", needle = "" Output: 0 
	 * 
	 * Constraints:
	 * 0 <= haystack.length, needle.length <= 5 * 104 
	 * haystack and needle consist of only lower-case English characters.
	 */
	
	public static void main(String[] args) {
		String haystack = "hello";
		String needle = "ll";
		int output = 0;
		
		// indexOf
		if(needle.isEmpty() || haystack.equals(needle)){
            System.out.println(output); // null, 같은 문자열이면 0
        }else {
        	output = -1;
        	if (haystack.indexOf(needle) >= 0) {
    			output = haystack.indexOf(needle);
    		}
    		System.out.println("Use indexOf output = " + output);
        }
		
		// not use indexOf
		output = 0;
		
		if(needle.isEmpty() || haystack.equals(needle)){
            System.out.println(output); // null, 같은 문자열이면 0
        }else {
        	// String => 배열 변환
    		char[] haystack_arr = haystack.toCharArray();
    		char[] needle_arr = needle.toCharArray();
    		
    		output = -1;
    		
        	for(int i = 0; i < haystack_arr.length; i++) {
    			if(haystack_arr[i] == needle_arr[0]) { // 문자가 처음 맞는 index는 i
    				 for (int j = i, k = 0; j < haystack_arr.length && k < needle_arr.length; j++, k++) {
    	                    if (haystack_arr[j] != needle_arr[k]) { // 문자가 틀릴 때
    	                        break;
    	                    }
    	                    if (k == needle_arr.length - 1) { // needle의 문자가 다 맞을 때
    	                        output = i;
    	                        break;
    	                    }
    				 }
    			}
    		}
    		System.out.println("Not use indexOf output = " + output);
        }
	}
}
