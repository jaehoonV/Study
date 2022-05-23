package ex_programmers;

public class Rank_search {
	
	/*
	 * 프로그래머스 - 순위 검색(2021 KAKAO BLIND RECRUITMENT)
	 * https://programmers.co.kr/learn/courses/30/lessons/72412
	 */

	public static void main(String[] args) {
		String[] info = { "java backend junior pizza 150", "python frontend senior chicken 210",
				"python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80",
				"python backend senior chicken 50" };
		String[] query = { "java and backend and junior and pizza 100",
				"python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250",
				"- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150" };

		int[] output = solution(info, query);

		for (int i : output) {
			System.out.print(i + " ");
		}
	}

	// 정확성 100, 효율성 실패
	private static int[] solution(String[] info, String[] query) {

		int[] answer = new int[query.length];

		for (int i = 0; i < query.length; i++) {
			answer[i] = search(info, query[i]);
		}
		return answer;
	}

	private static int search(String[] info, String q) {

		int cnt = 0; // 검색 count

		String q1 = q.split(" and ")[0]; // 첫번째 query
		String q2 = q.split(" and ")[1]; // 두번째 query
		String q3 = q.split(" and ")[2]; // 세번째 query
		String q4 = q.split(" and ")[3];
		int q5 = Integer.parseInt(q4.split(" ")[1]); // 다섯번째 query
		q4 = q4.split(" ")[0]; // 네번째 query

		// System.out.println(q1 + ", " + q2 + ", " + q3 + ", " + q4 + ", " + q5);

		for (int i = 0; i < info.length; i++) {
			// query가 "-"일 경우 통과, 아닐경우 continue
			if (!info[i].contains(q1) && !q1.equals("-"))
				continue;

			if (!info[i].contains(q2) && !q2.equals("-"))
				continue;

			if (!info[i].contains(q3) && !q3.equals("-"))
				continue;

			if (!info[i].contains(q4) && !q4.equals("-"))
				continue;
			
			// query보다 작을 경우 continue
			if (Integer.parseInt(info[i].split(" ")[4]) < q5)
				continue; 

			cnt++; // 모두 통과시 +1
		}

		return cnt;
	}

}
