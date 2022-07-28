package Day7;

import java.util.HashMap;
import java.util.Map;  

/*
Excel Sheet Column Number | leetcode 171 

Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnTitle = "A"
Output: 1
Example 2:

Input: columnTitle = "AB"
Output: 28
Example 3:

Input: columnTitle = "ZY"
Output: 701
 

Constraints:

1 <= columnTitle.length <= 7
columnTitle consists only of uppercase English letters.
columnTitle is in the range ["A", "FXSHRXW"].

*/

public class ExcelSheetColumnNumber {
	
	public Map<Character, Integer> excelValMap = new HashMap<Character, Integer>();
	
	public ExcelSheetColumnNumber() {
		excelValMap.put('A', 1);
		excelValMap.put('B', 2);
		excelValMap.put('C', 3);
		excelValMap.put('D', 4);
		excelValMap.put('E', 5);
		excelValMap.put('F', 6);
		excelValMap.put('G', 7);
		excelValMap.put('H', 8);
		excelValMap.put('I', 9);
		excelValMap.put('J', 10);
		excelValMap.put('K', 11);
		excelValMap.put('L', 12);
		excelValMap.put('M', 13);
		excelValMap.put('N', 14);
		excelValMap.put('O', 15);
		excelValMap.put('P', 16);
		excelValMap.put('Q', 17);
		excelValMap.put('R', 18);
		excelValMap.put('S', 19);
		excelValMap.put('T', 20);
		excelValMap.put('U', 21);
		excelValMap.put('V', 22);
		excelValMap.put('W', 23);
		excelValMap.put('X', 24);
		excelValMap.put('Y', 25);
		excelValMap.put('Z', 26);
	}

	public int titleToNumber(String columnTitle) {
		int excelColVal = 0;
        if(columnTitle.length() < 1 || columnTitle.length() >7)
            return -1;
        else{
            for (int i = columnTitle.length()-1, j=0; i >=0 ; i--, j++) {
            	excelColVal = (int) (excelColVal + excelValMap.get(columnTitle.charAt(i)) * Math.pow(26, j));
			}
        }
		return excelColVal;
    }
	
	public static void main(String[] args) {
		ExcelSheetColumnNumber ex = new ExcelSheetColumnNumber();
		int val = ex.titleToNumber("ZA");
		System.out.println("The Excel column corresponding to CA is :: "+ val);

	}

}
