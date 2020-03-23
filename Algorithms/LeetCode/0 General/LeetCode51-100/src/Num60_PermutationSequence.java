import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Num60_PermutationSequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IO.outMain(getPermutation(12, 2));
		IO.outMain("Finished");
	}
	
	
	
	static int[] factorials;
	static int num = 0;
	static LinkedList<Integer> list;
	static String str;
	
	//=======================================================
	// Solution 2
	//=======================================================
	public static String getPermutation2(int n, int k) {
		
		//initialize nums
		num = n;
		//generate factorial array and number list
		list = new LinkedList<Integer>();
		for(int i = 1; i <= n; i++) {
			list.add(i);
		}
		//initlize result str
		str = "";
		
		permute2(k);
        
		return str;
    }
	
	public static void permute2(int k) {
		
		int len = list.size();
		if(len == 1) {
			str += list.remove(0);
			return;
		}
		
		int range = factorial(len - 1);
		int i = k/range;
		int nextK = k%range;
		if(nextK == 0) {
			i -= 1;
			nextK = range;
		}
		str += list.remove(i);
		permute(nextK);
	}
	
	private static int factorial(int n){
        int res = 1;
        for(int i = n; i > 1; i--){
            res *= i;
        }
        return res;
    }
	
	//=======================================================
	// Solution 1
	//=======================================================
	//Total number of permutations: n!
	//Since k covers the entire range of n!, and k is int
	//therefore:
	// 1. n! <= Integer.MAX_VALUE, n <= 12
	// 2. factorials is okay to be int[]
	public static String getPermutation(int n, int k) {
		
		//initialize nums
		num = n;
		//generate factorial array and number list
		factorials = new int[num];
		list = new LinkedList<Integer>();
		factorials[0] = 1;
		for(int i = 1; i < n; i++) {
			factorials[i] = factorials[i - 1] * i;
			list.add(i);
		}
		list.add(num);
		//initlize result str
		str = "";
		
		permute(k);
        
		return str;
    }
	
	public static void permute(int k) {
		
		int len = list.size();
		if(len == 1) {
			str += list.remove(0);
			return;
		}
		
		int range = factorials[len - 1];
		int amount = 0;
		
		//if k != range * i
		//then i = k/range
		//        nextK = k%range
		//E.g. range = 2, k = 1
		//then i = 0, nextK = 1
		
		//if k == range * i
		//k/range is the next range, hence i = k/range - 1
		//nextK will be calculated as 0, hence nextK = range
		int i = k/range;
		int nextK = k%range;
		if(nextK == 0) {
			i -= 1;
			nextK = range;
		}
		str += list.remove(i);
		permute(nextK);
	}
	
	


}
