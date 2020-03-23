import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Num15_3Sum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int[][] nums = {
				{-1, 0, 1, 2, -1, -4},
				{0, 0, 0},
				{-1, -1, -1, 0, 0, 0, 2},
				{-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0},
				{1, 1, 1}
		};
		
		for(int i = 0; i < nums.length; i++) {
		//	List<List<Integer>> result = threeSum3(nums[i], 0);
			List<List<Integer>> result = threeSum3(nums[i]);
			System.out.println("===========");
			for(List<Integer> list : result) {
				System.out.println(list);
			}
		}
		
		/*
		int a = 0, b = 0, c = 0;
		Set<Set<Integer>> set = new HashSet<Set<Integer>>();
		
		System.out.println(containsSet(a, b, c, set));
		 */
	}
	
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<List<Integer>>();
        Set<Set<Integer>> set = new HashSet<Set<Integer>>();
        
        if(nums.length < 3)return resultList;
        
        for(int i = 0; i <= nums.length - 3; i++) {
        	for(int j = i + 1; j <= nums.length - 2; j++) {
        		for(int k = j + 1; k <= nums.length - 1; k++) {
        			
        			if(nums[i] + nums[j] + nums[k] == 0) {
        				boolean contains = containsSet(nums[i], nums[j], nums[k], set);
            			
        				if(!contains) {
        					List<Integer> tempList = new ArrayList<Integer>();
            				tempList.add(nums[i]);
            				tempList.add(nums[j]);
            				tempList.add(nums[k]);
            				resultList.add(tempList);
        					
        					set.add(new HashSet<Integer>(tempList));
        				}
        				
        				
        			}
        		}
        	}
        }
        
		return resultList;
    }
	
	public static boolean containsSet(int a, int b, int c, Set<Set<Integer>> set) {
		Set<Integer> testSubSet = new HashSet<Integer>();
		testSubSet.add(a);testSubSet.add(b);testSubSet.add(c);
		
		for(Set<Integer> subSet : set) {
			if(subSet.equals(testSubSet)) return true;
		}
		return false;
	}
	
	public static void printSet(Set<Set<Integer>> set) {
		for(Set<Integer> subSet : set) {
			System.out.print(subSet + " ");
		}
		System.out.println();
	}
	
	public static List<List<Integer>> threeSum2(int[] num) {
	    Arrays.sort(num);
	    List<List<Integer>> res = new LinkedList<>(); 
	    for (int i = 0; i < num.length-2; i++) {
	    	
	        if (i == 0 || (i > 0 && num[i] != num[i-1])) {		//num[i] is the first num of each section, for {-1, -1, -1, 0, 0, 0, 2}, num[i] will be 0, 3
	            int lo = i+1, hi = num.length-1, sum = 0 - num[i];
	            while (lo < hi) {										//move lo and hi to find accurate position to allow sum of num[i], num[lo], num[hi] is 0
	                if (num[lo] + num[hi] == sum) {
	                    res.add(Arrays.asList(num[i], num[lo], num[hi]));
	                    while (lo < hi && num[lo] == num[lo+1]) lo++;
	                    while (lo < hi && num[hi] == num[hi-1]) hi--;
	                    lo++; hi--;
	                } else if (num[lo] + num[hi] < sum) lo++;
	                else hi--;
	           }
	        }
	    }
	    return res;
	}
	
	public static List<List<Integer>> threeSum3(int[] nums, int target){
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<>();
		
		for(int i = 0; i <= nums.length - 3; i++) {
			if(i > 0 && nums[i - 1] == nums[i]) continue;
			
			if(nums[i]*4>target) break;// Too Big!!
	         if(nums[i]+3*nums[nums.length-1]<target) continue;//Too Small
			
			int j = i + 1, k = nums.length - 1;
			while(j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if(sum == target) {
					//Add current combination to list
					Integer[] arr = {nums[i], nums[j], nums[k]};
					List<Integer> subList = Arrays.asList(arr);
					list.add(subList);
					
					//Continue calculation, since there might be other combinations
					//e.g.: [-3, 0, 3] [-3, 1, 2]
					k--;
					while(j < k && nums[k] == nums[k + 1])k--;	//must be j < k, or it may run out of the bound
					j++;
					while(j < k && nums[j] == nums[j - 1])j++;
				}else if(sum > target) {
					k--;
					while(j < k && nums[k] == nums[k + 1])k--;
				}else {
					j++;
					while(j < k && nums[j] == nums[j - 1])j++;
				}
			}
		}
		
		return list;
	}
	
	public static List<List<Integer>> threeSum3(int[] nums){
		Arrays.sort(nums);
		List<List<Integer>> list = new LinkedList<>();
		
		for(int i = 0; i <= nums.length - 3; i++) {
			if(i > 0 && nums[i - 1] == nums[i]) continue;
			
			if(nums[i]*4>0) break;// Too Big!!
	         if(nums[i]+3*nums[nums.length-1]<0) continue;//Too Small
			
			int j = i + 1, k = nums.length - 1;
			while(j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if(sum == 0) {
					//Add current combination to list
					List<Integer> subList = Arrays.asList(nums[i], nums[j], nums[k]);
					list.add(subList);
					
					//Continue calculation, since there might be other combinations
					//e.g.: [-3, 0, 3] [-3, 1, 2]
					k--;
					while(j < k && nums[k] == nums[k + 1])k--;	//must be j < k, or it may run out of the bound
					j++;
					while(j < k && nums[j] == nums[j - 1])j++;
				}else if(sum > 0) {
					k--;
					while(j < k && nums[k] == nums[k + 1])k--;
				}else {
					j++;
					while(j < k && nums[j] == nums[j - 1])j++;
				}
			}
		}
		
		return list;
	}
}
