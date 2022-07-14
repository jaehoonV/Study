package ex_programmers;

public class Hide_cell_phone_number {
	
	/*
	 * 프로그래머스 - 핸드폰 번호 가리기 (연습문제)
	 * https://school.programmers.co.kr/learn/courses/30/lessons/12948
	 */
	
	public static void main(String[] args) {
		
		String phone_number = "01033334444";
		System.out.println(solution(phone_number));
		
		String phone_number1 = "027778888";
		System.out.println(solution(phone_number1));
		
	}
	
	public static String solution(String phone_number) {
        String answer = "";
        for(int i = 0; i < phone_number.length(); i++){
            if(i < phone_number.length() -4){
                answer += "*";
            } else{
                answer += phone_number.charAt(i);
            }
        }
        
        return answer;
    }
}
