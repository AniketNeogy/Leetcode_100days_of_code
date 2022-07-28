/*
 
442. Find All Duplicates in an Array
Medium

6785

264

Add to List

Share
Given an integer array nums of length n where all the integers of nums are in the range [1, n] and each integer appears once or twice, return an array of all the integers that appears twice.

You must write an algorithm that runs in O(n) time and uses only constant extra space.

 

Example 1:

Input: nums = [4,3,2,7,8,2,3,1]
Output: [2,3]
Example 2:

Input: nums = [1,1,2]
Output: [1]
Example 3:

Input: nums = [1]
Output: []
 
 */
package Day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllDupesInArray {
	
	public List<Integer> findDuplicates(int[] nums) {
        Arrays.parallelSort(nums);
        List<Integer> duplicateNumberList = new ArrayList<Integer>();
        for (int i=0; i< nums.length-1; i++){
            if(nums[i] == nums[i+1]){
                duplicateNumberList.add(nums[i]);
                i++;
            }
        }
        return duplicateNumberList;
    }

	public static void main(String[] args) {
		AllDupesInArray ad =  new AllDupesInArray();
		int nums[] = {4,3,2,7,8,2,3,1};
		List<Integer> dupeList = ad.findDuplicates(nums);
		System.out.println(dupeList);

	}

}
