package com.javaprojects.DynamicProgrammingProblems;

/**
 *Alice and Bob take turns playing a game, with Alice starting first.
 *
 * Initially, there is a number n on the chalkboard. On each player's turn, that player makes a move consisting of:
 *
 * Choosing any x with 0 < x < n and n % x == 0.
 * Replacing the number n on the chalkboard with n - x.
 * Also, if a player cannot make a move, they lose the game.
 *
 * Return true if and only if Alice wins the game, assuming both players play optimally.
 *
 *
 *
 * Example 1:
 *
 * Input: n = 2
 * Output: true
 * Explanation: Alice chooses 1, and Bob has no more moves.
 *  n = 2 => 0 , 1 , 2
 *  x = 1 => 2 - 1 = 1
 *  0, 1 => bob has no more moves
 *
 * Example 2:
 *
 * Input: n = 3
 * Output: false
 * Explanation: Alice chooses 1, Bob chooses 1, and Alice has no more moves.
 *
 * n = 3 => 0, 1, 2, 3
 * alice chooses 1: 3 % 1 == 0
 * 3 - 1 = 2
 * n = 2 => 0, 1, 2
 * bob will choose 1 => 2 - 1 =1
 * 0 1 => alice will lose
 *
 * n = 4 => 0,1,2,3,4 Alice takes 2
 * 4 - 2 = 2 => 0,1,2 bob takes 1
 * 2 - 1 = 1 => 0, 1
 * 0 , 1
 *
 * n = 5 => 0, 1, 2, 3, 4, 5
 * Constraints:
 *
 * 1 <= n <= 1000
 *  **/
public class DivisorGame {
    public boolean divisorGame(int n) {
        n-= 1;
        if(n % 2 == 0){
            return false;
        } else{
            return true;
        }
    }

}
