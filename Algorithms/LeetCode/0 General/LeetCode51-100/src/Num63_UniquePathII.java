
public class Num63_UniquePathII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][][] maps = {
				{
					{0},
				},
				
				{
					{1},
				},
				
				{
					{1, 0, 0},
					{0, 1, 0},
					{0, 1, 0},
				},
				
				{
					{0, 0, 0},
					{0, 1, 0},
					{0, 1, 0},
				},
				
				{
					{0, 0, 0},
					{0, 1, 0},
					{0, 0, 0},
				},
				
				{
					{0, 0, 0},
					{0, 1, 1},
					{0, 1, 0},
				},
				
		};
		
		for(int[][] map : maps) {
			IO.outMain("" + uniquePathsWithObstacles(map));
			IO.outMain("");
		}

	}
	
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		
		IO.print2DArray(obstacleGrid, true);
		
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
        
		int origin = obstacleGrid[0][0];
		int input = origin == 0 ? 1 : -1;
		obstacleGrid[0][0] = input;
		for(int i = 1; i < m; i++) {
			if(obstacleGrid[i][0] == 1) input = -1;
			obstacleGrid[i][0] = input;
		}
		
		input = origin == 0 ? 1 : -1;
		for(int i = 1; i < n; i++) {
			if(obstacleGrid[0][i] == 1) input = -1;
			obstacleGrid[0][i] = input;
		}
		
		for(int i = 1; i < m; i++) {
			for(int j = 1; j < n; j++) {
				if(obstacleGrid[i][j] == 1) obstacleGrid[i][j] = -1;
				else if(obstacleGrid[i - 1][j] == -1) obstacleGrid[i][j] = obstacleGrid[i][j - 1];
				else if(obstacleGrid[i][j - 1] == -1) obstacleGrid[i][j] = obstacleGrid[i - 1][j];
				else{
					obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
				}
			}
		}
		
		IO.print2DArray(obstacleGrid, true);
		int result = obstacleGrid[m - 1][n - 1];
		
		return result > 0 ? result : 0;
    }

}
