
public class Num65_ValidNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strs = {
//				/*
				"0",					//true
				" 0.1",				//true
				"abc",				//false
				"1 a",				//false
				"2e10",				//true
				" -90e3   ", 		// => true
				" 1e",				// => false
				"e3",					// => false
				" 6e-1",				// => true
				" 99e2.5 ",		// => false
				"53.5e93",		// => true
				" --6 ",				// => false
				"-+3",				// => false
				"95a54e53",	// => false
		
				"-0001e+5",
				".1",
				".3",
				".",
//				*/
				"+.3"
		};
		
		for(String s : strs) {
			IO.outMain(s + " " + (isNumber(s) == isNumber2(s)));
		}
		
	}
	
	//=======================================================
	// Solution 2
	//=======================================================
	public static boolean isNumber2(String s) {
		if(s == null || s.length() == 0) return false;
        
		s = s.trim();
		
		int dotPos = -1;
		for(int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '.') dotPos = i;
			if(c == 'e') return isSciNum2(s, i, dotPos);
		}
		
		if(dotPos >= 0) return isFloatPoint2(s, dotPos);
		
		if(isInteger2(s)) return true;
		
		return false;
    }
	
	public static boolean isSciNum2(String s, int cut, int floatCut) {
		String left = s.substring(0, cut);
		return (isInteger2(left) || isFloatPoint2(left, floatCut)) && isInteger2(s.substring(cut + 1));
	}
	
	public static boolean isFloatPoint2(String s, int cut) {
		if(s.length() == 0 || cut == -1) return false;
		
		char c = s.charAt(0);
		if(c == '+' || c == '-') {
			s = s.substring(1);
			cut--;
		}
		String left = s.substring(0, cut);
		String right = s.substring(cut + 1);
		if(left.length() == 0 && right.length() == 0) return false;
		return (isDigitSeq2(left) || left.length() == 0) && (isDigitSeq2(right) || right.length() == 0);
	}
	
	public static boolean isInteger2(String s) {
		if(s.length() == 0) return false;
		char c = s.charAt(0);
		if(c == '+' || c == '-') s = s.substring(1);
		return isDigitSeq2(s);
	}
	
	public static boolean isDigitSeq2(String s) {
		if(s.length() == 0) return false;
		for(int i = 0; i < s.length(); i++) {
			if(!digit0To92(s.charAt(i))) return false;
		}
		return true;
	}
	
	public static boolean digit0To92(char c) {
		return c >= '0' && c <= '9';
	}
	
	public static boolean digit1To92(char c) {
		return c >= '1' && c <= '9';
	}
	
	
	//=======================================================
	// Solution 1
	//=======================================================
	public static boolean isNumber(String s) {
		if(s == null || s.length() == 0) return false;
        
		s = s.trim();
		
		if(isInteger(s)) return true;
		if(isFloatPoint(s)) return true;
		if(isSciNum(s)) return true;
		
		return false;
    }
	
	//Correct scientific number format:
	//Integer e Float/Integer
	public static boolean isSciNum(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == 'e') {
				String left = s.substring(0, i);
				return (isInteger(left) || isFloatPoint(left)) && isInteger(s.substring(i + 1));
			}
		}
		return false;
	}
	
	//Correct float formats:
	//+0.1, -0.1, 0.1
	//+.1, -.1, .1
	//+1., -1., 1.
	public static boolean isFloatPoint(String s) {
		if(s.length() == 0) return false;
		char c = s.charAt(0);
		if(c == '+' || c == '-') s = s.substring(1);
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) == '.') {
				String left = s.substring(0, i);
				String right = s.substring(i + 1);
				if(left.length() == 0 && right.length() == 0) return false;
				return (isDigitSeq(left) || left.length() == 0) && (isDigitSeq(right) || right.length() == 0);
			}
		}
		
		return false;
	}
	
	//Since input might be < Integer.MAX_VALUE or > Integer.MIN_VALUE
	//default method provided by Integer cannot be used
	
	//Correct integer format:
	//+00000011, -00000011, 00000011
	public static boolean isInteger(String s) {
		if(s.length() == 0) return false;
		char c = s.charAt(0);
		if(c == '+' || c == '-') s = s.substring(1);
		return isDigitSeq(s);
	}
	
	public static boolean isDigitSeq(String s) {
		if(s.length() == 0) return false;
		for(int i = 0; i < s.length(); i++) {
			if(!digit0To9(s.charAt(i))) return false;
		}
		return true;
	}
	
	public static boolean digit0To9(char c) {
		return c >= '0' && c <= '9';
	}

}
