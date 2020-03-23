import java.util.LinkedList;
import java.util.List;

public class Num54_SpiralMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][][] matrices = {
				{
				},
				
				{
					{},
				},
				
				{
					{1},
				},
				
				{
					{1, 2},
				},
				
				{
					{1, 2},
					{3, 4},
				},
				
				{
					{1, 2, 3},
					{4, 5, 6},
					{7, 8, 9},
				},
				
				
				{
					{1, 2, 3, 4},
					{5, 6, 7, 8},
					{9,10,11,12},
				},
				
				
				
		};
		
		for(int[][] matrix : matrices) {
			out2("" + spiralOrder2(matrix));
		}

	}
	
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new LinkedList<Integer>();
		if(matrix.length == 0) return list;
		
		int upBound = 0, bottomBound = matrix.length - 1;
		int leftBound = 0, rightBound = matrix[0].length - 1;
		int dir = 0;	//0: right, 1: down, 2: left, 3: up
		int x_move = 0, y_move = 1;
		int i = 0, j = 0;
		while(upBound <= bottomBound && leftBound <= rightBound) {
			list.add(matrix[i][j]);
			switch(dir){
				case 0:
					if(j == rightBound) {
						dir++;
						x_move = 1;
						y_move = 0;
						upBound++;
					}
					break;
				case 1:
					if(i == bottomBound) {
						dir++;
						x_move = 0;
						y_move = -1;
						rightBound--;
					}
					break;
				case 2:
					if(j == leftBound) {
						dir++;
						x_move = -1;
						y_move = 0;
						bottomBound--;
					}
					break;
				case 3:
					if(i == upBound) {
						dir = 0;
						x_move = 0;
						y_move = 1;
						leftBound++;
					}
					break;
			}
			
			i += x_move;
			j += y_move;
		}
		
		
		return list;
    }
	
	public static List<Integer> spiralOrder2(int[][] matrix) {
		List<Integer> list = new LinkedList<Integer>();
		if(matrix.length == 0) return list;
		
		//rightBound, bottomBound, leftBound, upBound, 
		int[] bounds = {matrix[0].length - 1, matrix.length - 1, 0, 0};
		int dir = 0;	//0: right, 1: down, 2: left, 3: up
		int x_move = 0, y_move = 1;
		int i = 0, j = 0;
		
		while(bounds[3] <= bounds[1] && bounds[2] <= bounds[0]) {
			list.add(matrix[i][j]);
			
			if((dir%2 == 0 && j == bounds[dir]) || (dir%2 == 1 && i == bounds[dir])) {
				int last = dir == 0 ? 3 : dir - 1;
				bounds[last] += last <= 1 ? -1 : 1;
				dir = dir == 3? 0 : dir + 1;
				x_move = dir%2 == 0 ? 0 : (dir == 1 ? 1 : -1);
				y_move = dir%2 == 1 ? 0 : (dir == 0 ? 1 : -1);
			}
			
			i += x_move;
			j += y_move;
		}
		
		return list;
    }
	
	public static void out(String str) {
		 System.out.println(str);
	}
		
	public static void out2(String str) {
		 System.out.println(str);
	}

}
