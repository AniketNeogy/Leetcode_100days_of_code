/*
 * Question 9 :  Palindrome Number

Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.

Follow up: Could you solve it without converting the integer to a string?

Example 1:
Input: x = 121
Output: true

Example 2:
Input: x = -121
Output: false
Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.

Example 3:
Input: x = 10
Output: false
Explanation: Reads 01 from right to left. Therefore it is not a palindrome.

Example 4:
Input: x = -101
Output: false

 */

package Day5;

public class PlaindromeInteger {

	public boolean isPalindromeUisngStringBuffer(int x) {
		if(x==0) return true;
		
		if(x<0 || x%10==0) return false;
		
		String numberString  = new String(""+x);
		StringBuffer sb = new StringBuffer(numberString);
		sb.reverse();
		
		if(sb.toString().equals(numberString)) return true;
		return false;

	}
	
	public boolean isPalindromeUisngModOperator(int x) {
		if(x==0) return true;
		
		if(x<0 || x%10==0) return false;
		
		int reverse_int = 0;
		
		while(x > reverse_int) {
			int pop = x % 10;
			x = x / 10;
			reverse_int = (reverse_int * 10) + pop;
		}
		
		if(x == reverse_int || x == reverse_int/10) return true;
		else return false;

	}

	public static void main(String[] args) {
		PlaindromeInteger findPalindrome =  new PlaindromeInteger();
		System.out.println(findPalindrome.isPalindromeUisngStringBuffer(12321));
		System.out.println(findPalindrome.isPalindromeUisngModOperator(12321));

	}

}
