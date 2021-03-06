package Day1;
/*
 * Question #200 :: Number of Islands -- Medium
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. 
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. 
 * You may assume all four edges of the grid are all surrounded by water.
 * 

Example 1:

Input: grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
Output: 1


Example 2:

Input: grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
Output: 3

 */
public class NumberofIslands {

	public int numIslands(char[][] grid) {
		int count = 0;
		for (int i = 0; i < grid.length; i++) {
			for (int j = 0; j < grid[i].length; j++) {
				if(grid[i][j] == '1') {
					count++;
					callBFS(grid,i,j);
				}
			}
		}
		return count;

	}

	private void callBFS(char[][] grid, int i, int j) {
		if(i<0 || i>=grid.length || j<0 || j>=grid[i].length || grid[i][j] == '0')
			return;
		grid[i][j] = '0';
		callBFS(grid, i+1, j);//up
		callBFS(grid, i-1, j);//down
		callBFS(grid, i, j+1);//left
		callBFS(grid, i, j-1);//right

	}

	public static void main(String[] args) {

		char[][] grid = {
							{'1','1','1','1','0'},
							{'1','1','0','1','0'},
							{'1','1','0','0','0'},
							{'0','0','0','1','1'}
						};
		NumberofIslands islands =  new NumberofIslands();
		System.out.println(islands.numIslands(grid));
	}

}
