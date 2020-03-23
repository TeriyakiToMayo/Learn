import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Num3_LongestSubstringWithoutRepeatingChars {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {
				"abcabcbb",
				"aab",
				"dvdf",
				"bbbbb",
				"pwwkew",

		};
		
		for(int i = 0; i < strs.length; i++) {
			out("" + lengthOfLongestSubstring2(strs[i]));
		}
		
	}
	
	public static int lengthOfLongestSubstring(String s) {
        int LSize = 0;
        int currInit = 0;
        Map<String, Integer> map = new HashMap<>();
        
        for(int i = 0; i < s.length(); i++){
            String temp = s.charAt(i) + "";
            if(!map.containsKey(temp)){
                map.put(temp, i);
            }else{
                int size = i - currInit;
                if(size > LSize){
                    LSize = size;
                }
                int lastSameCharPos = map.get(temp);
                i = lastSameCharPos;
                currInit = i + 1;
                
                map = new HashMap<>();
            }
            
            if(i == s.length() - 1) {
            	int size = i + 1 - currInit;
                if(size > LSize){
                    LSize = size;
                }
            }
            
        }
        
        return LSize;
    }
	
	public static int lengthOfLongestSubstring2(String s) {
		int maxCount = 0;
		int curCount = 0;
		Map<Character, Integer> set = new HashMap<Character, Integer>();
		for(int i = 0; i <= s.length(); i++) {
			if(i == s.length() || set.containsKey(s.charAt(i))) {
				if(i != s.length()) i = set.get(s.charAt(i));
				maxCount = Math.max(curCount, maxCount);
				curCount = 0;
				set.clear();
			}else {
				curCount++;
				set.put(s.charAt(i), i);
			}
		}
		
		return maxCount;
	}

	public static void out(String str) {
		System.out.println(str);
	}
}
