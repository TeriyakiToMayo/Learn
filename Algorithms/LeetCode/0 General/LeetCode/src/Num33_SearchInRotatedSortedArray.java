
public class Num33_SearchInRotatedSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] nums = {
		//		{}, 
		//		{1},
		//		{1},
		//		{0, 1, 2, 4, 5, 6, 7},	
		//		{4, 5, 6, 7, 0, 1, 2},	
		//		{4, 5, 6, 7, 0, 1, 2},	
		//		{7, 0, 1, 2, 4, 5, 6}, 
		//		{7, 0, 1, 2, 4, 5, 6}, 
				{3, 4, 5, 6, 7, 8, 1, 2}, 
				{3, 4, 5, 6, 7, 8, 1, 2}, 
		};
		
		int[] targets = {
		//	1,
		//	0,
		//	1,
		//	4,
		//	4,
		//	3, 
		//	7, 
		//	6,
		//	5,
			5,
			1
		};
		
		for(int i = 0; i < nums.length; i++) {
			out("" + search(nums[i], targets[i]));
		}

	}
	
	public static int search(int[] nums, int target) {

		return searchHelp(nums, target, 0, nums.length - 1);
    }
	
	public static int searchHelp(int[] nums, int target, int l, int r) {
		
		if(nums == null || nums.length == 0) return -1;
		
		if(l == r) return (target == nums[l]) ? l : -1;
		
		int mid = (l + r) / 2;
		
		if(nums[mid] < nums[mid + 1]) {
			int side = -1;
			side = (nums[l] < nums[mid] ? -1 : 0) == 0 ? 0 : nums[mid] < nums[r] ? -1 : 1;
			
			if(side == -1) {
				return target <= nums[mid] ? searchHelp(nums, target, l, mid) : searchHelp(nums, target, mid + 1, r);
			}else if(side == 0) {
				return target > nums[mid] ? searchHelpBothSides(nums, target, l, r) : searchHelp(nums, target, l, mid);
			}else {
				return target <= nums[mid] ? searchHelpBothSides(nums, target, l, r) : searchHelp(nums, target, mid + 1, r);
			}
			
			
		}else {
			return searchHelpBothSides(nums, target, l, r);
		}

	}
	
	public static int searchHelpBothSides(int[] nums, int target, int l, int r) {
		int mid = (l + r) / 2;
		int temp0 = searchHelp(nums, target, l, mid);
		int temp1 = searchHelp(nums, target, mid + 1, r);
		if(temp0 != -1) return temp0;
		if(temp1 != -1) return temp1;
		
		return -1;
	}
	
	public static void out(String str) {
		 System.out.println(str);
	 }

}
