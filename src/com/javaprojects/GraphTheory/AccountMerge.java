package com.javaprojects.GraphTheory;

import java.util.*;

/**
 *
 *
 * 721. Accounts Merge
 * Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.
 *
 * Now, we would like to merge these accounts. Two accounts definitely
 * belong to the same person if there is some common email to both accounts.
 * Note that even if two accounts have the same name,
 * they may belong to different people as people could have the same name.
 * A person can have any number of accounts initially, but all of their accounts definitely have the same name.
 *
 * After merging the accounts,
 * return the accounts in the following format:
 * the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.
 *
 * Requirement:
 * go through the list of accounts and merge any accounts together if:
 *  they contains the same emails, either one of them or many similar emails
 *
 *  return list of account list, where each account list has the structured of name being the first element and email addresses followed and each email
 *  addresses must be sored.
 *
 *
 * Example 1:
 *
 * Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]

 * Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
 *
 * Explanation:
 * The first and second John's are the same person as they have the common email "johnsmith@mail.com".
 * The third John and Mary are different people as none of their email addresses are used by other accounts.
 * We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
 * ['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 * Example 2:
 *
 * Input: accounts = [["Gabe","Gabe0@m.co","Gabe3@m.co","Gabe1@m.co"],["Kevin","Kevin3@m.co","Kevin5@m.co","Kevin0@m.co"],["Ethan","Ethan5@m.co","Ethan4@m.co","Ethan0@m.co"],["Hanzo","Hanzo3@m.co","Hanzo1@m.co","Hanzo0@m.co"],["Fern","Fern5@m.co","Fern1@m.co","Fern0@m.co"]]
 * Output: [["Ethan","Ethan0@m.co","Ethan4@m.co","Ethan5@m.co"],["Gabe","Gabe0@m.co","Gabe1@m.co","Gabe3@m.co"],["Hanzo","Hanzo0@m.co","Hanzo1@m.co","Hanzo3@m.co"],["Kevin","Kevin0@m.co","Kevin3@m.co","Kevin5@m.co"],["Fern","Fern0@m.co","Fern1@m.co","Fern5@m.co"]]
 *
 *
 * Constraints:
 *
 * 1 <= accounts.length <= 1000
 * 2 <= accounts[i].length <= 10
 * 1 <= accounts[i][j] <= 30
 * accounts[i][0] consists of English letters.
 * accounts[i][j] (for j > 0) is a valid email.
 *
 *
 * Intuition: we will build out a graph of emails relationship, between the first email with all other emails in the current account list.
 *
 * once we build out the graph, we can merege two accounts together if they have a connected components in its email graph
 *
 *
 * Time complexity: O(NK \log{NK})O(NKlogNK)
 *
 * In the worst case, all the emails will end up belonging to a single person. The total number of emails will be N*KN∗K, and we need to sort these emails. DFS traversal will take NKNK operations as no email will be traversed more than once.
 *
 * Space complexity: O(NK)O(NK)
 *
 * Building the adjacency list will take O(NK)O(NK) space. In the end, visited will contain all of the emails hence it will use O(NK)O(NK) space. Also, the call stack for DFS will use O(NK)O(NK) space in the worst case.
 *
 * The space complexity of the sorting algorithm depends on the implementation of each programming language. For instance, in Java, Collections.sort() dumps the specified list into an array this will take O(NK)O(NK) space then Arrays.sort() for primitives is implemented as a variant of quicksort algorithm whose space complexity is O(\log NK)O(logNK). In C++ sort() function provided by STL is a hybrid of Quick Sort, Heap Sort, and Insertion Sort with the worst-case space complexity of O(\log NK)O(logNK).
 *
 *
 * **/
public class AccountMerge {
    public static List<List<String>> accountsMerge(List<List<String>> accounts){
        HashMap<String, List<String>> emailGraph = new HashMap<>();
        HashSet<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();
        //build out the graph
        for(List<String> account : accounts){
            String firstEmail = account.get(1);
            for(int i = 2; i < account.size(); i++){
                String currentEmail = account.get(i);
                emailGraph.computeIfAbsent(firstEmail, x -> new ArrayList<>()).add(currentEmail);
                emailGraph.computeIfAbsent(currentEmail, x -> new ArrayList<>()).add(firstEmail);
            }
        }

        for(List<String> account : accounts){
            String account_holder_name = account.get(0);
            String firstEmailAccount = account.get(1);

            if(!visited.contains(firstEmailAccount)){
                List<String> mergedAccount = new ArrayList<>();
                dfs(firstEmailAccount, mergedAccount, visited, emailGraph);
                Collections.sort(mergedAccount);
                //add the name into the merged version
                mergedAccount.add(0, account_holder_name);
                result.add(mergedAccount);
            }
        }

        return result;
    }


    //helepr method to apply dfs through the email graph
    private static void dfs(String email, List<String> mergedAccount, HashSet<String> visited, HashMap<String, List<String>> graph){
        //add the email into the visited and merged
        visited.add(email);
        mergedAccount.add(email);

        if(!graph.containsKey(email)){
            return;
        }

        for(String neiEmail : graph.get(email)){
            if(!visited.contains(neiEmail)){
                dfs(neiEmail, mergedAccount, visited, graph);
            }
        }
    }

}
