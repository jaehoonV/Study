package ex;

public class Search_a_2D_Matrix {
	
	/* Write an efficient algorithm that searches for a value target in an m x n
	 * integer matrix matrix. This matrix has the following properties:
	 * 
	 * Integers in each row are sorted from left to right. The first integer of each
	 * row is greater than the last integer of the previous row.
	 * 
	 * Example 1: 
	 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]]
	 * target = 3 Output: true
	 * 
	 * Example 2: 
	 * Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], 
	 * target = 13 Output: false
	 * 
	 * Constraints:
	 * m == matrix.length 
	 * n == matrix[i].length 
	 * 1 <= m, n <= 100 
	 */
	
	public static void main(String[] args) {
		// matrix, target 생성
		int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
//		int[][] matrix = {{1},{3}};
		int target = 3;
		
		// 행, 열 길이 생성
		int m = matrix.length;
		int n = matrix[0].length;
		
		// 저장할 행 index와 output 생성
		int row = 0;
		boolean output = false;
		
		for(int i = 0; i < m; i ++) { // 행의 마지막값 보다 target이 작을 경우 행을 저장하고 break 
			if(target <= matrix[i][n-1]) {
				row = i;
				break;
			}
		}
		
		for(int i = 0; i < n; i ++) { // 저장된 행에서 target 값을 찾음
			if(target == matrix[row][i]) {
				output = true;
				break;
			}
		}
		
		System.out.println(output);
	}
}
