package com.dsa.striversheet.arrays;
import java.util.Arrays;
import java.util.Scanner;

import com.dsa.readinputs.ReadInputs;

public class RepeatAndMissing {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int[] arr = ReadInputs.parseArray(input);
		int[] ans = findRepeatAndMissing(arr);
		System.out.println(Arrays.toString(ans));
		ans = findRepeatAndMissingXOR(arr);
		System.out.println(Arrays.toString(ans));
	}

	private static int[] findRepeatAndMissing(int[] arr) {
		int s = 0, ss = 0, sn = 0, ssn = 0;
		for(int i=0; i<arr.length; i++) {
			s += arr[i];
			ss += (arr[i]*arr[i]);
			sn += (i+1);
			ssn += ((i+1)*(i+1));
		}
		int x = ((s-sn) + ((ss - ssn)/(s-sn))) / 2;
		int y = x - (s -sn);
		for(int e : arr) {
			if(e == x) {
				return new int[] {x, y};
			}
		}
		return new int[] {y, x};
	}
	private static int[] findRepeatAndMissingXOR(int[] arr) {
		int x=0, y=0, l = arr.length;
		int xr = 0;
		for(int i=0; i<l; i++) {
			xr ^= arr[i];
			xr ^= (i+1);
		}
		long xrn = ~(xr-1);
		int bit = xr & ~(xr-1);
		int zero = 0, one = 0;
		for(int i=0; i<l; i++) {
			if((arr[i] & bit) == 0) {
				zero ^= arr[i];
			} else {
				one ^= arr[i];
			}
		}
		
		for(int i=1; i<=l; i++) {
			if((i & bit) == 0) {
				zero ^= i;
			} else {
				one ^= i;
			}
		}
		for(int e : arr) {
			if(zero == e) {
				return new int[] {zero, one};
			}
		}
		
		return new int[] {one, zero};
	}
}
/*
 * You are given a read only array of n integers from 1 to n.

Each integer appears exactly once except A which appears twice and B which is missing.

Return A and B.

Note: Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

Note that in your output A should precede B.

Example:

Input:[3 1 2 5 3] 

Output:[3, 4] 

A = 3, B = 4
 * 
 * 
 */
