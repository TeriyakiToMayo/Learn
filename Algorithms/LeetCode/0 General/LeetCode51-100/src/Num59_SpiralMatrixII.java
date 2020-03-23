
public class Num59_SpiralMatrixII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IO.print2DArray(generateMatrix(5), true);
	}
	
	public static int[][] generateMatrix(int n) {
		
		int[][] matrix = new int[n][n];
		
		//right, bottom, left, top
		int[] bounds = {n - 1, n - 1, 0, 0};
		int dir = 0;
		int i = 0, j = 0;
		int x_move = 0, y_move = 1;
		int num = 1;
		
		while(bounds[3] <= bounds[1] && bounds[2] <= bounds[0]) {
			matrix[i][j] = num;
			num++;
			
			if((dir%2 == 0 && j == bounds[dir]) || (dir%2 == 1 && i == bounds[dir])) {
				int lastDir = dir == 0 ? 3 : dir - 1;
				bounds[lastDir] += lastDir <= 1 ? -1 : 1;
				dir = dir == 3 ? 0 : dir + 1;
				x_move = dir%2 == 0 ? 0 : (dir == 1 ? 1 : -1);
				y_move = dir%2 == 1 ? 0 : (dir == 0 ? 1 : -1);
			}
			
			i += x_move;
			j += y_move;
		}
        
		return matrix;
    }

}
