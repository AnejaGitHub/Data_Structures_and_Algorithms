package com.dsa.striversheet.arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.dsa.readinputs.ReadInputs;

public class SortZeroOneTwo {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = bf.readLine();
		int[] arr = ReadInputs.parseArray(input);
		sortArray(arr);
		System.out.println(Arrays.toString(arr));
	}

	private static void sortArray(int[] arr) {
	    int zero = 0, one = 0, two = arr.length - 1;
	    
	    while (one <= two) {
	        if (arr[one] == 0) {
	            swap(arr, zero++, one++);
	        } else if (arr[one] == 1) {
	            one++;
	        } else {
	            swap(arr, one, two--);
	        }
	    }
	}

	private static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp; 
	}
	
}
/*
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.
 *We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
You must solve this problem without using the library's sort function.
Example 1:	Input: nums = [2,0,2,1,1,0]	Output: [0,0,1,1,2,2]
Example 2:	Input: nums = [2,0,1]	Output: [0,1,2]
Constraints:
n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.
Follow up: Could you come up with a one-pass algorithm using only constant extra space?
 */
