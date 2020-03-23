import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import Utils.IO;
import Utils.TreeNode;

public class Num103_BinaryTreeZigZagLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] numses = {
				{},	
				{"1"},
				{"1", "1"},
				{"1", "1", "1"},
				{"1", "1", "2"},
				{"1", "2", "3", "3", "4", "5", "6"},
				{"1", "2", "3" ,null, "4", null, "5"},
		};
		
		TreeNode[] heads = new TreeNode[numses.length];
		for(int i = 0; i < numses.length; i++) {
			heads[i] = TreeNode.generateTree(numses[i]);
			IO.outMain(Arrays.toString(numses[i]));
			TreeNode.printTree(heads[i], 0, true);
			List<List<Integer>> res = zigzagLevelOrder(heads[i]);
			
			for(List<Integer> list : res) {
				IO.outMain("" + list);
			}
			
			IO.outMain("");
		}
	}
	
	public static ArrayList<List<Integer>> output;
	
	public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		output = new ArrayList<List<Integer>>();
		
		if(root == null) return output;
		helper(root, 1);
		return output;
    }
	
	public static void helper(TreeNode node, int depth) {
		if(output.size() < depth) {
			output.add(new ArrayList<Integer>());
		}
		
		if(depth%2 == 1) {
			output.get(depth - 1).add(node.val);
		}else {
			output.get(depth - 1).add(0, node.val);
		}
		
		
		if(node.left != null) helper(node.left, depth + 1);
		if(node.right != null) helper(node.right, depth + 1);
	}

}
