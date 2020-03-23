import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Num18_4Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[][] nums = {
						{1, 0, -1, 0, -2, 2},
				//		{0, 0, 0},
				};
		
		int[] targets = {
				0,
			};
				
		for(int i = 0; i < nums.length; i++) {
			List<List<Integer>> result = fourSum3(nums[i], targets[i]);
			System.out.println("===========");
			for(List<Integer> list : result) {
				System.out.println(list);
			}
		}
		
	}

	public static List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> outerList = new ArrayList<>();
        
        for(int i = 0; i <= nums.length - 4; i++) {
        	List<List<Integer>> tempList = threeSum3(Arrays.copyOfRange(nums, i + 1, nums.length), target - nums[i], nums[i]);
        	
        	List<List<Integer>> addList = new ArrayList<>();
        	for(List<Integer> innerSubList : tempList) {
        		boolean contains = false;
        		for(List<Integer> outerSubList : outerList) {
                	if(innerSubList.equals(outerSubList)) {
                		contains = true;
                		break;
                	}
            	}
        		if(!contains) {
        			addList.add(innerSubList);
        		}
        	}
        	
        	for(List<Integer> subList : addList) {
        		outerList.add(subList);
        	}
        	
        }
		
		return outerList;
    }
	
	public static List<List<Integer>> threeSum3(int[] num, int target, int first){
		Arrays.sort(num);
		List<List<Integer>> list = new ArrayList<>();
		
		for(int i = 0; i <= num.length - 3; i++) {
			if(i == 0 || (i > 0 && num[i - 1] != num[i])) {
				int j = i + 1, k = num.length - 1;
				while(j < k) {
					int sum = num[i] + num[j] + num[k];
					if(sum == target) {
						//Add current combination to list
						List<Integer> subList = new ArrayList<>();
						subList.add(first); subList.add(num[i]); subList.add(num[j]); subList.add(num[k]);
						list.add(subList);
						
						//Continue calculation, since there might be other combinations
						//e.g.: [-3, 0, 3] [-3, 1, 2]
						k--;
						while(j < k && num[k] == num[k + 1])k--;	//must be j < k, or it may run out of the bound
						j++;
						while(j < k && num[j] == num[j - 1])j++;
					}else if(sum > target) {
						k--;
						while(j < k && num[k] == num[k + 1])k--;
					}else {
						j++;
						while(j < k && num[j] == num[j - 1])j++;
					}
				}
			}
		}
		
		return list;
	}
	
	public static List<List<Integer>> fourSum2(int[] nums, int target) {
        List<List<Integer>> res=new LinkedList<>();
        if(nums.length<4) return res;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-3;i++){
            if(i>0&&nums[i]==nums[i-1]) continue;
            
            if(nums[i]*4>target) break;// Too Big!!
            if(nums[i]+3*nums[nums.length-1]<target) continue;//Too Small
            
            for(int j=i+1;j<nums.length-2;j++){
                if(j>i+1&&nums[j]==nums[j-1]) continue;
                
                if(nums[j]*3>target-nums[i]) break;//Too Big
                if(nums[j]+2*nums[nums.length-1]<target-nums[i]) continue;// Too Small
                
                int begin=j+1;
                int end=nums.length-1;
                while(begin<end){
                    int sum=nums[i]+nums[j]+nums[begin]+nums[end];
                    if(sum==target){
                        res.add(Arrays.asList(nums[i],nums[j],nums[begin],nums[end]));
                        while(begin<end && nums[begin]==nums[begin+1]){begin++;}
                        while(begin<end && nums[end]==nums[end-1]){end--;}
                        begin++;
                        end--;
                    }else if (sum<target){
                        begin++;
                    }else{
                        end--;
                    }
                }
            }
        }
        return res;
    }
	
	public static List<List<Integer>> fourSum3(int[] nums, int target) {
		Arrays.sort(nums);
		
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		
		for(int i = 0; i < nums.length - 3; i++) {
			if(i > 0 && nums[i - 1] == nums[i])continue;
			
			 if(nums[i]*4>target) break;// Too Big!!
	         if(nums[i]+3*nums[nums.length-1]<target) continue;//Too Small
			
			for(int j = i + 1; j < nums.length - 2; j++) {
				if(j > i + 1 && nums[j - 1] == nums[j])continue;
				
				 if(nums[j]*3>target-nums[i]) break;//Too Big
	             if(nums[j]+2*nums[nums.length-1]<target-nums[i]) continue;// Too Small
				
				int lo = j + 1, hi = nums.length - 1;
				while(lo < hi) {
					int sum = nums[i] + nums[j] + nums[lo] + nums[hi];
					if(sum == target) {
						list.add(Arrays.asList(nums[i],  nums[j], nums[lo], nums[hi]));
						
						hi--;
						while(lo < hi && nums[hi] == nums[hi + 1]) hi--;
						lo++;
						while(lo < hi && nums[lo - 1] == nums[lo]) lo++;
					}else if(sum > target) {
						hi--;
						while(lo < hi && nums[hi] == nums[hi + 1]) hi--;
					}else {
						lo++;
						while(lo < hi && nums[lo - 1] == nums[lo]) lo++;
					}
				}
				
			}
		}
		
		return list;
	}
	
}
