package com.javaprojects.GraphTheory;

import java.util.List;

public interface BreadthFirstSearchService {
    /**
     * levelOrderTraversal() The method uses the level order traversal in a graph
     * to walk through the graph and return the a list of element that are contained in the graph
     *
     * @param grid A 2d matrix of mxn size that contains all
     *
     * @return an array that stores all element in the original grid
     *
     * constraints: the grid would always be valid and the we can only move up down left and right to move around the grid
     * **/

//    public List<Integer> levelOrderTraversal(int[][] grid);


    /**
     * shortestDistance() The method will return the minimum number of steps needed to
     * walk through a given 2-d grid
     *
     * @param grid A 2d matrix of mxn size that contains all
     *
     * @return an integer represent the smallest number of steps needed to walk through
     * the given 2-d grid.
     * **/

    public int shortestDistance(int[][] grid);

}
