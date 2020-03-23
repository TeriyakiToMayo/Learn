import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.stream.Collectors;

public class Num71_SimplifyPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] paths = {
				{"/", "/"},
				{"///", "/"},
//				/*
				{"/home/", "/home"},
				{"/../", "/"},
//				*/
				{"/home//foo/", "/home/foo"},
//				/*
				{"/a/./b/../../c/", "/c"},
				{"/a/../../b/../c//.//", "/c"},
//				*/
				{"/a//b////c/d//././/..", "/a/b/c"},
				
		};
		
		for(String[] path : paths) {
			String result = simplifyPath3(path[0]);
			IO.outMain(result + " " + (result.equals(path[1])));
			IO.outMain("");
		}
	}
	
	//In this case, we assume all inputs are legal
	public static String simplifyPath3(String path) {
		//split with "/" instead of "/+" improves performance by 100%
    	String[] strs = path.split("/");
    	Stack<String> stack = new Stack<String>();
    	
    	for(int i = 0; i < strs.length; i++) {
    		//use isEmpty() instead of empty()
    		if(strs[i].equals("..") && !stack.isEmpty()) stack.pop();
    		else if(strs[i].length() > 0 && !strs[i].equals("..") && !strs[i].equals("."))
    			stack.push(strs[i]);
    	}
    	
    	if(stack.isEmpty()) return "/";
    	
    	//using stream will cause performance problems
 //   	String ans = "/" + stack.stream().collect(Collectors.joining("/"));
    	
    	
    	StringBuffer res = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            res.append("/" + stack.get(i));
        }
        
    	
        return res.toString();
    }

    public static String simplifyPath(String path) {
    	//path must start with '/'
    	if(path.length() == 0 || path.charAt(0) != '/') return "";
    	
    	String[] strs = path.split("/+");
    	if(strs.length == 0) return "/";
    	if(strs[0].length() != 0) return "";
    	
    	Stack<String> stack = new Stack<String>();
    	for(int i = 1; i < strs.length; i++) {
    		if(strs[i].equals("..")) {
    			if(!stack.empty())stack.pop();
    			continue;
    		}
    		else if(strs[i].equals(".")) continue;
    		else stack.push(strs[i]);
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < stack.size(); i++) {
    		sb.append("/").append(stack.get(i));
    	}
    	
    	if(sb.length() == 0) return "/";
    	
        return sb.toString();
    }
    
    //Assume all inputs are correct
    public static String simplifyPath2(String path) {
        String[] s = path.split("/");
        Stack<String> stack = new Stack<>();
        IO.outTest(Arrays.toString(s));
        
        for (int i = 0; i < s.length; i++) {
            if (!stack.isEmpty() && s[i].equals(".."))
                stack.pop();
            else if (!s[i].equals("") && !s[i].equals(".") && !s[i].equals(".."))
                stack.push(s[i]);
        }
        if (stack.isEmpty())
            return "/";

        StringBuffer res = new StringBuffer();
        for (int i = 0; i < stack.size(); i++) {
            res.append("/" + stack.get(i));
        }
        return res.toString();
    }
    
	
}
