package com.javaprojects.DynamicProgrammingProblems;
/**
 The Fibonacci numbers, commonly denoted F(n) form a sequence, called the Fibonacci sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is,

 F(0) = 0, F(1) = 1
 F(n) = F(n - 1) + F(n - 2), for n > 1.
 Given n, calculate F(n).

 Example 1:

 Input: n = 2
 Output: 1
 Explanation: F(2) = F(1) + F(0) = 1 + 0 = 1.

n = 2
 f(2) = f(2-1) + f(2-2) = f(1) + f(0) = 1 + 0 = 1
n=3
 f(3) = f(3-1) + f(3-2) = f(2) + f(1) = 1 + 1 = 2
n=4
 f(4) = f(4-1) + f(4-2) = f(3) + f(2) = (f(3-1) + f(3-2)) + (f(2-1) + f(2-2)) = f(2) + f(1) + f(1) + f(0) = 3

 Recursive approach
 time complexity: O(2^n)
 space complexity: O(n), n is the size of the recursion stack

 Bottom up approach: where we cache the sub solution of each fibonacci sequence for later calculation
 f(4-1) + f(4-2) = f(3) + f(2) = 2 + 1 = 3

 time complexity: O(n), we just go through the array to find the solutions and plug it into the current calculation
 space complexity: O(n), n is the size of cached sub solutions, stored these in an array

 Example 2:

 Input: n = 3
 Output: 2
 Explanation: F(3) = F(2) + F(1) = 1 + 1 = 2.
 Example 3:

 Input: n = 4
 Output: 3
 Explanation: F(4) = F(3) + F(2) = 2 + 1 = 3.

 Constraints:
 0 <= n <= 30

 **/
public class FibonacciNumber {
    //recursive appraoch
    public int fib(int n) {
        if(n <= 1){
            return n;
        }
        return fib(n-1) + fib(n-2);
    }

    //bottom up approach
    public int fib_BOTTOM_UP(int n){
        //create an array to store all the calculated fibonacci sequence
        int[] dp = new int[n+2]; //handle edge cases where n = 0
        //base cases:
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }

        return dp[n];
    }
}
