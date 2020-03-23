import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Num40_CombinationSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[][] candidateSets = {
			{},
			{1},
			{2},
			{10, 1, 2, 7, 6, 1, 5},
			{2, 5, 2, 1, 2},
		};
		
		int[] targets = {
				1,
				1,
				1,
				8,
				5
				
		};
		
		
		for(int i = 0; i < candidateSets.length; i++) {
			out("" + combinationSum2(candidateSets[i], targets[i]));
		}

	}
	
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> resultList = new LinkedList<List<Integer>>();
		if(candidates.length == 0) return resultList;
		Arrays.sort(candidates);
		findComb(resultList, candidates, target, 0, new Stack<Integer>());
		return resultList;
	}
	
	public static void findComb(List<List<Integer>> resultList, int[] candidates, int residue, int start, Stack<Integer> stack) {
		for(int i = start; i < candidates.length && candidates[i] <= residue; i++) {
			stack.push(candidates[i]);
			List<Integer> subList = new LinkedList<Integer>(stack);
			if(candidates[i] == residue && !resultList.contains(subList)) resultList.add(subList);
			else findComb(resultList, candidates, residue - candidates[i], i + 1, stack);
			stack.pop();
		}
	}
	
	public static void out(String str) {
		System.out.println(str);
	}
	
}
