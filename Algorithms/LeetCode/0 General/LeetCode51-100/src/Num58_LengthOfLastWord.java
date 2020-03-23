
public class Num58_LengthOfLastWord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[] strs = {
				"",
				"a",
				"A",
				"abc",
				"ABC",
				"Hello World",
				"   AASDFAAA",
		};
		
		for(String str : strs) {
			IO.outMain("" + lengthOfLastWord(str));
		}

	}
	
	public static int lengthOfLastWord(String s) {
        s = s.trim();
        int i = s.length() - 1;
        while(i >= 0){
            if(!isLetter(s.charAt(i))) break;
            i--;
        }

        return s.length() - 1 - i;
    }

    public static boolean isLetter(char c){
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z');
    }

}
