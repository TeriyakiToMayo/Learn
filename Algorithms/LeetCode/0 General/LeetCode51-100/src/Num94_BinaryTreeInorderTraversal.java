import java.util.ArrayList;
import java.util.List;

public class Num94_BinaryTreeInorderTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	List<Integer> output;
    public List<Integer> inorderTraversal(TreeNode root) {
        output = new ArrayList<Integer>();
        if(root == null) return output;
        helper(root);

        return output;
    }

    public void helper(TreeNode root){
        if(root.left != null) helper(root.left);
        output.add(root.val);
        if(root.right != null) helper(root.right);
    }

}
