import java.util.Arrays;

public class Num74_SearchA2DMatrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][][] matrices = {
				{
					
				},
				
				{
					{},
				},
				
				{
					{1,   3,  5,  7},
					{10, 11, 16, 20},
					{23, 30, 34, 50},
				},	
				
				{
					{1,   3,  5,  7},
					{10, 11, 16, 20},
					{23, 30, 34, 50},
				},
		};
		
		int[] targets = {
			1,
			1,
			32, 
			0,	
		};
		
		IO.testVisible = true;
		for(int i = 0; i < matrices.length; i++) {
			IO.outMain("" + searchMatrix(matrices[i], targets[i]));
			IO.outMain("");
		}
	}

    public static boolean searchMatrix(int[][] matrix, int target) {
    	if(matrix.length == 0 || matrix[0].length == 0) return false;
    	int r = matrix.length, c = matrix[0].length;
    	
    	int[] res = searchLine(matrix, -1, c - 1, target);
    	if(res.length == 1) return true;
    	else if(res[1] == r) return false;
    	
    	res = searchLine(matrix, res[1], -1, target);
    	if(res.length == 1) return true;
    	else return false;
    }
    
    public static int[] searchLine(int[][] matrix, int row, int col, int target) {
    	int r = matrix.length, c = matrix[0].length;
    	int left = 0, right = row >= 0 ? c - 1 : r - 1, mid = 0;
    	int midN = 0;
		while(left <= right) {
			mid = left + (right - left)/2;
			midN = row >= 0 ? matrix[row][mid] : matrix[mid][col];
			if(midN == target) return new int[] {mid};
			else if(midN > target) right = mid - 1;
			else left = mid + 1;
		}
		mid = left + (right - left)/2;
		mid = mid >= (row >= 0 ? c: r) ? mid - 1 : mid;
		midN = row >= 0 ? matrix[row][mid] : matrix[mid][col];
		return target < midN ? new int[] {mid - 1, mid} : new int[] {mid, mid + 1};
    }
}
