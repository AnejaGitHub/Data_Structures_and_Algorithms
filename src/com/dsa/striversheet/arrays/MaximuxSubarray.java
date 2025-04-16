package com.dsa.striversheet.arrays;

import java.util.Scanner;
import com.dsa.readinputs.ReadInputs;

public class MaximuxSubarray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int[] arr = ReadInputs.parseArray(input);
		System.out.println(maximumSubarray(arr));
	}

	private static int maximumSubarray(int[] arr) {
		int sum = 0, curSum = 0;
		for (int e : arr) {
			if (curSum + e < 0) {
				sum = Math.max(sum, curSum);
				curSum = 0;
			} else {
				curSum += e;
				sum = Math.max(sum, curSum);
			}
		}
		if (sum == 0) {
			sum = Integer.MIN_VALUE;
			for (int e : arr) {
				sum = Math.max(sum, e);
			}
		}
		return sum;

	}

	public static int getMaximumSubarray(int[] arr) {
		// shorter version
		int sum = Integer.MIN_VALUE, curSum = 0;
		for (int e : arr) {
			curSum = Math.max(e, curSum + e);
			sum = Math.max(sum, curSum);
		}
		return sum;
	}

}
/*
 * Given an integer array nums, find the subarray with the largest sum, and
 * return its sum. Example 1:Input: nums = [-2,1,-3,4,-1,2,1,-5,4] Output: 6
 * Explanation: The subarray [4,-1,2,1] has the largest sum 6. Example 2: Input:
 * nums = [1] Output: 1 Explanation: The subarray [1] has the largest sum 1.
 * Example 3: Input: nums = [5,4,-1,7,8] Output: 23 Explanation: The subarray
 * [5,4,-1,7,8] has the largest sum 23. [-1,-90,-8,0] 0; [-5,-90,-8,-89] -5;
 * Constraints: 1 <= nums.length <= 105 -104 <= nums[i] <= 104
 */
