import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Stack;

public class Num39_CombinationSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
		int[][] candidateSets = {
				
				{},
				{1},
				{1},
				{2},
				{2, 3, 6, 7},
				{2, 3, 5},
				{8, 7, 4, 3},
				
				{1, 2, 3},
		};
		
		int[] targets = {
				
				1,
				1,
				2,
				3,
				7,
				8,
				11,
				3,
		};
		
		//Test of generateComb()
		/*
		Set<Integer> set = new HashSet<Integer>();
		set.addAll(Arrays.asList(candidateSets[1]));
		out("" + generateComb(set));
		*/
		
		
		
		for(int i = 0; i < candidateSets.length; i++) {
		//	out("" + combinationSum2(candidateSets[i], targets[i]));
		//	out("" + genComb(candidateSets[i]));
			out("" + genCombNoRep(candidateSets[i]));
		}
		
		
		/**/
	}
	
	//===================================================================
	//	Approach 1
	//===================================================================
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {

		Arrays.sort(candidates);
		return helper(candidates, target);

	}
	
	public static List<List<Integer>> helper(int[] candidates, int target) {
		List<List<Integer>> list = new LinkedList<List<Integer>>();
		
		if(candidates.length == 0 || candidates[0] > target) return list;
		
		int pos = candidates.length;
		for(int i = 0; i < candidates.length; i++) {
			if(candidates[i] > target) {
				pos = i;
				break;
			}
		}
		
		for(int i = 0; i < pos; i++) {
			if(candidates[i] == target) {
				List<Integer> tempSubList = new LinkedList<Integer>();
				tempSubList.add(candidates[i]);
				if(!list.contains(tempSubList)) list.add(tempSubList);
			}else {
				List<List<Integer>> tempList = helper(candidates, target - candidates[i]);
				for(List<Integer> subList : tempList) {
					subList.add(candidates[i]);
					Collections.sort(subList);
					if(!list.contains(subList)) list.add(subList);
				}
			}
		}
		
		return list;
	}
	
	//===================================================================
	//	Approach 2 **
	//===================================================================
	
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
			if(candidates[i] == residue) resultList.add(new LinkedList<Integer>(stack));
			else findComb(resultList, candidates, residue - candidates[i], i, stack);
			stack.pop();
		}
	}
	
	//===================================================================
	//	Approach 3
	//===================================================================
	private static List<List<Integer>> res = new LinkedList<>();
    private static int[] candidates_copy;
    private static int len_copy;

    private void findCombinationSum(int residue, int start, Stack<Integer> pre) {
        if (residue == 0) {
            res.add(new LinkedList<>(pre));
            return;
        }
       
        for (int i = start; i < len_copy && residue - candidates_copy[i] >= 0; i++) {
            pre.add(candidates_copy[i]);
            findCombinationSum(residue - candidates_copy[i], i, pre);
            pre.pop();
        }
    }

    public List<List<Integer>> combinationSum3(int[] candidates, int target) {
        int len = candidates.length;
        if (len == 0) {
            return res;
        }

        Arrays.sort(candidates);
        len_copy = len;
        candidates_copy = candidates;
        findCombinationSum(target, 0, new Stack<>());
        return res;
    }

	
	//===================================================================
	//	By-product (Primitive)
	//===================================================================
	public static List<List<Integer>> combinationSumWithoutRepeat(int[] candidates, int target) {
		
		List<List<Integer>> list = new LinkedList<List<Integer>>();
        Arrays.sort(candidates);
        if(candidates[0] > target) return list;
        
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < candidates.length; i++) {
        	if(candidates[i] > target) {
        		break;
        	}
        	set.add(candidates[i]);
        }
		
		Set<Set<Integer>> combs = generateComb(set);
		
		for(Set<Integer> comb : combs) {
			int sum = 0;
			for(Integer i : comb) {
				sum += i;
			}
			if(sum == target) {
				List<Integer> subList = new LinkedList<Integer>();
				subList.addAll(comb);
				list.add(subList);
			}
		}
		
		return list;
    }
	
	public static Set<Set<Integer>> generateComb(Set<Integer> set){
		Set<Set<Integer>> resultSet = new HashSet<Set<Integer>>();
		
		if(set.size() == 0) return resultSet;
		
		Set<Integer> tempSet = new HashSet<Integer>();
		tempSet.addAll(set);
		resultSet.add(tempSet);
		
		for(Integer i : set) {
			tempSet.remove(i);
			resultSet.addAll(generateComb(tempSet));
			tempSet.add(i);
		}
		
		return resultSet;
	}

	
	//===================================================================
	//	By-product: generate comb (with repeat)
	//===================================================================
	public static List<List<Integer>> genComb(int[] candidates){
		List<List<Integer>> genCombList = new LinkedList<List<Integer>>();
		if(candidates.length == 0) return genCombList;
		Arrays.sort(candidates);
		genCombHelper(genCombList, candidates, 0, new Stack<Integer>(), candidates.length);
		return genCombList;
	}
	
	public static void genCombHelper(List<List<Integer>> genCombList, int[] candidates, 
			int start, Stack<Integer> stack, int size){
		if(stack.size() > 0) genCombList.add(new LinkedList<Integer>(stack));
		if(size == 0) return;
		for(int i = start; i < candidates.length; i++) {
			stack.push(candidates[i]);
			genCombHelper(genCombList, candidates, i, stack, size - 1);
			stack.pop();
		}
		
	}
	
	//===================================================================
	//	By-product: generate comb (without repeat)
	//===================================================================
	public static List<List<Integer>> genCombNoRep(int[] candidates){
		List<List<Integer>> genCombNoRepList = new LinkedList<List<Integer>>();
		if(candidates.length == 0) return genCombNoRepList;
		Arrays.sort(candidates);
		genCombNoRepHelper(genCombNoRepList, candidates, 0, new Stack<Integer>());
		return genCombNoRepList;
	}
	
	public static void genCombNoRepHelper(List<List<Integer>> genCombNoRepList, int[] candidates, 
			int start, Stack<Integer> stack){
		if(stack.size() > 0) genCombNoRepList.add(new LinkedList<Integer>(stack));
		for(int i = start; i < candidates.length; i++) {
			stack.push(candidates[i]);
			genCombNoRepHelper(genCombNoRepList, candidates, i + 1, stack);
			stack.pop();
		}
		
	}
	
	public static void out(String str) {
		System.out.println(str);
	}
}
