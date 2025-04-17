package com.dsa.striversheet.arrays;

import java.util.Scanner;

public class PowerOfX {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int x = scanner.nextInt();
		int n = scanner.nextInt();
		System.out.println(pow(x, n));
	}
	private static double pow(int x, int n) {
		if(n<0) {
			x = 1/x;
			n = -n;
		}
		double ans = 1;
		while(n!=0) {
			if((n & 1) !=0) {
				ans *= x;
			}
			x *= x;
			n >>>=1;
		}
		return ans;
	}
}
