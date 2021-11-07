package com.javaprojects.Test.DynamicProgrammingTest;

import com.javaprojects.DynamicProgrammingProblems.PalindromicSubstring;
import org.junit.Test;
import static org.junit.Assert.*;

public class testCountSubstring {
    @Test
    public void testCountSubstringCase1(){
        assertEquals(3, PalindromicSubstring.countSubstrings("abc"));
    }

    @Test
    public void testCountSubstringCase2(){
        assertEquals(6, PalindromicSubstring.countSubstrings("aaa"));
    }
}
