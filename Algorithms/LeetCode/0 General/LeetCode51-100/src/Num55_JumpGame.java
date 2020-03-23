import java.util.Arrays;

public class Num55_JumpGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] numses = {
				{2, 3, 1, 1, 4},
				{3, 2, 1, 0, 4},
		};
		
		for(int[] nums : numses) {
			out2(Arrays.toString(nums));
			out2("" + canJump(nums));
			out2("");
		}

	}
	
	public static boolean canJump(int[] nums) {
		
		int curMax = 0;
		
		for(int i = 0; i < nums.length; i++) {
			if(curMax < i) return false;
			curMax = Math.max(curMax, i + nums[i]);
			if(curMax >= nums.length - 1) return true;
			
		}
        
		return true;
    }
	
	public static void out(String str) {
		 System.out.println(str);
	}
		
	public static void out2(String str) {
		 System.out.println(str);
	}

}
