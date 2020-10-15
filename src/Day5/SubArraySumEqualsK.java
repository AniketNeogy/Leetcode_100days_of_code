/*
 * Question 560 :  Subarray Sum Equals K

Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

Example 1:

Input:nums = [1,1,1], k = 2
Output: 2
 

Constraints:

The length of the array is in range [1, 20,000].
The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 
 
 */

package Day5;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK {
	
	//complexity O(n^2) -- not ideal solution
	public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int i=0;i<nums.length;i++){
        	int sum = 0;
            for(int j=i;j<nums.length;j++){
            		sum = sum +nums[j];
            		if(sum == k) {
            			count++;
                }
            }
        }
            
        return count;
    }
	
	//PrefixSum
	public int subarraySum1(int[] nums, int k) {
        int result = 0;
        int sum = 0;
        
        Map<Integer, Integer> arr_sum = new HashMap<Integer, Integer>();
        arr_sum.put(0, 1);
        
        for (int i = 0; i < nums.length; i++) {
        	sum += nums[i];
        	
			if(arr_sum.containsKey(sum-k))
				result +=arr_sum.get(sum-k);
			
			arr_sum.put(sum, arr_sum.getOrDefault(sum,0)+1);
		}
            
        return result;
    }

	public static void main(String[] args) {
		int nums[] = {1,1,1,-1,1,-1,1,2,-1};
		SubArraySumEqualsK getSum = new SubArraySumEqualsK();
		System.out.println(getSum.subarraySum(nums, 2));
		System.out.println("*********************************************");
		SubArraySumEqualsK getSum1 = new SubArraySumEqualsK();
		System.out.println(getSum1.subarraySum1(nums, 2));

	}

}
