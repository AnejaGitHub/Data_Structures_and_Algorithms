package com.dsa.striversheet.arrays;

import java.util.Scanner;
import com.dsa.readinputs.ReadInputs;

public class ReversePair {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		int[] arr = ReadInputs.parseArray(input);
		int[] count = new int[1];
		mergeSort(arr, 0, arr.length-1, count);
		System.out.println(count[0]);
	}

	private static void mergeSort(int[] arr, int left, int right, int[] count) {
		if(left<right) {
			int mid = (left + right)/2;
			mergeSort(arr, left, mid, count);
			mergeSort(arr, mid+1, right, count);
			count[0]  += countInversion(arr, left, mid, right);
			merge(arr, left, mid, right);
		}
	}

	private static void merge(int[] nums, int l, int m, int r){
        int n1 = m-l+1, n2 = r-m;
        int[] num1 = new int[n1], num2 = new int[n2];
        for(int i=0; i<n1; i++){
            num1[i] = nums[l+i];
        }
        for(int i=0; i<n2; i++){
            num2[i] = nums[m+1+i];
        }
        int i=0, j=0, k = l;
        while(i<n1 && j<n2){
            if(num1[i]<num2[j]){
                nums[k++] = num1[i++];
            } else{
                nums[k++] = num2[j++];
            }
        }
        while(i<n1){
            nums[k++] = num1[i++];
        }
        while(j<n2){
            nums[k++] = num2[j++];
        }
    }

	private static int countInversion(int[] nums, int left, int mid, int right){
        int c = 0, r = mid+1;
        for(int i=left; i<=mid; i++){
            while(r<=right && (long)nums[i] > 2L* (long)nums[r])  r++;
            c += r - (mid+1);
        }
        return c;
    }	
}
/*Given an integer array nums, return the number of reverse pairs in the array.
A reverse pair is a pair (i, j) where:	0 <= i < j < nums.length and nums[i] > 2 * nums[j].
Example 1:	Input: nums = [1,3,2,3,1]	Output: 2
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 3, nums[4] = 1, 3 > 2 * 1
Example 2:	Input: nums = [2,4,3,5,1]	Output: 3
Explanation: The reverse pairs are:
(1, 4) --> nums[1] = 4, nums[4] = 1, 4 > 2 * 1
(2, 4) --> nums[2] = 3, nums[4] = 1, 3 > 2 * 1
(3, 4) --> nums[3] = 5, nums[4] = 1, 5 > 2 * 1
 */
