import java.util.Arrays;

import Utils.IO;
import Utils.TreeNode;

public class Num101_SymmetricTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] numses = {
				{},	//true
				{"1"},	//true
				{"1", "1"},	//false
				{"1", "1", "1"},	//true
				{"1", "1", "2"},	//true
				{"1", "2", "2", "3", "4", "4", "3"},	//true
				{"1", "2", "2" ,null, "3", null, "3"},	//false
		};
		
		TreeNode[] heads = new TreeNode[numses.length];
		for(int i = 0; i < numses.length; i++) {
			heads[i] = TreeNode.generateTree(numses[i]);
			IO.outMain(Arrays.toString(numses[i]));
			TreeNode.printTree(heads[i], 0, true);
			IO.outMain("[" + isSymmetric(heads[i]) + "]");
			IO.outMain("");
		}
	}
	
	public static boolean isSymmetric(TreeNode root) {
		if(root == null) return true;
		
		return helper(root.left, root.right);
    }
	
	public static boolean helper(TreeNode p, TreeNode q) {
		if(p == null || q == null) return p == q;
		
		return p.val == q.val && helper(p.left, q.right) && helper(p.right, q.left);
	}

}
