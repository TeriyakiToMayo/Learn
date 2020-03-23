
public class Num8_ATOI {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		String[] test = {null, "42", "   -42", "words and 987", "-91283472332",  "", "-", "9223372036854775808"};
		
		
		for(int i = 0; i < test.length; i++) {
		//	System.out.println(myAtoi(test[i]));
		}
		
		System.out.println(myAtoi(" "));
		
		/*
		int i = 6;
		System.out.println(myAtoi(test[i]));
		
		*/
	}
	
	public static int myAtoi(String str) {
		str = str.trim();
		if(str == null || str.length() == 0)return 0;
		
		//categorize strings with the 1st character
		//1. value strings 
		//		- start with sign: '+' '-'
		//		- value strings start with numerical characters '1'
		//2. start with non-numerical characters 'a'
		
		boolean isSigned = false;
		if((str.charAt(0) == '-' || str.charAt(0) == '+') ) {
			if(str.length() > 1) {
				if(str.charAt(1) < '0' || str.charAt(1) > '9') {
					return 0;
				}
			}else {
				return 0;
			}
			
			isSigned = true;
		}else if(str.charAt(0) < '0' || str.charAt(0) > '9') {
			return 0;
		}
		
		//recreate numerical result:
		
		//initialize
		int sign = (isSigned && str.charAt(0) == '-') ? -1 : 1; 
		long res = 0;
		//recreate value
		for(int i = (isSigned ? 1 : 0); i < str.length(); i++) {
			if(str.charAt(i) < '0' || str.charAt(i) > '9') break;
			res = res * 10 + (str.charAt(i) - '0');
			
			long tempRes = sign * res;
			if(tempRes < Integer.MIN_VALUE) {
				return Integer.MIN_VALUE;
			}
			if(tempRes > Integer.MAX_VALUE) {
				return Integer.MAX_VALUE;
			}
		}
		
		//add sign
		return sign * (int)res;
	}
	
}
