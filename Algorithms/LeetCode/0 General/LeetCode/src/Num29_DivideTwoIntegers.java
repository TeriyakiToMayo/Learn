
public class Num29_DivideTwoIntegers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] inputs = {
		//		{0, 1},
		//		{0, -1},
		//		{Integer.MIN_VALUE, 1},
		//		{Integer.MIN_VALUE, -1},
				{10, 3},
		//		{700, -3},
		};
		
		for(int i = 0; i < inputs.length; i++) {
			System.out.println(inputs[i][0] + " / " + inputs[i][1] + " = " + divide2(inputs[i][0], inputs[i][1]));
		}
		
	//	System.out.println("sum of 2 min_values = " + (Integer.MIN_VALUE + Integer.MIN_VALUE));

	}
	
	public static int divide(int dividend, int divisor) {
		int sign = (dividend < 0 && divisor < 0) || (dividend > 0 && divisor > 0) ? 1 : -1;
		
		long tempDividend = Math.abs((long)dividend);
		long tempDivisor = Math.abs((long)divisor);

		if(dividend == Integer.MIN_VALUE && divisor == -1)  return Integer.MAX_VALUE;

		if(tempDivisor == 1) {
			System.out.println("okay");
			return sign > 0 ? (int)tempDividend : (int)(-tempDividend);	//(int)(-tempDividend) is okay, 
		}																						//(int)-tempDividend is not

		int quotient = 0;
		
		while(tempDividend >= tempDivisor) {
			tempDividend -= tempDivisor;
			quotient++;
			
		}
        
		return  sign > 0 ? quotient : -quotient;
    }
	
	public static int divide2(int dividend, int divisor) {
	    if(dividend == Integer.MIN_VALUE && divisor==-1) return Integer.MAX_VALUE;
	    boolean sign = (dividend < 0) == (divisor < 0);
	    //if use positive, then range [0, 2147483647], -2147483648 is not covered
	    //if use negative, then range [-2147483648, 0], -2147483648 is covered
	    int res = div(-Math.abs(dividend), -Math.abs(divisor));
	    return sign? res: -res;
	}
	    
	public static int div(int dividend, int divisor){
		System.out.println(dividend + " " + divisor);
	    if(dividend > divisor) return 0;
	    int sum = divisor, q = 1;
	    
	    //when (sum + sum) < Integer.MIN_VALUE, (sum + sum) == 0
	    //then loop breaks
	    while(dividend <= sum + sum && sum + sum < sum){
	        sum = sum + sum;	//in fact sum * 2
	        q = q + q;				//in fact q * 2
	        System.out.println("sum = " + sum);
	    }
	    
	    return q + div(dividend - sum, divisor);
	}
	
	

}
