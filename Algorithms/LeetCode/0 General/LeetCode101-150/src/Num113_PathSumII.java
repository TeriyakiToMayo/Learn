import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Utils.IO;
import Utils.TreeNode;

public class Num113_PathSumII {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] numses = {
				{},	
				{"1"},
				{"1", "1"},
				{"1", "1", "1"},
				{"1", "1", "2"},
				{"1", "1", "2", "1", "1"},
				{"1", "2", "2", "3", "4", "4", "3"},
				{"1", "2", "2" ,null, "3", null, "5"},
				{"5", "4", "8", "11", null, "13", "4", "7", "2", null, null, null, null, "5", "1"},
		};
		
		int[] sums = {
				0,
				1,
				1,
				2,
				3,
				4,
				6, 
				8,
				22,
		};
		
		for(int i = 0; i < numses.length; i++) {
			TreeNode head = TreeNode.generateTree(numses[i]);
			IO.outMain(Arrays.toString(numses[i]) + " " + sums[i]);
			TreeNode.printTree(head, 0, true);
			List<List<Integer>> res = pathSum(head, sums[i]);
			IO.outMain("[");
			for(List<Integer> subRes : res) {
				IO.outMain("\t" + subRes);
			}
			IO.outMain("]");
			IO.outMain("");
		}
	}
	
	public static List<List<Integer>> output;
	public static ArrayList<Integer> list;
	public static int SUM = 0;
	public static int CURSUM = 0;
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
		
		output = new ArrayList<List<Integer>>();
		if(root == null) return output;
		
		list = new ArrayList<Integer>();
		SUM = sum;
		CURSUM = 0;
		
		helper(root);
		return output;
    }
	
	public static void helper(TreeNode node) {
		list.add(node.val);
		CURSUM += node.val;
		if(node.left == null && node.right == null && CURSUM == SUM) {
			output.add(new ArrayList<Integer>(list));
		}
		
		if(node.left != null) helper(node.left);
		if(node.right != null) helper(node.right);
		list.remove(list.size() - 1);
		CURSUM -= node.val;
	}
	
	

}
