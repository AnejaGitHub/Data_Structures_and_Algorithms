package com.dsa.striversheet.arrays;

import java.util.Scanner;

import com.dsa.readinputs.ReadInputs;

public class SearchInMatrix {
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int target = sc.nextInt();
		int[][] mat = ReadInputs.parse2DArray(input);
		System.out.println(searchMatrix(mat, target));
	}

	public static boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m-1;
        while(top<=bottom){
            int mid = (top+bottom)/2;
            if(matrix[mid][0] == target)	return true;
            if(matrix[mid][0] > target){
            	bottom = mid-1;
            } else{
            	top = mid+1;
            }
        }
        if (bottom < 0) return false; // No valid row
        int row = bottom, l = 0, r = n-1;
        while(l<=r){
            int mid = (l+r)/2;
            if(matrix[row][mid] == target){
                return true;
            } else if(matrix[row][mid] < target){
                l = mid+1;
            } else{
                r = mid-1;
            }
        }
        return false;
    }
}
/*
You are given an m x n integer matrix matrix with the following two properties:

Each row is sorted in non-decreasing order.
The first integer of each row is greater than the last integer of the previous row.
Given an integer target, return true if target is in matrix or false otherwise.
You must write a solution in O(log(m * n)) time complexity.
Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
Output: true
*/
