import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Num76_MinimumWindowSubstring2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		/*
		String[][] strses = {
				
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
					"b"
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
				
				{
					"ADOBECODEBANC",
					"ABC"
				},
				
				
		};
		
		IO.testVisible = true;
		for(String[] strs : strses) {
			String res = minWindow2(strs[0], strs[1]);
			IO.outMain("\"" + strs[0] + "\" \"" + strs[1] + "\"");
			IO.outMain("\"" + res + "\"");
			IO.outMain("");
		}
//		*/
		
		
		String res = minWindow2(Num76_Util.s, Num76_Util.t);
		IO.outMain("\"" + res + "\"");
		
		
		
	}
	
	//=======================================================
	// Solution 4
	//=======================================================
	public static String minWindow2(String s, String t) {
    	if(s.length() == 0 || t.length() == 0) return "";
    	
    	//collect str t info
    	Map<Character, Integer> mapT = new HashMap<Character, Integer>();
    	for(int i = 0; i < t.length(); i++) {
    		char c = t.charAt(i);
    		mapT.put(c, mapT.getOrDefault(c, 0) + 1);
    	}
    	int required = mapT.size();
    	
    	//Warning 1: Must use ArrayList, or time will exceed
    	List<Pair<Character, Integer>> sReCon = new ArrayList<>();
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if(mapT.containsKey(c)) sReCon.add(new Pair<Character, Integer>(c, i));
    	}
    	
    	int len = sReCon.size();
    	if(len == 0) return "";
    	
    	//iteration
    	Map<Character, Integer> mapS = new HashMap<Character, Integer>();
    	int a = 0, b = -1;
    	int formed = 0;
    	char c = 'a';
    	
    	int[] ans = {0, s.length(), -1};
    	
    	while(b == -1 || (b < len - 1 && a <= b)) {
    		
    		while(b < len - 1 && formed < required) {
    			b++;
    			c = sReCon.get(b).getKey();
				mapS.put(c, mapS.getOrDefault(c, 0) + 1);
				if((int)mapT.get(c) == (int)mapS.get(c)) formed++;
    		}
    		
    		while(a <= b && formed == required) {
    			int sa = sReCon.get(a).getValue(), sb = sReCon.get(b).getValue(); 
    			if(ans[2] == -1 || sb - sa + 1 < ans[2]) {
    				ans[0] = sa;
    				ans[1] = sb;
    				ans[2] = sb - sa + 1;
    			}
    			
    			c = sReCon.get(a).getKey();
				int count = mapS.get(c);
				if(count - 1 < mapT.get(c)) formed--;
				mapS.put(c, count - 1);
				a++;
    		}
    	}
    	
    	return ans[2] == -1 ? "" : s.substring(ans[0], ans[1] + 1);
    }
	
	
	//=======================================================
	// Solution 3
	//=======================================================
	public static String minWindow(String s, String t) {
    	if(s.length() == 0 || t.length() == 0) return "";
    	
    	//collect str t info
    	Map<Character, Integer> mapT = new HashMap<Character, Integer>();
    	for(int i = 0; i < t.length(); i++) {
    		char c = t.charAt(i);
    		mapT.put(c, mapT.getOrDefault(c, 0) + 1);
    	}
    	int required = mapT.size();
    	
    	//Warning 1: Must use ArrayList, or time will exceed
    	List<Pair<Character, Integer>> sReCon = new ArrayList<>();
    	for(int i = 0; i < s.length(); i++) {
    		char c = s.charAt(i);
    		if(mapT.containsKey(c)) sReCon.add(new Pair<Character, Integer>(c, i));
    	}
    	
    	int len = sReCon.size();
    	if(len == 0) return "";
    	
    	//iteration
    	Map<Character, Integer> mapS = new HashMap<Character, Integer>();
    	int a = 0, b = 0;
    	//Warning 4: use required == formed to check status instead of 
    	//                  iterate through the entire map
    	int formed = 0;
    	
    	char c = sReCon.get(0).getKey();
    	mapS.put(c, 1);
    	if(mapT.get(c) == mapS.get(c)) formed++;
    	//Warning 3: use int[] instead of String to avoid using substring multiple times
    	int[] ans = {0, s.length(), -1};
    	
    	while(a < len && b < len && a <= b) {
    		if(formed == required) {
    			int sa = sReCon.get(a).getValue(), sb = sReCon.get(b).getValue(); 
    			if(ans[2] == -1 || sb - sa + 1 < ans[2]) {
    				ans[0] = sa;
    				ans[1] = sb;
    				ans[2] = sb - sa + 1;
    			}
                if(sb - sa + 1 == t.length()) break;
                
    			c = sReCon.get(a).getKey();
				a++;
				int count = mapS.get(c);
				if(count - 1 < mapT.get(c)) formed--;
				mapS.put(c, count - 1);
    		}else {
    			if(b == len - 1) break;
    			else {
    				b++;
    				c = sReCon.get(b).getKey();
    				mapS.put(c, mapS.getOrDefault(c, 0) + 1);
    				//Warning 2: Must convert Integer into int before comparing,
    				//or sometimes the result is correct, sometimes not
    				if((int)mapT.get(c) == (int)mapS.get(c)) formed++;
    			}
    		}
    	}
    	
    	return ans[2] == -1 ? "" : s.substring(ans[0], ans[1] + 1);
    }

}
