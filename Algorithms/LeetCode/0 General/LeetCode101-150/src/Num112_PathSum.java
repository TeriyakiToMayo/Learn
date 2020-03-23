import java.util.Arrays;

import Utils.IO;
import Utils.TreeNode;

public class Num112_PathSum {

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
		};
		
		TreeNode[] heads = new TreeNode[numses.length];
		for(int i = 0; i < numses.length; i++) {
			heads[i] = TreeNode.generateTree(numses[i]);
			IO.outMain(Arrays.toString(numses[i]) + " " + sums[i]);
			TreeNode.printTree(heads[i], 0, true);
			IO.outMain("[Has: " + hasPathSum(heads[i], sums[i]) + "]");
			IO.outMain("");
		}
	}
	
	public static boolean has = false;
	public static int SUM = 0;
	
	public static boolean hasPathSum(TreeNode root, int sum) {
		if(root == null) return false;
		has = false;
		SUM = sum;
		helper(root, 0);
		return has;
    }
	
	public static void helper(TreeNode node, int sum) {
		if(has) return;
		sum += node.val;
		if(node.left == null && node.right == null) {
			has = SUM == sum;
		}
		if(node.left != null) helper(node.left, sum);
		if(node.right != null) helper(node.right, sum);
		
	}

}
