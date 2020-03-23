package Utils;
import java.util.Arrays;

public class IO {
	public static boolean testVisible = true;
	
	public static void outTest(String str) {
		 if(testVisible) System.out.println(str);
	}
		
	public static void outMain(String str) {
		 System.out.println(str);
	}
	
	public static void print2DArray(int[][] nums, boolean main) {
		for(int[] num : nums) {
			String str = Arrays.toString(num);
			if(main) outMain(str);
			else outTest(str);
		}
	}
	
	public static void print2DArray(char[][] nums, boolean main) {
		for(char[] num : nums) {
			String str = Arrays.toString(num);
			if(main) outMain(str);
			else outTest(str);
		}
	}
	
	public static void print2DArray(boolean[][] nums, boolean main) {
		for(boolean[] num : nums) {
			String str = Arrays.toString(num);
			if(main) outMain(str);
			else outTest(str);
		}
	}
	
}
