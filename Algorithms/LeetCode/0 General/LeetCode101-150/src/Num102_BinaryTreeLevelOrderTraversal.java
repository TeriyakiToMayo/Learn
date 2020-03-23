import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Utils.IO;
import Utils.TreeNode;

public class Num102_BinaryTreeLevelOrderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] numses = {
				{},	
				{"1"},
				{"1", "1"},
				{"1", "1", "1"},
				{"1", "1", "2"},
				{"1", "2", "2", "3", "4", "4", "3"},
				{"1", "2", "2" ,null, "3", null, "3"},
				{"3", "9", "20", null, null, "15", "7"},
		};
		
		TreeNode[] heads = new TreeNode[numses.length];
		for(int i = 0; i < numses.length; i++) {
			heads[i] = TreeNode.generateTree(numses[i]);
			IO.outMain(Arrays.toString(numses[i]));
			TreeNode.printTree(heads[i], 0, true);
			List<List<Integer>> res = levelOrder(heads[i]);
			
			for(List<Integer> list : res) {
				IO.outMain("" + list);
			}
			
			IO.outMain("");
		}
	}
	
	public static ArrayList<List<Integer>> output;
	
	public static List<List<Integer>> levelOrder(TreeNode root) {
		output = new ArrayList<List<Integer>>();
		
		if(root == null) return output;
		helper(root, 1);
		return output;
    }
	
	public static void helper(TreeNode node, int depth) {
		if(output.size() < depth) {
			output.add(new ArrayList<Integer>());
		}
		
		output.get(depth - 1).add(node.val);
		
		if(node.left != null) helper(node.left, depth + 1);
		if(node.right != null) helper(node.right, depth + 1);
	}

}
