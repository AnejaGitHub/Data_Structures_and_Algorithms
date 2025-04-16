package com.dsa.striversheet.arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;


public class PascalTrianlge {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(bf.readLine());
		List<List<Integer>> triangle = pascalTriangle(n);
		for(List<Integer> list : triangle) {
			System.out.println(list);
		}
	}

	private static List<List<Integer>> pascalTriangle(int n) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
//		List<Integer> l = new ArrayList<Integer>();
//		l.add(1);
//		list.add(l);
//		n--;
//		while(n-->0) {
//			List<Integer> ol = list.get(list.size()-1);
//			l = new ArrayList<Integer>();
//			l.add(1);
//			for(int i=0; i<ol.size()-1; i++) {
//				l.add(ol.get(i) + ol.get(i+1));
//			}
//			l.add(1);
//			list.add(l);
//		}
		// short version
		list.add(List.of(1));
		IntStream.range(1, n).forEach(i -> {
			List<Integer> prev = list.get(i-1);
			List<Integer> row = new ArrayList<>();
			row.add(1);
			IntStream.range(0,prev.size()-1).forEach(j -> row.add(prev.get(j) + prev.get(j+1)));
			row.add(1);
			list.add(row);
		});
		return list;
	}
}
/*
 * Given an integer numRows, return the first numRows of Pascal's triangle.
 * In Pascal's triangle, each number is the sum of the two numbers directly above it
Example 1:Input: numRows = 5
Output: [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
Example 2:Input: numRows = 1
Output: [[1]]

Constraints: 1 <= numRows <= 30
 */
