import java.util.Arrays;

import Utils.IO;
import Utils.TreeNode;

public class Num124_BinaryTreeMaximumPathSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String[][] numses = {
				{},	
				{"1"},
				{"1", "2"},
				{"1", "2", "3"},
				{"-10", "9", "20", null, null, "15", "7"},
		};
		
		TreeNode head = null;
		for(int i = 0; i < numses.length; i++) {
			head = TreeNode.generateTree(numses[i]);
			TreeNode.printTree(head, 0, true);
			IO.outMain("RESULT = " + maxPathSum(head));
			IO.outMain("");
		}

	}
	
	public static int maxSum = Integer.MIN_VALUE;
	
	public static int maxPathSum(TreeNode root) {
		if(root == null) return 0;
		maxSum = Integer.MIN_VALUE;
		helper0(root);
		return maxSum;
    }
	
	public static int helper0(TreeNode node) {
		//node has no subtree
		if(node.left == null && node.right == null) {
			maxSum = Math.max(maxSum, node.val);
			return node.val;
		}
		
		//node has one subtree
		if((node.left != null && node.right == null) 
				|| (node.left == null && node.right != null)) {
			int extendable = node.left != null ? helper0(node.left) : helper0(node.right);
			extendable = extendable >= 0 ? extendable + node.val : node.val;
			maxSum = Math.max(maxSum, extendable);
			return extendable;
		}
		
		//node has both left and right subtrees
		int leftExt = helper0(node.left);
		int rightExt = helper0(node.right);
		
		if(leftExt > 0 && rightExt > 0) {
			maxSum = Math.max(maxSum, leftExt + node.val + rightExt);
		}
		
		leftExt = leftExt >= 0 ? leftExt + node.val : node.val;
		rightExt = rightExt >= 0 ? rightExt + node.val : node.val;
		int extendable = leftExt >= rightExt ? leftExt : rightExt;
		maxSum = Math.max(maxSum, extendable);
		
		return extendable;
	}
	

}
