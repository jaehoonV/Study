package ex_programmers;

public class Numeric_strings_and_English_words {
	
	/*
	 * 프로그래머스 - 숫자 문자열과 영단어(2021 카카오 채용연계형 인턴십)
	 * https://programmers.co.kr/learn/courses/30/lessons/81301
	 */
	
	public static void main(String[] args) {
		String s = "2three45sixseven";
		System.out.println("Use replaceAll => " + solution(s));
		System.out.println("Not use replaceAll => " + solution1(s));
	}
	
	// Use replaceAll
	private static int solution (String s) {
		
		String[] alphabets = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

		for (int i = 0; i < 10; i++) {
			s = s.replaceAll(alphabets[i], Integer.toString(i));
		}

		return Integer.parseInt(s);
	}

	// Not use replaceAll
	private static int solution1(String s) {

		String output = ""; // 변환한 문자를 담을 변수 생성

		int i = 0; // index

		while (i < s.length()) {
			char s_temp = s.charAt(i); // 문자

			if ('0' <= s_temp && s_temp <= '9') { // 0~9는 output에 바로 더 함
				output += s_temp;
				i++;
			} else {
				switch (s_temp) { // 규칙
				case 'z':
					output += '0';
					i += 4;
					break;
				case 'o':
					output += '1';
					i += 3;
					break;
				case 't':
					if (s.charAt(i + 1) == 'w') {
						output += '2';
						i += 3;
					} else {
						output += '3';
						i += 5;
					}
					break;
				case 'f':
					if (s.charAt(i + 1) == 'o') {
						output += '4';
						i += 4;
					} else {
						output += '5';
						i += 4;
					}
					break;
				case 's':
					if (s.charAt(i + 1) == 'i') {
						output += '6';
						i += 3;
					} else {
						output += '7';
						i += 5;
					}
					break;
				case 'e':
					output += '8';
					i += 5;
					break;
				case 'n':
					output += '9';
					i += 4;
					break;
				}
			}
		}
		return Integer.parseInt(output); // 정수로 변환해서 반환
	}

}
