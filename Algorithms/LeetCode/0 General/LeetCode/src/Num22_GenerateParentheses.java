import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Num22_GenerateParentheses {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] nums = {0, 1, 2, 3, 4};
		
		for(int i = 0; i < nums.length; i++) {
			printLists(generateParenthesis3(nums[i]));
		}
		
	}
	
	public static List<String> generateParenthesis(int n) {
		List<String> list = new LinkedList<String>();
		
        if(n == 0) {
        	list.add("");
        	return list;
        }else if(n == 1) {
        	list.add("()");
        	return list;
        }
        
        List<String> lastList = generateParenthesis(n - 1);
        Stack<Character> stack = new Stack<Character>();
        Set<String> set = new HashSet<String>();
        
        for(String str : lastList) {
        	
        	List<Integer> posList = new LinkedList<Integer>();
        	
        	//Record all outer parentheses
        	//       . . . . .     .
        	//e.g.: ( )( )( ( ) )
        	for(int i = 0; i < str.length(); i++) {
        		if(str.charAt(i) == '(') {
        			if(stack.size() == 0)  posList.add(i);
        			stack.push('(');
        		}
        		else stack.pop();
        	}
        	
        	//assume original = ()()()
        	//i == 0, then we have      [] + ()()()		and		()()() + []
        	//i == 1, then we have      [()]()()		[()()]()		[()()()]
        	//i == 2, then we have     ()[()]()		()[()()]
        	//i == 3, then we have     ()()[()]
        	for(int i = 0; i <= posList.size(); i++) {
        		//deal with i == 0
        		if(i == 0) {
        			String tempStr = "()" + str;
        			if(!set.contains(tempStr)) {
        				set.add(tempStr);
        				list.add(tempStr);
        			}
        			tempStr = str + "()";
        			if(!set.contains(tempStr)) {
        				set.add(tempStr);
        				list.add(tempStr);
        			}
        		//deal with i > 0
        		}else {
        			for(int j = 0; j < posList.size(); j++) {
        				for(int k = j; k < posList.size(); k++) {
        					int cut1 = posList.get(j);
        					int cut2 = (k < posList.size() - 1) ? posList.get(k + 1) : str.length();
        					String tempStr = str.substring(0, cut1) + "(" + str.substring(cut1, cut2) + ")" + str.substring(cut2);
        					if(!set.contains(tempStr)) {
                				set.add(tempStr);
                				list.add(tempStr);
                			}
        				}
        			}
        		}	
        	}
        	
        }
		
		return list;
    }
	
	public static List<String> generateParenthesis2(int n) {
        List<String> ans = new LinkedList<>();
        backtrack(ans, "", 0, 0, n, 0);
        return ans;
    }
	
	//open: number of "("
	//close: number of ")"
	//max: max pairs of parentheses
    public static void backtrack(List<String> ans, String cur, int open, int close, int max, int indent){
    //	String output = "cur = \"" + cur + "\" open = " + open + " close = " + close + " max = " + max;
   // 	printWithIndent(indent, output);
    	
    	//When we have enough pairs of parentheses, return
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }
        
        //For each invoke, we have 2 options: +"(" and +")"
        //If there are fewer open than max, we can +"("
        if (open < max)
            backtrack(ans, cur+"(", open+1, close, max, indent + 1);
        
        //If there are fewer close than open, then we close one of them by +")"
        //open - close == current open parentheses
        //e.g.: cur = "(()(" open = 3 close = 1 max = 3
        //       open - close = 2, we have 2 open parentheses
        if (close < open)
            backtrack(ans, cur+")", open, close+1, max, indent + 1);
    }
    
    public static List<String> generateParenthesis3(int n) {
    	List<String> list = new LinkedList<>();
    	backTracing2(list, "", 0, 0, n);
    	
    	return list;
    }
    
    public static void backTracing2(List<String> list, String curStr, int left, int right, int max) {
    	
    	if(curStr.length() == max * 2) {
    		list.add(curStr);
    		return;
    	}
    	
    	if(left < max) backTracing2(list, curStr + "(", left + 1, right, max);
    	if(right < left) backTracing2(list, curStr + ")", left, right + 1, max);
    	
    }
    
	public static void printLists(List<String> list) {
		System.out.println("[");
		for(String str : list) {
			System.out.println("\t\"" + str + "\"");
		}
		System.out.println("]");
		System.out.println();
	}
	
	public static void printWithIndent(int indent, String str) {
		String indentStr = "";
		for(int i = 0; i < indent; i++) {
			indentStr += "\t";
		}
		
		str = indentStr + str;
		
		System.out.println(str);
	}
	
}
