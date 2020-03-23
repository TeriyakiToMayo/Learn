
public class Num70_ClimbingStairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IO.outMain("" + climbStairs(3));
	}
	
	public static int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        
        int[] steps = new int[n];
        steps[0] = 1;
        steps[1] = 2;
        
        for(int i = 2; i < n; i++) {
        	steps[i] = steps[i - 1] + steps[i - 2];
        }
		
		return steps[n - 1];
    }

}
