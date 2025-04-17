package com.dsa.striversheet.arrays;

import com.dsa.readinputs.ReadInputs;
import java.util.Scanner;

public class MajorityElement1 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int[] arr = ReadInputs.parseArray(input);
		System.out.println(findMajority(arr));
		
	}
	private static int findMajority(int[] arr) {
		int maj = Integer.MIN_VALUE, count = 0;
		for(int e : arr) {
			if(count == 0) {
				maj = e;
				count = 1;
			}else if(e != maj) {
				count --;
				if(count == 0) {
					maj = e; count = 1;
				}
			} else {
				count++;
			}
		}
		return maj;
	}
}
/*The majority element is the element that appears more than ⌊n / 2⌋ times. You may assume that the majority element always exists in the array.
Example 1:	Input: nums = [3,2,3]
Output: 3
Example 2:	Input: nums = [2,2,1,1,1,2,2]
Output: 2
 */
