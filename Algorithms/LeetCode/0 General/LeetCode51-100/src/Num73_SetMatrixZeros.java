import java.util.Arrays;

public class Num73_SetMatrixZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][][] matrices = {
				
				{
					{1, 0}
				},
				
				{
					{1},
					{0}
				},
				
				{
					{1,1,1},
					{1,0,1},
					{1,1,1},
				},
				
				
				{
					{0,1,2,0},
					{3,4,5,2},
					{1,3,1,5},
				},

		};
		
		IO.testVisible = false;
		for(int[][] matrix : matrices) {
			setZeroes(matrix);
			IO.print2DArray(matrix, true);
			IO.outMain("");
		}
		
	}

    public static void setZeroes(int[][] matrix) {
    	boolean isCol = false;
    	
		for(int i = 0; i < matrix.length; i++) {
			if(matrix[i][0] == 0) {
			  		isCol = true;
			  		break;
			}
		}
		
		for(int i = 0; i < matrix[0].length; i++) {
			if(matrix[0][i] == 0) {
				matrix[0][0] = 0;
				break;
			}
		}
    	
    	for(int i = 1; i < matrix.length; i++) {
    		for(int j = 1; j < matrix[0].length; j++) {
    			if(matrix[i][j] == 0) {
    				matrix[i][0] = 0;
    				matrix[0][j] = 0;
    			}
    		}
    	}

        for(int i = 1; i < matrix.length; i++) {
        	if(matrix[i][0] == 0) {
        		for(int j = 1; j < matrix[0].length; j++) matrix[i][j] = 0;
        	}
        }
        
        for(int i = 1; i < matrix[0].length; i++) {
        	if((i == 0 && isCol) || (i > 0 && matrix[0][i] == 0)) {
        		for(int j = 1; j < matrix.length; j++) matrix[j][i] = 0;
        	}
        }
        
        if(matrix[0][0] == 0) for(int j = 0; j < matrix[0].length; j++) matrix[0][j] = 0;
        if(isCol) for(int j = 0; j < matrix.length; j++) matrix[j][0] = 0;
        
    }
}
