package ex;

public class Min_Cost_Climbing_Stairs {

//	You are given an integer array cost where cost[i] is the cost of ith step on a staircase. 
//	Once you pay the cost, you can either climb one or two steps.
//	You can either start from the step with index 0, or the step with index 1.
//	Return the minimum cost to reach the top of the floor.
//
//	Example 1:
//	Input: cost = [10,15,20]
//	Output: 15
//	Explanation: You will start at index 1.
//	- Pay 15 and climb two steps to reach the top.
//	The total cost is 15.

//	Example 2:
//	Input: cost = [1,100,1,1,1,100,1,1,100,1]
//	Output: 6
//	Explanation: You will start at index 0.
//	- Pay 1 and climb two steps to reach index 2.
//	- Pay 1 and climb two steps to reach index 4.
//	- Pay 1 and climb two steps to reach index 6.
//	- Pay 1 and climb one step to reach index 7.
//	- Pay 1 and climb two steps to reach index 9.
//	- Pay 1 and climb one step to reach the top.
//	The total cost is 6.
	
//	Constraints:
//	2 <= cost.length <= 1000
//	0 <= cost[i] <= 999

	public static void main(String[] args) {

		int[] cost = { 1, 100, 1, 1, 1, 100, 1, 1, 100, 1 };

		for (int i = cost.length - 3; i >= 0; i--) { // 뒤에서 부터 시작
			cost[i] += Math.min(cost[i + 1], cost[i + 2]); // 더 작은 값을 더해가면서 index를 내림
		}

		System.out.println(Math.min(cost[0], cost[1])); // index가 0, 1중 작은 값을 output
	}
}
