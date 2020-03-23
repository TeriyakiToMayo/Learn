import java.util.HashMap;
import java.util.Map;

import Utils.IO;
import Utils.TreeNode;

public class Num105_ConstructBinaryTreeFromPreorderAndInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][][] numses = {
				{{}, {}},
				{{1}, {1}},
				{{1, 2}, {2, 1}},
				{{1, 2, 3}, {2, 1, 3}},
				{{1, 2, 4, 5, 3, 6, 7}, {4, 2, 5, 1, 6, 3, 7}},
				
		};
		
		for(int i = 0; i < numses.length; i++) {
			TreeNode head = buildTree(numses[i][0], numses[i][1]);
			TreeNode.printTree(head, 0, true);
			IO.outMain("");
		}

	}
	
	public static int[] PRE;
	public static int preP = 0;
	public static Map<Integer, Integer> map;
	
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
		if(preorder.length == 0) return null;
		
		PRE = preorder;
		preP = 0;
		map = new HashMap<Integer, Integer>();
		for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
		
		return helper(0, preorder.length - 1);
    }
	
	public static TreeNode helper(int start, int end) {
		int nodePos = map.get(PRE[preP]);
		TreeNode node = new TreeNode(PRE[preP]);
		preP++;
		if(start  < nodePos) node.left = helper(start, nodePos - 1);
		if(nodePos < end) node.right = helper(nodePos + 1, end);
		
		return node;
	}

}
