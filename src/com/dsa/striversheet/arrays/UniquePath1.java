package com.dsa.striversheet.arrays;

import java.util.Scanner;
import com.dsa.readinputs.ReadInputs;

public class UniquePath1 {
	public static void main(String[] args) {
		Scanner sc = new  Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] dp = new int[m][n];
		getPaths(m, n, dp, 0, 0);
		System.out.println(dp[0][0]);
	}
	private static void getPaths(int m, int n, int[][] dp, int i, int j){
        if(i == m-1 || j == n-1 ){
            dp[i][j] = 1; return;
        }
        if(i<m-1 && dp[i][j] == 0){
            getPaths(m, n, dp, i+1, j);
        }
        if(j<n-1 && dp[i][j] == 0){
            getPaths(m, n, dp, i, j+1);
        }
        dp[i][j] = dp[i+1][j] + dp[i][j+1];
    }
}
/*There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
The test cases are generated so that the answer will be less than or equal to 2 * 109.
 * Example1 : Input: m = 3, n = 7
Output: 28
Example 2:	Input: m = 3, n = 2
Output: 3
Explanation: From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
1. Right -> Down -> Down
2. Down -> Down -> Right
3. Down -> Right -> Down
 */
