
public class Num5_LongestPalindromicSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strs = {"", "a", "ab", "aa", "abc", "aba", "aasaasld"};
		for(int i = 0; i < strs.length; i ++) {
			System.out.println(strs[i] + " longest palindromic substring: " + longestPalindrome2(strs[i])  + "\n");
		}
		
	}

	public static boolean isPalindrome(String str) {
		
		if(str.length() <= 1) {
			return true;
		}
		
		if(str.charAt(0) == str.charAt(str.length() - 1)) {
			return isPalindrome(str.substring(1, str.length() - 1));
		}
		
		return false;
	}
	
	public static boolean isPalindromeInt(int x) {
		
		String str = "" + x;
		
		return isPalindrome(str);
	}
	
	public static String longestPalindrome(String s) {
	        
		if(s == null || s.length() == 0) return s;
		
		String res = "";
		boolean[][] dp = new boolean[s.length()][s.length()];
		
		int max = 0;
		for(int j = 0; j < s.length(); j++) {
			for(int i = 0; i <= j; i++) {
				dp[i][j] = s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1]);
			//	System.out.println(s + " " + s.substring(i, j + 1) + " i = " + i + " j = " + j);
			//	print2DArray(dp);
				if(dp[i][j]) {
					if(j - i + 1 > max) {
						max = j - i + 1;
						res = s.substring(i, j + 1);
					}
				}
			}
		}
		
		return res;
    }
	
	public static void print2DArray(boolean[][] arr) {
//		System.out.println();
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static String res = "";
	public static String longestPalindrome2(String s) {
		res = "";
		if(s == null || s.length() == 0) return s;
		
		for(int i = 0; i < s.length(); i++) {
			helper(s, i, i);			//detect odd number of letters "a" "aba"
			helper(s, i, i + 1);	//detect even number of letters "aa" "abba"
		}
		
		return res;
	}
	
	public static void helper(String s, int left, int right) {
		while(true) {
			if(left >= 0 && right < s.length() && (s.charAt(left) == s.charAt(right))) {
				left--;
				right++;
			}else {
				break;
			}
		}
		
		String temp = s.substring(left + 1, right);
		if(res.length() < temp.length()) res = temp;
		
	}
	
	
	
}
