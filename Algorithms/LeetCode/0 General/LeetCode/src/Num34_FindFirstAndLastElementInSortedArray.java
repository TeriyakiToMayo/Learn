import java.util.Arrays;

public class Num34_FindFirstAndLastElementInSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] nums = {
				{},
				{1},
				{1},
				{1, 1},
				{5,7,7,8,8,10}, 
				{5,7,7,8,8,10},
				{6,6,6,7,7,8,8,10},
				{6,6,6,7,7,8,8,10,10,10},
		};
		
		int[] targets = {
				1,
				1,
				0,
				1,
				8,
				6,
				6,
				10,
		};
		
		for(int i = 0; i < nums.length; i++) {
			out(Arrays.toString(searchRange(nums[i], targets[i])));
		}

	}
	
	public static int[] searchRange(int[] nums, int target) {
		
		if(nums == null || nums.length == 0) return new int[]  {-1, -1};
        
		int targetIndex = searchTarget(nums, target, 0, nums.length - 1);
		
		if(targetIndex == -1) return new int[]  {-1, -1};
		
		int left = searchSide(nums, target, 0, targetIndex, 0);
		
		int right = searchSide(nums, target, targetIndex, nums.length - 1, 1);
		
		return new int[] {left, right};
    }
	
	public static int searchTarget(int[] nums, int target, int l, int r) {
		
		if(l == r) return target == nums[l] ? l : -1;
		int mid = (l + r) / 2;
		
		if(target <= nums[mid]) {
			return searchTarget(nums, target, l, mid);
		}else {
			return searchTarget(nums, target, mid + 1, r);
		}
		
	}
	
	public static int searchSide(int[] nums, int target, int l, int r, int side) {
		
		if(l == r) return target == nums[l] ? l : -1;
		int mid = (l + r) / 2;

		if(side == 0) {
			if(nums[mid] == target) return searchSide(nums, target, l, mid, 0);
			else return searchSide(nums, target, mid + 1, r, 0);
		}else {

			if(nums[mid + 1] == target) return searchSide(nums, target, mid + 1, r, 1);
			else return searchSide(nums, target, l, mid, 1);
		}
		
		
	}
	
	public static void out(String str) {
		 System.out.println(str);
	 }

}
