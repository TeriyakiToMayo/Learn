
public class Num67_AddBinary {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] strses = {
				{"0", "0"},	
				{"1", "0"},	
				{"0", "1"},	
				{"1", "1"},	
				{"11", "1"},	
				{"1010", "1011"},	
				{"100", "110010"},
		};

		for(String[] strs : strses) {
			IO.outMain(addBinary(strs[0], strs[1]));
		}
	}

    public static String addBinary(String a, String b) {
    	
    	if(a.length() < b.length()) {
    		String c = a;
    		a = b;
    		b = c;
    	}
    	
    	int digitA = 0, digitB = 0;
    	int lenA = a.length(), lenB = b.length();
    	int carry = 0;
    	int sum = 0;
    	StringBuilder sb = new StringBuilder();
    	for(int i = 0; i < lenA; i++) {
    		
    		if(carry == 0 && i >= lenB) {
    			sb.reverse();
    			sb.insert(0, a.substring(0, lenA - i));
    			return sb.toString();
    		}
    		
    		digitA = a.charAt(lenA - 1 - i) - '0';
    		digitB = (i < lenB ? b.charAt(lenB - 1 - i) - '0' : 0);
    		sum = digitA + digitB + carry;
    		sb.append(sum%2);
    		carry = sum/2;
    	}
    	
    	if(carry == 1) sb.append(1);
        sb.reverse();
    	
    	return sb.toString();
    }
}
