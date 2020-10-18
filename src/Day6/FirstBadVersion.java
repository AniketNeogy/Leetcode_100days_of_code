/*
 * Question 278 :  First Bad Version

You are a product manager and currently leading a team to develop a new product. Unfortunately, the latest version of your product fails the quality check. Since each version is developed based on the previous version, all the versions after a bad version are also bad.

Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one, which causes all the following ones to be bad.

You are given an API bool isBadVersion(version) which returns whether version is bad. Implement a function to find the first bad version. You should minimize the number of calls to the API.


Example 1:
Input: n = 5, bad = 4
Output: 4
Explanation:
call isBadVersion(3) -> false
call isBadVersion(5) -> true
call isBadVersion(4) -> true
Then 4 is the first bad version.


Example 2:
Input: n = 1, bad = 1
Output: 1


Constraints:
1 <= bad <= n <= 231 - 1

 */

package Day6;

import java.util.HashMap;
import java.util.Map;

public class FirstBadVersion {
	
	private Map<Integer, String> versionControl = new HashMap<Integer, String>();
	
	public String getVersionControlStatus(Integer versionNumber) {
		return versionControl.get(versionNumber);
	}

	public void seVersionControlStatus(Integer versionNumber, String status) {
		versionControl.put(versionNumber, status);
	}

	public boolean isBadVersion(int version) {
		if(getVersionControlStatus(version) == "bad") return true;
		return false;
	}

	
	// generic binary serach -- Complexity O(nlog(n)) -- still time limit exceeded
	public int firstBadVersion(int n) {
	
		int low  = 1;
		int high = n;
		int mid;
		int result = n;
		
		while(low<=high) {
			mid = (low + high)/2;
			if(isBadVersion(mid)) {
				result = mid;
				high = mid-1;
			}else {
				low = mid+1;
			}
		}
			
		return result;
		
	}
	
	//Binary Saerch - better Version -- Most optimal Solution
	public int firstBadVersion1(int n) {
		
		int left  = 1;
		int right = n;
		
		while(left<right) {
			int mid = left + (right-left)/2;
			if(isBadVersion(mid)) {
				right = mid;
			}else {
				left = mid+1;
			}
		}
		
		if(left==right && isBadVersion(left)) {
			return left;
		}
			
		return -1;
		
	}

	public static void main(String[] args) {
		
		FirstBadVersion obj = new FirstBadVersion();
		obj.seVersionControlStatus(1, "good");
		obj.seVersionControlStatus(2, "good");
		obj.seVersionControlStatus(3, "good");
		obj.seVersionControlStatus(4, "bad");
		obj.seVersionControlStatus(5, "bad");
		
		System.out.println(obj.firstBadVersion(5));

	}

}
