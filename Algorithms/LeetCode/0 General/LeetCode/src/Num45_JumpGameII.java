import java.util.Arrays;

public class Num45_JumpGameII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] nums = {
		//		{2, 3, 1, 1, 4},
				{2, 4, 1, 1, 1, 3, 5, 6, 8},
		//		{1, 2, 3},
		};
		
		for(int i = 0; i < nums.length; i++) {
			out2(Arrays.toString(nums[i]) + "\n");
			out2("jump = " + jump3(nums[i]));
		}

	}
	
	public static int jump(int[] nums) {
        
		int[] dp = new int[nums.length];
		
		dp[0] = 0;
		for(int i = 1; i < nums.length; i++) {
			dp[i] = Integer.MAX_VALUE;
		}
		
		for(int i = 0; i < nums.length; i++) {
			for(int j = 1; j <= nums[i] && i + j < nums.length; j++) {
				if(dp[i] + 1 < dp[i + j]) dp[i + j] = dp[i] + 1;
			}
		}
		
		return dp[nums.length - 1];
    }
	
	public static int jump2(int[] nums) {
	    int end = 0;
	    int maxPosition = 0; 
	    int steps = 0;
	    
	    /*
	    String[] ends = new String[nums.length];
	    ends[0] = "E";
	    for(int i = 1; i < ends.length; i++) {
	    	ends[i] = "";
	    }
	    */
	    
	  //  printArray(nums, ends, maxPosition);
	    
	    for(int i = 0; i < nums.length - 1; i++){
	    	
	    	/* 	
	     	out("nums[" + i + "] = " + nums[i]);
	    	out("maxPosition: nums[" + maxPosition + "] = " + (maxPosition < nums.length ? nums[maxPosition] : -1));
	        out("end: nums[" + end + "] = " +(end < nums.length ? nums[end] : -1));
	        */
	        maxPosition = Math.max(maxPosition, nums[i] + i); 
	        if( i == end){
	            end = maxPosition;
	        //    ends[end] = "E";
	            steps++;
	        }
	        
	        /*
	        out("maxPosition: nums[" + maxPosition + "] = " + (maxPosition < nums.length ? nums[maxPosition] : -1));
	        out("end: nums[" + end + "] = " +(end < nums.length ? nums[end] : -1));
	        out("");
	        */
	     //   out("");
	     //   printArray(nums, ends, maxPosition);
	       
	    }
	    return steps;
	}
	
	public static void printArray(int[] nums, String[] ends, int max) {
		String str = "[";
		for(int i = 0; i < nums.length; i++) {
			str += nums[i] + ends[i] + (i == max ? "(M)" : "") + (i != nums.length - 1 ? ",\t\t" : "");
		}
		str += "]";
		out2(str);
	}

	public static int jump3(int[] nums) {
		int n = nums.length;
		
		if(n <= 1) return 0;
		
		int[] dp = new int[n];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		
		int min_i = 0;
		int add_start = 0;
		
		while(true) {
			
			//add_start: the length of the range of nums[min_i-1]
			//		e.g.: [2, 4, 1, 1, 1, 3, 5, 6, 8]
			//		assume min_i = 1, then min_i-1 = 0, 
			//		then add_start = nums[0] = 2
			//		then range of nums[min_i-1]: [4, 1]
			//
			//min_i + add_start = min_i-1 + add_start + 1 : first element after last range
			//		e.g.: similarly to last e.g.
			//		since, range of min_i-1 (including min_i-1) is: [2, 4, 1]
			//		then first element after range of min_i-1 is 1 at position 3
			
			out("min_i + add_start = " + min_i + " + " + add_start + " = " + (min_i + add_start));
			for(int j = min_i + add_start; j < min_i + nums[min_i] + 1; j++) {
				if(j < n && dp[j] > dp[min_i] + 1) {
					dp[j] = dp[min_i] + 1;
				}
			}
			
			out(Arrays.toString(dp));
			out("add_start = " + add_start);
			out("");
			if(dp[n - 1] != Integer.MAX_VALUE) break;
			
			add_start = nums[min_i];
			
			min_i += 1;
		}
		
		
		return dp[n - 1];
	}
	
	public static void out(String str) {
		 System.out.println(str);
	}
		
	public static void out2(String str) {
		 System.out.println(str);
	}

}

