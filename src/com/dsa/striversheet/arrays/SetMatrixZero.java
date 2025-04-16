package com.dsa.striversheet.arrays;
import java.io.*;
import java.util.*;
import java.util.Scanner;
import java.util.stream.IntStream;

import com.dsa.readinputs.ReadInputs;


public class SetMatrixZero {

	public static void main(String[] args) throws IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//		String input = bf.readLine();
		Scanner sc = new Scanner(System.in);
		String in = sc.nextLine();
		int[][] arr = ReadInputs.parse2DArray(in);
		for (int[] row : arr) {
			System.out.println(Arrays.toString(row));
		}
		System.out.println("after");
		setZeros(arr);
		for (int[] row : arr) {
			System.out.println(Arrays.toString(row));
		}
	}

	private static void setZeros(int[][] arr) {
		int m = arr.length, n = arr[0].length;
		boolean[] row = new boolean[m], col = new boolean[n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(arr[i][j] == 0) {
					row[i] = true;
					col[j] = true; 
				}
			}
		}
		System.out.println("row" + Arrays.toString(row));
		System.out.println("col" + Arrays.toString(col));
//		for(int i=0; i<n; i++) {
//			if(col[i]) {
//				for (int k = 0; k < m; k++)
//					arr[k][i] = 0;
//			}
//		}
//		for(int i=0; i<m; i++) {
//			if(row[i]) {
//				for (int k = 0; k < n; k++)
//					arr[i][k] = 0;
//			}
//		}
		IntStream.range(0, n).filter(i -> col[i]).forEach(i -> IntStream.range(0, m).forEach(k -> arr[k][i] = 0));
		IntStream.range(0, m).filter(i -> row[i]).forEach(i -> IntStream.range(0, n).forEach(k -> arr[i][k] = 0));

	}

}
/*
 * Given an m x n integer matrix matrix, if an element is 0, set its entire row
 * and column to 0's.
 * 
 * You must do it in place. 
 * Input: matrix = [[1,1,1],[1,0,1],[1,1,1]] 
 * Output:[[1,0,1],[0,0,0],[1,0,1]]
 * Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
 * Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
 */
