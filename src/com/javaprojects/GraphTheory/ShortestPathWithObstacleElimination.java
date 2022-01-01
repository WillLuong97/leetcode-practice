package com.javaprojects.GraphTheory;
/** 
1293. Shortest Path in a Grid with Obstacles Elimination


Description: 
You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle). You can move up, down, left, or right from and to an empty cell in one step.
Return the minimum number of steps to walk from the upper left corner (0, 0) to the lower right corner (m - 1, n - 1) given that you can eliminate at most k obstacles. 
If it is not possible to find such walk return -1.


Requirement: 
- given a grid and an integer k return the shortest distance path from left corner (0, 0) to the lower right corner (m - 1, n - 1), with 
the condition that we can eliminate k obstacle 



Assumption:
=> shortest distance (BFS) + obstacle elimination (meaning that we have to check a cell more than once, to see if the path in this current cell can be smaller
after reducing the obstacles along the way)

grid = [
		[0,0,0],
		[1,1,0],
		[0,0,0],
		[0,1,1],
		[0,0,0]
				], k = 1



Example 1:

Input: grid = [[0,0,0],[1,1,0],[0,0,0],[0,1,1],[0,0,0]], k = 1
Output: 6
Explanation: 
The shortest path without eliminating any obstacle is 10.
The shortest path with one obstacle elimination at position (3,2) is 6. Such path is (0,0) -> (0,1) -> (0,2) -> (1,2) -> (2,2) -> (3,2) -> (4,2).
Example 2:


Input: grid = [[0,1,1],[1,1,1],[1,0,0]], k = 1
Output: -1
Explanation: We need to eliminate at least two obstacles to find such a walk.
 

Constraints:

m == grid.length
n == grid[i].length
1 <= m, n <= 40
1 <= k <= m * n
grid[i][j] is either 0 or 1.
grid[0][0] == grid[m - 1][n - 1] == 0



time complexity: O(mxn), mxn where m and n are the rows and cols of the grid
space complexity: O(mxn), we have to store space for the visited array with the same size 
as the grid 

**/


public class ShortestPathWithObstacleElimination {
	private static final int[][] DIRECTIONS = {{1,0}, {-1,0}, {0,1}, {0,-1}};
	public int shortestPath(int[][] grid, int k) {
		//extracting the rol and col number of the grid 
		int m = grid.length;
		int n = grid[0].length;

		//base case: 
		if(m == 1 && n == 1){
			return 0;
		}

		//create a visited array to store the visited node with its kth removed obstacle 
		int[][] visited = new int[m][n];

		//prefil this array with an arbitrarily big number 
		for(int[] i : visited){
			Arrays.fill(i, Integer.MAX_VALUE);
		}		

		//create a queue to store current processing node in the bfs 
		Deque<int[]> queue = new LinkedList<>();

		//push the source node onto the queue to init the bfs 
		//x,y, k 
		queue.offerLast(new int[]{0,0,0});

		int result = 0;
		while(!queue.isEmpty()){
			int level = queue.size();

			//keep track of the level in each graph 
			while(level-- != 0){
				int[] current = queue.poll();
				//stop the algorithm if the we have made it to the destination
				if(current[0] == m-1 && current[1] == n-1){
					return result;
				}

				//branch out to the current's neighbor under the valid points 
				for(int[] dir : DIRECTIONS){
					int newX = current[0] + dir[0];
					int newY = current[1] + dir[1];

					//check if the new coordinates are within the boundary 
					if(newX < 0 || newX >= m || newY <0 || newY >= n){
						continue;
					}

					//calculate the k needed to remove the current obstacle to traverse into this current node 
					int newK = current[2] + grid[newX][newY];

					if(newK > k){
						continue;
					}

					//if there are still more obstacle that we can remove so we will continue 
					if(visited[newX][newY] <= k){
						continue;
					}

					visited[newX][newY] = k;
					queue.offerLast(new int[]{newX, newY, newK});
				}

				result++;
			}
		}


		return -1;

	}


}
