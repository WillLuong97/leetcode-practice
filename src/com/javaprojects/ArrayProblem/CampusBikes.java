//package com.javaprojects.ArrayProblem;
//
//import java.util.*;
//
//import static java.lang.Math.abs;
//
///**
//On a campus represented on the X-Y plane, there are n workers and m bikes, with n <= m.
//
//You are given an array workers of length n where workers[i] =  [xi, yi] is the position of the ith worker.
//You are also given an array bikes of length m where bikes[j] = [xj, yj] is the position of the jth bike. All the given positions are unique.
//
//Assign a bike to each worker. Among the available bikes and workers, we choose the (workeri, bikej) pair with the shortest Manhattan distance between each other and assign the bike to that worker.
//
//If there are multiple (workeri, bikej) pairs with the same shortest Manhattan distance, we choose the pair with the smallest worker index. If there are multiple ways to do that, we choose the pair with the smallest bike index. Repeat this process until there are no available workers.
//
//Return an array answer of length n, where answer[i] is the index (0-indexed) of the bike that the ith worker is assigned to.
//
//The Manhattan distance between two points p1 and p2 is Manhattan(p1, p2) = |p1.x - p2.x| + |p1.y - p2.y|.
//
//Example 1:
//
//Input: workers = [[0,0],[2,1]], bikes = [[1,2],[3,3]]
//Output: [1,0]
//Explanation: Worker 1 grabs Bike 0 as they are closest (without ties), and Worker 0 is assigned Bike 1. So the output is [1, 0].
//
//Example 2:
//
//Input: workers = [[0,0],[1,1],[2,0]], bikes = [[1,0],[2,2],[2,1]]
//Output: [0,2,1]
//Explanation: Worker 0 grabs Bike 0 at first. Worker 1 and Worker 2 share the same distance to Bike 2, thus Worker 1 is assigned to Bike 2, and Worker 2 will take Bike 1. So the output is [0,2,1].
//Constraints:
//
//n == workers.length
//m == bikes.length
//1 <= n <= m <= 1000
//workers[i].length == bikes[j].length == 2
//0 <= xi, yi < 1000
//0 <= xj, yj < 1000
//All worker and bike locations are unique.
//
//Requirement:
//	- assignBikes() method will assign a bike to a worker and return an array of bike index that ith workker is assigned to with
//		+ The shortest manhattan distance or
//		+ The smallest worker index
//		+ The smallest bike index
//
//	param:
//	workers - 2-d array that stores the position of the worker on the grid
//	bikes 	- 2-d array that stores the position of the bikes on the grid
//
//Constraints/Observation:
//
//	bikeToWorker assignment is random, any worker can grab any bikes
//	The assignemnt is chosen based on the above condition
//
//linearly loop through the workers
//	linearly loop through the bikes array
//	at worker ith, we will pick bike ith
//		run through the checks:
//			current_manhattan_distance = |(workeri[0] - bikei[0])| + |(workeri[1] - bikei[1])|
//			compute all the distance, and store them into a hashmap
//
//this hashmap helps us find the smallest current_manhattan_distance
//							hashmap
//key 									value
//current_manhattan_distance				(worker_i, bikes_i)
//
//the map will helps us store the distance of each pairs from lowest to highest
//
//create a set to store the workers and bikes to keep trakc of which bikes and workers have been assigned
//
//loop through the map and add each bikes and workers to the result
//
//sort the worker array with bikes array
//
//
//
//
//	return result;
//
//Time complexity: O(mxn), nested loop between the worker and bike array
//space complexity: O(n), nested
//
//
//Example:
//             0th   1st
//workers = [[0,0], [2,1]]				n
//          0th     1st
//bikes = [[1,2],[3,3]]					m
//
//
//result = []
// **/
//public class CampusBikes {
//    public int[] assignBikes(int[][] workers, int[][] bikes){
//    	//create a hashmap to keep track of the distance and the pairs of the bikes and workers
//    	Map<Integer, List<Integer>> distanceToWorkerBikesMap = new HashMap<>();
//
//    	int[] result = new int[workers.length];
//
//    	//create a set to keep track of the assigned bikes and workers
//    	Set<Integer> assignedWorkers = new HashSet<>();
//    	Set<Integer> assignedBikes = new HashSet<>();
//
//    	//loop through the workers and bikes list to build out the hashmap
//    	for(int i = 0; i < workers.length; i++){
//    		for(int j = 0; j < bikes.length; j++){
//    			//calculate the manhattan distance of each points
//    			int distance = getDistance(i[0], i[1], j[0], j[1]);
//    			List<Integer> pairs = new ArrayList<>();
//    			pairs.add(i);
//    			pairs.add(j);
//    			//add the associtated distance into the map
//    			distanceToWorkerBikesMap.computeIfAbsent(distance, pairs);
//    		}
//    	}
//    	//loop through the map to find the pairs
//    	for(int distance : distanceToWorkerBikesMap.keySet()){
//    		for(List<Integer> pairs : distanceToWorkerBikesMap.get(distance)){
//    			if(!assignedWorkers.contains(pairs[0] && !assignedBikes.contains(pairs[1])){
//    				result[pairs[0]] = pairs[1];
//
//    				assignedWorkers.add(pairs[0]);
//    				assignedBikes.add(pairs[1]);
//
//    			}
//    		}
//    	}
//
//    	return result;
//    }
//    //helper method to calculate the manhattan distance
//    //= |p1.x - p2.x| + |p1.y - p2.y|.
//    private int getDistance(int p1_x, int p1_y, int p2_x, int p2_y){
//    	return abs(p1_x - p2_x) + abs(p1_y - p2_y);
//
//    }
//
//}
