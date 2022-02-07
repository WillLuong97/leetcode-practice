package com.javaprojects.BinaryTree;

import javax.swing.tree.TreeNode;


/**

Given the root of a binary tree and a tree node x, return values of all ancestors of x in the binary tree. 
Two nodes of a binary tree are cousins of each other if they have different parents, 
but they are at the same level.

For example, consider the following binary tree

			 1
		   /   \
		 /		 \
		2		  3
	  /  \		 /  \
	 /	  \		/	 \
	4	   5   6	  7
			  /		   \
			 /			\ 
			8			9

Input: x = Node 9
Output: [7, 3, 1]

Input: x = Node 6
Output: [3, 1]

Input: x = Node 5
Output: [2, 1]

Input: x = Node 10
Output: []


The returned nodes should follow the node-to-root order. The solution should return an empty list if x is not the actual node in the tree.


Assumption/Requirement: 
- findAncestor() => will take in a tree and a target tree node, and return a list of all tree nodes in the current tree
that are the ancestor of the target node. 

- Ancestor: are treenode that are recursively the parent node of the current target. 

Constraints: 
- return a list of treenode. 
- the target we are looking for is a treenode and not the value of the tree node, i.e int or char. 
- The binary tree can be full, balanced or empty 
- target can sometimes be in the tree or not. 

Solution: 
Tree traversal + backtracking 

+ Traverse the tree to find the target node.
+ Once the target node is found, we will backtrack to its parent and add it to the list 
+ And keep backtracking and adding the ancestor node to the list until we can't backtrack anymore 
+ return result. 

1. How to find the target node in the tree? 
- traverse the tree
	+ is the current node the target node (curr.val == target.val)
	+ if so, then backtrack and add its ancestor to the list 
	+ if not, then recursively call the search fucntion to look for the left and right subtree of the current node 
		+ search(currNode.left) => return true if found, false if none can be found 
		+ search(currNode.right)

2. How do we add the ancestor into the result list? 
- Target found!
	+ return true and back to the previous recursion and add the parent to list 
	+ repeat the process until we reach the root node 

Time complexity: O(n)
 **/

public class FindTreeNodeAncestor {
    public static void findAncestor(TreeNode root, TreeNode target){
    	return findAndPrintAncestor(root, target)
    }

    //helper recursive method to find the target node in the tree 
    private static boolean findAndPrintAncestor(TreeNode node, TreeNode target){
    	//base case:  the current node is null, so we skip it
    	if(node == null){
    		return false;

    	}
		if(node.val == target.val){
			return true;
		}

		boolean targetFoundOnTheLeft = isFound(node.left, target);
		boolean targetFoundOnTheRight = false;

		if(!targetFoundOnTheLeft){
			targetFoundOnTheRight = isFound(node.right, target);
		}

		if(targetFoundOnTheLeft || targetFoundOnTheRight){
			System.out.println(node.val + " ");
		}


		return targetFoundOnTheLeft || targetFoundOnTheRight;
    }


}
