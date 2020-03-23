import java.util.HashSet;
import java.util.Set;

public class Num36_ValidSudoku {

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
		};
		
		for(int i = 0; i < boards.length; i++) {
		//	out("" + isValidSudoku(boards[i]));
			out("" + isValidSudoku2(boards[i]));
		}

	}
	
	public static boolean isValidSudoku(char[][] board) {
        
		//test rows
		for(int i = 0; i < 9; i++) {
			boolean valid = areaValid(board, i, i, 0, 8);
			if(!valid) return false;
		}
		
		//test columns
		for(int i = 0; i < 9; i++) {
			boolean valid = areaValid(board, 0, 8, i, i);
			if(!valid) return false;
		}
		
		//test areas
		for(int i = 0; i < 3; i++) {
			for(int k = 0; k < 3; k++) {
				boolean valid = areaValid(board, i * 3, i * 3 + 2, k * 3, k * 3 + 2);
				if(!valid) return false;
			}
		}
		
		return true;
    }
	
	public static boolean areaValid(char[][] board, int rowStart, int rowEnd, int colStart, int colEnd) {
		
		Set<Character> set = new HashSet<Character>();
		
		for(int i = rowStart; i <= rowEnd; i++) {
			for(int k = colStart; k <= colEnd; k++) {
				char num = board[i][k];
				if(num == '.') continue;
				if(set.contains(num)) return false;
				else set.add(num);
			}
		}
		
		return true;
	}
	
	public static boolean isValidSudoku2(char[][] board) {
		
		for(int i = 0; i < 9; i++) {
			for(int j = 0; j < 9; j++) {
				char c = board[i][j];
				if(c == '.') continue;
				
				char num = board[i][j];
				board[i][j] = '.';	//temporarily remove num from board
				if(!isValidCell(board, i, j, num)) return false;
				board[i][j] = num;
			}
		}
		
		return true;
	}
	
	public static boolean isValidCell(char[][] board,  int row, int col, int num) {
		
		int box_i = row / 3;
		int box_k = col / 3;
		
		//Make sure current num is different with each element in the
		//same row
		//same column
		//same 3*3 box
		
		//For overall algorithm, each element is compared (2 times) with other elements in the 
		//same row
		//same column
		//same 3*3 box
		//Hence we can conclude that each element is different in those constraints
		
		for(int i = 0; i < 9; i++) {
			if(board[row][i] == num || board[i][col] == num
					|| board[box_i * 3 + i / 3][box_k * 3 + i % 3] == num) {
				return false;
			}
		}
		
		return true;
	}
	
	public static void out(String str) {
		System.out.println(str);
	}

}
