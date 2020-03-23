import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Num76_MinimumWindowSubstring {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] strses = {
//				/*
				{
					"",
					"a"
				},
				
				{
					"a",
					""
				},
				
				{
					"a",
					"aa"
				},
				
				{
					"a",
					"a"
				},
				
				{
					"aa",
					"a"
				},
				
				{
					"EBANC",
					"ABC"
				},
//				*/
				{
					"ADOBECODEBANC",
					"ABC"
				},
				
		};
		
		/*
		IO.testVisible = true;
		for(String[] strs : strses) {
			String res = minWindow2(strs[0], strs[1]);
			IO.outMain("\"" + strs[0] + "\" \"" + strs[1] + "\"");
			IO.outMain("\"" + res + "\"");
			IO.outMain("");
		}
		*/
		
		
		String res = minWindow(Num76_Util.s, Num76_Util.t);
		IO.outMain("\"" + res + "\"");
	}
	
	
	
	//=======================================================
	// Solution 2
	//=======================================================
	public static String minWindow2(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        Map<Character, Integer> dictT = new HashMap<Character, Integer>();

        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        int required = dictT.size();

        // Filter all the characters from s into a new list along with their index.
        // The filtering criteria is that the character should be present in t.
        List<Pair<Integer, Character>> filteredS = new ArrayList<Pair<Integer, Character>>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dictT.containsKey(c)) {
                filteredS.add(new Pair<Integer, Character>(i, c));
            }
        }

        int l = 0, r = 0, formed = 0;
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();  
        int[] ans = {-1, 0, 0};

        // Look for the characters only in the filtered list instead of entire s.
        // This helps to reduce our search.
        // Hence, we follow the sliding window approach on as small list.
        while (r < filteredS.size()) {
//        	IO.outTest("formed = " + formed);
//        	IO.outTest("r = " + r);
            char c = filteredS.get(r).getValue();
            int count = windowCounts.getOrDefault(c, 0);
            windowCounts.put(c, count + 1);

            if (dictT.containsKey(c) && windowCounts.get(c).intValue() == dictT.get(c).intValue()) {
                formed++;
            }

            // Try and co***act the window till the point where it ceases to be 'desirable'.
            while (l <= r && formed == required) {
                c = filteredS.get(l).getValue();

                // Save the smallest window until now.
                int end = filteredS.get(r).getKey();
                int start = filteredS.get(l).getKey();
                if (ans[0] == -1 || end - start + 1 < ans[0]) {
                    ans[0] = end - start + 1;
                    ans[1] = start;
                    ans[2] = end;
                }

                windowCounts.put(c, windowCounts.get(c) - 1);
                if (dictT.containsKey(c) && windowCounts.get(c).intValue() < dictT.get(c).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;   
        }
        
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

	
	
	//=======================================================
	// Solution 1
	//=======================================================
    public static String minWindow(String s, String t) {
    	if(s.length() == 0 || t.length() == 0) return "";
    	
    	//collect str t info
    	Map<Character, Integer> mapT = new HashMap<Character, Integer>();
    	for(int i = 0; i < t.length(); i++) {
    		char c = t.charAt(i);
    		mapT.put(c, mapT.getOrDefault(c, 0) + 1);
    	}
    	
    	//reconstruct s
    	List<Integer> sReCon = new ArrayList<>();
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if(mapT.containsKey(c)) sReCon.add(i);
    	}
    	
    	int len = sReCon.size();
    	if(len < mapT.size()) return "";
    	
    	//iteration
    	Map<Character, Integer> mapS = new HashMap<Character, Integer>();
    	int a = 0, b = 0, preB = b;
    	String res = s;
    	boolean contains = false;
    	
    	char c = s.charAt(sReCon.get(b++));
		if(mapT.containsKey(c)) mapS.put(c, mapS.getOrDefault(c, 0) + 1);
		
    	while(a<=len && b <= len && a<=b) {
    		int sa = sReCon.get(a), sb = sReCon.get(preB);
    		if(validStr(mapS, mapT)) {
    			contains = true;
    			
    			if(sb - sa + 1 < res.length()) res = s.substring(sa, sb + 1);
    			if(res.length() == t.length()) break;
    			
    			if(a == len - 1 || a == b) break;
    			c = s.charAt(sa);
    			if(mapS.get(c) > 1) {
					mapS.put(c, mapS.get(c) - 1);
				}else mapS.remove(c);
    			a++;
    		}else {
    			if(b == len) break;
    			c = s.charAt(sReCon.get(b));
				if(mapT.containsKey(c)) mapS.put(c, mapS.getOrDefault(c, 0) + 1);
				preB = b;
				b++;
    		}
    	}

    	return contains ? res : "";
    }
    
    public static boolean validStr(Map<Character, Integer> s, Map<Character, Integer> t) {
    	if(s.size() != t.size()) return false;
    	for(Character c : s.keySet())
    		if(s.get(c) < t.get(c)) return false;
    	
    	return true;
    }
}
