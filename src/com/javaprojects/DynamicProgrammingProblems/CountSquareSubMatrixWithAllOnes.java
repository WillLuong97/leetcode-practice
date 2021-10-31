package com.javaprojects.DynamicProgrammingProblems;

/**
 *
 *  Given a m * n matrix of ones and zeros, return how many square submatrices have all ones.
 *
 *
 *
 * Example 1:
 *
 * Input: matrix =
 * [
 *   [0,1,1,1],
 *   [1,1,1,1],
 *   [0,1,1,1]
 * ]
 *
 * [
 *   [0, 1, 1, 1],
 *   [1, 1, 2, 2],
 *   [0, 1, 2, 3]
 * ]
 *
 * Output: 15
 * Explanation:
 * There are 10 squares of side 1.
 * There are 4 squares of side 2.
 * There is  1 square of side 3.
 * Total number of squares = 10 + 4 + 1 = 15.
 * Example 2:
 *
 * Input: matrix =
 * [
 *   [1,0,1],
 *   [1,1,0],
 *   [1,1,0]
 * ]
 * Output: 7
 * Explanation:
 * There are 6 squares of side 1.
 * There is 1 square of side 2.
 * Total number of squares = 6 + 1 = 7.
 *
 *
 * Constraints:
 *
 * 1 <= arr.length <= 300
 * 1 <= arr[0].length <= 300
 * 0 <= arr[i][j] <= 1
 *
 * **/
public class CountSquareSubMatrixWithAllOnes {
    public static int countSquares(int[][] matrix) {
        //getting the size of the matrix dimension
        int m = matrix.length;
        int n  = matrix[0].length;

        //create a auxilary matrix with the same size of the matrix to calculate the square
        int[][] dp = new int[m][n];

        int result = 0;

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                //if the current cell is 0 then we will skip it
                if(matrix[i][j] == 0){
                    continue;
                }

                //if we are on the outer layer of the original matrix, then just add 1
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }

                //the inner layer of the matrix
                else if(dp[i-1][j] >= 1 && dp[i-1][j-1] >= 1 && dp[i][j-1] >= 1){
                    dp[i][j] = Math.min(dp[i-1][j], Math.min(dp[i][j-1], dp[i-1][j-1])) + 1;
                } else{
                    dp[i][j] = 1;
                }
                result += dp[i][j];
            }
        }
        return result;
    }
}
