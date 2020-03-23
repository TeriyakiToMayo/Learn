import java.util.HashMap;
import java.util.Map;

import Utils.IO;
import Utils.TreeNode;

public class Num106_ConstructBinaryTreeFromInorderAndPostorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][][] numses = {
				{{}, {}},
				{{1}, {1}},
				{{1, 2}, {1, 2}},
				{{1, 2, 3}, {1, 3, 2}},
				{{9, 3, 15, 20, 7}, {9, 15, 7, 20, 3}},
				
		};
		
		for(int i = 0; i < numses.length; i++) {
			TreeNode head = buildTree(numses[i][0], numses[i][1]);
			TreeNode.printTree(head, 0, true);
			IO.outMain("");
		}
	}
	
	public static int[] POST;
	public static int postP = 0;
	public static Map<Integer, Integer> map;
	
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
		if(postorder.length == 0) return null;
		
		POST = postorder;
		postP = postorder.length - 1;
		map = new HashMap<Integer, Integer>();
		for(int i = 0; i < inorder.length; i++) map.put(inorder[i], i);
		
		return helper(0, postorder.length - 1);
    }
	
	public static TreeNode helper(int start, int end) {
		int nodePos = map.get(POST[postP]);
		TreeNode node = new TreeNode(POST[postP]);
		postP--;
		if(nodePos < end) node.right = helper(nodePos + 1, end);
		if(start  < nodePos) node.left = helper(start, nodePos - 1);
		
		return node;
	}
	
	

}
