import java.util.Arrays;
import java.util.Stack;



public class Num32_LongestValidParentheses {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strs = {
		//	"()",
		//	"()(())",
		//	"()(()",
		//	"()(()()",
		//	"()()(()(())",
		//	"))))))))))(())(()())",
		//	"((()()()))",
		//	"()()()",
		//	"(())()())",
		//")))))))))((())(())(()))",
			"(()(()()))",
		};
		
		for(int i = 0; i < strs.length; i++) {
			out(strs[i] + " " + longestValidParentheses2(strs[i]));
			out("");
		}
		
	//	System.out.println(longestValidParentheses2(Num32_Util.str));
		
	}
	
	public static int longestValidParentheses(String s) {
        if(s == null || s.length() <= 1) return 0;
		
		int longestSingle = 0;
		Stack<Character> stack = new Stack<>();
		
		for(int i = 0; i < s.length(); i++) {
		//	System.out.println("i = " + i);
			stack.clear();
			int curInit = 0;
			int lastEnd = i - 1;
			int combo = 0;
			for(int j = i; j < s.length(); j++) {
				
				if(stack.size() == 0) {
					if(j - 1 != lastEnd) break;
					if(s.charAt(j) == '(') {
						stack.push('(');
						curInit = j;
					}
				}else {
					switch(s.charAt(j)) {
						case '(':
							stack.push('(');
							break;
						case ')':
							if(stack.peek() == '(') {
								stack.pop();
								
							}
							else break;
					}

					if(stack.size() == 0) {
						combo += j - curInit + 1;
						lastEnd = j;
					}
					
				}
			}
			longestSingle = combo > longestSingle ? combo : longestSingle;
			i = lastEnd + 1;
			
		}
        
		return longestSingle;
    }
	
	public static int longestValidParentheses2(String s) {
		int maxans = 0;
		int dp[] = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			out("start: " + Arrays.toString(dp));
			if (s.charAt(i) == ')') {
		        if (s.charAt(i - 1) == '(') {
		        	//i - 1: '('
		        	//i - 2: ending of last set
		        	//e.g.	"(   )   (   )"
		        	//				  b  a   i
		        	//a: i - 1
		        	//b: i - 2
		            dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
		        } 
		        //Now, charAt(i) is ')', and charAt(i - 1) is also ')',
		        //we need to trace back to find corresponding '('
		        //		Case 1: current set of parentheses starts from beginning	e.g. "()()')'", i = 4
		        //			- (i - dp[i - 1] > 0) checks if current set of parentheses starts from beginning
		        //			- if it is, then no corresponding '(', then we should keep dp[i]  as 0
		        //		Case 2: current set does not start from beginning e.g. "())(')'", i = 4
		        //			- char just before current set is '(': 
		        //				- calculate dp[i]
		        //			- char just before current set is not '(': 
		        //				- keep dp[i] as 0
		        
		        //dp[i - 1]: length of current valid set
		        //(i - dp[i - 1]): beginning of current valid set
		        //(i - dp[i - 1] - 1): character just before current valid set
		        //(i - dp[i - 1] - 2): the end of last valid set
		        //e.g.	"(   (   )   (   (    )   (    )   )   )"
		        //          0  0  2  0  0   2  0   4   0  0
		        //			          d  c   b            a    i     
		        //a: dp[i - 1]
		        //b: i - dp[i - 1]
		        //c: i - dp[i - 1] - 1
		        //d: i - dp[i - 1] - 2
		        else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
		            	out("dp[i - 1] = " + dp[i - 1] + ", (i - dp[i - 1]) = " + (i - dp[i - 1]));
		            	if((i - dp[i - 1]) >= 2) out("i = " + i + ", (i - dp[i - 1] - 2) = " + (i - dp[i - 1] - 2) + ", dp = " + dp[i - dp[i - 1] - 2]);
		                //(i - dp[i - 1]) >= 2 checks if there is at least a pair of parentheses before current set
		            	dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
		            }
		            maxans = Math.max(maxans, dp[i]);
		        }
		        out("end: " + Arrays.toString(dp));
		}
		return maxans;
	}
	 
	 public static int longestValidParentheses3(String s) {
		 int max = 0;
		 
		 Stack<Integer> stack = new Stack<>();
		 stack.push(-1);
		 
		 for(int i = 0; i < s.length(); i++) {
			 if(s.charAt(i) == '(') stack.push(i);
			 else {
				 stack.pop();
				 if(stack.empty()) {
					 stack.push(i);
				 }else {
					 max = Math.max(max, i - stack.peek());
				 }
			 }
		 }
		 
		 return max;
	 }
	 
	 public static void out(String str) {
		 System.out.println(str);
	 }

}
