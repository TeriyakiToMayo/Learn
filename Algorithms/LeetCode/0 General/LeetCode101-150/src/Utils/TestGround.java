package Utils;
import java.util.Arrays;

public class TestGround {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] nums = {"1", "3", null, null, "2"};
		
		TreeNode tree = TreeNode.generateTree(nums);
		TreeNode.printTree(tree, 0, true);
	}

}
