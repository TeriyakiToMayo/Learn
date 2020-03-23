import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Num49_GroupAnagram {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		out2("" + divideWord("cccba"));
		
		String[][] strsArr = {
				{"eat", "tea", "tan", "ate", "nat", "bat"},	
		};
		
		for(String[] strs : strsArr) {
			out2("" + groupAnagrams(strs));
		}
		
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {
		
		Map<List<Character>, List<String>> map 
			= new HashMap<List<Character>, List<String>>();
        
		for(String word : strs) {
			List<Character> list = divideWord(word);
			if(!map.containsKey(list)) map.put(list, new LinkedList<String>());	
			map.get(list).add(word);
		}
		
		List<List<String>> groups = new LinkedList<List<String>>(map.values());
		
		return groups;
    }
	
	public static List<Character> divideWord(String word){
		List<Character> list = new LinkedList<>();
		
		for(int i = 0; i < word.length(); i++) {
			list.add(word.charAt(i));
		}
		Collections.sort(list);
		
		return list;
	}
	
	public List<List<String>> groupAnagrams2(String[] strs) {
        if (strs.length == 0) return new ArrayList();
        Map<String, List> ans = new HashMap<String, List>();
        for (String s : strs) {
            char[] ca = s.toCharArray();
            Arrays.sort(ca);
            String key = String.valueOf(ca);
            if (!ans.containsKey(key)) ans.put(key, new ArrayList());
            ans.get(key).add(s);
        }
        return new ArrayList(ans.values());
    }

	
	public static void out(String str) {
		 System.out.println(str);
	}
		
	public static void out2(String str) {
		 System.out.println(str);
	}

}
