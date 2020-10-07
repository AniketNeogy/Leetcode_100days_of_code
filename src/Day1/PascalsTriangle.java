package Day1;
import java.util.ArrayList;
import java.util.List;

/*
 * Question #200 :: Number of Islands -- Medium
 Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.

 Leetcode Link :  https://leetcode.com/problems/pascals-triangle/

Example:

Input: 5
Output:
[
     [1],
    [1,1],
   [1,2,1],
  [1,3,3,1],
 [1,4,6,4,1]
]


 */


public class PascalsTriangle {

	public List<List<Integer>> generate(int numRows) {
		
		List<List<Integer>> triangle = new ArrayList<>();
		
		if(numRows == 0)
			return triangle;
		
		List <Integer> first_row = new ArrayList<Integer>();
		first_row.add(1);
		triangle.add(first_row);
		
		for (int i = 1; i < numRows; i++) {
			List<Integer> previous_row = triangle.get(i-1);
			List<Integer> current_row = new ArrayList<Integer>();
			current_row.add(1);
			for (int j = 1; j < i; j++) {
				current_row.add(previous_row.get(j-1)+previous_row.get(j));
				
			}
			current_row.add(1);
			triangle.add(current_row);			
		}
		return triangle;
	}

	public static void main(String[] args) {
		PascalsTriangle pt = new PascalsTriangle();
		System.out.println(pt.generate(5));

	}

}
