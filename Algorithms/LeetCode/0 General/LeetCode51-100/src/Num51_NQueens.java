import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class Num51_NQueens {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<List<String>> results = solveNQueens2(1);
		
		for(List<String> subResult : results) {
			printMatrix(subResult);
			out2("");
		}
		
		/*
		//Test of isValid()
		int n = 4;
		int[] rows = new int[n];
		int[] cols = new int[n];
		int[] slashes = new int[n*2 - 1];
		int[] backslashes = new int[n*2 - 1];
		int x = 0, y = 3;
		
		printBoolean(rows, cols, slashes, backslashes, x, y);
		*/
	}
	
	//=======================================================
	// Solution 2
	//=======================================================
	static int[] s2Cols;
	static int[] s2Slashes;
	static int[] s2Backslashes;
	static int s2N = 0;
	static List<List<String>> s2Output;
	static int[] s2Queens;
	
	public static List<List<String>> solveNQueens2(int n){
		s2N = n;
		s2Cols = new int[n];
		s2Slashes = new int[2 * n - 1];
		s2Backslashes = new int[2 * n - 1];
		s2Queens = new int[n];
		s2Output = new LinkedList<List<String>>();
		
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
					generateOutput();
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
	
	public static void generateOutput() {
		List<String> list = new LinkedList<String>();
		for(int row = 0; row < s2N; row++) {
			StringBuilder sb = new StringBuilder();
			for(int col = 0; col < s2N; col++) {
				if(s2Queens[row] == col) sb.append("Q");
				else sb.append(".");
			}
			list.add(sb.toString());
		}
		s2Output.add(list);
	}
	
	//=======================================================
	// Official Solution
	//=======================================================
	static int rows[];
	  // "hill" diagonals
	static int hills[];
	  // "dale" diagonals
	static int dales[];
	static int n;
	  // output
	static List<List<String>> output = new ArrayList();
	  // queens positions
	static int queens[];

	  public static boolean isNotUnderAttack(int row, int col) {
	    int res = rows[col] + hills[row - col + 2 * n] + dales[row + col];
	    return (res == 0) ? true : false;
	  }

	  public static void placeQueen(int row, int col) {
	    queens[row] = col;
	    rows[col] = 1;	
	    hills[row - col + 2 * n] = 1;  // "hill" diagonals
	    dales[row + col] = 1;   //"dale" diagonals
	  }

	  public static void removeQueen(int row, int col) {
	    queens[row] = 0;
	    rows[col] = 0;
	    hills[row - col + 2 * n] = 0;
	    dales[row + col] = 0;
	  }

	  public static void addSolution() {
	    List<String> solution = new ArrayList<String>();
	    for (int i = 0; i < n; ++i) {
	      int col = queens[i];
	      StringBuilder sb = new StringBuilder();
	      for(int j = 0; j < col; ++j) sb.append(".");
	      sb.append("Q");
	      for(int j = 0; j < n - col - 1; ++j) sb.append(".");
	      solution.add(sb.toString());
	    }
	    output.add(solution);
	  }

	  public static void backtrack(int row) {
	    for (int col = 0; col < n; col++) {
	      if (isNotUnderAttack(row, col)) {
	        placeQueen(row, col);
	        // if n queens are already placed
	        if (row + 1 == n) addSolution();
	          // if not proceed to place the rest
	        else backtrack(row + 1);
	        // backtrack
	        removeQueen(row, col);
	      }
	    }
	  }

	  public static List<List<String>> solveNQueens3(int num) {
	    n = num;
	    rows = new int[n];
	    hills = new int[4 * n - 1];	//since row - col might < 0, we add 2*n slots to make it positive
	    dales = new int[2 * n - 1];
	    queens = new int[n];

	    backtrack(0);
	    return output;
	  }

	//=======================================================
	// Solution 1
	//=======================================================
	public static List<List<String>> solveNQueens(int n) {
        
		int[] rows = new int[n];
		int[] cols = new int[n];
		int[] slashes = new int[n*2 - 1];
		int[] backslashes = new int[n*2 - 1];
		
		Set<List<Integer>> placedQueens = new HashSet<List<Integer>>();
		List<List<String>> output = new LinkedList<List<String>>();
		
		backtrack(rows, cols, slashes, backslashes, 0, 0, placedQueens, output);
		
		
		for(List<String> subOutput : output) {
			printMatrix(subOutput);
			out("");
		}
		
		
		return output;
    }
	
	public static void backtrack(int[] rows, int[] cols,
			int[] slashes, int[] backslashes, int x, int y, Set<List<Integer>> placedQueens,
			List<List<String>> output) {
		
		if(placedQueens.size() == rows.length) {
			output.add(generateBoard(placedQueens));
			return;
		}
		
		for(int i = x; i < rows.length; i++, y = 0) {
			for(int j = y; j < cols.length; j++) {
				if(isValid(rows, cols, slashes, backslashes, i, j)) {
					placedQueens.add(Arrays.asList(i, j));
					putRemoveQueen(rows, cols, slashes, backslashes, i, j, true);
					backtrack(rows, cols, slashes, backslashes, i, j + 1, placedQueens, output);
					putRemoveQueen(rows, cols, slashes, backslashes, i, j, false);
					placedQueens.remove(Arrays.asList(i, j));
				}
			}
		}
		
	}
	
	public static List<String> generateBoard(Set<List<Integer>> placedQueens){
		List<String> subOutput = new LinkedList<String>();
		int size = placedQueens.size();
		
		for(int i = 0; i < size; i++) {
			String str = "";
			for(int j = 0; j < size; j++) {
				str += placedQueens.contains(Arrays.asList(i, j)) ? "Q" : ".";
			}
			subOutput.add(str);
		}

		return subOutput;
	}
	
	public static boolean isValid(int[] rows, int[] cols,
			int[] slashes, int[] backslashes, int i, int j) {
		return rows[i] == 0
				&& cols[j]  == 0
				&& slashes[i + j]  == 0
				&& backslashes[i + (rows.length - 1 - j)]  == 0;
	}
	
	public static void putRemoveQueen(int[] rows, int[] cols,
			int[] slashes, int[] backslashes, int i, int j, boolean put) {
		int add = put ? 1 : -1;
		rows[i] += add;
		cols[j] += add;
		slashes[i + j] += add;
		backslashes[i + (rows.length - 1 - j)] += add;
	}
	
	
	//=======================================================
	// Helper Functions
	//=======================================================
	public static void printBoolean(int[] rows, int[] cols,
			int[] slashes, int[] backslashes, int x, int y) {
		
		putRemoveQueen(rows, cols, slashes, backslashes, x, y, true);
		
		for(int i = 0; i < rows.length; i++) {
			String str = "";
			for(int j = 0; j < cols.length; j++) {
				if(isValid(rows, cols, slashes, backslashes, i, j)) {
					str += ".";
				}else {
					str += "F";
				}
				str += "\t";
			}
			out2(str);
		}
	}
	
	public static void printMatrix(List<String> subOutput) {
		for(String str : subOutput) {
			String tmp = "";
			for(int i = 0; i < str.length(); i++) {
				tmp +=  str.charAt(i) + "\t";
			}
			out(tmp);
		}
	}
	
	public static void out(String str) {
		 System.out.println(str);
	}
		
	public static void out2(String str) {
		 System.out.println(str);
	}

}
