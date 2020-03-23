
public class Num12_13_IntegerToRoman_RomanToInteger {

	public static void main(String[] args) {
		
		/*
		int[] test = {3, 4, 9, 58, 1994};
		
		for(int i = 0; i < test.length; i++) {
			String result = intToRoman(test[i]);
			System.out.println(test[i] + " = " + result);
		}
		*/
		
		
		String[] testStr = {"III",  "IV",  "IX",  "LVIII",  
									"MCMXCIV", "MDLXX", "MMMDXCII"};
		
		
		for(int i = 0; i < testStr.length; i++) {
			int result = romanToInt2(testStr[i]);
			System.out.println(testStr[i] + " = " + result);
		}
		
		
		int i = 6;
		System.out.println(romanToInt2(testStr[i]));
		
		
		
	}
	
	public static String intToRoman(int num) {
        String result = "";
        String[][] digits = {{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}, 
								  {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}, 
								  {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}, 
								  {"", "M", "MM", "MMM"}};
        
		int pos = 1;
		while(num != 0) {
			int digit = num%10;
			num /= 10;
			
			

			result = digits[pos - 1][digit] + result;
			pos++;
			
		}
		
		return result;
    }
	
	public static String intToRoman2(int num) {
		String M[] = {"", "M", "MM", "MMM"};
	    String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
	    String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
	    String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
	    return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
	}
	
	public static int romanToInt(String s) {
		String[][] digits = {{"V", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}, 
								  {"L", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}, 
								  {"D", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}, 
								  {"M", "M", "MM", "MMM"}};
		
		int result = 0;
		int pos = digits.length - 1;
		
		while(pos >= 0) {
			result *= 10;
			if(s.length() > 0) {
				if((s.charAt(0) == digits[pos][0].charAt(0)) || (s.charAt(0) == digits[pos][1].charAt(0))) {
					int maxIndex = 0;
					for(int i = 1; i < digits[pos].length; i++) {
						if(s.contains(digits[pos][i])){
							maxIndex = (digits[pos][maxIndex].length() <= digits[pos][i].length()) ? i : maxIndex;
						}
					}
					s = s.substring(digits[pos][maxIndex].length());
					result += maxIndex;
				}
			}
			
			pos--;
		}
		
		return result;
    }
	
	public static int romanToInt2(String s) {
        int num = 0;
        int l = s.length();
        int last = 1000;
        for (int i = 0; i < l; i++){
            int v = getValue(s.charAt(i));
            if (v > last) num = num - last * 2;
            num = num + v;
            last = v;
        }
        return num;
    }
	
    private static int getValue(char c){
        switch(c){
            case 'I' : return 1;
            case 'V' : return 5;
            case 'X' : return 10;
            case 'L' : return 50;
            case 'C' : return 100;
            case 'D' : return 500;
            case 'M' : return 1000;
            default : return 0;
        }
    }
	
}

