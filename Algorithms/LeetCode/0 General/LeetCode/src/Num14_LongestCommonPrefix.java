
public class Num14_LongestCommonPrefix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String[][] test = {
				{"flower","flow","flight"},
				{"dog","racecar","car"},
				{},
				{"abc"},
				{"abc", "abcd", "abceg"},
				{"abab","aba",""},
				{"aa", "a"}
		};
		
		for(int i = 0; i < test.length; i++) {
			String result = longestCommonPrefix2(test[i]);
			System.out.println("result = " + result);
		}
		
		
		/*
		String a = "flower";
		String b = "flight";
		System.out.println(a + " " + b + " " + findLCP(a, b));
		*/
		
	}
	
	public static String longestCommonPrefix(String[] strs) {
		if(strs == null || strs.length == 0)return "";
		
        String lcp = strs[0];
        for(int i = 1; i < strs.length; i++) {
        	lcp = findLCP(lcp, strs[i]);
        	if(lcp.length() == 0)break;
        }
        
		return lcp;
    }
	
	public static String findLCP(String a, String b) {
		int len = a.length() < b.length() ? a.length() : b.length();
		String lcp = "";
		for(int i = 0; i < len; i++) {
			if(a.charAt(i) != b.charAt(i)) {
				lcp = a.substring(0, i);
				break;
			}
			
			if(i == len - 1)lcp = a.substring(0, i + 1);
		}
		
		return lcp;
	}
	
	public static String longestCommonPrefix2(String[] strs) {
		if(strs == null || strs.length == 0)return "";
		
        String lcp = strs[0];
        for(int i = 1; i < strs.length; i++) {
        	String tempLcp = "";
        	int len = lcp.length() < strs[i].length() ? lcp.length() : strs[i].length();
        	for(int j = 0; j < len; j++) {
        		//case 1: break point is in the middle of both strings
        		//e.g.: abc abe, break point at 1
        		if(lcp.charAt(j) != strs[i].charAt(j)) {
        			tempLcp = lcp.substring(0, j);
        			break;
        		}
        		
        		//case 2: break point is at the end of at least one string
        		//e.g.: abc ab
        		if(j == len - 1) tempLcp = lcp.substring(0, j + 1);
        	}
        	lcp = tempLcp;
        	
        	if(lcp.length() == 0)break;
        }
        
		return lcp;
    }

}
