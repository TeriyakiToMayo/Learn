import java.util.Arrays;

public class Num91_DecodeWays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strs = {
			"",	
			"0",	//0
			"00",
			"01",
			"1",
			"100",
			"101",
			"12",
			"226",
			"23612",
		};
		
		for(String str : strs) {
			IO.outMain("\"" + str + "\" " + numDecodings(str));
			
		}
		
	}
	
	public static int numDecodings(String s) {
		int len = s.length();
		
		if(len == 0) return 0;
		
		int[] dp = new int[len];
		dp[0] = isLetter0(s, 0) ? 1 : 0;
		if(len == 1) return dp[0];
		dp[1] = (isLetter0(s, 1) ? dp[0] : 0) + (isLetter(s, 0) ? 1 : 0);
		
		for(int i = 2; i < len; i++) {
			dp[i] = (isLetter0(s, i) ? dp[i - 1] : 0) + (isLetter(s, i - 1) ? dp[i - 2] : 0);
		}
		
		return dp[len - 1];
    }
	
	public static boolean isLetter0(String s, int start) {
		return s.charAt(start) != '0';
	}
	
	public static boolean isLetter(String s, int start) {
		char a = s.charAt(start);
		if(a == '0') return false;
		if(a == '1') return true;
		if(a == '2') {
			a = s.charAt(start + 1);
			return a <= '6';
		}
			
		return false;
	}

}
