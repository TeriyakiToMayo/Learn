import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Num47_PermutationsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] nums = {
				{},
				{1},
				{1, 1},
				{1, 2},
				{1, 1, 2},
		};
		
		
		for(int i = 0; i < nums.length; i++) {
			out2(Arrays.toString(nums[i]) + " results:");
			List<List<Integer>> results = permuteUnique(nums[i]);
			for(List<Integer> subResult : results) {
				out2("" + subResult);
			}
			out2("");
		}

	}
	
	public static List<List<Integer>> permuteUnique(int[] nums) {	
		
		Arrays.sort(nums);
		boolean[] markers = new boolean[nums.length];
		Arrays.fill(markers, true);
		
		return permuteUniqueHelper(nums, markers, nums.length);
	}
	
	public static List<List<Integer>> permuteUniqueHelper(int[] nums, boolean[] markers, int size) {	
		List<List<Integer>> results = new LinkedList<List<Integer>>();
		
		if(nums.length == 0) return results;
		
		int last = -1;
		for(int i = 0; i < markers.length; i++) {
			
			if(markers[i]) {
				
				if(last >= 0 && nums[last] == nums[i]) continue;
				last = i;
				
				if(size == 1) {
					List<Integer> subResult = new LinkedList<>();
					subResult.add(nums[i]);
					results.add(subResult);
					return results;
				}
				markers[i] = false;
				List<List<Integer>> tempResults = permuteUniqueHelper(nums, markers, size - 1);
				
				for(int j = 0; j < tempResults.size(); j++) {
					List<Integer> subTempResult = tempResults.get(j);
					subTempResult.add(0, nums[i]);
				}
				results.addAll(tempResults);
				
				markers[i] = true;
				
			}
		}
		
		return results;
	}
	
	public static void out(String str) {
		 System.out.println(str);
	}
		
	public static void out2(String str) {
		 System.out.println(str);
	}

}

