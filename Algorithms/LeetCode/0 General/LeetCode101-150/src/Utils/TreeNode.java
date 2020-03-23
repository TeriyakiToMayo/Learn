package Utils;

public class TreeNode {
	public int val;
	public TreeNode left;
	public TreeNode right;
	public TreeNode(int x) { val = x; }
	
	public static TreeNode generateTree(String[] nums) {
		
		if(nums.length == 0) return null;
		
		return helper(nums, 0, 0);
	}
	
	public static TreeNode helper(String[] nums, int index, int h) {
		TreeNode newNode = new TreeNode(Integer.parseInt(nums[index]));
		
		int left = 2 * index + 1;
		int right = left + 1;
		
		if(left < nums.length && nums[left] != null) newNode.left = helper(nums, left, h + 1);
		if(right < nums.length && nums[right] != null) newNode.right = helper(nums, right, h + 1);
		
		return newNode;
	}
	
	public static void printTree(TreeNode root, int h, boolean main) {
		if(root == null) {
			if(main) IO.outMain("empty");
			else IO.outTest("empty");
			return;
		}
		
		String tabs = tabs(h);
		if(main) IO.outMain(tabs + root.val);
		else IO.outTest(tabs + root.val);
		
		if(main) IO.outMain(tabs + "left:");
		else IO.outTest(tabs + "left:");
		if(root.left != null) printTree(root.left, h + 1, main);
		if(main) IO.outMain(tabs + "right:");
		else IO.outTest(tabs + "right:");
		if(root.right != null) printTree(root.right, h + 1, main);
	}
	
	public static String tabs(int n) {
		StringBuilder tabs = new StringBuilder();
		for(int i = 0; i < n; i++) {
			tabs.append("\t");
		}
		
		return tabs.toString();
	}
}
