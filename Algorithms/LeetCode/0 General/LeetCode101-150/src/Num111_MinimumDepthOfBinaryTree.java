import java.util.Arrays;

import Utils.IO;
import Utils.TreeNode;

public class Num111_MinimumDepthOfBinaryTree {

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
				{"1", "2", "2" ,null, "3", null, "3"},
		};
		
		TreeNode[] heads = new TreeNode[numses.length];
		for(int i = 0; i < numses.length; i++) {
			heads[i] = TreeNode.generateTree(numses[i]);
			IO.outMain(Arrays.toString(numses[i]));
			TreeNode.printTree(heads[i], 0, true);
			IO.outMain("minDepth = [" + minDepth(heads[i]) + "]");
			IO.outMain("");
		}
	}
	
	public static int minDep = 0;
	
	public static int minDepth(TreeNode root) {
		if(root == null) return 0;
		minDep = Integer.MAX_VALUE;
		helper(root, 1);
		return minDep;
    }
	
	public static void helper(TreeNode node, int depth) {
		if(node.left == null && node.right == null) 
			minDep = Math.min(minDep, depth);
		if(node.left != null) helper(node.left, depth + 1);
		if(node.right != null) helper(node.right, depth + 1);
	}

}
