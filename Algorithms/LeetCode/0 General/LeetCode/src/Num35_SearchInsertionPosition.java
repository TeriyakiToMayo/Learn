
public class Num35_SearchInsertionPosition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] nums = {
				{},
				{1},
				{1, 3, 5, 6},
				{1, 3, 5, 6},
				{1, 3, 5, 6},
				{1, 3, 5, 6},
		};
		
		int[] targets = {
				1,
				2,
				5,
				2,
				7,
				0,
		};
		
		for(int i = 0; i < nums.length; i++) {
			out("" + searchInsert(nums[i], targets[i]));
		}

	}
	
	public static int searchInsert(int[] nums, int target) {
		if(nums == null || nums.length == 0) return 0;
        
		return searchTarget(nums, target, 0, nums.length - 1);
    }
	
	public static int searchTarget(int[] nums, int target, int l, int r) {
		
		if(l == r) {
			if(nums[l] == target) return l;
			else if(nums[l] < target) return l + 1;
			else return l;
		}
		int mid = (l + r) / 2;
		
		if(target <= nums[mid]) {
			return searchTarget(nums, target, l, mid);
		}else {
			return searchTarget(nums, target, mid + 1, r);
		}
		
	}
	
	public static void out(String str) {
		 System.out.println(str);
	 }

}
