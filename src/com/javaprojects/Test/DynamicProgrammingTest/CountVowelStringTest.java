package com.javaprojects.Test.DynamicProgrammingTest;

import static org.junit.Assert.*;
import com.javaprojects.DynamicProgrammingProblems.CountVowelString;
import org.junit.Test;

public class CountVowelStringTest {
    @Test
    public void testCountVowelStringCase1(){
        assertEquals(5, CountVowelString.countVowelStrings(1));
    }
    @Test
    public void testCountVowelStringCase2(){
        assertEquals(15, CountVowelString.countVowelStrings(2));
    }

    @Test
    public void testCountVowelStringCase33(){
        assertEquals(66045, CountVowelString.countVowelStrings(33));
    }


}
