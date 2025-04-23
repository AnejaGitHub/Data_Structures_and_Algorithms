package com.dsa.striversheet.arrays;

import java.util.*;
import java.util.Scanner;
import com.dsa.readinputes.ReadInputs;

public class FourSum {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		int target = scanner.nextInt();
		int[] arr = ReadInputs.parseArray(input);
		System.out.println(fourSum(arr, target));
	}
	
	public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int l = nums.length;
        if(l<4) return new ArrayList<>(new ArrayList<>());
        List<List<Integer>> ans = new ArrayList<>();
        for(int a=0; a<l; a++){
            if(a>0 && nums[a] == nums[a-1]) continue; // remove duplicate four sum
            for(int b=a+1; b<l; b++){
                if(b>a+1 && nums[b] == nums[b-1]) continue; // remove duplicate four sum
                int c = b+1, d = l-1;
                while(c<d){
                    long sum = nums[a] + nums[b] + nums[c] + nums[d];
                    if(sum == target){
                        List<Integer> fs = Arrays.asList(nums[a], nums[b], nums[c], nums[d]);
                        ans.add(fs);
                        c++; d--;
                        while(c<d && nums[c] == nums[c-1])  c++; // remove duplicate four sum
                        while(c<d && nums[d] == nums[d+1])  d--; // remove duplicate four sum
                    }
                    else if(sum<target){
                        c++;
                    } else{
                        d--;
                    }
                }
            }
        }
        return ans;
    }
}
/*LeetCode 18: Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:
0 <= a, b, c, d < n		a, b, c, and d are distinct.
nums[a] + nums[b] + nums[c] + nums[d] == target
You may return the answer in any order.
Example 1:	Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
Example 2:	Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]
 * 
 */
