import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Num30_SubstringWithConcatenationOfAllWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strs = {
				"",
				"a",
				"",
				"aaaabarfoo",
				"barfoothefoobarman",
				"",
				"wordgoodgoodgoodbestword",
				"aaawordbestwordgoodabc"
		};
		
		String[][] words = {
				{""},
				{""},
				{"foo","bar"},	
				{"foo","bar"},	
				{"foo","bar"},	
				{"word","good","best","word"},
				{"word","good","best","word"},
				{"word","good","best","word"},
		};
		
		for(int i = 0; i < strs.length; i++) {
			List<Integer> list = findSubstring(strs[i], words[i]);
			
			System.out.println("output: ");
			for(Integer index : list) {
				System.out.print(index + " ");
			}
			System.out.println();
			
		}
	}
	
	public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new LinkedList<>();
        if(words == null || words.length == 0) return list;
		
		Map<String, Integer> map = new HashMap<>();
		
		for(String str : words) {
			map.put(str, map.getOrDefault(str, 0) + 1);
		}
		
		int nums = words.length;
		int word_len = words[0].length();
		
		for(int i = 0; i <= s.length() - nums * word_len; i++) {
			Map<String, Integer> seen = new HashMap<>();
			boolean isSub = true;
			for(int j = 0; j < nums; j++) {
				int pos = i + j * word_len;
				String temp = s.substring(pos, pos + word_len);
				seen.put(temp, seen.getOrDefault(temp, 0) + 1);
				
				if(seen.get(temp) > map.getOrDefault(temp, 0)) {
					isSub = false;
					break;
				}
			}
			
			if(isSub) list.add(i);
			
		}
		
		return list;
    }

}
