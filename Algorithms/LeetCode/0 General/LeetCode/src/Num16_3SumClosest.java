import java.util.Arrays;


public class Num16_3SumClosest {
	
	public static void main(String[] args) {
		int[][] nums = {
						{-1, 2, 1, -4},
						{0, 2, 1, -3},	//-3, 0 , 1, 2
//						{0, 0, 0},
				};
		
		int[] targets = {
			1,
			1
		};
				
		for(int i = 0; i < nums.length; i++) {
			int result = threeSumClosest(nums[i], targets[i]);
			System.out.println("Closest sum = " + result);
		}
	}
	
	public static int threeSumClosest(int[] nums, int target) {
	        Arrays.sort(nums);
	        int dist = Integer.MAX_VALUE;
	        int j, k;
	        int sum;
	        
	        
	        for(int i = 0; i <= nums.length - 3; i++) {
	        	if(i == 0 || (i > 0 && nums[i - 1] != nums[i])) {
	        		j = i + 1;
	        		k = nums.length - 1;
	        		int tempDist = 0;
	        		while(j < k) {
	        			sum = nums[i] + nums[j] + nums[k];
	        			tempDist = sum - target;
	        			if(Math.abs(tempDist) < Math.abs(dist)) {
	        				dist = tempDist;
	        			}
	        			
	        			if(tempDist == 0)return sum;
	        			else if(tempDist > 0) {
	        				k--;
	        				while(j < k && nums[k] == nums[k + 1])k--;
	        			}else {
	        				j++;
	        				while(j < k && nums[j - 1] == nums[j])j++;
	        			}
	        		}
	        	}
	        }
		
		return target + dist;
    }
	
	public static int threeSumClosest2(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = 99999999;
        int hi;
        int lo;
        int sum;
        
        for(int i=0;i<nums.length-2;i++){
            hi = nums.length-1;
            lo = i+1;
            
            while(lo<hi) {
                sum = nums[i] + nums[lo] + nums[hi];
                if(isClosestSoFar(target,closest,sum)) {
                    closest = sum;
                    if(target-closest==0 || closest-target==0) {
                        return closest;
                    }
                }
                
                if(sum>target)
                    hi--;
                else
                    lo++;
                
            }
        }
        return closest;
    }
    private static boolean isClosestSoFar(int target, int old, int sum){
        int currentDiff = target - old;
        int newDiff = target - sum;
        return Math.abs(newDiff)<Math.abs(currentDiff);
    }

}
