package com.javaprojects.Test.DynamicProgrammingTest;

import com.javaprojects.DynamicProgrammingProblems.CountSquareSubMatrixWithAllOnes;
import org.junit.Test;
import static org.junit.Assert.*;

public class CountSquareSubMatrixWithAllOnesTest {
    @Test
    public void testCountSquareCase1(){
        int[][] matrix = new int[][] {{0,1,1,1}, {1,1,1,1}, {0,1,1,1}};
        assertEquals(15, CountSquareSubMatrixWithAllOnes.countSquares(matrix));
    }

    @Test
    public void testCountSquareCase2(){
        int[][] matrix = new int[][] {{1,0,1}, {1,1,0}, {1,1,0}};
        assertEquals(7, CountSquareSubMatrixWithAllOnes.countSquares(matrix));
    }


}
