package com.dsa.striversheet.arrays;
import java.util.Scanner;
//import ReadInputs class => com.dsa.readiputs.ReadInputs;

import com.dsa.readinputs.ReadInputs;

public class FindDuplicate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int[] arr = ReadInputs.parseArray(input);
		System.out.println(findDuplicate(arr));
	}
	public static int findDuplicate(int[] nums) {
         while(nums[0] != nums[nums[0]]){
             // System.out.println(Arrays.toString(nums));
             int temp = nums[nums[0]];
             nums[nums[0]] = nums[0];
             nums[0] = temp;
         }
         return nums[0];

          
  }
	private static int findDuplicateUsingCycle(int[] nums) {
		// using slow and fast pointer(just like cycle detection)
        int slow = nums[0], fast = nums[0];
        while(true){
            System.out.println(slow + " " + fast);
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast)    break;
        }
        int slow2 = nums[0];
        while (slow != slow2) {
            slow = nums[slow];
            slow2 = nums[slow2];
        }
        return slow;
	}
}
/*Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
There is only one repeated number in nums, return this repeated number.
You must solve the problem without modifying the array nums and using only constant extra space.
Example 1:	Input: nums = [1,3,4,2,2]
Output: 2
Example 2:	Input: nums = [3,1,3,4,2]
Output: 3
Example 3:	Input: nums = [3,3,3,3,3]
Output: 3
 * 
 */
