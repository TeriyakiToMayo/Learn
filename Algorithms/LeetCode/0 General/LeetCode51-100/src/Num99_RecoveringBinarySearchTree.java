
public class Num99_RecoveringBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] numses = {
				{"3", "1", null, null, "2"},	//correct
				{"1", "3", null, null, "2"},	//swap 1 and 3
				{"2", "1", "4", null, null, "3"},	//correct
				{"3", "1", "4", null, null, "2"},	//swap 3 and 2
				{"4", "2", "6", "1", "3", "5", "7"},	//correct
				{"4", "5", "6", "1", "3", "2", "7"},	//swap 5 and 2
		};
			
		for(String[] nums : numses) {
			TreeNode root = TreeNode.generateTree(nums);
			TreeNode.printTree(root, 0, true);
			recoverTree(root);
			IO.outMain("");
			TreeNode.printTree(root, 0, true);
			IO.outMain("");
		}
		
	}
	
	public static void recoverTree(TreeNode root) {
		if(root == null) return;
		
		node0 = null;
		node1 = null;
		swap0 = null;
		swap1 = null;
		findingFirst = true;
		
		traverse(root);
		
		if(swap0 != null) {
			swap0.val = swap0.val ^ swap1.val;
			swap1.val = swap0.val ^ swap1.val;
			swap0.val = swap0.val ^ swap1.val;
		}
		
    }
	
	public static TreeNode node0 = null, node1 = null;
	public static TreeNode swap0 = null, swap1 = null;
	public static boolean findingFirst = true;
	
	public static void traverse(TreeNode root) {
		if(root.left != null) traverse(root.left);
		if(node0 == null) node0 = root;
		else {
			node0 = node1 != null ? node1 : node0;
			node1 = root;
			if(findingFirst) {
				if(node0.val > node1.val) {
					swap0 = node0;
					swap1 = node1;
					findingFirst = false;
				}
			}else {
				if(node0.val > node1.val) {
					swap1 = node1;
					return;
				}
			}
			
		}
		
		if(root.right != null) traverse(root.right);
	}

}
