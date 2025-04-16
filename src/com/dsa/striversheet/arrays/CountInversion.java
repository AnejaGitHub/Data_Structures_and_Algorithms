package com.dsa.striversheet.arrays;

import java.util.Arrays;
import java.util.Scanner;
//import ReadInputs class => com.dsa.readiputs.ReadInputs;

import com.dsa.readinputs.ReadInputs;

public class CountInversion {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int[] arr = ReadInputs.parseArray(input);
		int[] count = new int[] {0};
		mergeSort(arr, 0, arr.length-1, count);
		System.out.println(Arrays.toString(arr) + " inversion count: " + Arrays.toString(count));
	}
	private static void mergeSort(int[] arr, int l, int r, int[] c) {
		
		if (l < r) {
			int mid = (l + r) / 2;
			mergeSort(arr, l, mid, c);
			mergeSort(arr, mid + 1, r, c);
			c[0] += merge(arr, l, mid, r);
		}
	}

	private static int merge(int[] arr, int l, int mid, int r) {
		int count = 0;
		int n1 = mid-l+1, n2 = r-mid;
		int[] num1 = new int[n1], num2 = new int[n2];
		for(int i=0; i<n1; i++) {
			num1[i] = arr[l+i];
		}
		for(int i=0; i<n2; i++) {
			num2[i] = arr[mid+i+1]; 
		}
		int i=0, j=0, k = l;
		while(i<n1 && j<n2) {
			if(num1[i]<=num2[j]) {
				arr[k++] = num1[i++];
			} else {
				arr[k++] = num2[j++];
				count += n1-i; // ==============+++++++++++ main thing happens here +++++++++++++============
			}
		}
		while(i<n1) {
			arr[k++] = num1[i++];
		}
		while(j<n2) {
			arr[k++] = num2[j++];
		}
		return count;
	}
}
