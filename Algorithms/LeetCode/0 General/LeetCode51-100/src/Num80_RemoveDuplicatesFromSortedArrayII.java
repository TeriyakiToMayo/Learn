import java.util.Arrays;

public class Num80_RemoveDuplicatesFromSortedArrayII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] numses = {
				{1},
				{1, 2, 3},
				{1, 1, 2, 3},
				{1, 1, 1, 2, 2, 3},	
				{0,0,1,1,1,1,2,3,3},	
		};
		
		for(int[] nums : numses) {
			IO.outMain("" + removeDuplicates(nums));
			IO.outMain(Arrays.toString(nums));
			IO.outMain("");
		}
		
	}
	
	public static int removeDuplicates(int[] nums) {
		if(nums.length == 0) return 0;
		
		int cur = nums[0];
		int curCount = 1;
		int j = 1;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] != cur) {
				cur = nums[i];
				nums[j] = cur;
				curCount = 1;
				j++;
			}else {
				if(curCount == 1) {
					nums[j] = cur;
					curCount++;
					j++;
				}
			}
		}
		
		return j;
    }

}
