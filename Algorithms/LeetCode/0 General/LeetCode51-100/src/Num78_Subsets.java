import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Num78_Subsets {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] numses = {
				{},
				{1, 1},
				{1, 2, 3},
				
		};
		
		for(int[] nums : numses) {
			List<List<Integer>> myOutput = subsets(nums);
			
			for(List<Integer> list : myOutput) {
				IO.outMain("" + list);
			}
			
			IO.outMain("");
		}
		
	}
	
	//=======================================================
	// Solution 2
	//=======================================================
	public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<Integer>());
        return res;

    }

    private void backtrack(int i, int[] nums, List<List<Integer>> res, ArrayList<Integer> tmp) {
        res.add(new ArrayList<>(tmp));
        for (int j = i; j < nums.length; j++) {
            tmp.add(nums[j]);
            backtrack(j + 1, nums, res, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }
	
	
	//=======================================================
	// Solution 1
	//=======================================================
	static ArrayList<Integer> tmpList;
	static List<List<Integer>> output;
	
    public static List<List<Integer>> subsets(int[] nums) {
    	output = new ArrayList<>();
    	tmpList = new ArrayList<>();
        findCombinations(0, nums);
    	
    	return output;
    }

    private static void findCombinations(int index, int[] nums) {
    	output.add(new ArrayList<>(tmpList));

        for (int i = index; i < nums.length; i++) {
        	tmpList.add(nums[i]);
            findCombinations(i + 1, nums);
            tmpList.remove(tmpList.size() - 1);
        }
    }

}
