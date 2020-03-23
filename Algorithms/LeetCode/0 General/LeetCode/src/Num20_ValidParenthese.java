import java.util.Stack;

public class Num20_ValidParenthese {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strs = {
				"()",
				"()[]{}",
				"(]",
				"([)]", 
				"{[]}"
		};
		
		for(int i = 0; i < strs.length; i++) {
			System.out.println(strs[i] + " is " + isValid(strs[i]));
		}
	}
	
	public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
        	char c = s.charAt(i);
        	if(c == '(' || c == '{' || c == '[') {
        		stack.push(c);
        	}else {
        		if(stack.size() == 0)return false;
        		char topC = stack.pop();
        		switch(c) {
	        		case ')':
	        			if(topC != '(')return false;
	        			break;
	        		case '}':
	        			if(topC != '{') return false;
	        			break;
	        		case ']':
	        			if(topC != '[')return false;
	        			break;
        		}
        	}
        }
        
        
		return stack.size() == 0;
    }
}
