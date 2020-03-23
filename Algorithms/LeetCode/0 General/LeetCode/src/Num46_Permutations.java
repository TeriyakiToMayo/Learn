import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Num46_Permutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] nums = {
		//		{},
		//		{1},
		//		{1, 2},
				{1, 2, 3},
		};
		
		
		for(int i = 0; i < nums.length; i++) {
			out2(Arrays.toString(nums[i]) + " results:");
			List<List<Integer>> results = permute3(nums[i]);
			for(List<Integer> subResult : results) {
				out2("" + subResult);
			}
			out2("");
		}

	}
	
	public static void backtrack(int n, ArrayList<Integer> nums, 
			List<List<Integer>> output, int first) {
		// if all integers are used up
		if (first == n)
			output.add(new ArrayList<Integer>(nums));
		for (int i = first; i < n; i++) {
			// place i-th integer first 
			// in the current permutation
			Collections.swap(nums, first, i);
			// use next integers to complete the permutations
			backtrack(n, nums, output, first + 1);
			// backtrack
			Collections.swap(nums, first, i);
		}
	}
		
	public static List<List<Integer>> permute3(int[] nums) {
		// init output list
		List<List<Integer>> output = new LinkedList();
		
		// convert nums into list since the output is a list of lists
		ArrayList<Integer> nums_lst = new ArrayList<Integer>();
		for (int num : nums)
		nums_lst.add(num);
		
		int n = nums.length;
		backtrack(n, nums_lst, output, 0);
		return output;
	}
	
	public static List<List<Integer>> permute(int[] nums) {	
		LinkedList<Integer> list = new LinkedList<>();
		for(int num : nums) {
			list.add(num);
		}
		return permuteHelper(list);
    }

	public static List<List<Integer>> permuteHelper(LinkedList<Integer> list){
		
		List<List<Integer>> results = new LinkedList<List<Integer>>();
		
		if(list.size() == 1) {
			List<Integer> subResult = new LinkedList<>();
			subResult.add(list.get(0));
			results.add(subResult);
			return results;
		}
		
		for(int i = 0; i < list.size(); i++) {
			int num = list.remove(i);
			
			List<List<Integer>> tempResult = permuteHelper(list);
			for(int j = 0; j < tempResult.size(); j++) {
				List<Integer> subTempResult = tempResult.get(j);
				subTempResult.add(0, num);
			}
			results.addAll(tempResult);
			list.add(i, num);
		}
		
		return results;
	}
	
	public static List<List<Integer>> permute2(int[] nums) {	
		
		boolean[] markers = new boolean[nums.length];
		Arrays.fill(markers, true);
		
		List<List<Integer>> results = new LinkedList<List<Integer>>();
		List<Integer> curList = new LinkedList<>();
		permute2Helper(nums, markers, curList, results);
		return results;
	}

	public static void permute2Helper(int[] nums, boolean[] markers, 
			List<Integer> curList, List<List<Integer>> output) {	
		for(int i = 0; i < markers.length; i++) {
			if(markers[i]) {
				curList.add(nums[i]);
				if(curList.size() == nums.length) {
					output.add(new LinkedList<Integer>(curList));
					curList.remove(curList.size() - 1);
					return;
				}
				markers[i] = false;
				permute2Helper(nums, markers, curList, output);
				markers[i] = true;
				curList.remove(curList.size() - 1);
			}
		}
		
	}
	
	

	
	public static String tabs(int i) {
		String str = "";
		for(; i > 0; i--) {
			str += "\t";
		}
		return str;
	}
	
	public static void out(String str) {
		 System.out.println(str);
	}
		
	public static void out2(String str) {
		 System.out.println(str);
	}

}
