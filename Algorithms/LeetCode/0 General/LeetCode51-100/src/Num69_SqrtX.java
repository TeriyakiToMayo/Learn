
public class Num69_SqrtX {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		for(int i = 0; i <= 100; i++) {
			IO.outMain("sqrt(" + i + ") = " + mySqrt(i));
		}
		
		
		int test = 2147483647;
		IO.outMain("" + Integer.MAX_VALUE);
		IO.outMain("sqrt(" + test + ") = " + mySqrt2(test));
		
	}
	
	//=======================================================
	// Solution 2: Using long
	//=======================================================
	public static int mySqrt2(int x) {

		if(x == 0) return 0;
		if(x == 1) return 1;
		
		long left = 0, right = x;
		long mid = (right + left)/2;
		long sqr1 = sqr2(mid);
		long sqr2 = sqr2(mid + 1);
		
		while(!(sqr1 <= x && sqr2 >= x)) {
			if(sqr1 > x) {
				right = mid - 1;
			}else if(sqr2 < x) {
				left = mid + 1;
			}
			mid = left + (right - left)/2;
			sqr1 = sqr2(mid);
			sqr2 = sqr2(mid + 1);
		}
		
		if(sqr2 == x) mid++;
		
		return (int) mid;

    }
	
	public static long sqr2(long n) {
		return n * n;
	}
	
	//=======================================================
	// Solution 1: Without using long
	//=======================================================
	public static int sqr(int n) {
		return n >= 46341 ? Integer.MAX_VALUE : n * n;
	}
	
	public static int mySqrt(int x) {

		if(x == 0) return 0;
		if(x == 1) return 1;
		if(x ==  Integer.MAX_VALUE) return 46340;
		
		int left = 0, right = x;
		int mid = left + (right - left)/2;
		int sqr1 = sqr(mid);
		int sqr2 = sqr(mid + 1);
		
		while(!(sqr1 <= x && sqr2 >= x)) {
			if(sqr1 > x) {
				right = mid - 1;
			}else if(sqr2 < x) {
				left = mid + 1;
			}
			mid = left + (right - left)/2;
			sqr1 = sqr(mid);
			sqr2 = sqr(mid + 1);
		}
		
		if(sqr2 == x) mid++;
		
		return mid;

    }

}
