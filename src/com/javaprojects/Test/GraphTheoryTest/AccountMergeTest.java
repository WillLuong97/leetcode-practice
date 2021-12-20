package com.javaprojects.Test.GraphTheoryTest;


import com.javaprojects.GraphTheory.AccountMerge;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

//Test cases for Leetcode 721 - Accounts merge
public class AccountMergeTest {

    static class Accounts{
        private List<List<String>> accountInfo;
        //constructors
        public Accounts() {
        }

        public List<List<String>> getAccountInfo() {
            return accountInfo;
        }

        public void setAccountInfo(List<List<String>> accountInfo) {
            this.accountInfo = accountInfo;
        }
    }

    //list of test cases to pass
    public List<Accounts> generateTestCases(){
        //main list to store all test cases
        List<Accounts> output = new ArrayList<>();
        List<List<String>> mockedAccountList1 = new ArrayList<>();
        Accounts testAccount1 = new Accounts();
        List<List<String>> mockedAccountList2 = new ArrayList<>();
        Accounts testAccount2 = new Accounts();

        List<String> account_info_1_for_test_1 = new ArrayList<>();
        account_info_1_for_test_1.add("John");
        account_info_1_for_test_1.add("johnsmith@mail.com");
        account_info_1_for_test_1.add("john_newyork@mail.com");
        List<String> account_info_2_for_test_1 = new ArrayList<>();
        account_info_2_for_test_1.add("John");
        account_info_2_for_test_1.add("johnsmith@mail.com");
        account_info_2_for_test_1.add("john00@mail.com");
        List<String> account_info_3_for_test_1 = new ArrayList<>();
        account_info_3_for_test_1.add("Mary");
        account_info_3_for_test_1.add("mary@mail.com");
        List<String> account_info_4_for_test_1 = new ArrayList<>();
        account_info_4_for_test_1.add("John");
        account_info_4_for_test_1.add("johnnybravo@mail.com");

        mockedAccountList1.add(account_info_1_for_test_1);
        mockedAccountList1.add(account_info_2_for_test_1);
        mockedAccountList1.add(account_info_3_for_test_1);
        mockedAccountList1.add(account_info_4_for_test_1);

        List<String> account_info_1_for_test_2 = new ArrayList<>();
        account_info_1_for_test_2.add("Gabe");
        account_info_1_for_test_2.add("Gabe0@m.co");
        account_info_1_for_test_2.add("Gabe3@m.co");
        account_info_1_for_test_2.add("Gabe1@m.co");

        List<String> account_info_2_for_test_2 = new ArrayList<>();
        account_info_2_for_test_2.add("Kevin");
        account_info_2_for_test_2.add("Kevin3@m.co");
        account_info_2_for_test_2.add("Kevin5@m.co");
        account_info_2_for_test_2.add("Kevin0@m.co");

        List<String> account_info_3_for_test_2 = new ArrayList<>();
        account_info_3_for_test_2.add("Ethan");
        account_info_3_for_test_2.add("Ethan5@m.co");
        account_info_3_for_test_2.add("Ethan4@m.co");
        account_info_3_for_test_2.add("Ethan0@m.co");

        List<String> account_info_4_for_test_2 = new ArrayList<>();
        account_info_4_for_test_2.add("Hanzo");
        account_info_4_for_test_2.add("Hanzo3@m.co");
        account_info_4_for_test_2.add("Hanzo1@m.co");
        account_info_4_for_test_2.add("Hanzo0@m.co");


        List<String> account_info_5_for_test_2 = new ArrayList<>();
        account_info_5_for_test_2.add("Fern");
        account_info_5_for_test_2.add("Fern5@m.co");
        account_info_5_for_test_2.add("Fern1@m.co");
        account_info_5_for_test_2.add("Fern0@m.co");

        testAccount1.setAccountInfo(mockedAccountList1);
        testAccount2.setAccountInfo(mockedAccountList2);

        output.add(testAccount1);
        output.add(testAccount2);
        return output;
    }


    //method to generate the ouput
    public List<Accounts> generateExpectedResult(){
        List<Accounts> result = new ArrayList<>();
        Accounts expected_1 = new Accounts();
        Accounts expected_2 = new Accounts();
        List<List<String>> expectedResultForTest1 = new ArrayList<>();
        List<List<String>> expectedResultForTest2 = new ArrayList<>();
        List<String> result_1_for_test_1 = new ArrayList<>();
        result_1_for_test_1.add("John");
        result_1_for_test_1.add("john00@mail.com");
        result_1_for_test_1.add("john_newyork@mail.com");
        result_1_for_test_1.add("johnsmith@mail.com");
        List<String> result_2_for_test_1 = new ArrayList<>();
        result_2_for_test_1.add("Mary");
        result_2_for_test_1.add("mary@mail.com");
        List<String> result_3_for_test_1 = new ArrayList<>();
        result_3_for_test_1.add("John");
        result_3_for_test_1.add("johnnybravo@mail.com");
        expectedResultForTest1.add(result_1_for_test_1);
        expectedResultForTest1.add(result_2_for_test_1);
        expectedResultForTest1.add(result_3_for_test_1);



        List<String> result_1_for_test_2 = new ArrayList<>();
        result_1_for_test_2.add("Ethan");
        result_1_for_test_2.add("Ethan0@m.co");
        result_1_for_test_2.add("Ethan4@m.co");
        result_1_for_test_2.add("Ethan5@m.co");
        List<String> result_2_for_test_2 = new ArrayList<>();
        result_2_for_test_2.add("Gabe");
        result_2_for_test_2.add("Gabe0@m.co");
        result_2_for_test_2.add("Gabe1@m.co");
        result_2_for_test_2.add("Gabe3@m.co");
        List<String> result_3_for_test_2 = new ArrayList<>();
        result_3_for_test_2.add("Hanzo");
        result_3_for_test_2.add("Hanzo0@m.co");
        result_3_for_test_2.add("Hanzo1@m.co");
        result_3_for_test_2.add("Hanzo3@m.co");
        List<String> result_4_for_test_2 = new ArrayList<>();
        result_4_for_test_2.add("Kevin");
        result_4_for_test_2.add("Kevin0@m.co");
        result_4_for_test_2.add("Kevin3@m.co");
        result_4_for_test_2.add("Kevin5@m.co");
        List<String> result_5_for_test_2 = new ArrayList<>();
        result_5_for_test_2.add("Fern");
        result_5_for_test_2.add("Fern0@m.co");
        result_5_for_test_2.add("Fern1@m.co");
        result_5_for_test_2.add("Fern5@m.co");
        expectedResultForTest2.add(result_1_for_test_2);
        expectedResultForTest2.add(result_2_for_test_2);
        expectedResultForTest2.add(result_3_for_test_2);
        expectedResultForTest2.add(result_4_for_test_2);
        expectedResultForTest2.add(result_5_for_test_2);

        expected_1.setAccountInfo(expectedResultForTest1);
        expected_2.setAccountInfo(expectedResultForTest2);

        result.add(expected_1);
        result.add(expected_2);
        return result;

    }

    @Test
    public void testAccountMergeSuccessCases(){
        //generate test cases:
        List<Accounts> generatedAccounts = generateTestCases();
        List<Accounts> generatedExpectedOutput = generateExpectedResult();

        //iterate through each accounts and run the methods through it
        for(int i = 0; i < generatedAccounts.size(); i++){
            assertEquals(generatedExpectedOutput.get(i).accountInfo, AccountMerge.accountsMerge(generatedAccounts.get(i).getAccountInfo()));
        }
    }

}
