import java.util.Arrays;

public class Num41_FirstMissingPositive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] nums = {
				{1, 2, 1},		//if the pos contains correct num, then repeated
									//num will be ignored (like the 2nd 1)
				{1, 10, 3, },
				{3, 4, -1, 1},
				{7, 8, 9, 11, 12},
		};
		
		for(int i = 0; i < nums.length; i++) {
			out("" + firstMissingPositive(nums[i]));
		}
		
	}
	
	public static int firstMissingPositive(int[] nums) {
        
		for(int i = 0; i < nums.length; i++) {
			//Hashing process:
			//num_pos = num - 1
			//E.g. [1, 3, 5, 2, 6] 
			//=> [1, 2, 3, 6(six is placed here after swapping), 5]
			while(nums[i] > 0 && nums[i] <= nums.length 
					&& nums[nums[i] - 1] != nums[i]) {
				swap(nums, nums[i] - 1, i);
			}
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != i + 1) return i + 1;
		}
		
		return nums.length + 1;
    }
	
	public static void swap(int[] nums, int i, int j) {
		nums[i] = nums[i] ^ nums[j];
		nums[j] = nums[i] ^ nums[j];
		nums[i] = nums[i] ^ nums[j];
	}

	public static void out(String str) {
		 System.out.println(str);
	}
}
