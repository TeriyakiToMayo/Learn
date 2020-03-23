import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Num1_TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] nums = {
				{0, 0, 2, 7, 11, 15},
		//		{0, 0, 0},
		};

		int[] targets = {
				22,
			};
				
		for(int i = 0; i < nums.length; i++) {
			int[] result = twoSum(nums[i], targets[i]);
			System.out.println("===========");
			for(int list : result) {
				System.out.print(list + " ");
			}
		}
		
	}
	
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(nums[i]))return new int[] {map.get(nums[i]), i};
			else {
				map.put(target - nums[i], i);
			}
		}
		
		return null;
	}

}
