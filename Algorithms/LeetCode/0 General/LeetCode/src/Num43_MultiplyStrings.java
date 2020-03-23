import java.util.Arrays;

public class Num43_MultiplyStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] nums = {
				/*
				{"0", "0"},
				{"0", "10"},
				{"10", "0"},
				{"1", "2"},
				{"5", "2"},
				{"10", "10"},
				*/
				{"999", "91"},
				/*
				{"2147483647", "2147483647"},
				*/
		};
		
		
		for(int i = 0; i < nums.length; i++) {
		//	out(multiply(nums[i][0], nums[i][1]));
		out(multiply2(nums[i][0], nums[i][1]));
		}
		
		
		
		/*
		for(int i = 1; i <= 999; i++) {
			for(int j = 1; j <= 99; j++) {
				multiply2(i + "", j + "");
			}
		}
		*/
		

	}
	
	public static String multiply(String num1, String num2) {
        
		if(num1.equals("0") || num2.equals("0")) return "0";
		
		if(num1.length() < num2.length()) {
			String temp = num1;
			num1 = num2;
			num2 = temp;
		}
		
		String sum = "0";
		for(int i = num2.length() - 1, j = 0; i >= 0; i--, j++) {
			String multiResult = multiplySingle(num1, num2.charAt(i) - '0', j);
			sum = add(sum, multiResult);
		}
		
		return sum;
    }
	
	public static String multiplySingle(String num, int digit, int j) {
		if(num.equals("0") || digit == 0) return "0";
		
		int carry = 0;
		String result = "";
		for(int i = num.length() - 1; i >= 0; i--) {
			int curDigit = num.charAt(i) - '0';
			int newDigit = curDigit * digit + carry;
			carry = newDigit / 10;
			result = newDigit%10 + result;
		}
		if(carry != 0) result = carry + result;
		
		for(; j>0; j--) {
			result += "0";
		}
		
		return result;
	}
	
	public static String add(String num1, String num2) {
		if(num1.equals("0")) return num2;
		if(num2.equals("0")) return num1;
		
	//	out("num1 = " + num1 + " num2 = " + num2);
		int carry = 0;
		String sum = "";
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		while(i >= 0 || j >= 0 || carry > 0) {
			int digit1 = i >= 0 ? num1.charAt(i) - '0' : 0;
			int digit2 = j >= 0 ? num2.charAt(j) - '0': 0;
			int newDigit = digit1 + digit2 + carry;
			if(newDigit > 9) carry = 1;
			else carry = 0;
			sum = newDigit%10 + sum;
			i--;
			j--;
		}
		
		return sum;
	}
	
	public static String multiply2(String num1, String num2) {
		
		char[] chs1 = num1.toCharArray();
		char[] chs2 = num2.toCharArray();
		int n1 = chs1.length, n2 = chs2.length;
		char[] res = new char[n1 + n2];
		Arrays.fill(res, '0');
		
		for(int j = n2 - 1; j >= 0; j--) {
			for(int i = n1 - 1; i >= 0; i--) {
				int product = (chs1[i] - '0') * (chs2[j] - '0');
				int tmp = (res[i + j + 1] - '0' + product);
				
				out(Arrays.toString(res));
				out((chs1[i] - '0') + " " + (chs2[j] - '0'));
				out("product = " + product);
				out("pos (i + j + 1) = " + (i + j + 1));
				out("tmp = " + (res[i + j + 1] - '0') + " + " + product + " = " + tmp);
				
				res[i + j + 1] = (char) (tmp%10 + '0');
				res[i + j] = (char) ((res[i + j] - '0' + tmp / 10) + '0');
				if(res[i + j] >= 'A') {
				//	out("num1 = " + num1 + " num2 = " + num2);
				//	out("res[i + j] = " + res[i + j]);
				}
				
				out("res[i + j] = " + ((int) res[i + j]));
				out(Arrays.toString(res));
				out("");
				
				
			}
		}
		
		StringBuilder sb = new StringBuilder();
		boolean seen = false;
		for(char c : res) {
			if(c == '0' && !seen) continue;
			sb.append(c);
			seen = true;
		}
		
		return sb.length() == 0 ? "0" : sb.toString();
	}
	
	public static void out(String str) {
		 System.out.println(str);
	}
		
	public static void out2(String str) {
		 System.out.println(str);
	}
}
