import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Num90_SubsetsII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] numses = {
				/*
				{},
				{1},
				{1, 2, 2},
				*/
		//		{1,2,3,4,5,6,7,8,10,0},
				{3,1,3},

		};
		
		for(int[] nums : numses) {
			List<List<Integer>> result = subsetsWithDup(nums);
			IO.outMain("" + result);
			IO.outMain("" + result.size());
		}
	}
	
	
	//=======================================================
	// Solution 2
	//=======================================================
	public List<List<Integer>> subsetsWithDup2(int[] nums) {
	    List<List<Integer>> ans = new ArrayList<>();
	    Arrays.sort(nums);
	    getAns(nums, 0, new ArrayList<>(), ans);
	    return ans;
	}

	private void getAns(int[] nums, int start, ArrayList<Integer> temp, List<List<Integer>> ans) {
	    ans.add(new ArrayList<>(temp));
	    for (int i = start; i < nums.length; i++) {
	        if (i > start && nums[i] == nums[i - 1]) {
	            continue;
	        }
	        temp.add(nums[i]);
	        getAns(nums, i + 1, temp, ans);
	        temp.remove(temp.size() - 1);
	    }
	}
	
	
	//=======================================================
	// Solution 1
	//=======================================================
	static ArrayList<Integer> tmpList;
	static List<List<Integer>> output;
	
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
    	//Must sort
    	//Assume {3, 1, 3}
    	//Sorted result: [[], [1], [1, 3], [1, 3, 3], [3], [3, 3]]
    	//Not sorted result: [[], [3], [3, 1], [3, 1, 3], [3, 3], [1], [1, 3]]
    	//[1, 3] and [3, 1] are actually the same subset
    	Arrays.sort(nums);
    	output = new ArrayList<>();
    	tmpList = new ArrayList<>();
        findCombinations(0, nums);
    	
    	return output;
    }

    private static void findCombinations(int index, int[] nums) {
    	output.add(new ArrayList<>(tmpList));

        for (int i = index; i < nums.length; i++) {
        	if(i > index && nums[i - 1] == nums[i]) continue;
        	
        	tmpList.add(nums[i]);
            findCombinations(i + 1, nums);
            tmpList.remove(tmpList.size() - 1);
        }
    }
}
