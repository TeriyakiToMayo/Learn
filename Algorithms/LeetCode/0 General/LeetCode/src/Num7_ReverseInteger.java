
public class Num7_ReverseInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] x = {0, 5, 10, 123, 1534236469, -102};
		for(int i = 0; i < x.length; i++) {
			System.out.println(reverse(x[i]));
			System.out.println(reverse2(x[i]));
		}
		
		System.out.println(123%10);
		System.out.println(-123%10);
	}
	
	public static int reverse(int x) {
		if(x == 0) return 0;
		boolean isNeg = x < 0;
		if(isNeg)x = -x;
		
		long res = 0;
		while(x > 0) {
			int digit = x % 10;
			x /= 10;
			res = res * 10 + digit;
			if(res > Integer.MAX_VALUE)return 0;
		}
		
		res = isNeg ? -1 * res : res;
		
		return (int)res;
	}
	
	public static int reverse2(int x) {
		
		long res = 0;
		while(x != 0) {
			res = res * 10 + x%10;
			x /= 10;
			if(res > Integer.MAX_VALUE || res < Integer.MIN_VALUE) {
				return 0;
			}
		}
		
		return (int)res;
	}

}
