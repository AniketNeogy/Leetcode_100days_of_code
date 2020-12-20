/*
 * Question 844. Backspace String Compare

Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

Note that after backspacing an empty text, the text will continue empty.

Example 1:
Input: S = "ab#c", T = "ad#c"
Output: true
Explanation: Both S and T become "ac".


Example 2:
Input: S = "ab##", T = "c#d#"
Output: true
Explanation: Both S and T become "".


Example 3:
Input: S = "a##c", T = "#a#c"
Output: true
Explanation: Both S and T become "c".


Example 4:
Input: S = "a#c", T = "b"
Output: false
Explanation: S becomes "c" while T becomes "b".


Note:
1 <= S.length <= 200
1 <= T.length <= 200
S and T only contain lowercase letters and '#' characters.


 */

package Day6;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BackspaceStringCompare {
	
	List<Integer> ls = new ArrayList<Integer>();

	//most Optimal Solution
	public boolean backspaceCompare(String S, String T) {
		Stack<Character> sStack = new Stack<Character>();
		Stack<Character> tStack = new Stack<Character>();

		for (Character c : S.toCharArray()) {
			if(c!='#') {
				sStack.push(c);
			}
			else if(!sStack.isEmpty()){
				sStack.pop();
			}
		}

		for (Character c : T.toCharArray()) {
			if(c!='#') {
				tStack.push(c);
			}
			else if(!tStack.isEmpty()){
				tStack.pop();
			}
		}

		while(!sStack.isEmpty()) {
			char currentCharacter = sStack.pop();
			if(tStack.isEmpty() || tStack.pop() != currentCharacter) {
				return false;
			}
		}

		return sStack.isEmpty() && tStack.isEmpty();

	}

	public boolean backspaceCompare1(String S, String T) {

		String sResult = "";
		String tResult = "";

		int sPointer = S.length()-1;
		int tPointer = T.length()-1;

		int sSkip = 0;
		int tSkip = 0;

		while(sPointer>=0){
			if(S.charAt(sPointer) == '#') {
				sSkip++;
				sPointer--;
			}
			else if(sSkip>0) {
				sSkip--;
				sPointer--;
			}
			else {
				sResult = S.charAt(sPointer) + sResult;
				sPointer--;
			}
		}


		while(tPointer>=0){
			if(T.charAt(tPointer) == '#') {
				tSkip++;
				tPointer--;
			}
			else if(tSkip>0) {
				tSkip--;
				tPointer--;
			}
			else {
				tResult = T.charAt(tPointer) + tResult;
				tPointer--;
			}
		}

		if(sResult.equals(tResult)) return true;

		return false;

	}

	public static void main(String[] args) {
		String firstInput = "ab##";
		String secondInput = "c#d#";

		BackspaceStringCompare compareStr = new BackspaceStringCompare();
		System.out.println(compareStr.backspaceCompare1(firstInput, secondInput));

	}

}
