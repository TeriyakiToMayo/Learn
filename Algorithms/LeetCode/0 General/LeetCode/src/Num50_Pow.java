
public class Num50_Pow {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		double[][] x_n = {
				/*
				{2.00000, 0},
				{2.00000, 1},
				{2.00000, 10},
				{2.10000, 3},
				{2.00000, -2},*/
				{2f, Integer.MIN_VALUE}
		};
		
		for(double[] d : x_n) {
			out2("" + myPow(d[0], (int) d[1]));
		}

	}
	
	public static double myPow(double x, int n) {
		
		if(n == 0) return 1;
		if(n == 1) return x;
		if(n == -1) return 1f/x;
		
		//Since n might be Integer.MIN_VALUE -2147483648
		//Math.abs(n) == 2147483648 > 2147483647 == Integer.MAX_VALUE
		//Hence we divided it first then make absolute value
		double pow = myPow(x, Math.abs(n / 2));
		pow = pow * pow * (n%2 == 0 ? 1 : x);

        if(n < 0) pow = 1f / pow;
		
		return pow;
    }
	
	public static void out(String str) {
		 System.out.println(str);
	}
		
	public static void out2(String str) {
		 System.out.println(str);
	}

}
