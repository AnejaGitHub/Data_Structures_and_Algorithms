package com.dsa.striversheet.arrays;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import com.dsa.readinputs.ReadInputs;

public class Rotate2DArray {
	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		String input = bf.readLine();
		int[][] arr = ReadInputs.parse2DArray(input);
		for(int[] row : arr) {
			System.out.println(Arrays.toString(row));
		}
		rotate90D(arr);
		System.out.println("After rotate");
		for(int[] row : arr) {
			System.out.println(Arrays.toString(row));
		}
	}
	private static void rotate90D(int[][] arr) {
		int n = arr.length;
		for(int i=0; i<n; i++) {
			for(int j=i; j<n; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[j][i];
				arr[j][i] = temp; 
			}
		}
		for(int i=0; i<n; i++) {
			for(int j=0; j<n/2; j++) {
				int temp = arr[i][j];
				arr[i][j] = arr[i][n-j-1];
				arr[i][n-1-j] = temp;
			}
		}
	}
}
/*
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
Output: [[7,4,1],[8,5,2],[9,6,3]]
Input: matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
Output: [[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
 */
