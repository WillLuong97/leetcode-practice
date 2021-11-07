package com.javaprojects.DynamicProgrammingProblems;
/**
 *
 *
 * Given a string s, return the number of palindromic substrings in it.
 *
 * A string is a palindrome when it reads the same backward as forward.
 *
 * A substring is a contiguous sequence of characters within the string.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abc"
 *       a   b   c
 * dp = [1, 0, 0] => a
 *      [0, 1, 0] => b
 *      [0, 0, 1] => c
 *
 * "a" -> palindromic => 1
 * "ab" -> not palindromic => 1
 * "abc" -> not palindromic  => 1
 *
 * "b" -> palindromic => 2
 * "bc" -> not palindromic => 2
 * "c" -> palindromic => 3
 *
 * Bottom up approach:
 *  we will still have to generate all substring and check for the palindromic substring
 *  but with the bottom up approach, we can save some extra times for checking as we can cache the
 *  previous result on the previous palindromic substring that is also available in the current substring that we are checking
 * two pointer
 *
 * time complexity: O(n^2)
 * space complexity: O(n^2)
 *
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 * Example 2:
 *
 * Input: s = "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 *
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 * s consists of lowercase English letters.
 *
 *
 * **/
public class PalindromicSubstring {
    public static int countSubstrings(String s) {
        int size = s.length();
        Boolean[][] dp = new Boolean[size][size];
        int result = 0;
        for(int ch = 0; ch < size; ch++){
            for(int i = 0, j = i + ch; j < size; j++, i++){
                //the first character in the string
                if(ch == 0){
                    dp[i][j] = true;
                } else if(ch == 1){
                    if(s.charAt(i) == s.charAt(j)){
                        dp[i][j] = true;
                    } else {
                        dp[i][j] = false;
                    }
                } else{
                    if(s.charAt(i) == s.charAt(j) && dp[i+1][j-1]){
                        dp[i][j] = true;
                    } else{
                        dp[i][j] = false;
                    }
                }
                if(dp[i][j] == true){
                    result++;
                }
            }
        }
        return result;
    }

}
