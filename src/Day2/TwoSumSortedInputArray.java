/* Question : 167 -  Two Sum II - Input array is sorted

Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.

Note:

Your returned answers (both index1 and index2) are not zero-based.
You may assume that each input would have exactly one solution and you may not use the same element twice.


Example 1:

Input: numbers = [2,7,11,15], target = 9
Output: [1,2]
Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
Example 2:

Input: numbers = [2,3,4], target = 6
Output: [1,3]
Example 3:

Input: numbers = [-1,0], target = -1
Output: [1,2]


Constraints:

2 <= nums.length <= 3 * 104
-1000 <= nums[i] <= 1000
nums is sorted in increasing order.
-1000 <= target <= 1000


 */

package Day2;

import java.util.Arrays;

public class TwoSumSortedInputArray {
	
	/*Whenever you get a sorted array and you need to find a sum of 2 numbers matching a target think of 
	using pointer logic*/

	public int[] twoSum(int[] numbers, int target) {
		int a_pointer = 0;
		int b_pointer = numbers.length-1;
		
		while (a_pointer<=b_pointer) {
			
			if(a_pointer == b_pointer)
				return new int [] {-1};
			
			else {
				if(numbers[a_pointer]+numbers[b_pointer] > target) {
					b_pointer--;
				}
				else if(numbers[a_pointer]+numbers[b_pointer] < target) {
					a_pointer++;
					
				}
				else if(numbers[a_pointer]+numbers[b_pointer] == target) {
					return new int[] {a_pointer+1, b_pointer+1};
				}
			}
		}
		return null;
	}


	public static void main(String[] args) {
		int array1[] = {2,7,11,15};
		int array2[] = {2,3,4};
		int array3[] = {-1,0};
		
		TwoSumSortedInputArray twoSumArrayIndexes = new TwoSumSortedInputArray();
		int twoSumarray1[]= twoSumArrayIndexes.twoSum(array1, 10);
		//int twoSumarray2[]= twoSumArrayIndexes.twoSum(array2, 6);
		//int twoSumarray3[]=  twoSumArrayIndexes.twoSum(array3, -1);
		
		for (int i : twoSumarray1) {
			System.out.print(i+" ");
		}
		
		

	}

}
