import java.util.Arrays;

public class Num26_RemoveDuplicatesFromSortedArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] nums = {
				{}, 
				{1, 1}, 
				{1, 2, 2}, 
				{1, 2, 3}, 
				{1, 2, 3, 4}, 
				{1, 2, 3, 4, 5},
				{0, 0, 1, 1, 1, 2, 2, 3, 3, 4},
		};
		
		for(int i = 0; i < nums.length; i++) {
			int result = removeDuplicates(nums[i]);
			System.out.println("result = " + result);
			System.out.println(Arrays.toString(nums[i]));
		}

	}
	
	public static int removeDuplicates(int[] nums) {
		if(nums == null) return 0;

        int[] nums_copy = new int[nums.length];
        int j = 0;
        
        for(int i = 0; i < nums.length; i++) {
        	if(i > 0 && nums[i - 1] == nums[i]) continue;
        	
        	nums_copy[j] = nums[i];
        	j++;
        }
        
        System.arraycopy(nums_copy, 0, nums, 0, j);
		
		return j;
    }

}
