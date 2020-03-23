import java.util.Arrays;

public class Num27_RemoveElement {

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
				{0, 1, 2, 2, 3, 0, 4, 2},
				{3,2,2,3},
		};
		
		int[] vals = {
			0,
			1,
			2,
			2,
			3,
			3,
			1,
			2,
			3
		};
		
		for(int i = 0; i < nums.length; i++) {
			int result = removeElement(nums[i], vals[i]);
			System.out.println("result = " + result);
			System.out.println(Arrays.toString(nums[i]));
		}
		
	}
	
	public static int removeElement(int[] nums, int val) {
        
		int j = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != val) {
				nums[j] = nums[i];
				j++;
			}
		}
		
		return j;
    }

}
