/*
 * Question 344. Reverse String

Write a function that reverses a string. The input string is given as an array of characters char[].

Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.

You may assume all the characters consist of printable ascii characters.

 

Example 1:
Input: ["h","e","l","l","o"]
Output: ["o","l","l","e","h"]

Example 2:
Input: ["H","a","n","n","a","h"]
Output: ["h","a","n","n","a","H"]
 
 
 */

package Day6;

public class ReverseString {

	public void reverseString(char[] s) {
		int a_pointer = 0;
		int b_pointer = s.length-1;
		
		while(a_pointer<=b_pointer) {
			char temp = s[a_pointer];
			s[a_pointer] = s[b_pointer];
			s[b_pointer] = temp;
			a_pointer++;
			b_pointer--;
		}
		
		for (char c : s) {
			System.out.print(c +" ");
		}
	}

	public static void main(String[] args) {
		ReverseString revStr = new ReverseString();
		char[] s = {'h','e','l','l','o'};
		revStr.reverseString(s);

	}

}
