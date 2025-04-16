package com.dsa.striversheet.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.dsa.readinputs.ReadInputs;

public class NextPermutation {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = bf.readLine();
		int[] arr = ReadInputs.parseArray(input);
		getNextPermutation(arr);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void getNextPermutation(int[] nums) {
		int l = nums.length-1;
		int i=l-1;
		while(i>=0 && nums[i]>=nums[i+1]) {
			i--;
		}
		System.out.println(i);
		if(i>=0) { // find next greater number then swap
			int j = nums.length-1;
			while(j>0 && nums[j]<= nums[i]) j--;
			swap(nums, i, j); 
		}
		i++;
		while(i<l) { // reverse the remaining array
			swap(nums, i, l);
			i++;l--;
		}
	}
	public static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp; 
	}
}
/*
 * A permutation of an array of integers is an arrangement of its members into a sequence or linear order.

For example, for arr = [1,2,3], the following are all the permutations of arr: [1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1].
Example 1:Input: nums = [1,2,3]
Output: [1,3,2]
Example 2:Input: nums = [3,2,1]
Output: [1,2,3]
Example 3:Input: nums = [1,1,5]
Output: [1,5,1]
IN [1,2,3,4,8,7,6,5] OUT [1, 2, 3, 5, 6, 7, 8, 4]
 Constraints:
 1 <= nums.length <= 100
0 <= nums[i] <= 100
 */
