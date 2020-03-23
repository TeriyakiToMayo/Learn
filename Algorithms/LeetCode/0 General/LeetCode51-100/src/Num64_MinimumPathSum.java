
public class Num64_MinimumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][][] maps = {
				{
					{1},
				},
				
				{
					{1, 3, 1},
					{1, 5, 1},
					{4, 2, 1},
				},
		};
		
		for(int[][] map : maps) {
			IO.outMain("" + minPathSum(map));
			IO.outMain("");
		}

	}
	
	public static int minPathSum(int[][] grid) {
		
		int rows = grid.length;
		if(rows == 0) return 0;
		int cols = grid[0].length;
        
		for(int i = 1; i < rows; i++) {
			grid[i][0] = grid[i - 1][0] + grid[i][0];
		}
		
		for(int i = 1; i < cols; i++) {
			grid[0][i] = grid[0][i - 1] + grid[0][i];
		}
		
		
		for(int i = 1; i < rows; i++) {
			for(int j = 1; j < cols; j++) {
				int left = grid[i][j - 1];
				int top = grid[i - 1][j];
				grid[i][j] = (left < top ? left : top) + grid[i][j];
			}
		}
		
		IO.print2DArray(grid, false);
		
		return grid[rows - 1][cols - 1];
    }

}
