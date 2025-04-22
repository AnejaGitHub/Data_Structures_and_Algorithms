package com.dsa.striversheet.arrays;

import com.dsa.readinputs.ReadInputs;
import java.util.*;


public class TwoSum {
	public static void main(String[] args) {
		Scanner sc  = new Scanner(System.in);
		String input = sc.nextLine();
		int target = sc.nextInt();
		int[] arr = ReadInputs.parseArray(input);
		int[] ans = twoSum(arr, target);
		System.out.println(Arrays.toString(ans));
	}
	public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] ans = new int[2];
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(target - nums[i])){
                ans[0] = map.get(target - nums[i]);
                ans[1] = i;
                break;
            }
            map .put(nums[i], i);
        }
        return ans;
    }
}
/*Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
You may assume that each input would have exactly one solution, and you may not use the same element twice.
You can return the answer in any order.
Example 1:	Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
Example 2:	Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:	Input: nums = [3,3], target = 6
Output: [0,1]
 * 
 */
