package com.dsa.striversheet.arrays;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.dsa.readinputs.ReadInputs;

public class MajorityElements2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int[] arr = ReadInputs.parseArray(input);
		List<Integer> ans = findMajorities(arr); 
		System.out.println(ans);
	}
	private static List<Integer> findMajorities(int[] arr){
		List<Integer> ans = new ArrayList<>();
		int maj1 = Integer.MIN_VALUE, maj2 = maj1, c1 = 0, c2 = 0;
		for(int e: arr) {
			if(c1 == 0 && e != maj2) {
				maj1 = e; c1 = 1;
			} else if(c2 == 0 && e != maj1) {
				maj2 = e; c2 = 1;
			} else if(e == maj1) {
				c1++;
			} else if(e == maj2) {
				c2++;
			} else {
				c1--; c2--;
			}
		}
		c1 = 0; c2 = 0;
		for(int e : arr) {
			if(e == maj1)	c1++;
			if(e == maj2)	c2++;
		}
		if(c1>arr.length/3)		ans.add(maj1);
		if(c2>arr.length/3)		ans.add(maj2);
		return ans;
	}
}
/*Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
Example 1:	Input: nums = [3,2,3]
Output: [3]
Example 2:	Input: nums = [1]
Output: [1]
 * 
 */
