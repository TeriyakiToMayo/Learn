import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Num52_NQueensII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		out2("" + totalNQueens2(8));
	}
	
	//=======================================================
	// Solution 2
	//=======================================================
	static int[] s2Cols;
	static int[] s2Slashes;
	static int[] s2Backslashes;
	static int s2N = 0;
	static int s2Output;
	static int[] s2Queens;
	
	public static int totalNQueens2(int n) {
		s2N = n;
		s2Cols = new int[n];
		s2Slashes = new int[2 * n - 1];
		s2Backslashes = new int[2 * n - 1];
		s2Queens = new int[n];
		s2Output = 0;
		
		helper(0);
		
		return s2Output;
	}
	
	public static void helper(int row) {
		for(int col = 0; col < s2N; col++) {
			if(locationValid(row, col)) {
				queenOps(row, col, true);
				if(row < s2N - 1) {
					helper(row + 1);
				}else {
					s2Output++;
				}
				queenOps(row, col, false);
			}
		}
	}
	
	public static boolean locationValid(int row, int col) {
		int r = s2Cols[col] + s2Slashes[row + col] + s2Backslashes[row + s2N - 1 - col];
		return r == 0;
	}
	
	public static void queenOps(int row, int col, boolean place) {
		s2Queens[row] = place ? col : 0;
		int i = place ? 1 : 0;
		s2Cols[col] = i;
		s2Slashes[row + col] = i;
		s2Backslashes[row + s2N - 1 - col] = i;
	}
	
	
	//=======================================================
	// Solution 1
	//=======================================================
	public static int totalNQueens(int n) {
        
		int[] rows = new int[n];
		int[] cols = new int[n];
		int[] slashs = new int[n*2 - 1];
		int[] backslashs = new int[n*2 - 1];
		
		Set<List<Integer>> placedQueens = new HashSet<List<Integer>>();

		return backtrack(rows, cols, slashs, backslashs, 0, 0, placedQueens);
    }
	
	public static int backtrack(int[] rows, int[] cols,
			int[] slashs, int[] backslashs, int x, int y, Set<List<Integer>> placedQueens) {
		
		if(placedQueens.size() == rows.length) return 1;
		
		int output = 0;
		
		for(int i = x; i < rows.length; i++, y = 0) {
			for(int j = y; j < cols.length; j++) {
				if(isValid(rows, cols, slashs, backslashs, i, j)) {
					placedQueens.add(Arrays.asList(i, j));
					putRemoveQueen(rows, cols, slashs, backslashs, i, j, true);
					output += backtrack(rows, cols, slashs, backslashs, i, j + 1, placedQueens);
					putRemoveQueen(rows, cols, slashs, backslashs, i, j, false);
					placedQueens.remove(Arrays.asList(i, j));
				}
			}
		}
		
		return output;
		
	}
	
	public static boolean isValid(int[] rows, int[] cols,
			int[] slashs, int[] backslashs, int i, int j) {
		return rows[i] == 0
				&& cols[j]  == 0
				&& slashs[i + j]  == 0
				&& backslashs[i + (rows.length - 1 - j)]  == 0;
	}
	
	public static void putRemoveQueen(int[] rows, int[] cols,
			int[] slashs, int[] backslashs, int i, int j, boolean put) {
		int add = put ? 1 : -1;
		rows[i] += add;
		cols[j] += add;
		slashs[i + j] += add;
		backslashs[i + (rows.length - 1 - j)] += add;
	}
	
	public static void out(String str) {
		 System.out.println(str);
	}
		
	public static void out2(String str) {
		 System.out.println(str);
	}

}
