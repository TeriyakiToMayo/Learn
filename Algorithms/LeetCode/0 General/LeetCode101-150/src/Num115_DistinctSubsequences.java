import Utils.IO;

public class Num115_DistinctSubsequences {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String S = "adbab", T = "ab";
		numDistinct(S, T);
		
	}
	
	public static int numDistinct(String S, String T) {
	    // array creation
	    int[][] mem = new int[T.length()+1][S.length()+1];

	    // filling the first row: with 1s
	    for(int j=0; j<=S.length(); j++) {
	        mem[0][j] = 1;
	    }
	    
	    // the first column is 0 by default in every other rows but the first, which we need.
	    
	    for(int i=0; i<T.length(); i++) {
	        for(int j= i; j<S.length(); j++) {
	            if(T.charAt(i) == S.charAt(j)) {
	                mem[i+1][j+1] = mem[i][j] + mem[i+1][j];
	            } else {
	                mem[i+1][j+1] = mem[i+1][j];
	            }
	        }
	    }
	    IO.print2DArray(mem, false);
	    
	    return mem[T.length()][S.length()];
	}

}
