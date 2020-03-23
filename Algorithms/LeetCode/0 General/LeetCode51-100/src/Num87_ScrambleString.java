import java.util.Arrays;

public class Num87_ScrambleString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "great", s2 = "rgtea";
		IO.testVisible = true;
		IO.outMain("" + isScrambleTest(s1, s2));

	}
	
	public static boolean isScramble(String s1, String s2) {
		
		int n = s1.length(), n2 = s2.length();
		
		//deal with special cases
		//case 1: length not equal
		if(n != n2) return false;
		//case 2: strings are equal
		if(s1.equals(s2)) return true;
		//case 3: decide if letters match
		int[] letters = new int[26];
	    for (int i = 0; i < s1.length(); i++) {
	        letters[s1.charAt(i) - 'a']++;
	        letters[s2.charAt(i) - 'a']--;
	    }
	    for (int i = 0; i < 26; i++) {
	        if (letters[i] != 0) {
	            return false;
	        }
	    }
		
	    //dynamic programming
		boolean[][][] dp = new boolean[n + 1][n][n];
		
		for(int len = 1; len <= n; len++) {
			for(int i = 0; i <= n - len; i++) {
				for(int j = 0; j <= n - len; j++) {
					if(len == 1) {
						dp[len][i][j] = s1.charAt(i) == s2.charAt(j);
					}else {
						//split into 2 parts: q and (len - q) 
						for(int q = 1; q < len; q++) {
							boolean noSwap = dp[q][i][j] && dp[len - q][i + q][j + q];
							boolean swap = dp[q][i][j + len - q] && dp[len - q][i + q][j];
							dp[len][i][j] = noSwap || swap || dp[len][i][j];
						}
					}
				}
			}
		}
		
		return dp[n][0][0];
    }
	
	public static boolean isScrambleTest(String s1, String s2) {
		
		int n = s1.length(), n2 = s2.length();
		if(n != n2) return false;
		
		boolean[][][] dp = new boolean[n + 1][n][n];
		
		for(int len = 1; len <= n; len++) {
			for(int i = 0; i <= n - len; i++) {
				for(int j = 0; j <= n - len; j++) {
					if(len == 1) {
						dp[len][i][j] = s1.charAt(i) == s2.charAt(j);
					}else {
						//split into 2 parts: q and (len - q) 
						for(int q = 1; q < len; q++) {
							boolean noSwap = dp[q][i][j] && dp[len - q][i + q][j + q];
							boolean swap = dp[q][i][j + len - q] && dp[len - q][i + q][j];
							dp[len][i][j] = noSwap || swap || dp[len][i][j];
							
							
							if(len == 5 && q == 2) {
								IO.outTest(s1.substring(i, i + q) + " " + s2.substring(j, j + q) + " + " + s1.substring(i + q, i + q + len - q) + " " + s2.substring(j + q, j + q +  len - q));
								IO.outTest(dp[q][i][j] + " + " + dp[len - q][i + q][j + q]);
								IO.outTest("noSwap = " + noSwap);
							}
							
						}
					}
				}
			}
			print2DArray(dp[len], len, s1, s2);
			IO.outTest("");
		}
		
		
		return dp[n][0][0];
    }
	
	public static void print2DArray(boolean[][] dp, int len, String s1, String s2) {
		int n = s1.length();
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i <= n - len; i++) {
			sb.append("[");
			for(int j = 0; j <= n - len; j++) {
				sb.append(s1.substring(i, i + len)).append(":").append(s2.substring(j, j + len)).append(" ").append(dp[i][j]);
				if(j < n - len) sb.append(", ");
			}
			sb.append("]\n");
		}
		IO.outTest(sb.toString());
	}

}
