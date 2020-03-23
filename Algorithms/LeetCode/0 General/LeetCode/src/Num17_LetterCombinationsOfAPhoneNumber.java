import java.util.ArrayList;
import java.util.List;

public class Num17_LetterCombinationsOfAPhoneNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strs = {"23", "7", "8"};
				
				for(int i = 0; i < strs.length; i++) {
					List<String> result = letterCombinations(strs[i]);
					System.out.println("===========");
					for(String str : result) {
						System.out.println(str);
					}
				}

	}
	
	public static List<String> letterCombinations(String digits) {
		List<String> list = new ArrayList<String>();
        if(digits.length() == 0) return list;
        else {
        	int num = digits.charAt(0) - '0' - 2;
        	char[] curChars = chars[num];
        	List<String> tempList = letterCombinations(digits.substring(1));
        	for(int i = 0; i < curChars.length; i++) {
        		if(tempList.size() == 0)tempList.add("");
        		for(int j = 0; j < tempList.size(); j++) {
        			list.add(curChars[i] + tempList.get(j));
        		}
        	}
        }
		
		return list;
    }
	
	static char[][] chars = {
			{'a', 'b', 'c'}, {'d', 'e', 'f'},
			{'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, 
			{'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}
	};
	
	
}
