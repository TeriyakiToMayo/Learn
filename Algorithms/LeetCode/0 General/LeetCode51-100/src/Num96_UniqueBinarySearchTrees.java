import java.util.Arrays;

public class Num96_UniqueBinarySearchTrees {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IO.outMain("" + numTrees(4));
	}
	
	public static int numTrees(int n) {
		
		int[] dp = new int[n + 1];
		
		dp[0] = 1;
		dp[1] = 1;
		
		for(int i = 2; i <= n; i++) {
			for(int j = 1; j <= i; j++) {
				dp[i] += dp[j - 1] * dp[i - j];
			}
		}
		
		return dp[n];
    }

}
