package ex;

import java.util.ArrayList;
import java.util.List;

public class Shift_2D_Grid {

	public static void main(String[] args) {

		int[][] grid = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int k = 1;

//		int[][] grid = { { 1 }, { 2 }, { 3 }, { 4 }, { 7 }, { 6 }, { 5 } };
//		int k = 23;

		List<List<Integer>> output = shiftGrid(grid, k);

		for (List<Integer> data : output) {
			for (int d : data) {
				System.out.print(d);
			}
			System.out.println();
		}
	}

	public static List<List<Integer>> shiftGrid(int[][] grid, int k) {
		
		int m = grid[0].length;
		
		// 2차원 배열을 list로 변환
		List<Integer> temp_list = new ArrayList<Integer>();
		for (int i = 0; i < grid.length; i++)
			for (int j = 0; j < grid[0].length; j++)
				temp_list.add(grid[i][j]);
		
		int n = temp_list.size();
		// k가 temp_list의 크기일 경우 list가 변함이 없으므로 k는 k에서 list의 크기인 n을 나눈 나머지로 저장
		k %= n;
		// k값을 기준으로 temp_list를 나누고 위치를 바꿔서 결합
		List<Integer> shift_list = new ArrayList<>();
		shift_list.addAll(temp_list.subList(n - k, n));
		shift_list.addAll(temp_list.subList(0, n - k));
		
		// shift_list_output에 shift_list를 grid[0]의 길이 만큼 나눠서 add
		List<List<Integer>> shift_list_output = new ArrayList<List<Integer>>();
		int i = 0;
		int j = 0;
		while (i < shift_list.size() / m) {
			shift_list_output.add(shift_list.subList(0 + j, m + j));
			j += m;
			i++;
		}

		return shift_list_output;
	}
}
