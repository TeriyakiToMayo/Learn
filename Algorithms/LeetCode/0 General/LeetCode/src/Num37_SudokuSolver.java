import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Num37_SudokuSolver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[][][] boards = {
				{
					{'5','3','.','.','7','.','.','.','.'},
					{'6','.','.','1','9','5','.','.','.'},
					{'.','9','8','.','.','.','.','6','.'},
					{'8','.','.','.','6','.','.','.','3'},
					{'4','.','.','8','.','3','.','.','1'},
					{'7','.','.','.','2','.','.','.','6'},
					{'.','6','.','.','.','.','2','8','.'},
					{'.','.','.','4','1','9','.','.','5'},
					{'.','.','.','.','8','.','.','7','9'},
				},
				
				{
					{'.','.','9','7','4','8','.','.','.'},
					{'7','.','.','.','.','.','.','.','.'},
					{'.','2','.','1','.','9','.','.','.'},
					{'.','.','7','.','.','.','2','4','.'},
					{'.','6','4','.','1','.','5','9','.'},
					{'.','9','8','.','.','.','3','.','.'},
					{'.','.','.','8','.','3','.','2','.'},
					{'.','.','.','.','.','.','.','.','6'},
					{'.','.','.','2','7','5','9','.','.'},	
				},
				
				/*
				{
					{'8','3','.','.','7','.','.','.','.'},
					{'6','.','.','1','9','5','.','.','.'},
					{'.','9','8','.','.','.','.','6','.'},
					{'8','.','.','.','6','.','.','.','3'},
					{'4','.','.','8','.','3','.','.','1'},
					{'7','.','.','.','2','.','.','.','6'},
					{'.','6','.','.','.','.','2','8','.'},
					{'.','.','.','4','1','9','.','.','5'},
					{'.','.','.','.','8','.','.','7','9'},
				},	
				*/
		};
		
		
		for(int i = 0; i < boards.length; i++) {
			solveSudoku3(boards[i]);
			printBoard(boards[i]);
			out("");
		}
		
		
		
		
		//test of charIntersection
		/*
		Set<Character> set = new HashSet<Character>();
		set.addAll(Arrays.asList('2', '3', '4', '6', '8'));
		out("" + charIntersection(boards[0], 0, 3, set));
		*/
		
		//test of findCell
		
	//	findCell(boards[1], 0, 0);
		

	}
	
	public static void solveSudoku(char[][] board) {
        solveSudokuHelper(board);
    }
	
	public static boolean solveSudokuHelper(char[][] board) {
		
		int[] subBox = findSubBox(board);
        if(subBox[0] == -1) return true;
        
        List<Object> objs = findCell(board, subBox[0], subBox[1]);
        int[] min = (int[]) objs.get(0);
        Set<Character> set = (Set<Character>) objs.get(1);
        
        if(set.size() == 0) return false;
        
        for(char c : set) {
        	board[min[0]][min[1]] = c;
        	boolean result = solveSudokuHelper(board);
        	if(result) {
        	//	out(Arrays.deepToString(board));
        		return true;
        	}else {
        		board[min[0]][min[1]] = '.';
        	}
        }
        
        return false;
	}
	
	public static int[] findSubBox(char[][] board) {
		int[] min = {-1, -1};
		int minNum = 10;	//in case one sub-box contains no character
		for(int i = 0; i < 3; i++) {
			for(int k = 0; k < 3; k++) {
				int curNum = 0;
				for(int ii = 0; ii < 3; ii++) {
					for(int kk = 0; kk < 3; kk++) {
						if(board[i*3 + ii][k*3 + kk] == '.') curNum++;
					}
				}

				if(curNum >= 1) {
					if(curNum < minNum) {
						min[0] = i;
						min[1] = k;
						minNum = curNum;
					}
				}
		//		out("curNum = " + curNum);
		//		out("minNum = " + minNum);
			}
		}
		return min;
	}
	
	public static List<Object> findCell(char[][] board, int box_i, int box_k) {
		Set<Character> set = new HashSet<Character>();
		for(int i = 1; i <= 9; i++) {
			set.add((char)(i + '0'));
		}
		
		//find in sub-box
		for(int i = 0; i < 3; i++) {
			for(int k = 0; k < 3; k++) {
				char c = board[box_i*3 + i][box_k*3 + k];
				if(c == '.') continue;
				else set.remove(c);
			}
		}
		
		//find each
		int[] min = {-1, -1};
		Set<Character> setMin = new HashSet<Character>() ;
		
		boolean isFirst = true;
		for(int i = 0; i < 3; i++) {
			for(int k = 0; k < 3; k++) {
				int ii = box_i*3 + i;		//box_i * 3 important!
				int kk = box_k*3 + k;	//box_k * 3 important!
				char c = board[ii][kk];
				if(c != '.') continue;
				Set<Character> setCopy = new HashSet<Character>();
				setCopy.addAll(set);
				Set<Character> setTemp = charIntersection(board, ii, kk, setCopy);
				if(isFirst || setTemp.size() < setMin.size()) {
					isFirst = false;
					min[0] = ii;
					min[1] = kk;
					setMin = setTemp;
				}
			}
		}

		Object[] objs = new Object[] {min, setMin};
		return new LinkedList<Object> (Arrays.asList(objs));
		
	}
	
	public static Set<Character> charIntersection(char[][] board, int ii, int kk, Set<Character> set){
		
		//find in row
		for(int k = 0; k < 9; k++) {
			char c = board[ii][k];
			if(c == '.') continue;
			else if(set.contains(c)) set.remove(c);
		}
		
		//find in column
		for(int i = 0; i < 9; i++) {
			char c = board[i][kk];
			if(c == '.') continue;
			else if(set.contains(c)) set.remove(c);
		}
		
		return set;
	}
	
	public static void solveSudoku2(char[][] board) {
		doSolve(board, 0, 0);
    }
	    
    private static boolean doSolve(char[][] board, int row, int col) {
        for (int i = row; i < 9; i++, col = 0) { 	// note: must reset col here!
        														//col is set to 0 after the first loop is over
        	out("col = " + col);
            for (int j = col; j < 9; j++) {
                if (board[i][j] != '.') continue;
                for (char num = '1'; num <= '9'; num++) {
                    if (isValid(board, i, j, num)) {
                        board[i][j] = num;
                        if (doSolve(board, i, j + 1))
                            return true;
                        board[i][j] = '.';
                    }
                }
                return false;
            }
        }
        return true;
    }
	    
    private static boolean isValid(char[][] board, int row, int col, char num) {
        int blkrow = (row / 3) * 3, blkcol = (col / 3) * 3; // Block no. is i/3, first element is i/3*3
        for (int i = 0; i < 9; i++)
            if (board[i][col] == num || board[row][i] == num || 
                    board[blkrow + i / 3][blkcol + i % 3] == num)
                return false;
        return true;
    }
    
    public static void solveSudoku3(char[][] board) {
    	sudokuSolver(board, 0, 0);
    }
    
    public static boolean sudokuSolver(char[][] board, int row, int col) {
    	//updating col:
    	//if only update at beginning of the function:
    	//		- then col will not be updated within loop,
    	//		  that is, k is always start with col, not 0
    	//must update col each loop
    	for(int i = row; i < 9; i++, col = 0) {
    		for(int k = col; k < 9; k++) {
    			if(board[i][k] != '.') continue;
    			for(char num = '1'; num <= '9'; num++) {
    				if(isValidCell(board, i, k, num)) {
    					board[i][k] = num;
    					if(sudokuSolver(board, i, k + 1)) return true;
    				}
    			}
    			board[i][k] = '.';
    			return false;
    		}
    	}
    	
  //  	out(Arrays.deepToString(board));
    	return true;
    }
    
    public static boolean isValidCell(char[][] board,  int row, int col, char num) {
		
		int box_i = row / 3;
		int box_k = col / 3;
		
		//Note: num compares with board[][], hence num must be char
		for(int i = 0; i < 9; i++) {
			if(board[row][i] == num || board[i][col] == num
					|| board[box_i * 3 + i / 3][box_k * 3 + i % 3] == num) {
				return false;
			}
		}
		
		return true;
	}
    
    public static void printBoard(char[][] board) {
    	for(int i = 0; i < 9; i++) {
    		String str = "";
    		for(int k = 0; k < 9; k++) {
    			str += board[i][k] + "\t";
    		}
    		System.out.println(str);
    	}
    }
	
	public static void out(String str) {
		 System.out.println(str);
	 }

}
