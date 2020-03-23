import java.util.Arrays;

public class Num44_WildcardMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s = "abcde";
		String p = "ab*";
		out2("" + isMatch(s, p));
	}
	
    public static boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        boolean[][] dp = new boolean [m + 1][n + 1];	//initialized as false
        
        dp[0][0] = true;
        for(int i = 1; i <= n; i++) {
        	dp[0][i] = dp[0][i - 1] && p.charAt(i - 1) == '*';
        }
        //No need to set up falses to the first column, since they are already false
        
        for(int i = 1; i <= m; i++) {
        	for(int j = 1; j <= n; j++) {
        		//i = 1, j = 1, then s.charAt(0), p.charAt(0)
        		if(s.charAt(i - 1) == p.charAt(j - 1) || p.charAt(j - 1) == '?') {
        			dp[i][j] = dp[i - 1][j - 1];
        		}else if(p.charAt(j - 1) == '*') {
        			//dp[i][j - 1]: * matches empty
        			//dp[i - 1][j]: * matches 1 character
        			dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
        		}
        	}
        }
        
    //    printMatrix(dp);
        
    	return dp[m][n];
    }
    
    public static void printMatrix(boolean[][] dp) {
    	out2("[");
    	for(int i = 0; i < dp.length; i++) {
    		out2("\t" + Arrays.toString(dp[i]));
    	}
    	out2("]");
    }
    
    public static void out(String str) {
		 System.out.println(str);
	}
		
	public static void out2(String str) {
		 System.out.println(str);
	}
}
