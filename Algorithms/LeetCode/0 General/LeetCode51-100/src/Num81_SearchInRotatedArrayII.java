import java.util.Arrays;

public class Num81_SearchInRotatedArrayII {
	
	public static void main(String[] args) {
		int[][] numses = {

				{},
				{1},

				{1, 1},

				{2, 5, 6, 0, 0, 1, 2},
				{2, 5, 6, 0, 0, 1, 2},
				{2, 5, 6, 0, 0, 1, 2},
				{2, 5, 6, 0, 0, 1, 2},
				{1, 2, 2, 5, 6, 0, 0},
				{1, 2, 2, 5, 6, 0, 0},
				{1, 2, 2, 5, 6, 0, 0},
				{1, 2, 2, 5, 6, 0, 0},

		};
		
		int[] targets = {

				1,
				1,

				0,

				-1,
				0, 
				3,
				7,
				-1,
				0, 
				3,
				7,

		};
		
		for(int i = 0; i < numses.length; i++) {
			IO.outMain(Arrays.toString(numses[i]) + " " + targets[i]);
			IO.outMain("" + search(numses[i], targets[i]));
			IO.outMain("");
		}
	}
	
	public static boolean search(int[] nums, int target) {
		if(nums.length == 0) return false;
		return helper(nums, 0, nums.length - 1, target);
    }
	
	public static boolean helper(int[] nums, int l, int r, int target) {
		if(l > r) return false;
		if(l == r) return nums[r] == target;
		
		int mid = (l + r)/2;
		int midN = nums[mid];
		if(midN == target) return true;
		
		int leftN = nums[l];
		int midNPlus1 = nums[mid + 1];
		if(midN > midNPlus1) {
			if(target < midNPlus1 || target > midN) return false;
			if(target < leftN) return helper(nums, mid + 1, r, target);
			else return helper(nums, l, mid - 1, target);
		}else {
			
			if(leftN < midNPlus1) {
				//pivot is on the right side if exists
				if(target >= midNPlus1) return helper(nums, mid + 1, r, target);
				else {
					boolean exists = helper(nums, l, mid - 1, target) || helper(nums, mid + 1, r, target);
					return exists;
				}
			}else if(leftN > midNPlus1) {
				//pivot is on the left side
				if(target >= leftN) return helper(nums, l, mid - 1, target);
				else {
					boolean exists = helper(nums, l, mid - 1, target) || helper(nums, mid + 1, r, target);
					return exists;
				}
			}else {
				boolean exists = helper(nums, l, mid - 1, target) || helper(nums, mid + 1, r, target);
				return exists;
			}
		}
	}
}
