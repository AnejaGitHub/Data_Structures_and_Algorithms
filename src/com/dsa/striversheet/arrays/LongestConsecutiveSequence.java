package com.dsa.striversheet.arrays;

import java.util.*;
import com.dsa.readinputes.ReadInputes;

public class LongestConsecutiveSequence {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		int[] arr = ReadInputs.parseArray(input);
		System.out.println(longestConsecutive(arr));
	}
	public static int longestConsecutive(int[] nums) {
        if(nums.length == 0)    return 0;
        Set<Integer> set = new HashSet<>();
        int ans = 1;
        for(int e : nums){
            set.add(e);
        }
        for(int e : set){
            if(!set.contains(e-1)){
                int x = e, count = 0;                
                while(set.contains(x)){
                    count++;
                    x++;
                }
                ans = Math.max(ans, count);
            }
        }
        return ans;
    }
}
/*LeetCode 128: Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
You must write an algorithm that runs in O(n) time.
Example 1:	Input: nums = [100,4,200,1,3,2]		Output: 4
Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
Example 2:	Input: nums = [0,3,7,2,5,8,4,6,0,1]	Output: 9
Example 3:	Input: nums = [5,0,4,3]	Output: 3
Constraints:
0 <= nums.length <= 105
-109 <= nums[i] <= 109
 * 
 */
