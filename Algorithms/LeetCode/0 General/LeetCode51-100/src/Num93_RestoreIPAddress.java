import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Num93_RestoreIPAddress {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] sss = {
				"0000",
				"0111111",
				"10101010",
				"25525511135",
		};
		
		for(String ss : sss) {
			IO.outMain("" + restoreIpAddresses(ss));
			IO.outMain("" + restoreIpAddresses2(ss));
			IO.outMain("");
		}
		
	}
	
	//=======================================================
	// Solution 1
	//=======================================================
	public static List<String> res;
	public static String str;
	public static int[] cuts;
	public static int len;
	
	public static List<String> restoreIpAddresses(String s) {
		res = new ArrayList<String>();
		str = s;
		cuts = new int[3];
		len = s.length();
		helper(1, 0);
		
		return res;
    }
	
	public static void helper(int stage, int index) {
		if(stage == 4) {
			int space = len - index;
			if(index >= len || space >= 4) return;
			if((space == 2 && !is2DigitIP(index)) 
					|| (space == 3 && !is3DigitIP(index))) return;
			
			res.add(buildIPAddress());
		}else {
			int remainStages = 4 - stage;
			int remainSpace = len - index - 1;
			
			for(int i = 0; i < 3; i++) {
				if(remainSpace - remainStages - i < 0) break;
				if(i == 1 && !is2DigitIP(index)) break;
				if(i == 2 && !is3DigitIP(index)) break;
				cuts[stage - 1] = index + 1 + i;
				helper(stage + 1, index + 1 + i);
			}
		}
		
	}
	
	public static String buildIPAddress() {
		StringBuilder sb = new StringBuilder();
		sb.append(str.substring(0, cuts[0]));
		sb.append(".");
		sb.append(str.substring(cuts[0], cuts[1]));
		sb.append(".");
		sb.append(str.substring(cuts[1], cuts[2]));
		sb.append(".");
		sb.append(str.substring(cuts[2]));
		return sb.toString();
	}
	
	public static boolean is2DigitIP(int start) {
		char c0 = str.charAt(start);
		return c0 != '0';
	}
	
	public static boolean is3DigitIP(int start) {
		char c0 = str.charAt(start);
		if(c0 == '0') return false;
		if(c0 == '1') return true;
		if(c0 >= '3') return false;
		
		c0 = str.charAt(start + 1);
		if(c0 >= '6') return false;
		if(c0 == '5') return str.charAt(start + 2) <= '5';
		
		return true;
	}

	
	//=======================================================
	// Official Solution
	//=======================================================
	
	static int n;
	static String str2;
	static LinkedList<String> segments;
	static ArrayList<String> output;
	
	public static boolean valid(String segment) {
	    /*
	    Check if the current segment is valid :
	    1. less or equal to 255      
	    2. the first character could be '0' 
	    only if the segment is equal to '0'
	    */
	    int m = segment.length();
	    if (m > 3)
	      return false;
	    return (segment.charAt(0) != '0') ? (Integer.valueOf(segment) <= 255) : (m == 1);
	  }

	  public static void update_output(int curr_pos) {
	    /*
	    Append the current list of segments 
	    to the list of solutions
	    */
	    String segment = str2.substring(curr_pos + 1, n);
	    if (valid(segment)) {
	      segments.add(segment);
	      output.add(String.join(".", segments));
	      segments.removeLast();
	    }
	  }

	  public static void backtrack(int prev_pos, int dots) {
	    /*
	    prev_pos : the position of the previously placed dot
	    dots : number of dots to place
	    */
	    // The current dot curr_pos could be placed 
	    // in a range from prev_pos + 1 to prev_pos + 4.
	    // The dot couldn't be placed 
	    // after the last character in the string.
	    int max_pos = Math.min(n - 1, prev_pos + 4);
	    for (int curr_pos = prev_pos + 1; curr_pos < max_pos; curr_pos++) {
	      String segment = str2.substring(prev_pos + 1, curr_pos + 1);
	      if (valid(segment)) {
	        segments.add(segment);  // place dot
	        if (dots - 1 == 0)      // if all 3 dots are placed
	          update_output(curr_pos);  // add the solution to output
	        else
	          backtrack(curr_pos, dots - 1);  // continue to place dots
	        segments.removeLast();  // remove the last placed dot 
	      }
	    }
	  }

	  public static List<String> restoreIpAddresses2(String s) {
	    n = s.length();
	    str2 = s;
	    segments = new LinkedList<String>();
	    output = new ArrayList<String>();
	    backtrack(-1, 3);
	    return output;
	  }
	
}
