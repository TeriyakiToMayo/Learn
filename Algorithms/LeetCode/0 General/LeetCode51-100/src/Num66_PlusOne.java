import java.util.Arrays;

public class Num66_PlusOne {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] digitses = {
				{0},
				{9},
				{9, 9},
				{1, 2, 3},	
				{4, 3, 2, 1},	
				
		};
		
		for(int[] digits : digitses) {
			IO.outMain("" + Arrays.toString(plusOne(digits)));
		}

	}

    public static int[] plusOne(int[] digits) {
    	
    	int carry = 1;
    	int sum = 0;
    	
    	for(int i = digits.length - 1; i >= 0; i--) {
    		sum = digits[i] + carry;
    		if(sum <= 9) {
    			digits[i] = sum;
    			carry = 0;
    			break;
    		}else {
    			digits[i] = sum%10;
    			carry = 1;
    		}
    	}
    	
    	if(carry == 1) {
    		int[] newDigits = new int[digits.length + 1];
    		newDigits[0] = 1;
    		System.arraycopy(digits, 0, newDigits, 1, digits.length);
    		return newDigits;
    	}
        
    	return digits;
    }
}

