import java.util.Arrays;

public class Num48_RotateImage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][][] matrices = {
				{
					{1,2,3},
					{4,5,6},
					{7,8,9},
				},
				
				{
					{5, 1, 9,11},
					{2, 4, 8,10},
					{13, 3, 6, 7},
					{15,14,12,16},
				},
		};
		
		for(int i = 0; i < matrices.length; i++) {
			printMatrix(matrices[i]);
			out2("");
			rotate(matrices[i]);
			printMatrix(matrices[i]);
			out2("");
		}

	}
	
	public static void rotate(int[][] matrix) {
        
        int len = matrix.length;
        int bound = len / 2 + (len%2 == 0 ? 0 : 1);
        
        for(int i = 0; i < bound; i++) {
        	//len - i * 2: current matrix length
        	//innerBound: last element of current line of elements
        	int innerBound = i + len - i * 2 - 2;
			for(int j = i; j <= innerBound; j++) {
				int x = i, y = j;
				int storedVal = matrix[x][y];
				for(int k = 0; k < 4; k++) {
					int[] nextCoord = rotateCoord(x, y, len);
					int tempVal = matrix[nextCoord[0]][nextCoord[1]];
					matrix[nextCoord[0]][nextCoord[1]] = storedVal;
					storedVal = tempVal;
					x = nextCoord[0];
					y = nextCoord[1];
				}
			}
        } 
    }
	
	public static int[] rotateCoord(int x, int y, int len) {
		return new int[] {y, len - x - 1};
	}
	
	public static void printMatrix(int[][] matrix) {
		for(int i = 0; i < matrix.length; i++) {
			 out2(Arrays.toString(matrix[i]));
		}
	}
	
	public static void out(String str) {
	//	 System.out.println(str);
	}
		
	public static void out2(String str) {
		 System.out.println(str);
	}

}
