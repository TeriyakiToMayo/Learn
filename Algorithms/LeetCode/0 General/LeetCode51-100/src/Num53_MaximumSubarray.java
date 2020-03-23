
public class Num53_MaximumSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] nums = {
				{-2, 1, -3, 4, -1, 2, 1, -5, 4},
		};
		
		for(int i = 0; i < nums.length; i++) {
			out2("" + maxSubArray(nums[i]));
		}

	}
	
	public static int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num: nums) {
            if(sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
	
	public static void out(String str) {
		 System.out.println(str);
	}
		
	public static void out2(String str) {
		 System.out.println(str);
	}

}
