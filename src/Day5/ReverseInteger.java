/*
Question 7: Reverse Integer

Given a 32-bit signed integer, reverse digits of an integer.

Example 1:
Input: x = 123
Output: 321

Example 2:
Input: x = -123
Output: -321

Example 3:
Input: x = 120
Output: 21

Example 4:
Input: x = 0
Output: 0
 */
package Day5;

public class ReverseInteger {

	//This will not work in case of negative numbers
	public int reverseUsingString(int x) {
		StringBuffer sb = new StringBuffer(new String(""+x));
		sb.reverse();
		return Integer.parseInt(sb.toString());

	}

	// Most Optimal Solution
	public int reverseModOperator(int x) {
		int reverse = 0;
		int pop = 0;
		while(x!=0) {
			pop = x % 10;
			x = x/10;
			if(reverse > Integer.MAX_VALUE/10 || reverse == Integer.MAX_VALUE/10 && pop >7) return 0;
			if(reverse < Integer.MIN_VALUE/10 || reverse == Integer.MIN_VALUE/10 && pop <8) return 0;
			reverse = (reverse*10) + pop;
		}
		return reverse;
	}

	public static void main(String[] args) {
		ReverseInteger rev = new ReverseInteger();
		System.out.println(rev.reverseUsingString(123));
		System.out.println(rev.reverseModOperator(123));

	}

}
