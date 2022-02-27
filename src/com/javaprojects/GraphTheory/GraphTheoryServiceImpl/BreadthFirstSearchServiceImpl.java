package com.javaprojects.GraphTheory.GraphTheoryServiceImpl;

import com.javaprojects.GraphTheory.BreadthFirstSearchService;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class BreadthFirstSearchServiceImpl implements BreadthFirstSearchService {
    //Time complexity: O(v+e), v is the number of vertices in the grid and e is the number of edges in the grid
//    @Override
    public static List<Integer> levelOrderTraversal(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        List<Integer> result = new ArrayList<>();

        //base case: the grid only have 1 element
        if(m == 1 && n == 1){
            result.add(grid[m-1][n-1]);
            return result;
        }

        //create a queue and visited array to keep track of the next processing node and
        //visited node
        boolean[][] visited = new boolean[m][n];

        Deque<int[]> queue = new LinkedList<>();

        int[][] DIRECTIONS = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
        //push the source node (0,0) onto the queue to begin bfs
        queue.offerLast(new int[]{0,0});

        //begin dfs
        while(!queue.isEmpty()){
            //keep track of which level we are at
//            int size = queue.size();
//            while(size-- != 0){
            int[] current = queue.poll();
            result.add(grid[current[0]][current[1]]);
            //begin branching out to the next node
            for(int[] direction : DIRECTIONS){
                //getting the new coordinate of the current node neighbor
                int newM = current[0] + direction[0];
                int newN = current[1] + direction[1];
                //check to see if the new coordinate are in boundary or not
                if(newM < 0 || newM >= m-1 || newN < 0 || newN >= n-1){
                    continue;
                }
                //check if the element has been visited or not
                if(!visited[newM][newN]){
                    visited[newM][newN] = true;
                    queue.offerLast(new int[]{newM, newN});
                }

            }
//        }
        }

        return result;
    }

    @Override
    public int shortestDistance(int[][] grid) {
        return 0;
    }

    public static void main(String[] args){
        int[][] grid = new int[][]{{0,1},{2,3}};
        System.out.println(levelOrderTraversal(grid));
    }
}
