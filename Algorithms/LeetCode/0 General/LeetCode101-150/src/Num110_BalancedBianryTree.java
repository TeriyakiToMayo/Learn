import java.util.Arrays;

import Utils.IO;
import Utils.TreeNode;

public class Num110_BalancedBianryTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] numses = {
				{},	
				{"1"},
				{"1", "1"},
				{"1", "1", "1"},
				{"1", "1", null, "1"},
				{"1", "2", "2", "3", "4", "4", "3"},
				{"1", "2", "2" ,null, "3", null, "3"},
		};
		
		TreeNode[] heads = new TreeNode[numses.length];
		for(int i = 0; i < numses.length; i++) {
			heads[i] = TreeNode.generateTree(numses[i]);
			IO.outMain(Arrays.toString(numses[i]));
			TreeNode.printTree(heads[i], 0, true);
			IO.outMain("[Balanced? " + isBalanced(heads[i]) + "]");
			IO.outMain("");
		}
	}
	
	static boolean balanced = true;
	
	public static boolean isBalanced(TreeNode root) {
		balanced = true;
		helper(root);
		
		return balanced;
    }
	
	public static int helper(TreeNode node) {
		if(!balanced) return 0;
		
		if(node == null) return 0;
		int leftH = helper(node.left);
		int rightH = helper(node.right);
		if(Math.abs(leftH - rightH) > 1) {balanced = false; return 0;}
		
		return 1 + Math.max(leftH, rightH);
	}

}
