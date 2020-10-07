/*
 * Question 1  : Two Sum

Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.

Example 1:

Input: nums = [2,7,11,15], target = 9
Output: [0,1]
Output: Because nums[0] + nums[1] == 9, we return [0, 1].


Example 2:

Input: nums = [3,2,4], target = 6
Output: [1,2]
Example 3:

Input: nums = [3,3], target = 6
Output: [0,1]


Constraints:

2 <= nums.length <= 105
-109 <= nums[i] <= 109
-109 <= target <= 109
Only one valid answer exists.

 */


package Day2;

import java.util.HashMap;
import java.util.Map;

public class TwoSumProblem {
	
	//Time Complexity id O(n^2)
	public int[] twoSumBruteForce(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i+1; j < nums.length; j++) {
				if(nums[i]+nums[j] == target) {
					return new int[] {i,j};
				}
			}
		}
		throw new IllegalArgumentException("No match Found");
	}
	
	
	//Time complexity is O(n) -- Most Optimized Solution
	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> arrayIndexMap = new HashMap<Integer, Integer>();
		
		for (int i = 0; i < nums.length; i++) {
			int elementMatch = target - nums[i];
			if(arrayIndexMap.containsKey(elementMatch)) {
				return new int [] {arrayIndexMap.get(elementMatch),i};
			}
			else {
				arrayIndexMap.put(nums[i], i);
			}
		}
		
		throw new IllegalArgumentException("No match Found");
	}
	

	public static void main(String[] args) {
		int array1[] = {2,7,11,15};
		int array2[] = {3,2,4};
		int array3[] = {3,3};

		TwoSumProblem twoSumArrayIndexes = new TwoSumProblem();
		int twoSumarray1[]= twoSumArrayIndexes.twoSumBruteForce(array1, 9);
		int twoSumarray2[]= twoSumArrayIndexes.twoSumBruteForce(array2, 6);
		int twoSumarray3[]=  twoSumArrayIndexes.twoSumBruteForce(array3, 6);



	}


}
