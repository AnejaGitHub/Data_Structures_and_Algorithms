package com.dsa.striversheet.arrays;
import java.util.*;
import java.util.Scanner;

import com.dsa.readinputs.ReadInputs;

public class MergeIntervals {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int[][] arr = ReadInputs.parse2DArray(input);
		int[][] merged = mergeStream(arr);
		for(int[] row : merged) {
			System.out.println(Arrays.toString(row));
		}
	}

	public static int[][] merge(int[][] intervals) {
		List<int[]> list = new ArrayList<>();
		Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
		int l = intervals.length;
		for (int i = 0; i < l - 1; i++) {
			if (intervals[i][1] >= intervals[i + 1][0]) {
				intervals[i + 1][0] = intervals[i][0];
				intervals[i + 1][1] = Math.max(intervals[i][1], intervals[i + 1][1]);
			} else {
				list.add(new int[] { intervals[i][0], intervals[i][1] });
			}
		}
		list.add(new int[] { intervals[l - 1][0], intervals[l - 1][1] });
		return list.toArray(new int[list.size()][]);
	}
	
	private static int[][] mergeStream(int[][] arr) {
		List<int[]> merged = new ArrayList<>();
		Arrays.stream(arr)
			.sorted((a,b)-> a[0]-b[0])
			.forEach(interval -> {
				if(merged.isEmpty() || merged.get(merged.size()-1)[1] < interval[0]) {
					merged.add(interval);
				} else {
					merged.get(merged.size()-1)[1] = Math.max(merged.get(merged.size()-1)[1], interval[1]);
				}
			});
		return merged.toArray(new int[merged.size()][]);
	}

}
/*  
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
Example 1:Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
Example 2:	Input: intervals = [[1,15],[2,6],[8,10],[15,18]]
Output: [[1,18]]
 */
