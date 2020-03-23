
public class Num72_EditDistance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "plasma", s2 = "altruism";
		IO.outMain("" + minDistance(s1, s2) + " " + minDistance2(s1, s2));
	}

    public static int minDistance2(String word1, String word2) {
    	int len1 = word1.length(), len2 = word2.length();
    	
        int[][] map = new int[len1 + 1][len2 + 1];
        
        for(int i = 1; i <= len1; i++) {
        	map[i][0] = i;
        }
        
        for(int i = 1; i <= len2; i++) {
        	map[0][i] = i;
        }
        
        for(int i = 1; i <= len1; i++) {
        	for(int j = 1; j <= len2; j++) {
        		if(word1.charAt(i - 1) == word2.charAt(j - 1)) map[i][j] = map[i - 1][j - 1];
        		else map[i][j] = 1 + Math.min(map[i - 1][j], Math.min(map[i - 1][j - 1], map[i][j - 1]));
        	}
        }
        
        IO.outTest("");
        IO.print2DArray(map, false);
        
        
    	return map[len1][len2];
    }
	
    public static int minDistance(String s1, String s2) {
        int m = s1.length(), n = s2.length();
        int[][] dp = new int[m + 1][n + 1];
        // base case 
        for (int i = 1; i <= m; i++)
            dp[i][0] = i;
        for (int j = 1; j <= n; j++)
            dp[0][j] = j;
    		
        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++)
                if (s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = dp[i - 1][j - 1];
                else               
                    dp[i][j] = min(
                        dp[i - 1][j] + 1,
                        dp[i][j - 1] + 1,
                        dp[i-1][j-1] + 1
                    );
        
        IO.print2DArray(dp, false);
        
        return dp[m][n];
    }

    public static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    
}
