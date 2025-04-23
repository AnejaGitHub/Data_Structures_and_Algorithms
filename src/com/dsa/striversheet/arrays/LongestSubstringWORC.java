package com.dsa.striversheet.arrays;

import java.util.*;
import com.dsa.readinputes.ReadInputes;

public class LongestSubstringWORC {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.next();
		System.out.println(lengthOfLongestSubstring(input));
	}
	
	public static int lengthOfLongestSubstring(String s) {
        int l = s.length();
        if(l<2)    return l;
        Set<Character> set = new HashSet<>();
        int i = 0, j = 1;
        set.add(s.charAt(i));
        int ans = 1;
        while(j<l){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                j++;
            }else{
                ans = Math.max(ans, set.size());
                while(i<j && s.charAt(i) != s.charAt(j)){
                    set.remove(s.charAt(i));
                    i++;
                }
                j++; i++;
            }            
        }
        ans = Math.max(ans, set.size());
        return ans;
    }
}
/*LeetCode3. Longest Substring Without Repeating Characters
Given a string s, find the length of the longest substring without duplicate characters.
Example 1:	Input: s = "abcabcbb"	Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:	Input: s = "bbbbb"	Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:	Input: s = "pwwkew"	Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
 * 
 */
