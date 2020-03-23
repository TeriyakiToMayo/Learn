import java.util.Arrays;

public class Num10_RegularExpressionMatching {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		String[] s = {"aa", "aa", "ab",	"aab", "mississippi", "a"};
		String[] p = {"a", "a*",	 ".*", "c*a*b", "mis*is*p*.", "ab*a"};
		
		for(int i = 0; i < s.length; i++) {
			boolean result = isMatch2(s[i], p[i]);
			System.out.println("s = " + s[i] + " p = " + p[i] + " " + (result ? "Match" : "Not match"));
		}
		*/
		
		
		
		
		String s = "ab";
		String p = ".*";
		boolean result = isMatch2(s, p);
		System.out.println("s = " + s + " p = " + p + " " + (result ? "Match" : "Not match"));
		
		
		/*
		out("" + ((int) 'a'));	//97
		out("" + ((int) 'A'));	//65
		out("" + ((int) '.'));	//46
		*/
		
	}
	
	//s: string
	//p: pattern
	public static boolean isMatch(String s, String p) {
	//	System.out.println("s = " + s + " p = " + p);
		if(p.length() == 0) {	//no more pattern
			if(s.length() > 0) return false;
			else return true;
		}else if(p.length() == 1) { //exactly one pattern character
		//	System.out.println("one pattern character");
			if(s.length() == 1) return decideSinglePatternMatch(s, p);
			else return false;
		}else {	//more than two pattern characters
		//	System.out.println("pattern >= 2");
			if(p.charAt(1) == '*') {
			//	System.out.println("pattern >= 2 and *");
				char curP = p.charAt(0);
				boolean result = false;
				for(int i = 0; i <= s.length(); i++){
				//	System.out.println("p.substring(2) = " + p.substring(2));
					result |= isMatch(s.substring(i), p.substring(2));
					if(result == true) break;
					
					if(i < s.length()) {
						if(curP != '.' && s.charAt(i) != curP) break;
					}
				}
				return result;
			}else {
				if(s.length() == 0) return false;
				else return decideSinglePatternMatch(s, p) && isMatch(s.substring(1), p.substring(1));
			}
		}
		
	}

	public static boolean decideSinglePatternMatch(String str, String pat) {
		char s = str.charAt(0);
		char p = pat.charAt(0);
		if(p == '.')return true;
		else {
			if(s == p) return true;
			else return false;
		}
	}
	
	public static boolean isMatch2(String s, String p) {
		
		String p2 = "";
		for(int i = 0; i < p.length(); i++) {
			char c = p.charAt(i);
			if(i < p.length() - 1 && p.charAt(i + 1) == '*') {
				p2 += c == '.' ? '+' : Character.toUpperCase(c);
				i++;
			}else {
				p2 += c;
			}
		}
		
		
		int m = s.length();
		int n = p2.length();
		
		boolean[][] dp = new boolean[m + 1][n + 1];
		
		dp[0][0] = true;
		for(int i = 1; i <= n; i++) {
			//if c* or .*, then match
			dp[0][i] = dp[0][i - 1] && ((p2.charAt(i - 1) >= 'A' && p2.charAt(i - 1) <= 'Z') || p2.charAt(i - 1) == '+');
		}
		
		for(int i = 1; i <= m; i++) {
			for(int j = 1; j <= n; j++) {
				if(s.charAt(i - 1) == p2.charAt(j - 1) || p2.charAt(j - 1) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				}else if(p2.charAt(j - 1) >= 'A'&& p2.charAt(j - 1) <= 'Z') {
					//Case: c*
					char c = Character.toLowerCase(p2.charAt(j - 1));
					dp[i][j] = dp[i][j - 1] || (s.charAt(i - 1) == c ? dp[i - 1][j] : false);
				}else if(p2.charAt(j - 1) == '+') {	
					//Case: .*
					dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
				}
			}
		}
	//	printMatrix(dp);
		
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
