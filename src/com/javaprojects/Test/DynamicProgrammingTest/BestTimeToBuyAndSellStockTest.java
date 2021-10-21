package com.javaprojects.Test.DynamicProgrammingTest;

import com.javaprojects.DynamicProgrammingProblems.BestTimeToBuyAndSellStock;
import org.junit.Test;
import static org.junit.Assert.*;

public class BestTimeToBuyAndSellStockTest {
    @Test
    public void testmaxProfitCase1(){
        assertEquals(5, BestTimeToBuyAndSellStock.maxProfit(new int[]{7,1,5,3,6,4}));
    }

    @Test
    public void testmaxProfitCase2(){
        assertEquals(0, BestTimeToBuyAndSellStock.maxProfit(new int[]{7,6,4,3,1}));
    }

}
