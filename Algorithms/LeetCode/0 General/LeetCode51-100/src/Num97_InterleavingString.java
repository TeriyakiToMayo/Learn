
public class Num97_InterleavingString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] strses = {
				{"", "", ""},	//true	
				{"a", "", ""},	//false
				{"a", "", "a"},	//true
				{"", "a", ""},	//false
				{"", "a", "a"},	//false
				{"a", "az", "aza"},	//true
				{"aabcc", "dbbca", "aadbbcbcac"},	//true
				{"aabcc", "dbbca", "aadbbbaccc"},
		};
		
		for(String[] strs : strses) {
			IO.outMain("\"" + strs[0] + "\" \"" + strs[1] + "\" \"" + strs[2] + "\"");
			IO.outMain("" + isInterleave(strs[0], strs[1], strs[2]));
			IO.outMain("");
		}

	}
	
	public static boolean isInterleave(String s1, String s2, String s3) {
		
		int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
		if((len1 + len2) != len3) return false;
		
		boolean[][] dp = new boolean[len1 + 1][len2 + 1];
		dp[0][0] = true;
		
		for(int i = 1; i <= len1; i++) {
			dp[i][0] = dp[i - 1][0] == true ? s1.charAt(i - 1) == s3.charAt(i - 1) : false;
		}
		
		for(int i = 1; i <= len2; i++) {
			dp[0][i] = dp[0][i - 1] == true ? s2.charAt(i - 1) == s3.charAt(i - 1) : false;
		}
		
		for(int i = 1; i <= len1; i++) {
			for(int j = 1; j <= len2; j++) {
				dp[i][j] = dp[i - 1][j] == true ? s1.charAt(i - 1) == s3.charAt(i + j - 1) : false;
				if(!dp[i][j]) {
					dp[i][j] = dp[i][j - 1] == true ? s2.charAt(j - 1) == s3.charAt(i + j - 1) : false;
				}
			}
		}
		
//		IO.print2DArray(dp, false);
		
		return dp[len1][len2];
    }

}
