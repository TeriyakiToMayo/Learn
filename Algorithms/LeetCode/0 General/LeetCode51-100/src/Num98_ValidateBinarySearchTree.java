import java.util.Arrays;

public class Num98_ValidateBinarySearchTree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] strses = {
				{"1"},	//valid
				{"1", "0"},	//valid
				{"1", "1"},	//invalid
				{"1", "2"},	//invalid
				
				{"1", "0", "2"},	//valid
				{"1", "0", "1"},	//invalid
				{"1", "0", "0"},	//invalid
				{"2", "1", "3"},	//valid
				
				{"5", "14", null, "1"},	//invalid
				{"5", "1", "4", null, null, "3", "6"},	//invalid
		};
		
		boolean[] results = {
			true,
			true,
			false,
			false,
			
			true,
			false,
			false,
			true,
			
			false,
			false,
		};
		
		TreeNode[] heads = new TreeNode[strses.length];
		boolean work = true;
		if(work) {
			for(int i = 0; i < strses.length; i++) {
				heads[i] = TreeNode.generateTree(strses[i]);
				IO.outMain(Arrays.toString(strses[i]));
//				TreeNode.printTree(heads[i], 0, true);
				boolean result = isValidBST(heads[i]);
				IO.outMain("[" + result + "] [" + results[i] + "] " + (result == results[i] ? "Correct" : "Incorrect"));
				IO.outMain("");
			}
		}
		
		if(!work) {
			String[] nums = {"3", null, "30", "10", null, null, "15", null, "45"};
			TreeNode head = TreeNode.generateTree(nums);
			IO.outMain("" + isValidBST(head));
		}
		
		
	}
	
	public static boolean curValidation = true;
	
	public static boolean isValidBST(TreeNode root) {
		if(root == null) return true;
		curValidation = true;
		helper(root);
		return curValidation;
    }
	

	public static int[] helper(TreeNode root) {
		if(!curValidation) return null;
		
		int[] res = new int[2];
		res[0] = root.val;
		res[1] = root.val;
		
		if(root.left != null) {
			int[] leftRes = helper(root.left);
			if(leftRes == null || leftRes[1] >= root.val) {curValidation = false; return null;}
			updateMinMax(res, leftRes);
			
		}
		
		if(root.right != null) {
			int[] rightRes = helper(root.right);
			if(rightRes == null || rightRes[0] <= root.val) {curValidation = false; return null;}
			updateMinMax(res, rightRes);
		}
		
		return res;
	}
	
	public static void updateMinMax(int[] a, int[] b) {
		a[0] = a[0] > b[0] ? b[0] : a[0];
		a[1] = a[1] < b[1] ? b[1] : a[1];
	}

}
