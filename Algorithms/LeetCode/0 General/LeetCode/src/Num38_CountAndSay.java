
public class Num38_CountAndSay {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		for(int i = 1; i <= 30; i++ ) {
			out(countAndSay(i));
		}
		
	}
	
	public static String countAndSay(int n) {
		
		String str = "1";
        for(int i = 1; i < n; i++) {
        	str = helper(str);
        }
        
		return str;
    }
	
	public static String helper(String str) {
		String result = "";
		int count = 0;
		char c = '.';
		for(int i = 0; i <= str.length(); i++) {
			if(i == str.length()) {
				result += count + "" + c;
				break;
			}
			if(str.charAt(i) == c) count++;
			else {
				if(i > 0) result += count + "" + c;
				c = str.charAt(i);
				count = 1;
			}
		}
		
		return result;
	}
	
	public static void out(String str) {
		 System.out.println(str);
	}

}
