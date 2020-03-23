import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Num77_Combinations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<List<Integer>> myOutput = combine3(5, 3);
		
		for(List<Integer> list : myOutput) {
			IO.outMain("" + list);
		}

	}
	
	//=======================================================
	// Solution 3
	//=======================================================
	private static List<List<Integer>> result;

    public static List<List<Integer>> combine3(int n, int k) {
    	result = new LinkedList<>();
        findCombinations(n, k, 1, new LinkedList<Integer>());
        return result;
    }

    private static void findCombinations(int n, int k, int index, LinkedList<Integer> p) {
        if (p.size() == k) {
            result.add(new LinkedList<>(p));
            return;
        }
        for (int i = index; i <= n - (k - p.size()) + 1; i++) {
            p.add(i);
            findCombinations(n, k, i + 1, p);
            p.removeLast();
        }
    }

	//=======================================================
	// Solution 2
	//=======================================================
	static Stack<Integer> stack;
	static LinkedList<Integer> tmpList;
	static List<Integer> tmpList2;
	static List<List<Integer>> output;
	static int N, K;
	
	public void backtrack(int first, LinkedList<Integer> curr) {
	    // if the combination is done
		if (curr.size() == K)
		  output.add(new LinkedList<Integer>(curr));

		for (int i = first; i < N + 1; ++i) {
			// add i into the current combination
			curr.add(i);
			// use next integers to complete the combination
			backtrack(i + 1, curr);
			// backtrack
			curr.removeLast();
		}
	}


	public List<List<Integer>> combine2(int n, int k) {
		output = new LinkedList<List<Integer>>();
	    N = n;
	    K = k;
	    backtrack(1, new LinkedList<Integer>());
	    return output;
	}

	//=======================================================
	// Solution 1
	//=======================================================
	public static List<List<Integer>> combine(int n, int k) {
    	tmpList = new LinkedList<Integer>();
    	output = new LinkedList<List<Integer>>();
    	N = n;
    	helper(1, k);
    	
    	return output;
    }
    
    public static void helper(int start, int k) {
    	if(k == 0) {
    		output.add(new LinkedList<Integer>(tmpList));
    		return;
    	}
    	
    	for(int i = start; i <= N; i++) {
    		tmpList.add(i);
    		helper(i + 1, k - 1);
    		tmpList.removeLast();
    	}
    }
}
