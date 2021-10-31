package com.javaprojects.Test.DynamicProgrammingTest;

import static org.junit.Assert.*;

import com.javaprojects.DynamicProgrammingProblems.CountSubstringThatDiffersByOneCharacter;
import com.javaprojects.DynamicProgrammingProblems.CountVowelString;
import org.junit.Test;

public class CountSubstringThatDiffersByOneCharacterTest {
    @Test
    public void testCountSubstringCase1(){
        assertEquals(6, CountSubstringThatDiffersByOneCharacter.countSubstrings("aba", "baba"));
    }

    @Test
    public void testCountSubstringCase2(){
        assertEquals(3, CountSubstringThatDiffersByOneCharacter.countSubstrings("ab", "bb"));
    }

    @Test
    public void testCountSubstringCase3(){
        assertEquals(0, CountSubstringThatDiffersByOneCharacter.countSubstrings("a", "a"));
    }

    @Test
    public void testCountSubstringCase4(){
        assertEquals(10, CountSubstringThatDiffersByOneCharacter.countSubstrings("abe", "bbc"));
    }


}
