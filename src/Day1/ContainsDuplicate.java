package Day1;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
 *  Question #217 :: Contains Duplicate -- Easy

Given an array of integers, find if the array contains any duplicates.

Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

Example 1:

Input: [1,2,3,1]
Output: true


Example 2:

Input: [1,2,3,4]
Output: false


Example 3:

Input: [1,1,1,3,3,4,3,2,4,2]
Output: true

 */


public class ContainsDuplicate {
	
	// time complexity  = O(n) 
	public boolean containsDuplicate(int[] nums) {
		Set<Integer> numSet = new HashSet<Integer>();
		for (int i : nums) {
			if(!numSet.add(i))
				return true;
		}

		return false;
	}
	
	// time complexity = O(n) 
	public boolean containsDuplicateNew(int[] nums) {
		Arrays.sort(nums);
		for (int i = 0; i < nums.length-1; i++) {
			if(nums[i]==nums[i+1])
				return true;
		}
		return false;
	}
	
	

	public static void main(String[] args) {
		ContainsDuplicate dupObj = new ContainsDuplicate();
		int nums[] = {1,2,3,1};
		System.out.println(dupObj.containsDuplicate(nums));
		System.out.println(dupObj.containsDuplicateNew(nums));
	}

}
